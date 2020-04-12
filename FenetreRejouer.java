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
		setSize(350, 300) ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
		
		//===== Instanciation des widgets de la fenêtre ====//
		jeuFini=new JLabel("Notre IA t'as démasqué... Aurais-tu un crush sur:");
		descriptionPerso=new JTextArea("Nom: "+jeu.getQui().getNom()+"\nGenre: "+
        jeu.getQui().getGenre()+"\nCouleur cheveux: "+jeu.getQui().getCouleurCheveux()
        +"\nType cheveux: "+jeu.getQui().getTypeCheveux() +"\nYeux: "+jeu.getQui().getCouleurYeux());
        descriptionPerso.setEditable(false);
		imagePerso=new JLabel(new ImageIcon("/Users/emmanuelle/Desktop/21 ROUSSI Emmanuelle.JPG")); //À REMPLACER PAR L'IMAGE DE 'QUI'
		btnRejouer=new JButton("Rejouer");
		btnRejouer.addActionListener(new EcouteurRejouer(this));
		
		//=========== Organisation structurelle ======//
		
		JPanel panelPrincipal=new JPanel(new BorderLayout()); //panel contenant tous les widgets
		panelPrincipal.add(jeuFini,BorderLayout.NORTH);
		panelPrincipal.add(imagePerso,BorderLayout.WEST);
		panelPrincipal.add(descriptionPerso,BorderLayout.CENTER);
		panelPrincipal.add(btnRejouer,BorderLayout.SOUTH);
		
		//Ajout du panel principal a la fenetre
		this.add(panelPrincipal);
		setVisible(true);
	}

}
