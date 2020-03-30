import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class FenetreJeu  extends JFrame{
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
    
    
    public FenetreJeu(){
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
        labelQIA = new JLabel ("Questions de l'IA") ;
        bOui = new JButton("OUI"); 
        bOui.addActionListener(new EcouteurReponse(this));
        bNon = new JButton("NON") ;
        bNon.addActionListener(new EcouteurReponse(this));
		
        
        //Bas
        labelNomAuteurs = new JLabel("Nom auteurs") ; 
         
        
        
        //=========== Organisation structurelle ======//
		//Ajout de tous les widgets dans le conteneurHaut
		
		//Déclaration et instanciation du conteneur du Haut 
		JPanel panelHaut = new JPanel(); 
		panelHaut.setBackground(Color.YELLOW) ; 
		//Ajout des widgets (dans l'ordre de gauche à droite)
		panelHaut.add(labelExplication); 
    
	
		
		//Déclaration et instanciation du conteneurMilieuGauche
		JPanel panelMilieuGauche = new JPanel(new BorderLayout()); 
		panelMilieuGauche.setBackground(Color.GREEN) ; 
        //Ajout des widgets (dans l'ordre de gauche à droite)
        panelMilieuGauche.add(labelCaracPerso,BorderLayout.NORTH) ; 
        panelMilieuGauche.add(bPersoChoisi,BorderLayout.SOUTH) ;
        
        //Déclaration et instanciation du conteneurMilieuDroite
        JPanel panelMilieuDroite = new JPanel(new BorderLayout()); 
		panelMilieuDroite.setBackground(Color.BLUE) ; 
        
        //Déclaration et instanciation du sous-conteneurMilieuDroite
        JPanel panelBoutons = new JPanel(); 
       
        //Ajout des widgets (dans l'ordre de gauche à droite)
        panelBoutons.add(bOui) ; 
        panelBoutons.add(bNon) ; 
        
        
        //Ajout des widgets (dans l'ordre de gauche à droite) dans conteneurMilieuDroite
        panelMilieuDroite.add(labelQIA,BorderLayout.NORTH) ; 
        panelMilieuDroite.add(panelBoutons,BorderLayout.SOUTH); 
       
        //panelMilieuDroite.add(labelQIA,BorderLayout.NORTH) ;
    
		
        
         
        
       
        //Déclaration et instanciation du conteneur3
        JPanel panelBas = new JPanel(); 
        panelBas.setBackground(Color.ORANGE) ;
        panelBas.add(labelNomAuteurs); 
		
		
		
		//Ajout des panel a un panel principal
		JPanel cadrePrincipal = new JPanel(new BorderLayout()) ; 
		
		cadrePrincipal.add(panelHaut,BorderLayout.NORTH); 
		cadrePrincipal.add(panelMilieuGauche,BorderLayout.WEST); 
        cadrePrincipal.add(panelMilieuDroite,BorderLayout.CENTER); 
        cadrePrincipal.add(panelBas,BorderLayout.SOUTH);
		
		
		//Ajout le gros conteneur à la fenêtre
		add(cadrePrincipal) ; 
        
        setVisible(true) ; 
        
    
    
    }
}
    
