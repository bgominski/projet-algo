import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class FenetreAccueil extends JFrame{
	
	//ATTRIBUTS
	
	//Variables du jeu courant
	public int nbPersos; //nombre de personnages initialement possi
	private Jeu jeu; //jeu courant
	
	//Widgets du panel Accueil(Haut)
    private JPanel panelAcceuil; 
	private JLabel labelAccueil2; //Label d'instruction
	private JLabel labelAccueil3; //Label untilisé pour un rendu plus esthétique
	private JPanel panel2Accueil; //Panel utilisé pour un rendu plus esthétique
	
    //Widgets du panelSecondaire (Haut) 
    private ImageIcon imageQuiEstCe; //logo du jeu
    private JTextArea labelAccueil1; //Label de bienvenue
    private JButton btnJouer;
    private JTextArea labelDescription; //affiche les règles du jeu 
    private JPanel panel2; //sous panel du panelSecondaire, contient les boutons et les noms des personnages possibles
	private JButton[] tabBtn; //contient les boutons liés aux personnages possibles ( 1 par personnage)
	private JPanel[] tabPan; //contient des oanels liés aux personnages possibles (1 par personnage, contient son nom et son bouton)
    
	//METHODES

	//Constructeur
	public FenetreAccueil(Jeu jeu){
		
		super("Qui est-ce? - Fenetre d'accueil"); //nom de la fenêtre
		this.jeu=jeu; //récupération du jeu courant
		this.nbPersos=jeu.getListePersonnage().size();//récuparation du notre de personnages initialement disponibles
		
		//Dimensions de la fenetre graphique et fermeture
		setSize(1200,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		//Instanciation des widgets de la fenetre secondaire
		this.ajoutChoix();
      
        
        //Instanciation des widgets du panelAccueil
        labelAccueil1 = new JTextArea("\nEDITION SPÉCIALE AMERINSA! ES-TU PRÊT À JOUER CONTRE NOTRE IA?");
        labelAccueil1.setEditable(false);
        labelAccueil1.insert("BIENVENUE DANS 'QUI EST-CE?'", 0); 
        labelAccueil1.setOpaque(false);
        Font  f1  = new Font(Font.DIALOG, Font.BOLD, 25);
        labelAccueil1.setFont(f1); 
        
        
        imageQuiEstCe = new ImageIcon("../Multimedia/Images_autres/Image_Qui-est-ce.png"); //Instanciation de l'icone du jeu
        JLabel imageAccueil = new JLabel(imageQuiEstCe); //Création d'un JLabel pour stocker le logo du jeu
        labelAccueil2= new JLabel("                                                                           "
        +"CHOISIS UN PERSONNAGE PUIS CLIQUE SUR 'JOUER' POUR COMMENCER LA PARTIE!");
        labelAccueil3= new JLabel("  "); //pour espacer les éléments
        
        panel2Accueil = new JPanel(new BorderLayout()); //pour espacer les éléments
        panel2Accueil.setOpaque(false); 
        panel2Accueil.add(labelAccueil1, BorderLayout.WEST) ; 
        panel2Accueil.add(imageAccueil, BorderLayout.EAST) ; 
        panelAcceuil = new JPanel(new BorderLayout());
        panelAcceuil.setOpaque(false) ; 
        panelAcceuil.add(panel2Accueil, BorderLayout.NORTH); 
        panelAcceuil.add(labelAccueil2,BorderLayout.CENTER);
        panelAcceuil.add(labelAccueil3,BorderLayout.SOUTH);
        
        labelDescription = new JTextArea ("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+ //pour centrer le texte
        "Clique sur le joueur de ton choix et\nla machine virtuelle\n tentera de lire dans tes pensées."+
        "Une fois que tu auras cliqué\n n'oublie pas\n pas de cliquer sur le bouton 'jouer' en bas de l'écran ! ");
        labelDescription.setOpaque(true);
        labelDescription.setBackground(new Color(187,210,225)) ; 
        labelDescription.setEditable(false) ; 
        
        
        btnJouer= new JButton("Jouer");
        btnJouer.setOpaque(true);
        btnJouer.setBorderPainted(false);
        btnJouer.setBackground(Color.green) ; 
        btnJouer.addActionListener(new EcouteurJouer(this));
        JPanel panelBouton = new JPanel() ; 
        panelBouton.add(btnJouer) ; 
        
        //Instanciation  des widgets du panel secondaire
        int l =nbPersos/3;
        panel2= new JPanel(new GridLayout(4,l));
        panel2.setOpaque(false) ;
        for (int i=0;i<nbPersos;i++){
			panel2.add(tabPan[i]);
		}
    
		
		//Ajout des éléments au cadre principal      
        setContentPane(new AfficheImage("../Multimedia/Images_autres/Image_salle-de-classe.jpg")); 
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(187,210,225)) ;
        getContentPane().add(panelAcceuil, BorderLayout.NORTH);
        getContentPane().add(panelBouton,BorderLayout.SOUTH);
        getContentPane().add(labelDescription, BorderLayout.WEST);
        getContentPane().add(panel2,BorderLayout.CENTER);
        getContentPane().add(labelAccueil3,BorderLayout.EAST);
        setVisible(true);
	}
    
    
    //Création des boutons de choix
    public void ajoutChoix(){
        tabPan = new JPanel[nbPersos];
		tabBtn= new JButton[nbPersos];
		for (int i=0; i<nbPersos; i++){ 
			tabPan[i]= new JPanel(new BorderLayout());//On crée un panel pour chaque personne
            tabPan[i].setOpaque(false) ; 
			tabBtn[i]= new JButton((jeu.getListePersonnage().get(i)).getImage()) ; //On crée un bouton pour chaque personne en affichant l'image du personnage dans le bouton
			tabPan[i].add(tabBtn[i],BorderLayout.CENTER); //On ajoute les boutons au Panel
			tabPan[i].add(new JLabel("		"+jeu.getListePersonnage().get(i).getNom()), BorderLayout.SOUTH); //Affiche le nom du personnage
			tabPan[i].add(new JLabel("   "), BorderLayout.NORTH); //Pour espacer les boutons
			tabPan[i].add(new JLabel("   "), BorderLayout.EAST); //Pour espacer les boutons
			tabPan[i].add(new JLabel("   "), BorderLayout.WEST); //Pour espacer les boutons
            tabBtn[i].addActionListener(new EcouteurChoixPerso(this, i)); //Définit le personnage du bouton comme 'qui'
        }
    }
    
    //Getters
    public Jeu getJeu(){ 
        return jeu ; 
    }
    
	
}

