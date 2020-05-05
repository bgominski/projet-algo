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
    JPanel listePersos ; //panel central, Affiche la liste des personnages possibles
    JComboBox boxAttribut; //Contient les attributs à tester
    JComboBox boxValeur; //Contient les valeurs de l'attribut choisi
    JButton btnDemander; //Permet de poser un question (MAJ des attributs possibles, des valeur d'attributs possibles et des persos possibles)
    JPanel panelTerciaire = new JPanel(new FlowLayout()); //Contient les JComboBox et le bouton "demander", passé en attribut car MAJ au cours du jeu
    JLabel reponse ; //Contient la réponse à la question précédente
    
    //Tablaux utilisés dans la JComboBox boxValeur (impossible d'utiliser des ArrayList)
    private String[] listeGenre=new String[] {"femme","homme"} ; //Genres possibles
	private String[] listeTypeCheveux = new String[]{"lisses" ,"bouclés", "ondulés", "frisés"};; //CheveuxTypes de cheveux possibles
	private String[] listeCouleurCheveux =new String[]{"blonds" ,"chatains", "bruns","noirs","bicolores"};; //Couleurs de cheveux possibles
	private String[] listeCouleurYeux =new String[]{"marrons" ,"bleus", "ondulés"};; //Couleurs d'yeux possibles
    private String[] listeAccessoire =new String[]{"lunettes", "rien","sa beauté"};; //Accessoires possibles
    private String[] listePays =new String[]{"France", "Guadeloupe","Pérou","El Salvador","Maroc","Martinique","Guyane","Vénézuela","Panama","Le ciel","Méééxico"}; //Pays possibles
    private String[] listeNoms =new String[]{"Ajouter tous les noms? les récupérer ?"};; //Pays possibles
    
    //Liste en cours dans boxValeur
    String[] listeEnCours; //permet de récupérer la liste présente dans boxValeur
        
    //Jeu courant
    Jeu jeu ; 
    
    //Stock de la valeur du selected item de boxValeur
    String valeurSelectionnee; //permet de tester cette valeur lorsqu'une question est posée
    
    //Liste des persos possibles à mettre à jour à chaque questions
    ArrayList<String> listePersonnagePossibles ;
    
    //Pour répondre aux questions
    boolean aAttribut =false; 
    
  
    
    //CONSTRUCTEUR
    public FenetreJeu2(Jeu jeu){
        super("Qui-est-ce ? - Fenêtre de jeu ") ;  //on definit le nom de la fenetre
        
        this.jeu=jeu; //récupération du jeu
  	
		//Dimensions de la fenetre graphique et fermeture
        setSize(950, 1200) ; 
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
        reponse = new JLabel("La réponse à votre question s'affichera ici");
        int s=jeu.getListePersonnage().size()+1;
        JPanel listePersos = new JPanel (new GridLayout(s,1)); //On crée une grille  une case par personnage + une case pour afficher les réponses
        listePersos.add(reponse); //Afficher la réponse à la derière question posée
        JButton[] tabButton = new JButton[jeu.getListePersonnage().size()]; //On crée un tableau de boutons qui contient autant de cases que de personnages
        for (int i=0; i<tabButton.length; i++) {
			tabButton[i]= new JButton(jeu.getListePersonnage().get(i).toString()); //chaque bouton contient la discription d'un personnage
			tabButton[i].addActionListener(new EcouteurSupprimer()); //chaque bouton doit disparaître quand on clique dessus
			listePersos.add(tabButton[i]); //chaque case de la grille contient un bouton
		}
        
   
        String[] types = new String[] {"Genre", "Type de cheveux", "Couleur de cheveux", "Couleur des yeux", "Accessoire", "Pays", "Nom"}; //À remplacer par la liste des attributs
        boxAttribut = new JComboBox(types);
        boxAttribut.addActionListener(new EcouteurComboBox(this));     
        
        btnDemander = new JButton("DEMANDER"); //Ajouter un écouteur de MAJ
        btnDemander.addActionListener(new EcouteurDemander(this));
        
        
        //=========== Organisation structurelle ======//
        
        //Ajout des widgets du panel terciaire de gauche à droite
        panelTerciaire.add(boxAttribut);
        panelTerciaire.add(btnDemander);
        
        
        //Création du panel secondaire
        JPanel panelSecondaire = new JPanel(new BorderLayout());
        panelSecondaire.setBackground(new Color(240,255,255)) ;
        //Ajout des widgets
        panelSecondaire.add(panelTerciaire,BorderLayout.NORTH);
        panelSecondaire.add(listePersos,BorderLayout.CENTER);
        panelSecondaire.add(reponse,BorderLayout.EAST);
        
        
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
             
    //Getters
    public Jeu getJeu(){ 
        return jeu ; 
    }
    
    public String getAttribut(){
        return (String) boxAttribut.getSelectedItem(); 
    }
    
    public String getValeur(){ 
        return (String) boxValeur.getSelectedItem();
     }
    
    
    public String[] getListeGenre(){ 
		return listeGenre;
	} 
	
    public String[] getListeTypeCheveux(){
		return listeTypeCheveux;
	}
	
    public String[] getListeCouleurCheveux(){
		return listeCouleurCheveux;
	}
	
    public String[] getListeCouleurYeux(){
		return listeCouleurYeux;
	}
	
    public String[] getListeAccessoire(){
		return listeAccessoire;
	}
	
    public String[] getListePays(){
		return listePays;
	}
	
	public String[] getListeEnCours(){
		return listeEnCours;
	}
	
    public String[] getListeNoms(){
		return listeNoms;
	}
        
	public JComboBox getboxValeur(){
		return boxValeur;
	}
	
	//Setters
	public void setListeGenre(String[] tab){ 
		listeGenre=tab;
	} 
	
    public void setListeTypeCheveux(String[] tab){
		listeTypeCheveux=tab;
	}
	
    public void setListeCouleurCheveux(String[] tab){
		listeCouleurCheveux=tab;
	}
	
    public void setListeCouleurYeux(String[] tab){
		listeCouleurYeux=tab;
	}
	
    public void setListeAccessoire(String[] tab){
		listeAccessoire=tab;
	}
	
    public void setListePays(String[] tab){
		listePays=tab;
	}
	
	 public void setListeEnCours(String[] tab){
		listeEnCours=tab;
	}
    
       
    //méthode pour rafrachir la 2e comBoBox en fonction de la première
    public String[] adapterBoxValeur(){
        
        String attribut=this.getAttribut();
        String[] valeurs = {""}; //On initialise le tableau qui contient la liste à afficher
              
        switch(attribut) {
			
			case "Genre":
            boxValeur = new JComboBox(getListeGenre()); //Mise à jour du contenue de boxValeur
            valeurs = getListeGenre(); //Mise à jour de la liste des valeurs testés
            //Mise à jour du panel
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            validate(); 
			break;
            
            
            case "Type de cheveux":
            boxValeur = new JComboBox(getListeTypeCheveux()); 
            valeurs = getListeTypeCheveux();
            //Mise à jour du panel
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            validate(); 
			break;
            
            
            case "Couleur de cheveux":
            boxValeur = new JComboBox(getListeCouleurCheveux()); 
            valeurs = getListeCouleurCheveux();
            //Mise à jour du panel
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander); 
            validate(); 
			break;
            
            
            case "Couleur des yeux":
            boxValeur = new JComboBox(getListeCouleurYeux()); 
            valeurs = getListeCouleurYeux();
            //Mise à jour du panel
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            validate(); 
			break;
            
            case "Accessoire":
            boxValeur = new JComboBox(getListeAccessoire()); 
            valeurs = getListeAccessoire();
            //Mise à jour du panel
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            validate(); 
			break;
            
            case "Pays":
            boxValeur = new JComboBox(getListePays()); 
            valeurs = getListePays();
            //Mise à jour du panel
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            validate(); 
			break;
            
            case "Nom":
            boxValeur = new JComboBox(getListeNoms()); 
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            validate(); 
			break;
            
            
        }
        setListeEnCours(valeurs);
        return valeurs; 
    }
    
    
    //Méthode de maj des attributs contenue dans boxValeur en fonction de la question posée
    public void refreshList(){
   
        valeurSelectionnee = (String)boxValeur.getSelectedItem(); //on récupère la valeur sélectionné dans boxValeur
        String[] tab = getListeEnCours(); //on récupère les valeurs possible avant la question posée
		ArrayList<String> ListeIntermediaire = new ArrayList<String>(); //on crée une liste intermédiaire
		for(int i=0; i<tab.length; i++) {
			ListeIntermediaire.add(tab[i]);//on récupère les éléments présents dans boxValeurs et on les places dans ListeIntermédiaire
		}
		
		ListeIntermediaire.removeIf(s -> (getValeur().equals(s))); //on élimine la valeur sélectionnée (valeur testée par la question) 
		String[] tabMAJ=new String[ListeIntermediaire.size()]; //On crée un tableau
		for (int i=0; i<ListeIntermediaire.size(); i++){
			tabMAJ[i]= ListeIntermediaire.get(i); //On place les éléments de la liste dans le tableau 
		}
		
		boxValeur = new JComboBox(tabMAJ); //On met à jour les éléments de boxValeur grâce à tabMAJ
		
		//Mise à jour du panel
        panelTerciaire.removeAll() ; 
        panelTerciaire.add(boxAttribut);
        panelTerciaire.add(boxValeur);
        panelTerciaire.add(btnDemander); 
        validate(); 
        
        //Mise à jour des listes passées en attribut (pour éviter que les caractéristiques déjà testées réapparaissent)
		String attribut=this.getAttribut();
		switch(attribut) {
			case "Genre":
			setListeGenre(tabMAJ);
			break;
			
			case "Type de cheveux":
			setListeTypeCheveux(tabMAJ);
			break;
			
			case "Couleur de cheveux":
			setListeCouleurCheveux(tabMAJ);
			break;
			
            case "Couleur des yeux":
            setListeCouleurYeux(tabMAJ);
			break;
            
            case "Accessoire":
            setListeAccessoire(tabMAJ);
			break;
            
            case "Pays":
            setListePays(tabMAJ);
			break;
        
		}
	}
			
    
    public String donnerReponse(){
        String res = "Non"; //Initialisation de la réponse
  
		ArrayList<String> caractéristiquesPerso = new ArrayList<String>(); //on crée une liste 
        //On stocke toutes les caractéristqieus du perso dans cette liste
        caractéristiquesPerso.add(jeu.getQui().getGenre()) ;
        caractéristiquesPerso.add(jeu.getQui().getCouleurCheveux()) ;
        caractéristiquesPerso.add(jeu.getQui().getTypeCheveux()) ;
        caractéristiquesPerso.add(jeu.getQui().getAccessoire()) ;
        caractéristiquesPerso.add(jeu.getQui().getCouleurYeux()) ;
        caractéristiquesPerso.add(jeu.getQui().getPays()) ;
        caractéristiquesPerso.add(jeu.getQui().getNom()) ;
            
        //On parcourt les éléments de la liste et on renvoie oui s'il y a une correspondance
		for(String s : caractéristiquesPerso){
            if(valeurSelectionnee.equals(s)){
                res="oui";
                aAttribut=true;       
            }	
		}  
		    
        //On affiche la réponse
        reponse.setText("Réponse : "+res); 
        repaint(); 
        revalidate() ; 
        return res;
    }
    
    
}
