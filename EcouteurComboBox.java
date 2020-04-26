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
	 if (fen.getListeGenre()==null)
	 System.out.println("ListeGenre nulle");
	 if (fen.getboxValeur()==null)
	 System.out.println("boxValeur nulle");
     fen.adapterBoxValeur(); 
     }
	
  

}


