import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class FenetreAccueil extends JFrame{
	
	//ATTRIBUTS
	
	//Variables du jeu courant
	public int nbPersos; //nombre de personnages initiale
	private Jeu jeu; //jeu courant
	
	//Widgets du panel Accueil(Haut)
    private JPanel panelAcceuil; 
	private JLabel labelAccueil2; //Label d'instruction
	private JLabel labelAccueil3; //Label untilisé pour un rendu plus esthétique
	private JPanel panel2Accueil; //Panel utilisé pour un rendu plus esthétique
    //Widgets du panelSecondaire (Haut) 
    private ImageIcon imageQuiEstCe; 
    private JTextArea labelAccueil1; //Label de bienvue
    
    //Widgets du 2e panel (Centre et Bas)
    private JButton btnJouer;
    private JTextArea labelDescription; 
    private JPanel panel2; 
	
	//Widgets du panelSecondaire (Centre et Bas) 
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
      
        
        //Instanciation des widges du panelAccueil
        labelAccueil1 = new JTextArea("\nEDITION SPÉCIALE AMERINSA! ES-TU PRÊT À JOUER CONTRE NOTRE IA?");
        labelAccueil1.setEditable(false);
        
        labelAccueil1.insert("BIENVENUE DANS 'QUI EST-CE?'", 0); 
        labelAccueil1.setOpaque(false);
        Font  f1  = new Font(Font.DIALOG, Font.BOLD, 25);
        labelAccueil1.setFont(f1); 
        
        
        imageQuiEstCe = new ImageIcon("/Users/alainboulard/Desktop/Image Algo/Capture d’écran 2020-04-12 à 11.11.14.png"); //Instanciation de l'incone du jeu
        JLabel imageAccueil = new JLabel(imageQuiEstCe); //Création d'un JLabel pour stocker le logo du jeu
        labelAccueil2= new JLabel("                                                                           "
        +"CHOISIS UN PERSONNAGE PUIS CLIQUE SUR 'JOUER' POUR COMMENCER LA PARTIE!");
        labelAccueil3= new JLabel("  ");
        panel2Accueil = new JPanel(new BorderLayout());
        panel2Accueil.setOpaque(false); /** Pour ne pas laisser apparaître la couleur initiale du panel et permettre de voir la couleur du panel parent**/
        panel2Accueil.add(labelAccueil1, BorderLayout.WEST) ; 
        panel2Accueil.add(imageAccueil, BorderLayout.EAST) ; 
        panelAcceuil = new JPanel(new BorderLayout());
        //panelAcceuil.setBackground(new Color(187,210,225)) ; 
        panelAcceuil.setOpaque(false) ; 
        panelAcceuil.add(panel2Accueil, BorderLayout.NORTH); 
        panelAcceuil.add(labelAccueil2,BorderLayout.CENTER);
        panelAcceuil.add(labelAccueil3,BorderLayout.SOUTH);
        
        labelDescription = new JTextArea ("Clique sur le joueur de ton choix et\nla machine virtuelle\n tentera de lire dans tes pensées.\n Une fois que tu auras cliqué\n n'oublie pas\n pas de cliquer sur le bouton 'jouer' en bas de l'écran ! ");
        labelDescription.setBackground(Color.WHITE) ; 
        labelDescription.setEditable(false) ; 
        
        
        btnJouer= new JButton("Jouer");
        btnJouer.setForeground(new Color(0,123, 123)); //Changer la couleur de la police
        btnJouer.setOpaque(true);
        btnJouer.setBorderPainted(false);
        btnJouer.setBackground(Color.red) ; 
        //btnJouer.setBackground(new Color(12,255,14)); //changer la couleur du bouton
        btnJouer.addActionListener(new EcouteurJouer(this));
        JPanel panelBouton = new JPanel() ; 
        panelBouton.add(btnJouer) ; 
        
        //Instanciation panel secondaire
        int l =nbPersos/3;
        panel2= new JPanel(new GridLayout(4,l));
        //panel2.setBackground(new Color(240,255,255)) ; 
        panel2.setOpaque(false) ;
        for (int i=0;i<nbPersos;i++){
			panel2.add(tabPan[i]);
		}
        
        ImageIcon image = new ImageIcon(new ImageIcon("/Users/alainboulard/Desktop/salle de classe.jpg").getImage().getScaledInstance(1200,800, Image.SCALE_DEFAULT)) ; 
        
        JLabel imageFond = new JLabel(image); 
        JPanel panelImage = new JPanel(); 
        panelImage.add(imageFond) ; 
        
		
		//Instanciation du panel principal
        
        setContentPane(new AfficheImage("/Users/alainboulard/Desktop/salle de classe.jpg")); 
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(187,210,225)) ;
        
        /**
		JPanel panel1 = new JPanel (new BorderLayout()); 
		panel1.setBackground(new Color(187,210,225)) ; 
        //panel1.add(panelImage, BorderLayout.CENTER) ; 
        //panel1.add(imageFond,BorderLayout.EAST);
		panel1.add(panelAcceuil, BorderLayout.NORTH);
		panel1.add(btnJouer,BorderLayout.SOUTH);
		panel1.add(labelDescription, BorderLayout.WEST);
		panel1.add(panel2,BorderLayout.CENTER);
		panel1.add(labelAccueil3,BorderLayout.EAST);
        
        this.add(panelImage, BorderLayout.CENTER);
        this.add(panel1, BorderLayout.SOUTH);
        **/
        
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
			//tabPan[i].setBackground(new Color(240,255,255)); 
            tabPan[i].setOpaque(false) ; 
			tabBtn[i]= new JButton((jeu.getListePersonnage().get(i)).getImage()) ; //On crée un bouton pour chaque personne en affichant l'image du personnage dans le bouton
			tabPan[i].add(tabBtn[i],BorderLayout.CENTER); //On ajoute les boutons au Panel
			tabPan[i].add(new JLabel("		"+jeu.getListePersonnage().get(i).getNom()), BorderLayout.SOUTH); //Affiche le nom du personnage
			tabPan[i].add(new JLabel("   "), BorderLayout.NORTH); //Pour espacer les boutons
			tabPan[i].add(new JLabel("   "), BorderLayout.EAST); //Pour espacer les boutons
			tabPan[i].add(new JLabel("   "), BorderLayout.WEST); //Pour espacer les boutons
            tabBtn[i].addActionListener(new EcouteurChoixPerso(this, i)); //Définit le personnage du bouton comme 'qui'
     /**       
    this.add(new JLabel(new ImageIcon("/Users/alainboulard/Desktop/salle de classe.jpg")));	
    this.pack(); 
    this.setVisible(true); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    **/
        }
    }
    
    //Getters
    public Jeu getJeu(){ 
        return jeu ; 
    }
    
	
}

