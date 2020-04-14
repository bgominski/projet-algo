import java.awt.BorderLayout; 
import java.awt.Graphics; 
import java.awt.Image; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 

class AfficheImage extends JPanel { 
    
    Image fondEcran; 


    AfficheImage(String s) 
    { 
    fondEcran = getToolkit().getImage(s); 
    } 

    public void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        g.drawImage(fondEcran , 0, 0, getWidth(), getHeight(), this); 
    } 
} 
