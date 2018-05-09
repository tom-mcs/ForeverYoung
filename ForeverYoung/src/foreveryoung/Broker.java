package foreveryoung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matt
 */
public class Broker {
 
/**
 * The program uses specialized strings to set up the connection to the derby database
 * The driver string tells the program which driver to use to allow the database to work
 * The protocol string specifies how to connect to the database
 * @author Ryan
 */     
    
    final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    final String protocol = "jdbc:derby:";
    final String dbName = "derbyDB";
    static Connection connection = null;
    static Statement statement = null;
    final int versionNum = 2;   //increment every time the database is substantially changed and requires a rebuild

/**
 * @throws SQLException 
 * The program makes use of Java SQL imports to try to establish a connection to the database.
 * If the program detects it cannot make a connection, it will throw an exception. If a 
 * successful connection has been made, the program will then attempt to create a table
 * to store and retrieve information.
 * @author Ryan
 */
    
    //constructer connects to db and creates username table
    //if a username table already exists it will drop the table and create a new one
     public Broker() throws SQLException{
   
        try{
            Class.forName(driver).newInstance();
        }
        catch(Exception E){
            E.printStackTrace();
        }
        try {
             connection = DriverManager.getConnection(
                     protocol + dbName + ";create=true");
        } 
        catch (SQLException ex) {
             Logger.getLogger(Broker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("=====    Started/Connected DB    =====");
        
        statement = connection.createStatement();
       
        //rebuilds database if versionNum is different
        if(true){
            System.out.println("db versionNum is different or doesn't exist");
            System.out.println("dropping all tables");
            deleteDB();
            System.out.println("creating new tables");
            buildDB();
        }
        else{
            System.out.println("DB versionNum is up to date");
        }
    }
      
    /**
     * Builds all tables of the database
     * tables are users, goals, and exercises, where goals and exercises are linked to the users table via the foreign key 'username'
     * additionally there is a versionNum table used to keep track of the DB version (this is an haphazard solution and will likely need to be changed)
     * @author Matt
     */ 
    public void buildDB(){        
        try{
            statement.execute("CREATE TABLE versionNum ("
                    + "version INTEGER NOT NULL, "
                    + "CONSTRAINT versionNumPK PRIMARY KEY (version))");            
            statement.execute("INSERT INTO versionNum VALUES (" + versionNum + ")");
        }
        catch(SQLException sqlExcept){
            System.out.println("error creating versionNumber: " + sqlExcept);
        }        
        try{
            statement.execute("CREATE TABLE users ("
                    + "username VARCHAR(15), "
                    + "password VARCHAR(15) NOT NULL, "
                    + "firstName VARCHAR(15), "
                    + "lastName VARCHAR(15), "
                    + "practitioner VARCHAR(15), "
                    + "CONSTRAINT usersPK PRIMARY KEY (username))");
        }
        catch(SQLException sqlExcept){
            System.out.println("error creating user table: " + sqlExcept);
        }
        
        try{
            statement.execute("CREATE TABLE goals ("
                    + "goal VARCHAR(15), "
                    + "description VARCHAR(50), "
                    + "isCompleted BOOLEAN, "
                    + "username VARCHAR(15) REFERENCES users(username), "
                    + "CONSTRAINT goalsPK PRIMARY KEY (goal, username))");
        }
        catch(SQLException sqlExcept){
            System.out.println("error creating goals table: " + sqlExcept);
        }
        
        try{
            statement.execute("CREATE TABLE exercises ("
                    + "exerciseName VARCHAR(15), "
                    + "username VARCHAR(15) REFERENCES users(username), "
                    + "CONSTRAINT exercisesPK PRIMARY KEY (exerciseName, username))");
        }
        catch(SQLException sqlExcept){
            System.out.println("error creating exercises table: " + sqlExcept);
        }
        
        try{
            statement.execute("CREATE TABLE exerciseEntries ("
                    + "exerciseEntryID INTEGER not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "date DATE, "
                    + "time TIME, "
                    + "lengthOfExerciseInMinutes INTEGER, "
                    + "exerciseName VARCHAR(15), "
                    + "username VARCHAR(15), "
                    + "CONSTRAINT exerciseEntriesFK FOREIGN KEY(exerciseName, username) REFERENCES exercises (exerciseName, username), "
                    + "CONSTRAINT exerciseEntriesPK PRIMARY KEY (exerciseEntryID))");
        }
        catch(SQLException sqlExcept){
            System.out.println("error creating exercisesEntries table: " + sqlExcept);
        }
    } 
   
    /**
     * Drops all tables from the database
     * Currently each table must manually be specified to be dropped and due to the nature of the foreign key constraints must be dropped in a certain order
     * In future updates, this process should be cleaned up so all tables can be dropped easily without having to modify this code for every new table added to the DB
     * @author Matt
     */ 
    public void deleteDB(){  
        try{
            statement.execute("DROP TABLE versionNum");
        }
        catch(SQLException sqlExcept){
            System.out.println("error dropping version table: " + sqlExcept);
        } 
        try{
            statement.execute("DROP TABLE exerciseEntries");
        }
        catch(SQLException sqlExcept){
            System.out.println("error dropping exerciseEntries table: " + sqlExcept);
        } 
        try{
            statement.execute("DROP TABLE goals");
        }
        catch(SQLException sqlExcept){
            System.out.println("error dropping goals table: " + sqlExcept);
        } 
        try{
            statement.execute("DROP TABLE exercises");
        }
        catch(SQLException sqlExcept){
            System.out.println("error exercises table: " + sqlExcept);
        } 
        try{
            statement.execute("DROP TABLE users");
        }
        catch(SQLException sqlExcept){
            System.out.println(sqlExcept);
            System.out.println("error dropping user table: " + sqlExcept);
        } 
    }
     
    //closes all connections to the database
    public void shutdown()
    {
        try
        {
            if (statement != null)
            {
                statement.close();
                System.out.println("statement closed");
            }
            if (connection != null)
            {
                connection.close();
                System.out.println("connection closed");
            }           
        }
        catch (SQLException sqlExcept)
        {
            System.out.print(sqlExcept);
        }
    }
    
    public int getDBVersionNum(){
        try{
        ResultSet rs = statement.executeQuery("SELECT * FROM versionNum");          
            if(rs.next()){
                return Integer.parseInt(rs.getString(1));
            }
        }
        catch (SQLException sqlExcept){
            return 0;
        }
        return 0;
    }

/**
 * 
 * @return 
 * 
 * The addUser method uses statements to add a newly created user to the database.
 * When using the derby DB database, statements are required to perform any SQL 
 * executions.
 * @author Ryan
 */
    
   //adds practitioner with username, password, first name, and last name as argument
    public boolean addPractitioner(Practitioner user){
       if(user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getFirstName().isEmpty()|| user.getLastName().isEmpty()){
           return false;
       }
       else{
           try{
               statement.execute("INSERT INTO users VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getFirstName() + "', '" + user.getLastName() + "', NULL)");
               return true;
           }
           catch (SQLException ex) {
               return false;
           }
       }
    }
     
    //adds client with username, password, first name, last name and practitioner name as argument
    public boolean addClient(Client user){
       if(user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getFirstName().isEmpty()|| user.getLastName().isEmpty()){
           return false;
       }
       else{
           try{
               statement = connection.createStatement();
               statement.execute("INSERT INTO users VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getPractitionerName() + "')");
               return true;
           }
           catch (SQLException ex) {
               System.out.println(ex);
               return false;
           }
       }
    }

/**
 * 
 * @param username
 * @return
 * Similar to the addUser method, this method also uses a statement to retrieve
 * both the username and password from the database. The method also utilizes get
 * methods to retrieve the appropriate information.
 * @author Ryan
 */
     
     //looks up username in db and returns their info as a user object
     //returns null if the user isn't found
     public User getUser(String username){  
        try{
            User user = new User();
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE username='" + username + "'");          
            if(rs.next()){
                if (rs.getString("practitioner") == null){
                    user = new Practitioner(rs.getString("username"),rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"));
                    ArrayList<Client> clients = getClients((Practitioner)user);
                    for(Client client : clients){
                        ((Practitioner)user).addClient(client);
                    }
                }
                else{
                    System.out.println("ELSEEEE");
                    user = new Client(rs.getString("username"),rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("practitioner"));
                }
                
            }
            return user;
        }
        catch(SQLException ex){
            return new User();
        }
    }    
 
/**
 * 
 * @return
 * The getAllUsers method used an ArrayList to store all of the pulled from the database 
 * into a list, which then can be displayed to the user.
 * @author Ryan
 */         
     
    public ArrayList<Client> getClients(Practitioner practitioner){
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE practitioner='" + practitioner.getUsername() + "'");
            ArrayList<Client> clients = new ArrayList<>();
            
            while(rs.next()){
                clients.add(new Client(rs.getString("username"),rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("practitioner")));
            }
            return clients;
        }
        catch(SQLException ex){
           return null; 
        }        
    }
    
    public void removeUser(Client user) {
        try {   
                System.out.println(user.getUsername());
                String username = user.getUsername();
              
                    String sql = "DELETE FROM users WHERE username='" + username + "'";
                    statement.executeUpdate(sql);          
                    System.out.println("User successfully removed from database");
            
        }
        catch(SQLException ex) {
            System.out.println(ex);
        }
    }

/**
 * adds an exercise with an associated client to the DB
 * returns true if successful
 * @param exercise
 * @param client
 * @return 
 */
    public boolean addAerobicExercise(AerobicExercise exercise, Client client) {
        try{  
            statement.execute("INSERT INTO exercises(exerciseName, username) VALUES ('" + exercise.getName() + "', '" + client.getUsername() + "')");
            return true;
        }
        catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

/**
 * returns an aerobic exercise relating to the exercise name and the associated client
 * @param exerciseName
 * @param client
 * @return 
 */    
    public AerobicExercise getAerobicExercise(String exerciseName, Client client){
        try{           
            ResultSet exerciseRS = statement.executeQuery("SELECT exerciseName FROM exercises WHERE exerciseName='" + exerciseName + "' AND username='" + client.getUsername() + "'");
            AerobicExercise exercise = null;
            
            if(exerciseRS.next()){
                exercise = new AerobicExercise(exerciseRS.getString("exerciseName"));
            }
            
            ResultSet entryRS = statement.executeQuery("SELECT * FROM exerciseEntries WHERE exerciseName='" + exerciseName + "' AND username='" + client.getUsername() + "'");     
            if (exercise != null){
                while(entryRS.next()){
                    exercise.addEntry(entryRS.getInt("lengthOfExerciseInMinutes"), LocalDateTime.parse(entryRS.getString("date") + "T" + entryRS.getString("time")));
                }
                return exercise;
            }
            else{
                return null;
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
            return null; 
        } 
    }
    
 /**
 * returns an aerobic exercise relating to the exercise name and the associated client
 * @param exerciseName
 * @param client
 * @return 
 */    
    public ArrayList<AerobicExercise> getAllAerobicExercisesOfClient(Client client){
        try{           
            ResultSet exerciseRS = statement.executeQuery("SELECT exerciseName FROM exercises WHERE username='" + client.getUsername() + "'");
            ArrayList<AerobicExercise> exercises = new ArrayList<AerobicExercise>();

            ResultSet entryRS;
            while(exerciseRS.next()){
                exercises.add(new AerobicExercise(exerciseRS.getString("exerciseName")));
            }
            int i = 0;
            while(i<exercises.size()){
                entryRS = statement.executeQuery("SELECT * FROM exerciseEntries WHERE exerciseName='" + exercises.get(i)  + "' AND username='" + client.getUsername() + "'");  
                while(entryRS.next()){
                        exercises.get(i).addEntry(entryRS.getInt("lengthOfExerciseInMinutes"), LocalDateTime.parse(entryRS.getString("date") + "T" + entryRS.getString("time")));
                    }
                    i++;
            }
            return exercises;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return null; 
        } 
    }
    
/**
 * adds an exercise entry to the DB including how long the exercise went for in minutes and the date and time it occurred
 * returns true if successful
 * @param exercise
 * @param entry
 * @param client
 * @return 
 */
    public boolean addExerciseEntry(AerobicExercise exercise, AerobicExercise.Entry entry, Client client){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:MM");
        try{  
            statement.execute("INSERT INTO exerciseEntries(date, time, lengthOfExerciseInMinutes, exerciseName, username) VALUES ('" + entry.date.format(dateFormatter) + "', '" + entry.date.format(timeFormatter) + "', " + entry.minutes + ", '" + exercise.getName() + "' ,'" + client.getUsername() + "')");
            return true;
        }
        catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean addGoal(Goal goal, Client client) {
        try{  
               statement.execute("INSERT INTO goals(goal, description, isCompleted, username) VALUES ('" + goal.getName() + "', '" + goal.getDescription() + "', false, '" + client.getUsername() + "')");
               return true;
            }
            catch (SQLException ex) {
                
                return false;
        }
    }  
    
    public boolean setGoalAsCompleted(Goal goal, Client client) {
        try{  
               statement.execute("UPDATE goals SET isCompleted=true WHERE username='" + client.getUsername() + "' AND goal='" + goal.getName() + "'");
               return true;
            }
        catch (SQLException ex) {
                System.out.println(ex);
                return false;
        }
    } 
    
    public ArrayList<Goal> getGoals(Client client){
        try{
            ResultSet rs = statement.executeQuery("SELECT * FROM goals WHERE username='" + client.getUsername() + "'");
            ArrayList<Goal> goals = new ArrayList<>();
            while(rs.next()){
                goals.add(new Goal(rs.getString("goal"),rs.getString("description"),rs.getBoolean("isCompleted")));
            }
            return goals;
        }
        catch(SQLException ex){
           return null; 
        }        
    }
}
