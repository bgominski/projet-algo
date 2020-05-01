import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class EcouteurSupprimer implements ActionListener{

	 public void actionPerformed(ActionEvent e) {
          JButton btn = (JButton)(e.getSource());
          btn.setVisible(false); //disparition du bouton
}
}
