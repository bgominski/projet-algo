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
    JPanel panelTerciaire = new JPanel(new FlowLayout()); //Contient les JComboBox et le bouton "demander", passé en attribut car MAJ au cours du jeu
    
    //Tablaux utilisés dans la JComboBox boxValeur (impossible d'utiliser des ArrayList)
    private String[] ListeGenre=new String[] {"femme","homme"} ; //Genres possibles
	private String[] ListeTypeCheveux = new String[]{"lisses" ,"bouclés", "ondulés", "frisés"};; //CheveuxTypes de cheveux possibles
	private String[] ListeCouleurCheveux =new String[]{"blonds" ,"chatains", "bruns","noirs","bicolores"};; //Couleurs de cheveux possibles
	private String[] ListeCouleurYeux =new String[]{"marrons" ,"bleus", "ondulés"};; //Couleurs d'yeux possibles
    private String[] ListeAccessoire =new String[]{"lunettes", "rien","sa beauté"};; //Accessoires possibles
    private String[] ListePays =new String[]{"France", "Guadeloupe","Pérou","El Salvador","Maroc","Martinique","Guyane","Vénézuela","Panama","Le ciel","Méééxico"}; //Pays possibles
    private String[] ListeNoms =new String[]{"Ajouter tous les noms? les récupérer ?"};; //Pays possibles
    
    //Liste en cours dans boxValeur
    String[] listeEnCours; //permet de récupérer la liste présente dans boxValeur
        
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
		return ListeGenre;
	} 
	
    public String[] getListeTypeCheveux(){
		return ListeTypeCheveux;
	}
	
    public String[] getListeCouleurCheveux(){
		return ListeCouleurCheveux;
	}
	
    public String[] getListeCouleurYeux(){
		return ListeCouleurYeux;
	}
	
    public String[] getListeAccessoire(){
		return ListeAccessoire;
	}
	
    public String[] getListePays(){
		return ListePays;
	}
	
	public String[] getListeEnCours(){
		return listeEnCours;
	}
	
    /*public String[] getListeNoms(){
		return ListeNoms;
	}*/
        
	public JComboBox getboxValeur(){
		return boxValeur;
	}
	
	//Setters
	public void setListeGenre(String[] tab){ 
		ListeGenre=tab;
	} 
	
    public void setListeTypeCheveux(String[] tab){
		ListeTypeCheveux=tab;
	}
	
    public void setListeCouleurCheveux(String[] tab){
		ListeCouleurCheveux=tab;
	}
	
    public void setListeCouleurYeux(String[] tab){
		ListeCouleurYeux=tab;
	}
	
    public void setListeAccessoire(String[] tab){
		ListeAccessoire=tab;
	}
	
    public void setListePays(String[] tab){
		ListePays=tab;
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
            
            /*case "Nom":
			//valeurs2 = modifListeValeur("Type de cheveux"); //Je n'arrive pas à le modifier donc je l'ai instancié ici
            boxValeur = new JComboBox(getListeNoms()); 
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            validate(); 
			break;*/
            
            
        }
        setListeEnCours(valeurs);
        return valeurs; 
    }
    
    
    //Méthode de maj des attributs contenue dans boxValeur en fonction de la question posée
    public void refreshList(){
		System.out.println("élément sélectionné : "+(String) boxValeur.getSelectedItem());
        String[] tab = getListeEnCours(); //on récupère les valeurs possible avant la question posée
        System.out.println("élément sélectionné : "+(String) boxValeur.getSelectedItem());
        
        //Juste pour vérif ( à supprimer )
        String res="Ancien contenu:";//Vérif du contenu du tableau
        for(int i=0; i<tab.length; i++) {
			res=res+" "+tab[i];
		} 
		System.out.println(res);//Vérif du contenu du tableau
		
		ArrayList<String> ListeIntermediaire = new ArrayList<String>(); //on crée une liste intermédiaire
		for(int i=0; i<tab.length; i++) {
			ListeIntermediaire.add(tab[i]);//on récupère les éléments présents dans boxValeurs et on les places dans ListeIntermédiaire
		}
		System.out.println("élément sélectionné : "+(String) boxValeur.getSelectedItem());//Vérif du contenu du tableau
		ListeIntermediaire.removeIf(s -> (getValeur().equals(s))); //on élimine la valeur sélectionnée (valeur testée par la question) 
		
		//Juste pour vérif ( à supprimer )
		System.out.println("Nouveau contenu"); // Vérif du contenu de la liste
        for(String s: ListeIntermediaire) {
			System.out.println(s); //Vérif du contenu de la liste
		}
		
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
        
        //Mise à jour des Liste passées en attribut
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
