import java.awt.event.*;
import java.util.*;

public class EcouteurComboBox implements ActionListener{
	
	//ATTRIBUTS
	private Jeu jeu ; 
    private FenetreJeu2 fen; 
	
	
	//Constructeur
	public EcouteurComboBox(FenetreJeu2 fen) {
		this.fen = fen;
	}
    
    //MÉTHODES
     public void actionPerformed(ActionEvent e){
     fen.adapterBoxValeur(); 
     }
	
  

}


