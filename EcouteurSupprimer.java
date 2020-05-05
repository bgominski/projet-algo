import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class EcouteurSupprimer implements ActionListener{
      //Instructions a executer au clic du bouton 
	 public void actionPerformed(ActionEvent e) {
          JButton btn = (JButton)(e.getSource()); //on récupère le bouton lié à l'écouteur
          btn.setVisible(false); //on fait disparaitre le bouton
}
}
