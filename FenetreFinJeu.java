import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;



public class FenetreFinJeu extends JFrame{

    //ATTRIBUTS
    
    
    public FenetreFinJeu(){
        
    /** Première option 
    this.add(new JLabel(new ImageIcon("/Users/alainboulard/Desktop/Image Algo/QuiEstce.png")));	
    this.pack(); 
    this.setVisible(true); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    * **/
    
    setSize(1280, 1024); 
    setTitle("Test"); 
    
   
    setContentPane(new AfficheImage("/Users/alainboulard/Desktop/Image Algo/fond-colore-confettis-qui-est-baisse-illustration-vectorielle_41084-389.png")); 
    getContentPane().setLayout(new FlowLayout()); 
    getContentPane().setBackground(new Color(187,210,225)) ; 
    
    JTextArea aireCongrats = new JTextArea("Youpiiii la machine a trouvé ton personnage ! ") ;
    aireCongrats.setOpaque(false) ;  
    aireCongrats.setEditable(false) ; 
    aireCongrats.setLocation(20,20) ; 
    aireCongrats.setFont(new Font("Arial", Font.BOLD, 35));
    JButton bReJouer = new JButton("Rejouer !") ;
    //bReJouer.setLocation(50, 50) ; //Fonctionne pas
    bReJouer.setBackground(Color.red) ; 
     bReJouer.setForeground(Color.red) ; 
    //bRejouer.setOpaque(false) ;  
   // Dimension tailleMaxBouton = new Dimension(1, 5) ; 
    //bReJouer.setSize(tailleMaxBouton); 
    
    /**
    JPanel panelCentre = new JPanel() ; 
    panelCentre.add(aireCongrats) ; 
    panelCentre.setOpaque(false);
    
    JPanel panelSUD = new JPanel() ;
    panelSUD.add(bReJouer) ; 
    panelSUD.setOpaque(false);
 
    getContentPane().add(panelCentre, BorderLayout.CENTER) ; 
    getContentPane().add(panelSUD, BorderLayout.SOUTH) ;
    * **/
    getContentPane().add(bReJouer) ; 
    getContentPane().add(aireCongrats) ;
    
    
    /**
    ImageIcon image = new ImageIcon(new ImageIcon("/Users/alainboulard/Desktop/salle de classe.jpg").getImage().getScaledInstance(20,50, Image.SCALE_DEFAULT)) ; 
    JLabel imageFond = new JLabel(image); 
    getContentPane().add(imageFond, BorderLayout.NORTH) ; 
    * **/
    this.setVisible(true); 
    
    
    
 
    /** Le pack sert à adapter la taille de l'image à la taille de la fenêtre 
     * 
    this.add(new JLabel(new ImageIcon("/Users/alainboulard/Desktop/fond-colore-confettis-qui-est-baisse-illustration-vectorielle_41084-389.png")));	
    this.pack(); //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents. The resulting width and height of the window are automatically enlarged if either of dimensions is less than the minimum size as specified by the previous call to the setMinimumSize method.
                 //If the window and/or its owner are not displayable yet, both of them are made displayable before ca
    this.setVisible(true); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    * **/

    
    
    }
    
    
  

}
	
