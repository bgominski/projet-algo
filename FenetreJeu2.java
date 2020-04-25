import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

import java.util.*;
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
    
    //Pour pouvoir y accéder dans la méthode en dessous
    String[] valeurs=new String[]{"Valeur 1","Valeur 2", "Valeur 3"}; //À remplacer par la liste des valeurs possibles SELON L'ATTRIBUT CHOISI
    
    //Juste pour les tests
    //String[] types = new String[] {"Nom","Genre", "Type de cheveux", "Couleur de cheveux", "Couleur des yeux", "Accessoire", "Pays"}; //À remplacer par la liste des attributs
    ArrayList<String> ListeTypes=new ArrayList<String>();
    
    JPanel panelTerciaire = new JPanel(new FlowLayout());
    
        
    //Jeu courant
    Jeu jeu ; 
    
    
    //CONSTRUCTEUR
    public FenetreJeu2(Jeu jeu){
        super("Qui-est-ce ? - Fenêtre de jeu ") ;  //on definit le nom de la fenetre
        
        this.jeu=jeu; //récupération d'un nouveau jeu
        
        //jeu=new Jeu(2); //création d'un nouveau jeu v2
		
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
        
        //String[] types = new String[] {"Type 1","Type 2", "Type 3"}; //À remplacer par la liste des attributs
        String[] types = new String[] {"Genre", "Type de cheveux", "Couleur de cheveux", "Couleur des yeux", "Accessoire", "Pays", "Nom"}; //À remplacer par la liste des attributs
        boxAttribut = new JComboBox(types);
        boxAttribut.addActionListener(new EcouteurComboBox(this));
        
        //String[] valeurs=new String[]{"Valeur 1","Valeur 2", "Valeur 3"}; //À remplacer par la liste des valeurs possibles SELON L'ATTRIBUT CHOISI
        //boxValeur = new JComboBox(valeurs);
        //System.out.println(valeurs) ; 
       
        
        btnDemander = new JButton("DEMANDER"); //Ajouter un écouteur de MAJ
        btnDemander.addActionListener(new EcouteurDemander(this));
        
        
        //=========== Organisation structurelle ======//
        
        //Création du panel terciaire
        //JPanel panelTerciaire = new JPanel(new FlowLayout());
        //Ajout des widgets de gauche à droite
        panelTerciaire.add(boxAttribut);
        //panelTerciaire.add(boxValeur);
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
        
        //Getters
    public Jeu getJeu(){ 
        return jeu ; 
    }
    
    public String getAttribut(){
        return (String) boxAttribut.getSelectedItem(); 
    }
    
      public String Valeur(){
        return (String) boxValeur.getSelectedItem(); 
        
    }
    
    //méthode pour rafrachir la 2e comBoBox en fonction de la première
    public void adapterBoxValeur(){
        if(boxAttribut.getSelectedItem().equals("Genre")) {
        //System.out.println(valeurs) ; 

        //boxValeur = JComboBox(valeurs);
        //boxValeur.removeAllItems(); 
        String[] valeurs2 = modifListeValeur("Genre"); //Je n'arrive pas à le modifier donc je l'ai instancié ici
        boxValeur = new JComboBox(valeurs2); 
        panelTerciaire.removeAll() ; 
        panelTerciaire.add(boxAttribut);
        panelTerciaire.add(boxValeur);
         panelTerciaire.add(btnDemander);
        //repaint(); 
        validate(); 
        }
       
        /**
        //Appelle la méthode qui met à jour la liste des valeurs
        //String[] valeurs2 = modifListeValeur("Genre"); 
        
        //Fonctionne pas
        //JComboBox boxValeur2 = new JComboBox(valeurs2);
        //boxValeur= boxValeur2; 
        
        //Affiche un truc chelou'LJavalang...' au lieu de valeurs2
        //boxValeur.addItem(valeurs2); 
        //repaint(); 
        //add(boxValeur);
        //validate();**/
        
        if(boxAttribut.getSelectedItem().equals("Type de cheveux")) {
            String[] valeurs2 = modifListeValeur("Type de cheveux"); //Je n'arrive pas à le modifier donc je l'ai instancié ici
            boxValeur = new JComboBox(valeurs2); 
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            //repaint(); 
            validate(); 
        }
             
        
    }
        
    
        
    public String[] modifListeValeur(String attribut){
        //Créer toutes les listes de valeurs possibles ou chercher comment les récupérer avec les classes déjà existantes
        String[] valeursGenre=new String[]{"femme", "homme"}; 
        String[] valeursNom=new String[]{"", ""}; //Ajouter les noms des persos
        String[] valeursTypeCheveux=new String[]{"lisses" ,"bouclés", "ondulés"}; 
        /** String[] CouleurCheveux=new String[]{"femme", "homme"}; 
        String[] couleurYeux=new String[]{"femme", "homme"}; 
        String[] accessoire=new String[]{"lunettes", "Rien"}; 
        String[] pays=new String[]{"Femme", "Homme"}; **/
        
        //Trouver un moyen pour ne pas les tester une par une
        if(attribut.equals("Genre")) {
            //valeurs.removeAll(); 
            valeurs= valeursGenre ; 
        }
        
         if(attribut.equals("Type de cheveux")) {
            //valeurs.removeAll(); 
            valeurs= valeursTypeCheveux ; 
        }
        
        
        
        System.out.println(valeurs) ; 
            
            return valeurs; 
    
    }

    
    public String donnerReponse(){
        String res = "Non"; 
        
        //Vérifier si ça correspond au personnage
        if(jeu.getQui().getGenre().equals(boxValeur.getSelectedItem())){
        res = "Oui"; 
        //System.out.println(res); 
        }
         
        
        //Afficher ça dans un panel à créer
        //panel.setText(res); 
        return res;
    }
    
    //MÉTHODES POUR ACTUALISER LA LISTE DES PERSOS DISPO
    
    
}
