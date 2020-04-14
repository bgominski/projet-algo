import java.awt.event.*;
import java.util.*;

public class EcouteurJouer implements ActionListener{
	
	//ATTRIBUTS
	private FenetreAccueil fen; //fenêtre accueil liée au jeu courant
	private FenetreJeu fen2; //fenêtre de jeu liée à le fenêtre accueil
	private Jeu jeu ; //jeu courant
	
	//MÉTHODES
	
	//Constructeur
	public EcouteurJouer(FenetreAccueil fen) {
		this.fen = fen;
		this.jeu=fen.getJeu(); //récuprération du jeu courant		
	}
	
    //Instructions a executer au clic du bouton jouer
    public void actionPerformed(ActionEvent e){
		fen.hide(); //Ferme la fenêtre d'accueil
		fen2 = new FenetreJeu(fen);  //Ouvre la fenêtre de jeu
		

    }
}
