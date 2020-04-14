import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class FenetreRejouer  extends JFrame{
	
	//ATTRIBUTS
	
	FenetreJeu fenetreJeu; 
	Jeu jeu; //jeu courant
	JLabel jeuFini; 
	JTextArea descriptionPerso; //affiche la description du perosnnage choisi au début
	JLabel imagePerso; //affiche l'image du perosnnage choisi au début
	JButton btnRejouer; //permet de lancer une nouvelle partie
	
	public FenetreRejouer(FenetreJeu fenetreJeu){
		super("Qui-est-ce ? - Fin de jeu "); //on definit le nom de la fenêtre
		jeu=fenetreJeu.getJeu();
		
		//Dimensions et fermetrure de la fenêtre
		setSize(1280, 1024) ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
        
        //Ajout du fond d'écran
        setContentPane(new AfficheImage("/Users/alainboulard/Desktop/Image Algo/fond-colore-confettis-qui-est-baisse-illustration-vectorielle_41084-389.png")); 
        getContentPane().setLayout(new BorderLayout()); 
        getContentPane().setBackground(new Color(187,210,225)) ; 
		
		//===== Instanciation des widgets de la fenêtre ====//
		jeuFini=new JLabel("Notre IA t'as démasqué... Aurais-tu un crush sur:");
		descriptionPerso=new JTextArea("Nom: "+jeu.getQui().getNom()+"\nGenre: "+
        jeu.getQui().getGenre()+"\nCouleur cheveux: "+jeu.getQui().getCouleurCheveux()
        +"\nType cheveux: "+jeu.getQui().getTypeCheveux() +"\nYeux: "+jeu.getQui().getCouleurYeux());
        descriptionPerso.setOpaque(false); 
        descriptionPerso.setEditable(false);
        descriptionPerso.setFont(new Font("Arial", Font.BOLD, 35));
		imagePerso=new JLabel(jeu.getQui().getImage()); //À REMPLACER PAR L'IMAGE DE 'QUI'
		btnRejouer=new JButton("Rejouer !!");
		btnRejouer.addActionListener(new EcouteurRejouer(this));
      
		
		//=========== Organisation structurelle ======//
		
		JPanel panelPrincipal=new JPanel(new BorderLayout()); //panel contenant tous les widgets
        getContentPane().add(jeuFini,BorderLayout.NORTH);
        getContentPane().add(imagePerso,BorderLayout.WEST);
        getContentPane().add(descriptionPerso,BorderLayout.CENTER);
        getContentPane().add(btnRejouer,BorderLayout.SOUTH);
		
		// Fenêtre visible
		setVisible(true);
	}

}