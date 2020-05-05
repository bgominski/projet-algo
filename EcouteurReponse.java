import java.awt.event.*;
import java.util.*;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

public class EcouteurReponse implements ActionListener{
	private FenetreJeu fen; //fenetre de jeu courante
    private String rep ; 
    private Jeu jeu ; //jeu courant
    private Question query ; //dernière question posée
    private AudioInputStream audio; //son
    
    //Constructeur
	public EcouteurReponse(FenetreJeu fen, String rep) {
		//Récuparation des attribus de la fenetre jeu
		this.fen = fen;
		this.jeu= fen.getJeu();
        this.rep = rep ; 
		
	}
	
    //instructions a executer au clic du bouton
    public void actionPerformed(ActionEvent e){
		
        //instructions si la réponse est 'Oui'
        if(rep.equals("Oui")){
    
        jeu.getIA().UpdateListes(true,jeu.getQuestion()); //Mise à jour des listes selon la réponse
        query = jeu.getIA().QuestionIA(); //génération d'une nouvelle question
        jeu.setQuestion(query); //affectation de cette question au jeu
        fen.afficheQuestion(); //Affichage de la question
        fen.affichePerso(); //Mise à jour des persos possible
        jeu.playSound("/Users/alainboulard/Desktop/OUI.wav"); //son au clic du bouton
        
            if(jeu.getIA().PersonnageFound()==true){
                FenetreRejouer fenetreRejouer = new FenetreRejouer(fen) ; //si le personnage est trouvé, le jeu est fini
            } 
        }
         
        //instructions si la réponse est 'Oui'
        if(rep.equals("Non")){
        
        jeu.getIA().UpdateListes(false,jeu.getQuestion()); //Mise à jour des listes selon la réponse
        query = jeu.getIA().QuestionIA(); //génération d'une nouvelle question
        jeu.setQuestion(query);//affectation de cette question au jeu
        System.out.println(jeu.getQuestion().toString()); //Pour vérifier la question
        fen.afficheQuestion(); //Affichage de la question
        fen.affichePerso(); //Mise à jour des persos possible
        jeu.playSound("/Users/alainboulard/Desktop/NON.wav"); //son au clic du bouton
        
            if(jeu.getIA().PersonnageFound()==true){
                    FenetreRejouer fenetreRejouer = new FenetreRejouer(fen) ; //si le personnage est trouvé, le jeu est fini
                }           
        }
    } 
}
    
	
    

