import java.awt.event.*;
import java.util.*;

public class EcouteurReponse implements ActionListener{
	private FenetreJeu fen;
    private String rep ; 
	private IA ia ;
    private Jeu jeu ; 
	public EcouteurReponse(FenetreJeu fen, String rep) {
		this.fen = fen;
        this.rep = rep ; 
		
	}
    //actionPerformed indique les instructions a executer au clic du bouton
    public void actionPerformed(ActionEvent e){
    
        jeu = fen.getJeu(); 
        ia = new IA(jeu); /**instancie un IA avec le jeu en cours dans la fenetreJeu donc pas besoin d'instancier jeu ?**/
        System.out.println("nouvelle boucle");
        ia.afficheListe();
        Question Query = ia.QuestionIA();
        System.out.println(Query.toString());
        System.out.println("Veuillez saisir réponse :");     
        if(rep.equals("Oui")){
        //Appel de la méthode triant les personnage en fonction de la réponse
        ia.UpdateListes(true,Query);
         //Appeler la methode fenêtre accueil pour mettre à jour les personnages possibles
        }
        
        
        //Même procédé avec la réponse non
        if(rep.equals("Non")){
        ia.UpdateListes(false,Query);
            
        
    }
	}
    
}

