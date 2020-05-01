import java.awt.event.*;
import java.util.*;

public class EcouteurDemander implements ActionListener{
	
	//ATTRIBUTS
	private Jeu jeu ; 
    private FenetreJeu2 fen; 
	
	
	//Constructeur
	public EcouteurDemander(FenetreJeu2 fen) {
		this.fen = fen;
	}
    
    //MÉTHODES
     public void actionPerformed(ActionEvent e){
        fen.refreshList(); //mise à jour de la ComboBox boxValeur
        fen.donnerReponse(); //affichage de la réponse
     }
}


