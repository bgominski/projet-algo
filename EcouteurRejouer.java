import java.awt.event.*;
import java.util.*;

public class EcouteurRejouer implements ActionListener{

	//ATTRIBUTS
	private FenetreRejouer fenetreRejouer; //fenetre rejouer liée au jeu courant
	private FenetreAccueil fenetreAcceuil; //nouvelle fenetre d'accueil
	private Jeu jeu; //nouveau jeu
	
	//MÉTHODES
	
	//Constructeur
	public EcouteurRejouer(FenetreRejouer fenetreRejouer) {
		this.fenetreRejouer=fenetreRejouer;
		this.jeu=new Jeu(); //création d'un nouveau jeu	
	}
	
	public void actionPerformed(ActionEvent e){		
		fenetreRejouer.hide(); //Ferme la fenêtre d'accueil
		fenetreAcceuil = new FenetreAccueil(jeu);  //Ouvre la fenêtre de jeu

	}
}
