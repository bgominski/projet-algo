import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class FenetreLancement extends JFrame{
	
	//ATTRIBUTS
	
	//Conteneur Haut
	JLabel labelAccueil ;
	
	//Conteneur Gauche
	JTextArea texteInstructions;
	
	//Conteneur Bas
	JLabel nomAuteurs;
	
	//Conteneur centre
	JButton btnV1;
	JButton btnV2;
	
	//CONSTRUCTEUR
	public FenetreLancement(){
		
		//Nom, dimensions  et fermeture de la fenetre graphique
		super("Qui-est-ce ? - Fenêtre de lancement ") ;
		setSize(1000,250) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
		
	
		//===== Instanciation des widgets de la fenêtre ====//
		//Conteneur Haut
		labelAccueil=new JLabel("BIENVENUE DANS 'QUI EST-CE?', ÉDITION AMERINSA 2020 !");
	
		//Conteneur Gauche
		texteInstructions= new JTextArea("Le but du jeu est de deviner l'identité d'un personnage \nen posant des questions sur ses caractéristiques physiqyes \n" + 
		"Tu as donc le choix entre deux versions:\n Version 1: notre IA devine le personnageque tu auras choisi \n Version 2: Tu dois deviner le personnage choisi  par l'IA "+
		"\n"+" \n Clique sur un des deux boutons (Version 1 ou Version 2)\n pour commencer à jouer!");
		texteInstructions.setEditable(false);
		texteInstructions.setBackground(new Color(187,210,225)) ;
	
		//Conteneur Bas
		nomAuteurs = new JLabel ("Auteurs : BOULARD Solenn, GOMINSKI Benjamin, ROUSSI Emmanuelle");
		
		//Conteneur centre
		btnV1 = new JButton("Version 1:\nJe choisis un personnage!");
        btnV1.addActionListener(new EcouteurChoixVersion1(this));
		btnV2 = new JButton("Version 2:\nJe devine un personnage!");
        btnV2.addActionListener(new EcouteurChoixVersion2(this));
        
		
		//=========== Organisation structurelle ======//
		
		//Création du panel secondaire
		JPanel panelSecondaire = new JPanel(new GridLayout(1,2));
		//Ajout des widgets au panel secondaire
		panelSecondaire.add(btnV1);
		panelSecondaire.add(btnV2);
		
		
		//Création du panel principal
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		//Ajout des widgets au conteneur principal
		panelPrincipal.add(labelAccueil,BorderLayout.NORTH);
		panelPrincipal.add(texteInstructions,BorderLayout.WEST);
		panelPrincipal.add(panelSecondaire,BorderLayout.CENTER);
		panelPrincipal.add(nomAuteurs,BorderLayout.SOUTH);
		
		//Ajout du panel principal à la fenêtre
		add(panelPrincipal) ;       
        setVisible(true) ;  
		
	
	}
	
	

}
