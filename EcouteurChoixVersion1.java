import java.awt.event.*;
import java.util.*;

public class EcouteurChoixVersion1 implements ActionListener{
	
	//ATTRIBUTS
	private Jeu jeu ; 
    private FenetreLancement fen; 
	
	//MÉTHODES
	
	//Constructeur
	public EcouteurChoixVersion1(FenetreLancement fen) {
		this.fen = fen;
	}
	
    //Instructions a executer au clic du bouton jouer
    public void actionPerformed(ActionEvent e){
    jeu = new Jeu(1) ; //instanciation d'un jeu de version 1
    }
}
