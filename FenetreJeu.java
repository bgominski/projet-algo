import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class FenetreJeu  extends JFrame{
    //Declaration des attributs de la fenêtre
    
    //Panel Haut
    //Explications
    JLabel labelExplication ; 
    
    //Panel Gauche
    //Caractéristiques du personnage 
     JLabel labelCaracPerso ;  
     /** Sera une image plus tard mais sait pas encore faire**/
    //Image voir perso 
    JLabel imagePersoChoisi ;
     
    
    //Panel Milieu
    //Questions de l'IA
    JLabel labelQIA ; 
    //Bouton voir perso 
    JButton bOui ; 
    JButton bNon ;
    
    //Panel Droite 
    JLabel labelListePerso ; 
    
    
    //Panel Bas
    //Noms auteurs
    JLabel labelNomAuteurs ; 
    
   
    
    
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
        imagePersoChoisi = new JLabel( new ImageIcon("/Users/alainboulard/Desktop/École/INSA/2A/Info/S4/Projet algo/4_DOCUMENT EXPLICATIF/Photos classe/Capture d’écran 2020-03-28 à 20.11.02.png")); 
        labelQIA = new JLabel ("Questions de l'IA") ;
        bOui = new JButton("OUI"); 
        bOui.addActionListener(new EcouteurReponse(this));
        bNon = new JButton("NON") ;
        bNon.addActionListener(new EcouteurReponse(this));
        
        //Droite 
        labelListePerso = new JLabel ("Personnages restants possibles :") ;
		
        
        //Bas
        labelNomAuteurs = new JLabel("Nom auteurs") ; 
         
        
        
        //=========== Organisation structurelle ======//
		//Ajout de tous les widgets dans le conteneurHaut
		
		//Déclaration et instanciation du conteneur du Haut 
		JPanel panelHaut = new JPanel(); 
		panelHaut.setBackground(Color.YELLOW) ; 
		//Ajout des widgets (dans l'ordre de gauche à droite)
		panelHaut.add(labelExplication); 
    
	
		
		//Déclaration et instanciation du conteneurGauche
		JPanel panelGauche = new JPanel(new BorderLayout()); 
		panelGauche.setBackground(Color.GREEN) ; 
        //Ajout des widgets (dans l'ordre de gauche à droite)
        panelGauche.add(labelCaracPerso, BorderLayout.NORTH) ; 
        panelGauche.add(imagePersoChoisi,BorderLayout.SOUTH) ;
        
        
        
        //Déclaration et instanciation du conteneurCentre
        JPanel panelCentre = new JPanel(new BorderLayout()); 
		panelCentre.setBackground(Color.BLUE) ;
        
        //Déclaration et instanciation sous-conteneurCentre
        JPanel panelBoutons = new JPanel(new GridLayout());  
        //panelBoutons.setBackground(Color.BLUE) ;
        panelBoutons.setOpaque(false); /** Pour ne pas laisser apparaître la couleur initiale du panel et permettre de voir la couleur du panel parent**/
        //Ajout des widgets (dans l'ordre de gauche à droite)
        panelBoutons.add(bOui) ; 
        panelBoutons.add(bNon) ; 
        
        //Ajout des widgets (dans l'ordre de gauche à droite) dans conteneurCentre
        panelCentre.add(labelQIA,BorderLayout.NORTH) ; 
        panelCentre.add(panelBoutons,BorderLayout.CENTER); 
        
    
        //Déclaration et instanciation du conteneur Droite
        JPanel panelDroite = new JPanel(new BorderLayout()); 
		//panelDroite.setBackground(Color.???) ;
        //Ajout des widgets (dans l'ordre de gauche à droite) dans conteneurCentre
        panelDroite.add(labelListePerso) ; 
        
        
        
       
        //Déclaration et instanciation du conteneurBas
        JPanel panelBas = new JPanel(); 
        panelBas.setBackground(Color.ORANGE) ;
        panelBas.add(labelNomAuteurs); 
		
		
		
		//Ajout des panel a un panel principal
		JPanel cadrePrincipal = new JPanel(new BorderLayout()) ; 
		
		cadrePrincipal.add(panelHaut,BorderLayout.NORTH); 
		cadrePrincipal.add(panelGauche,BorderLayout.WEST); 
        cadrePrincipal.add(panelCentre,BorderLayout.CENTER);
        cadrePrincipal.add(panelDroite,BorderLayout.EAST);
        cadrePrincipal.add(panelBas,BorderLayout.SOUTH);
		
		
		//Ajout le gros conteneur à la fenêtre
		add(cadrePrincipal) ; 
        
        setVisible(true) ; 
        
    
    
    }
}
    
