import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

public class FenetreAccueil extends JFrame{
	
	//Variables du jeu
	public int nbPersos;
	public Jeu jeu = new Jeu(); 
	
	//Widgets du panel Princial
	private JLabel labelAccueil1;
	private JLabel labelAccueil2;
	private JLabel labelAccueil3;
	private JPanel panelAcceuil; //Panel utilisé pour un rendu plus esthétique
	private JLabel labelDescription;
	private JButton btnJouer;
	
	//Widgets du panel Secondaire
	private JButton[] tabBtn;
	private JPanel[] tabPan;
    
	//METHODES
    
    /**
     * Constructeur de la classe FenetreAccueil
     */
	
	//Constructeur
	public FenetreAccueil(){
		super("Qui est-ce? - Fenetre d'accueil");
		this.nbPersos=jeu.getListePersonnage().size();
		setSize(1200,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		//Instanciation des widgets de la fenetre secondaire
		this.ajoutChoix();
      
        
        //Instanciation des widges de la fenetre principale
        labelAccueil1 = new JLabel("                                                                  "
        +"BIENVENUE DANS 'QUI EST-CE?' ÉDITION SPÉCIALE AMERINSA! ES-TU PRÊT À JOUER CONTRE NOTRE IA?");
        labelAccueil2= new JLabel("                                                                           "
        +"CHOISI UN PERSONNAGE PUIS CLIQUE SUR 'JOUER' POUR COMMENCER LA PARTIE!");
        labelAccueil3= new JLabel("  ");
        panelAcceuil = new JPanel(new BorderLayout());
        panelAcceuil.setBackground(new Color(187,210,225)) ; 
        panelAcceuil.add(labelAccueil1, BorderLayout.NORTH); 
        panelAcceuil.add(labelAccueil2,BorderLayout.CENTER);
        panelAcceuil.add(labelAccueil3,BorderLayout.SOUTH);
        
        labelDescription = new JLabel ("Description et règles du jeu");
        btnJouer= new JButton("Jouer");
        //btnJouer.setBackground(Color.BLUE); //changer la couleur du bouton
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
			tabPan[i]= new JPanel(new BorderLayout());
			tabPan[i].setBackground(new Color(240,255,255)); 
			tabBtn[i]= new JButton((jeu.getListePersonnage().get(i)).getImage()) ;
			tabPan[i].add(tabBtn[i],BorderLayout.CENTER); //Pour afficher l'image du personage dans le bouton
			tabPan[i].add(new JLabel("		"+jeu.getListePersonnage().get(i).getNom()), BorderLayout.SOUTH); // Pour afficher le nom du Perso en dessous de sa photo
			tabPan[i].add(new JLabel("   "), BorderLayout.NORTH); //Pour espacer les boutons
			tabPan[i].add(new JLabel("   "), BorderLayout.EAST); //Pour espacer les boutons
			tabPan[i].add(new JLabel("   "), BorderLayout.WEST); //Pour espacer les boutons
            //tabBtn[i].addActionListener(new EcouteurChoixPerso(this, tabBtn[i])); //Pour lier chaque bouton à l'écouteur
            tabBtn[i].addActionListener(new EcouteurChoixPerso(this, i));
        }
		
        /**tabBtn[i]= new JButton(p1.getNom(),imagePerso ) ; Ça fonctionne **/
    }
    
     
    
      /** public int getNumBouton(){
        tabBtn= new JButton[nbPersos];
        public Personnage trouverPerso(){**/
    
    
        
    
	
	
}

