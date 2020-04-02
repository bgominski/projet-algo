import java.awt.*;
import javax.swing.*;
import java.util.*;

public class FenetreAccueil extends JFrame{
	
	//Variables du jeu
	private int nbPersos;
	
	//Widgets du panel Princial
	private JLabel labelAccueil;
	private JLabel labelDescription;
	private JButton btnJouer;
	
	//Widgets du panel Secondaire
	private JButton[] tabBtn;
	
	//METHODES
    
    /**
     * Constructeur de la classe FenetreAccueil
     */
	
	//Constructeur
	public FenetreAccueil(int nbPersos){
		super("Qui est-ce? - Fenetre d'accueil");
		this.nbPersos=nbPersos;
		setSize(1200,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Instanciation des widgets de la fenetre secondaire
		this.ajoutChoix();
        
        //Instanciation des widges de la fenetre principale
        labelAccueil = new JLabel("                                                                  "
        +"BIENVENUE DANS 'QUI EST-CE?' ÉDITION SPÉCIALE AMERINSA! ES-TU PRÊT À JOUER CONTRE NOTRE IA?");
        labelDescription = new JLabel ("Description et règles du jeu");
        //ImageIcon imagePerso = new ImageIcon("/Users/alainboulard/Desktop/École/INSA/2A/Info/S4/Projet algo/4_DOCUMENT EXPLICATIF/Photos classe/14_HARDY_Guenael.PNG");
        
        //Image         im   =  imagePerso.getImage();
        //int	hauteur	= im.getHeight(this);
        //int	largeur	= 100;
        //im	= im.getScaledInstance(40,50,Image.SCALE_DEFAULT); 
        btnJouer= new JButton("Jouer");
        btnJouer.addActionListener(new EcouteurJouer(this));
        
        //Instanciation panel secondaire
        int l =nbPersos/3;
        JPanel panel2= new JPanel(new GridLayout(3,l));
        for (int i=0;i<nbPersos;i++){
			panel2.add(tabBtn[i]);
		}
		
		//Instanciation du panel principal
		JPanel panel1 = new JPanel ( new BorderLayout());
		panel1.add( labelAccueil, BorderLayout.NORTH);
		panel1.add( btnJouer,BorderLayout.SOUTH);
		panel1.add( labelDescription, BorderLayout.WEST);
		panel1.add(panel2,BorderLayout.CENTER);
         
        this.add(panel1);
        setVisible(true);
	}
    
    //Création des boutons de choix
    public void ajoutChoix(){
        //Test pour voir si ça affichait l'image à remplacer
        ImageIcon imagePerso = new ImageIcon("/Users/alainboulard/Desktop/Capture d’écran 2020-03-28 à 20.11.02.png");
        
		tabBtn= new JButton[nbPersos];
		for (int i=0; i<nbPersos; i++){
			tabBtn[i]= new JButton("Personnage n°"+(i+1), imagePerso);// Ici à la place de imagePerso mettre un getter de l'image en fonction du numero du personnage
		}
	}
	
	
}
