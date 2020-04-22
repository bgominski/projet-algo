import java.awt.event.*;
import java.util.*;

//Pour le son
import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;


public class EcouteurRejouer implements ActionListener{

	//ATTRIBUTS
	private FenetreRejouer fenetreRejouer; //fenetre rejouer liée au jeu courant
	private FenetreAccueil fenetreAcceuil; //nouvelle fenetre d'accueil
	private Jeu jeu; //nouveau jeu
	private AudioInputStream audio;
   // private AudioSystem system = new AudioSystem();
	//MÉTHODES
	
	//Constructeur
	public EcouteurRejouer(FenetreRejouer fenetreRejouer) {
		this.fenetreRejouer=fenetreRejouer;
		this.jeu=new Jeu(1); //création d'un nouveau jeu	
	}
    
	
	public void actionPerformed(ActionEvent e){		
		fenetreRejouer.hide(); //Ferme la fenêtre d'accueil
		fenetreAcceuil = new FenetreAccueil(jeu);  //Ouvre la fenêtre de jeu
        jeu.playSound("/Users/alainboulard/Downloads/Double-Mixte-59.wav");

	}
}
