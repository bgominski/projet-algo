import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class EcouteurChoixPerso implements ActionListener{
	private FenetreAccueil fen;
    private JButton bouton; 
    private Jeu jeu; 
    private int theIndex; 
    private Personnage qui ; 
	
	public EcouteurChoixPerso(FenetreAccueil fen, int theIndex) {
		this.fen = fen;
        this.theIndex=theIndex; 
		
	}
    //actionPerformed indique les instructions a executer au clic du bouton
    public void actionPerformed(ActionEvent e){
        
        //Instructions a executer au clic d'un des boutons 
       
        //Instancier un jeu en récupérant celui en cours dans la fenêtre Accueil
        jeu=fen.getJeu() ; 
        
        // Récupérer le personnage associé au bouton et le transmettre à la classe Jeu
        qui = jeu.getListePersonnage().get(theIndex); 
        jeu.setQui(qui);
        
    
        }
}
 
    
 
  



        
      
     
    

