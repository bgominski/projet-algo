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
        //Chercher si le personne répond à ça, va répondre oui ou non
         //System.out.println(fen.donnerReponse()); 
        //Va actualiser la liste des personnages disponibles
        
    
        fen.refreshList();
        
        fen.donnerReponse();

     }
	
    
    //Va actualiser la liste des personnages disponibles
        
}


