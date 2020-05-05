import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class FenetreRejouer  extends JFrame{
	
	//ATTRIBUTS
	
	FenetreJeu fenetreJeu; //contient la fenêtre de jeu courante
	Jeu jeu; //contient le jeu courant
	JLabel jeuFini; //affiche un message de fin de jeu
	JTextArea descriptionPerso; //affiche la description du perosnnage choisi au début
	JLabel imagePerso; //affiche l'image du perosnnage choisi au début
	JButton btnRejouer; //permet de lancer une nouvelle partie
	
	public FenetreRejouer(FenetreJeu fenetreJeu){
		super("Qui-est-ce ? - Fin de jeu "); //on definit le nom de la fenêtre
		jeu=fenetreJeu.getJeu(); //on écupère le jeu courant
		
		//Dimensions et fermetrure de la fenêtre
		setSize(1280, 1024) ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
        
        //Ajout du fond d'écran
        setContentPane(new AfficheImage("/Users/alainboulard/Desktop/Image Algo/fond-colore-confettis-qui-est-baisse-illustration-vectorielle_41084-389.png")); 
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(187,210,225)) ; 
		
		//===== Instanciation des widgets de la fenêtre ====//
		jeuFini=new JLabel("Notre IA t'as démasqué... Aurais-tu un crush sur:"); //message de fin de jeu
			
		descriptionPerso=new JTextArea("Nom: "+jeu.getQui().getNom()+"\nGenre: "+
        jeu.getQui().getGenre()+"\nCouleur cheveux: "+jeu.getQui().getCouleurCheveux()
        +"\nType cheveux: "+jeu.getQui().getTypeCheveux() +"\nYeux: "+jeu.getQui().getCouleurYeux()); //description du personnage deviné
        
        descriptionPerso.setOpaque(false); 
        descriptionPerso.setEditable(false);
        descriptionPerso.setFont(new Font("Arial", Font.BOLD, 30)); 
        
		imagePerso=new JLabel(jeu.getQui().getImage()); 
		btnRejouer=new JButton("Rejouer !!");
		btnRejouer.addActionListener(new EcouteurRejouer(this));
      
		
		//=========== Organisation structurelle ======//
		
		//On défini la taille et la position des composants
        jeuFini.setBounds(500, 250, 500, 100); 
        descriptionPerso.setBounds(370, 380, 600,800); 
        imagePerso.setBounds(700, 310, 400, 300); 
        btnRejouer.setBounds(560, 700, 150, 35); 
        
        //On ajoute les composants à la fenêtre
        getContentPane().add(jeuFini);
        getContentPane().add(descriptionPerso);
        getContentPane().add(imagePerso);
        getContentPane().add(btnRejouer);
		
		// Fenêtre visible
		setVisible(true);
	}

}
