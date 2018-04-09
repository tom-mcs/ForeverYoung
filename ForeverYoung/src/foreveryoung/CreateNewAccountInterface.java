/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * This is the create new account interface. It is added to the main frame, when the user selects
 * "New Account" from the welcome interface. It has fields for username and two password fields, a
 * "create" button and a "cancel" button. When a button is selected, the "action"
 * variable is altered. The main method checks this variable to determine what action
 * has been taken by the user.
 * @author Thomas McSkimming
 */
public class CreateNewAccountInterface extends JPanel{
    
    private final JTextField userNameTextField = new JTextField();
    private final JTextField firstNameTextField = new JTextField();
    private final JTextField lastNameTextField = new JTextField();
    private final JPasswordField passwordField1 = new JPasswordField();
    private final JPasswordField passwordField2 = new JPasswordField();
    private JLabel dialog = new JLabel();
    private final JButton createButton = new JButton("create");
    private final JButton cancel = new JButton("cancel");
    private boolean createButtonClicked;
    private boolean cancelButtonClicked;
    
    public CreateNewAccountInterface() {
        this.init();
    }
    
    //initialises components
    private void init(){
        //formatting
        this.setLayout(new GridLayout(2,1));
        this.setBorder(new EmptyBorder(10,10,10,10));
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new BorderLayout(5,5));
        JPanel LabelPanel = new JPanel(new GridLayout(0,1,2,20));
        JPanel TextFieldPanel = new JPanel(new GridLayout(0,1,2,20));
        JPanel ButtonPanel = new JPanel(new FlowLayout());
        Font dialogFont = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
        dialog.setFont(dialogFont);
        
        //create Labels
        JLabel uLabel = new JLabel("Username:", SwingConstants.RIGHT);
        JLabel fnLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        JLabel lnLabel = new JLabel("Last Name:", SwingConstants.RIGHT);
        JLabel pLabel = new JLabel("Password:", SwingConstants.RIGHT);
        JLabel p2Label = new JLabel("Re-enter password", SwingConstants.RIGHT);
        JLabel logo  = new JLabel(new ImageIcon("./lph.png"));
        
        //Add components to panels
        ButtonPanel.add(createButton);
        ButtonPanel.add(cancel);
        LabelPanel.add(uLabel);
        LabelPanel.add(fnLabel);
        LabelPanel.add(lnLabel);
        LabelPanel.add(pLabel);
        LabelPanel.add(p2Label);
        TextFieldPanel.add(userNameTextField);
        TextFieldPanel.add(firstNameTextField);
        TextFieldPanel.add(lastNameTextField);
        TextFieldPanel.add(passwordField1);
        TextFieldPanel.add(passwordField2);
        topPanel.add(logo);
        bottomPanel.add(TextFieldPanel, BorderLayout.CENTER);
        bottomPanel.add(LabelPanel, BorderLayout.WEST);
        bottomPanel.add(dialog, BorderLayout.NORTH);
        bottomPanel.add(ButtonPanel, BorderLayout.SOUTH);
        
        //add panels to main panel
        this.add(topPanel);
        this.add(bottomPanel);
        
        //add action listeners
        createButton.addActionListener(createButtonAL);
        cancel.addActionListener(cancelButtonAL);
    }
    
    /**
     * returns true if a user is created
     * otherwise displays an error message and returns false
     */
    public boolean create(){

        String username = userNameTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String password1 = passwordField1.getText();
        String password2 = passwordField2.getText();
        
        //if passwords match, adds the user. if user already exists returns an error
        if (password1.equals(password2)){
            if(Broker.addUser(username, password1, firstName, lastName)){
                setMessage("user added successfully");
                return true;
            }
            else{
                setMessage("error: username already exists or fields were left empty");
            }
        }
        else{
            setMessage("passwords do not match");
        }
        return false;
    }

    public boolean isCreateButtonClicked() {
        return createButtonClicked;
    }

    public void setCreateButtonClicked(boolean createButtonClicked) {
        this.createButtonClicked = createButtonClicked;
    }

    public boolean isCancelButtonClicked() {
        return cancelButtonClicked;
    }

    public void setCancelButtonClicked(boolean cancelButtonClicked) {
        this.cancelButtonClicked = cancelButtonClicked;
    }
    
    public void setDefaultButton()throws NullPointerException{
        this.getRootPane().setDefaultButton(createButton);
    }
    
    private void setMessage(String message){
        dialog.setText(message);
    }
    private void clearMessage(){
        dialog.setText("");
    }
    
    private ActionListener createButtonAL = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            createButtonClicked = true;
        }
    };
    
    private ActionListener cancelButtonAL = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            cancelButtonClicked = true;
        }
    };
}