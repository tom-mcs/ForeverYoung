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
 * this class is the extends JFrame and creates a frame for the program to run into.
 * all interfaces extend JPanel and are placed into this frame.
 * @author Thomas McSkimming
 */
public class MainFrame extends JFrame{
    
    //set/get dimensions        
    private final Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int screenWidth = ScreenSize.width;
    private final int screenHeight = ScreenSize.height;
    private final int frameHeight = screenHeight/2;
    private final int frameWidth = screenWidth/4;
    private final Dimension frameSize = new Dimension(frameWidth,frameHeight);
    
    public MainFrame(){
        super.setSize(frameSize);
        super.setLocation((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2);
    }
    
    public void setPanel(JPanel panel){
        super.getContentPane().removeAll();
        panel.setSize(super.getSize());
        super.add(panel);
        super.revalidate();
        super.repaint();
    }

}
