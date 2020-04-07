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
        
        // On cherche l'indice du bouton qui a été appuyé
        //On parcourt le tableau de bouton et on prend l'indice de celui qui a été appuyé
       /** int a=0; 
        for(int i=0; i<nbPersos; i++){
            if (e.getSource() == tabBtn[i]) {
			a=i;
            }
        }**/
        //Instancier un jeu en récupérant celui en cours dans la fenêtre Accueil
        
        jeu=fen.getJeu() ; 
        qui = jeu.getListePersonnage().get(theIndex); 
        jeu.setQui(qui);
        //System.out.println(qui.toString()) ;  Vérifier si quand on clique sur le bouton ça set bien le personnage "qui"
    
        }
}
 
    
 
  



        
        // Récupérer le personnage associé du bouton et le transmettre à la classe Jeu
     
    

