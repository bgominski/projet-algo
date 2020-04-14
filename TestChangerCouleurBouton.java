import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;

public class TestChangerCouleurBouton extends JFrame{

    //ATTRIBUTS
    
    
    public TestChangerCouleurBouton(){
   
    setSize(1280, 1024); 
    setTitle("Test"); 

    
    JButton coloredButton1 = new JButton("One");
    coloredButton1.setUI((ButtonUI) BasicButtonUI.createUI(coloredButton1));
    coloredButton1.setBackground(Color.CYAN);
   

    JPanel panelPrincipal = new JPanel(); 
    panelPrincipal.add(coloredButton1) ; 
     
    
    add(panelPrincipal);
    
    setVisible(true) ; 
    

    }
}
	
