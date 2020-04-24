import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class FenetreJeu2  extends JFrame{
    //ATTRIBUTS
    
    //Conteneur Haut
    JLabel labelExplication ; 
    
    //Conteneur Gauche
    JTextArea textRegles;
    
    //Conteneur Bas
    JLabel labelNomAuteurs ; //Noms auteurs
    
    //Conteneur Centre
    JTextArea listePersos ; //Affiche la liste des personnages possibles
    JComboBox boxAttribut; //Contient les attributs à tester
    JComboBox boxValeur; //Contient les valeurs de l'attribut choisi
    JButton btnDemander; //Permet de poser un question (MAJ des attributs possibles, des valeur d'attributs possibles et des persos possibles)
      
    //Jeu courant
    Jeu jeu ; 
    
    
    //CONSTRUCTEUR
    public FenetreJeu2(){
        super("Qui-est-ce ? - Fenêtre de jeu ") ;  //on definit le nom de la fenetre
        
        jeu=new Jeu(2); //création d'un nouveau jeu v2
		
		//Dimensions de la fenetre graphique et fermeture
        setSize(800, 400) ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        
        //===== Instanciation des widgets de la fenêtre ====//
        
        //Conteneur Haut
        labelExplication = new JLabel("Pour poser une question, choisissez la caractéristique grâce aux menus déroulants puis cliquez sur DEMANDER") ;
        
        //Conteneur Gauche
        textRegles= new JTextArea("Règles à compléter");
        textRegles.setEditable(false);
        
        //Conteneur Bas
        labelNomAuteurs = new JLabel ("Auteurs : BOULARD Solenn, GOMINSKI Benjamin, ROUSSI Emmanuelle");
        
        //Conteneur Centre
        listePersos= new JTextArea("Affiche les persos possibles\nPerso1\nPerso2\nPerso3");
        listePersos.setEditable(false);
        listePersos.setOpaque(false);
        
        String[] types = new String[] {"Type 1","Type 2", "Type 3"}; //À remplacer par la liste des attributs
        boxAttribut = new JComboBox(types);
        
        String[] valeurs=new String[]{"Valeur 1","Valeur 2", "Valeur 3"}; //À remplacer par la liste des valeurs possibles SELON L'ATTRIBUT CHOISI
        boxValeur = new JComboBox(valeurs);
        
        btnDemander = new JButton("DEMANDER"); //Ajouter un écouteur de MAJ
        
        
        //=========== Organisation structurelle ======//
        
        //Création du panel terciaire
        JPanel panelTerciaire = new JPanel(new FlowLayout());
        //Ajout des widgets de gauche à droite
        panelTerciaire.add(boxAttribut);
        panelTerciaire.add(boxValeur);
        panelTerciaire.add(btnDemander);
        
        //Création du panel secondaire
        JPanel panelSecondaire = new JPanel(new BorderLayout());
        panelSecondaire.setBackground(new Color(240,255,255)) ;
        //Ajout des widgets
        panelSecondaire.add(panelTerciaire,BorderLayout.NORTH);
        panelSecondaire.add(listePersos,BorderLayout.CENTER);
        
        //Création du panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        //Ajout des widgets
        panelPrincipal.add(labelExplication,BorderLayout.NORTH);
        panelPrincipal.add(panelSecondaire,BorderLayout.CENTER);
        panelPrincipal.add(textRegles,BorderLayout.WEST);
        panelPrincipal.add(labelNomAuteurs, BorderLayout.SOUTH);
        
        //Ajout du conteneur principal à la fenêtre
        this.add(panelPrincipal);
        this.setVisible(true);
         
        }
        
        //MÉTHODES
        //Méthode MAJListes à prévoir
}
