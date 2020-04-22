import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class FenetreJeu2  extends JFrame{
    /*
     * ATTRIBUTS
     * 
     * 
     * */
    
    //fenetre d'accueil 
    FenetreAccueil fenA; 
    
    //Panel Haut
    JLabel labelExplication ; 
    
    //Panel Gauche
    JPanel PanelRegles;
    
    //Panel Bas
    JLabel labelNomAuteurs ; //Noms auteurs
    
    //Panel ListePerso
    JPanel PanelListe;
    
    //Panel Menus déroulants
    JPanel PanelDemande
    JButton ButtonQuery;
    
    
    //Jeu courant
    Jeu jeu ; 
    
    public FenetreJeu2(FenetreAccueil fenA){
        super("Qui-est-ce ? - Fenêtre de jeu ") ;  //on definit le nom de la fenetre
        
        jeu= fenA.getJeu(); 
		
		//Dimensions de la fenetre graphique et fermeture
        setSize(1600, 500) ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        
        //===== Instanciation des widgets de la fenêtre ====
        
        labelExplication = new JLabel("Pour poser une question, choisissez la caractéristique grâce aux menus déroulants puis cliquez sur ""DEMANDER""") ; 
        
