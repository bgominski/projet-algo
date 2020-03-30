import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class FenetreJeu2  extends JFrame{
    //Declaration des attributs de la fenêtre
    
    //Explications
    JLabel labelExplication ; 
    
    //Questions de l'IA
    JLabel labelQIA ; 
    
    //Caractéristiques du personnage 
     JLabel labelCaracPerso ; 
     
    //Noms auteurs
    JLabel labelNomAuteurs ; 
    
    /** Sera une image plus tard mais sait pas encore faire**/
    //Bouton voir perso 
    JButton bPersoChoisi ;
    
    
    //Boutons réponse
    JButton bOui ; 
    JButton bNon ; 
    
    
    public FenetreJeu2(){
        super("Qui-est-ce ? -- Fenêtre de jeu --") ;  //on definit le nom de la fenetre
		
		//Dimensions de la fenetre graphique et fermeture
		setSize(1200, 400) ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
        
        
        //===== Instanciation des widgets de la fenêtre ====
        
        //Haut
		labelExplication = new JLabel("Répondre par oui ou par non à la question suivante :  ") ; 
        
        
        //Milieu 
        labelCaracPerso = new JLabel ("Caractéristiques du personnage") ;
        bPersoChoisi = new JButton("Perso Choisi") ; 
        labelQIA = new JLabel ("CQuestions de l'IA") ;
        bOui = new JButton("OUI"); 
        bNon = new JButton("NON") ;
		
        
        //Bas
        labelNomAuteurs = new JLabel("Nom auteurs") ; 
         
        
        
        //=========== Organisation structurelle ======//
		//Ajout de tous les widgets dans le conteneurHaut
		
		//Déclaration et instanciation du conteneur1
		JPanel panelHaut = new JPanel(); 
		panelHaut.setBackground(Color.YELLOW) ; 
		//Ajout des widgets (dans l'ordre de gauche à droite)
		panelHaut.add(labelExplication); 
        
	
		
		//Ajout de tous les widgets dans le conteneur2 
		
		//Déclaration et instanciation du conteneurMilieu
		JPanel panelMilieu = new JPanel(); 
		panelMilieu.setBackground(Color.GREEN) ; 
        JPanel panelMGauche = new JPanel();
        JPanel panelMDroite = new JPanel();
        JPanel panelBoutons = new JPanel(); 
		//Ajout des widgets (dans l'ordre de gauche à droite)
        panelBoutons.add(bOui) ; 
        panelBoutons.add(bNon) ; 
        
        panelMGauche.add(labelCaracPerso) ; 
        panelMGauche.add(bPersoChoisi) ;
         
        panelMDroite.add(labelQIA) ; 
        panelMDroite.add(panelBoutons) ; 
        
        
		panelMilieu.add(panelMGauche,BorderLayout.NORTH); 
        panelMilieu.add(panelMDroite,BorderLayout.SOUTH); 
       
        
        //Déclaration et instanciation du conteneur3
        JPanel panelBas = new JPanel(); 
        panelBas.setBackground(Color.ORANGE) ;
        panelBas.add(labelNomAuteurs); 
		
		
		
		//Ajout des panel a un panel principal
		JPanel cadrePrincipal = new JPanel(new BorderLayout()) ; 
		
		cadrePrincipal.add(panelHaut,BorderLayout.NORTH); 
		cadrePrincipal.add(panelMilieu,BorderLayout.CENTER); 
        cadrePrincipal.add(panelBas, BorderLayout.SOUTH);
		
		
		//Ajout le gros conteneur à la fenêtre
		add(cadrePrincipal) ; 
        
        setVisible(true) ; 
        
    
    
    }
}
    
