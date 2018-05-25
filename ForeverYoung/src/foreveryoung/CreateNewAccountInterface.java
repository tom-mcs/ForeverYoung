/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import static foreveryoung.ForeverYoung.textFont;
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
    private String parent;
    
    public CreateNewAccountInterface() {
        this.parent = null;
        this.init();
    }
    
    public CreateNewAccountInterface(String parent) {
        this.parent = parent;
        this.init();
    }
    
    //initialises components
    private void init(){
        //formatting
        this.setLayout(new GridLayout(2,1));
        this.setBorder(new EmptyBorder(10,10,10,10));
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new BorderLayout(5,5));
        JPanel LabelPanel = new JPanel(new GridLayout(0,1,2,2));
        JPanel TextFieldPanel = new JPanel(new GridLayout(0,1,2,2));
        JPanel ButtonPanel = new JPanel(new FlowLayout());
        Font dialogFont = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
        dialog.setFont(dialogFont);
        
        //create Labels
        JLabel uLabel = new JLabel("Username:", SwingConstants.RIGHT);
        JLabel fnLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        JLabel lnLabel = new JLabel("Last Name:", SwingConstants.RIGHT);
        JLabel pLabel = new JLabel("Password:", SwingConstants.RIGHT);
        JLabel p2Label = new JLabel("Re-enter password", SwingConstants.RIGHT);
        uLabel.setFont(textFont);
        fnLabel.setFont(textFont);
        lnLabel.setFont(textFont);
        pLabel.setFont(textFont);
        p2Label.setFont(textFont);
        userNameTextField.setFont(textFont);
        firstNameTextField.setFont(textFont);
        lastNameTextField.setFont(textFont);
        passwordField1.setFont(textFont);
        passwordField2.setFont(textFont);
        createButton.setFont(textFont);
        cancel.setFont(textFont);
        
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
    
    public String getUsernameText(){
        return userNameTextField.getText();
    }
    
    public String getPassword1Text(){
        return passwordField1.getText();
    }
    
    public String getPassword2Text(){
        return passwordField2.getText();
    }
    
    public String getFirstNameText(){
        return firstNameTextField.getText();
    }
    
    public String getLastNameText(){
        return lastNameTextField.getText();
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
    
    public void setMessage(String message){
        dialog.setText(message);
    }
    
    public void clearMessage(){
        dialog.setText("");
    }
    
    public void clearFields(){
        userNameTextField.setText("");
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
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