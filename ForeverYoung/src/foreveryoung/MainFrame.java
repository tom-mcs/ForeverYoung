/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreveryoung;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * this class is the extends JFrame and creates a frame for interfaces to be displayed in.
 * all interfaces extend JPanel and are placed into this frame.
 * @author Thomas McSkimming
 */
public class MainFrame extends JFrame{
    
    //Initial Dimensions        
    private final Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int screenWidth = ScreenSize.width;
    private final int screenHeight = ScreenSize.height;
    private final int frameHeight = screenHeight - 300;
    private final int frameWidth = screenWidth - 600;
    private final Dimension frameSize = new Dimension(frameWidth,frameHeight);
    
    //constructor
    public MainFrame(){
        super.setSize(frameSize);
        super.setLocationRelativeTo(null);        
        this.setVisible(true);
    }
    
    //Set the panel that is placed into the main frame.
    public void setPanel(JPanel panel){
        super.getContentPane().removeAll();
        panel.repaint();
        panel.revalidate();
        super.add(panel);
        super.revalidate();
        super.repaint();
    }
 
}
