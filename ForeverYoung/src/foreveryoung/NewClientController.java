package foreveryoung;

import static java.lang.Thread.sleep;

/**
 *
 * @author Admin
 */
public class NewClientController {
    
    private CreateNewAccountInterface CNAInterface;
    private Broker broker;
    private Client client;
    private boolean done;
    private MainFrame frame;
    private Practitioner practitioner;
    
    public NewClientController(Broker broker, MainFrame frame, Practitioner pract){
        practitioner = pract;
        this.broker = broker;
        CNAInterface = new CreateNewAccountInterface();
        this.frame = frame;
    }
    
    public void activate(){
        CNAInterface.clearFields();
        CNAInterface.clearMessage();
        done = false;
        frame.setPanel(CNAInterface);
        CNAInterface.setDefaultButton();
        while(!done){
            try{sleep(50);}catch(InterruptedException ie){}
            check();
        }
    }
    
    public CreateNewAccountInterface getInterface(){
        return CNAInterface;
    }
    
    public boolean isDone(){
        return done;
    }
    
    public User getUser(){
        return client;
    }
    
    public void check(){
            if(CNAInterface.isCreateButtonClicked()){
                CNAInterface.setCreateButtonClicked(false);
                done = create();
            }
            if(CNAInterface.isCancelButtonClicked()){
                CNAInterface.setCancelButtonClicked(false);
                done = true;
            }
    }
    
    /**
     * returns true if a user is created
     * otherwise displays an error message and returns false
     */
    private boolean create(){

        String username = CNAInterface.getUsernameText();
        String firstName = CNAInterface.getFirstNameText();
        String lastName = CNAInterface.getLastNameText();
        String password1 = CNAInterface.getPassword1Text();
        String password2 = CNAInterface.getPassword2Text();
        
        //if passwords match, adds the user. if user already exists returns an error
        if (password1.equals(password2)){
            client = new Client(username, password1, firstName, lastName, practitioner.getUsername());
            if(broker.addClient(client)){
                practitioner.addClient(client);
                CNAInterface.setMessage("Client added successfully");
                System.out.println("Client added");
                return true;
            }
            else{
                CNAInterface.setMessage("error: username already exists or fields were left empty");
            }
        }
        else{
            CNAInterface.setMessage("passwords do not match");
        }
        return false;
    }
    
}

