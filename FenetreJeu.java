import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class FenetreJeu  extends JFrame{
	
    //ATTRIBUTS
    
    //Panel Haut
    JLabel labelExplication ; //Explications du jeu
    
    //Panel Gauche
    //Caractéristiques du personnage 
    JPanel panelPersoChoisi ;
    JTextArea labelCaracPerso ;  
    JLabel imagePersoChoisi ;
     
    
    //Panel Milieu
    JLabel aireQIA ; //Contient les questions de l'IA
    JButton bOui ; //Bouton de réponse
    JButton bNon ; //Bouton de réponse
    
    //Panel Droite 
    JTextArea PersoPossibles ; //Liste des personnages possibles (voir le raisonnement de l'IA)
    
    
    //Panel Bas
    JLabel labelNomAuteurs ; //Noms auteurs 
    
    //Jeu courant
    Jeu jeu ; 
    
    //fenetre d'accueil 
    FenetreAccueil fenA; 
    
    
    public FenetreJeu(FenetreAccueil fenA){
        super("Qui-est-ce ? - Fenêtre de jeu ") ;  //on definit le nom de la fenetre
        
        jeu= fenA.getJeu(); //récupération du jeu courant
		
		//Dimensions de la fenetre graphique et fermeture
		setSize(1600, 500) ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
        
        
        //===== Instanciation des widgets de la fenêtre ====
        //Haut
		labelExplication = new JLabel("Répond par oui ou par non à la question suivante :  ") ; 
        
        
        //Gauche   ("Ton texte\nTon texte");
        panelPersoChoisi= new JPanel( new BorderLayout());
        labelCaracPerso = new JTextArea("Votre personnage :\nNom: "+jeu.getQui().getNom()+"\nGenre: "+
        jeu.getQui().getGenre()+"\nCouleur cheveux: "+jeu.getQui().getCouleurCheveux()
        +"\nType cheveux: "+jeu.getQui().getTypeCheveux() +"\nYeux: "+jeu.getQui().getCouleurYeux()+"\nAccessoire: "+jeu.getQui().getAccessoire()+
        "\nPays: "+jeu.getQui().getPays()); //description du personnage choisi  
		labelCaracPerso.setEditable(false);
		labelCaracPerso.setBackground(new Color(187,210,225)) ;		
        imagePersoChoisi = new JLabel((jeu.getQui()).getImage()); //récuparation de l'image du personnage choisi
        panelPersoChoisi.add(labelCaracPerso,BorderLayout.SOUTH);
        panelPersoChoisi.add(imagePersoChoisi,BorderLayout.CENTER);
        
        //Milieu
        aireQIA = new JLabel() ;
        aireQIA.setText(jeu.getQuestion().toString());
        bOui = new JButton("OUI"); 
        bOui.setBackground(Color.BLUE);
        bOui.addActionListener(new EcouteurReponse(this, "Oui"));
        bNon = new JButton("NON") ;
        bNon.addActionListener(new EcouteurReponse(this, "Non"));
        
        //Droite 
        PersoPossibles = new JTextArea(15,30);
		PersoPossibles.setText("Personnages possibles:\n"+jeu.getIA().affichePersoPossibles()); //affiche la liste de personnage initiale
        
        //Bas
        labelNomAuteurs = new JLabel("Nom auteurs") ; 
         
        
        
        //=========== Organisation structurelle ======//
		
		//Déclaration et instanciation du conteneur du Haut 
		JPanel panelHaut = new JPanel(); 
		panelHaut.setBackground(new Color(187,210,225)) ; 
		//Ajout des widgets (dans l'ordre de gauche à droite)
		panelHaut.add(labelExplication); 


		//Déclaration et instanciation du conteneurGauche
		JPanel panelGauche = new JPanel(new BorderLayout()); 
		panelGauche.setBackground(new Color(187,210,225)) ; 
        //Ajout des widgets (dans l'ordre de gauche à droite)
        panelGauche.add(labelCaracPerso, BorderLayout.NORTH) ; 
        panelGauche.add(imagePersoChoisi,BorderLayout.SOUTH) ;
            
        
        //Déclaration et instanciation du conteneurCentre
        JPanel panelCentre = new JPanel(new BorderLayout()); 
		panelCentre.setBackground(new Color(240,255,255)) ;
        
        //Déclaration et instanciation sous-conteneurCentre
        JPanel panelBoutons = new JPanel(new GridLayout());  
        panelBoutons.setOpaque(false); 
        //Ajout des widgets (dans l'ordre de gauche à droite)
        panelBoutons.add(bOui) ; 
        panelBoutons.add(bNon) ; 
        
        //Ajout des widgets (dans l'ordre de gauche à droite) dans conteneurCentre
        panelCentre.add(aireQIA,BorderLayout.NORTH) ; 
        panelCentre.add(panelBoutons,BorderLayout.CENTER); 
        
    
        //Déclaration et instanciation du conteneur droite
        JPanel panelDroite = new JPanel(new BorderLayout()); 
        //Ajout des widgets (dans l'ordre de gauche à droite) dans conteneur droite
        panelDroite.add(PersoPossibles) ; 
             
       
        //Déclaration et instanciation du conteneurBas
        JPanel panelBas = new JPanel(); 
        panelBas.setBackground(new Color(187,210,225)) ;
        panelBas.add(labelNomAuteurs); 
		
		
		
		//Ajout des panel a un panel principal
		JPanel cadrePrincipal = new JPanel(new BorderLayout()) ; 
		cadrePrincipal.setBackground(new Color(187,210,225)) ;
		cadrePrincipal.add(panelHaut,BorderLayout.NORTH); 
		cadrePrincipal.add(panelGauche,BorderLayout.WEST); 
        cadrePrincipal.add(panelCentre,BorderLayout.CENTER);
        cadrePrincipal.add(panelDroite,BorderLayout.EAST);
        cadrePrincipal.add(panelBas,BorderLayout.SOUTH);
		
		
		//Ajout du conteneur principal à la fenêtre
		add(cadrePrincipal) ;       
        setVisible(true) ;      
    }
    
    //MÉTHODES
   
   //Getters
    public Jeu getJeu() {
		return jeu;
	}
	
	//Mise à jour de la question posée
	public void afficheQuestion() {
		aireQIA.setText(jeu.getQuestion().toString());
	}
	
	//Mise à jour de la liste des personnages possibles
	public void affichePerso() {
	PersoPossibles.setText("Personnage(s) possible(s):\n"+jeu.getIA().affichePersoPossibles());	
		
	}
}
    
