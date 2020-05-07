import java.awt.event.*;
import java.util.*;

public class EcouteurChoixVersion2 implements ActionListener{
	
	//ATTRIBUTS
	private Jeu jeu ; 
    private FenetreLancement fen; 
	
	//MÉTHODES
	
	//Constructeur
	public EcouteurChoixVersion2(FenetreLancement fen) {
		this.fen=fen;
	}
	
    //Instructions a executer au clic du bouton 
    public void actionPerformed(ActionEvent e){
    jeu = new Jeu(2) ; //on instencie un jeu de version 2
    int persoChoisi = (int)(Math.random()*jeu.getListePersonnage().size()); //on choisit un personnage aléatoirement
    jeu.setQui(jeu.getListePersonnage().get(persoChoisi)) ; //on affecte ce personnage au jeu
 
    }
}
