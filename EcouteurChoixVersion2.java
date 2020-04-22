import java.awt.event.*;
import java.util.*;

public class EcouteurChoixVersion2 implements ActionListener{
	
	//ATTRIBUTS
	private Jeu jeu ; //jeu courant
    private FenetreLancement fen; 
	
	//MÉTHODES
	
	//Constructeur
	public EcouteurChoixVersion2(FenetreLancement fen) {
		this.fen=fen;
	}
	
    //Instructions a executer au clic du bouton jouer
    public void actionPerformed(ActionEvent e){
     
    //On aurait pu comparer un getText, méthode créée dans l'interface de lancement mais j'ai 
    //préféré faire deux écouteurs différents pour ne pas avoir à modifier cette classe si onchange le texte des boutons
    //Dans ce cas on aurait mis un 2e attribut à l'écouteur 
    
    jeu = new Jeu(2) ; 

    }
}
