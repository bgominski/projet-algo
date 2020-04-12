import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class FenetreAccueil extends JFrame{
	
	//ATTRIBUTS
	
	//Variables du jeu courant
	public int nbPersos; //nombre de personnages initiale
	private Jeu jeu; //jeu courant
	
	//Widgets du panel Accueil
    private JPanel panelAcceuil; 
	private JLabel labelAccueil1; //LLbel de bienvue
	private JLabel labelAccueil2; //Label d'instruction
	private JLabel labelAccueil3; //Label untilisé pour un rendu plus esthétique
	private JPanel panel2Accueil; //Panel utilisé pour un rendu plus esthétique
	private JLabel labelDescription;
	private JButton btnJouer;
    private ImageIcon imageQuiEstCe; 
	
	//Widgets du panel Secondaire
	private JButton[] tabBtn;
	private JPanel[] tabPan;
    
	//METHODES
    
    /**
     * Constructeur de la classe FenetreAccueil
     */
	
	//Constructeur
	public FenetreAccueil(Jeu jeu){
		
		super("Qui est-ce? - Fenetre d'accueil");
		this.jeu=jeu; //récupération d'un nouveau jeu
		this.nbPersos=jeu.getListePersonnage().size();//récuparation du notre de personnages initiale
		
		//Dimensions de la fenetre graphique et fermeture
		setSize(1200,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		//Instanciation des widgets de la fenetre secondaire
		this.ajoutChoix();
      
        
        //Instanciation des widges de la fenetre principale
        labelAccueil1 = new JLabel("                                                                  "
        +"BIENVENUE DANS 'QUI EST-CE?' ÉDITION SPÉCIALE AMERINSA! ES-TU PRÊT À JOUER CONTRE NOTRE IA?");
        imageQuiEstCe = new ImageIcon("/Users/alainboulard/Desktop/Image Algo/QuiEstce.png"); 
        JLabel imageAccueil = new JLabel(imageQuiEstCe);
        labelAccueil2= new JLabel("                                                                           "
        +"CHOISI UN PERSONNAGE PUIS CLIQUE SUR 'JOUER' POUR COMMENCER LA PARTIE!");
        labelAccueil3= new JLabel("  ");
        panel2Accueil = new JPanel(new BorderLayout());
        panel2
        panelAcceuil = new JPanel(new BorderLayout());
        panelAcceuil.setBackground(new Color(187,210,225)) ; 
        panelAcceuil.add(labelAccueil1, BorderLayout.NORTH); 
        panelAcceuil.add(imageAccueil, BorderLayout.NORTH); 
        panelAcceuil.add(labelAccueil2,BorderLayout.CENTER);
        panelAcceuil.add(labelAccueil3,BorderLayout.SOUTH);
        
        labelDescription = new JLabel ("Description et règles du jeu");
        btnJouer= new JButton("Jouer");
        btnJouer.setForeground(new Color(0,123, 123)); //Changer la couleur de la police
        //btnJouer.setBackground(new Color(12,255,14)); //changer la couleur du bouton
        btnJouer.addActionListener(new EcouteurJouer(this));
        
        //Instanciation panel secondaire
        int l =nbPersos/3;
        JPanel panel2= new JPanel(new GridLayout(4,l));
        panel2.setBackground(new Color(240,255,255)) ; 
        for (int i=0;i<nbPersos;i++){
			panel2.add(tabPan[i]);
		}
		
		//Instanciation du panel principal
		JPanel panel1 = new JPanel (new BorderLayout()); 
		panel1.setBackground(new Color(187,210,225)) ; 
		panel1.add(panelAcceuil, BorderLayout.NORTH);
		panel1.add(btnJouer,BorderLayout.SOUTH);
		panel1.add(labelDescription, BorderLayout.WEST);
		panel1.add(panel2,BorderLayout.CENTER);
		panel1.add(labelAccueil3,BorderLayout.EAST);
         
        this.add(panel1);
        setVisible(true);
	}
    
    //Création des boutons de choix
    public void ajoutChoix(){
        tabPan = new JPanel[nbPersos];
		tabBtn= new JButton[nbPersos];
		for (int i=0; i<nbPersos; i++){ 
			tabPan[i]= new JPanel(new BorderLayout());//On crée un panel pour chaque personne
			tabPan[i].setBackground(new Color(240,255,255)); 
			tabBtn[i]= new JButton((jeu.getListePersonnage().get(i)).getImage()) ; //On crée un bouton pour chaque personne
			tabPan[i].add(tabBtn[i],BorderLayout.CENTER); //Affiche l'image du personnage dans le bouton
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

