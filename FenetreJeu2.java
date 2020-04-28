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
    JPanel panelTerciaire = new JPanel(new FlowLayout());
    
    //Pour pouvoir y accéder dans la méthode en dessous
    String[] valeurs=new String[]{"Valeur 1","Valeur 2", "Valeur 3"}; //À remplacer par la liste des valeurs possibles SELON L'ATTRIBUT CHOISI
    
    //Juste pour les tests
    //String[] types = new String[] {"Nom","Genre", "Type de cheveux", "Couleur de cheveux", "Couleur des yeux", "Accessoire", "Pays"}; //À remplacer par la liste des attributs
    ArrayList<String> ListeTypes=new ArrayList<String>();
    
    //Création de toutes les listes de valeurs possibles
    //Tablaux utilisés dans la JComboBox boxValeur (impossible d'utiliser des ArrayList)
    private String[] ListeGenre=new String[] {"femme","homme"} ; //Genres possibles
	private String[] ListeTypeCheveux = new String[]{"lisses" ,"bouclés", "ondulés", "frisés", "verts"};; //CheveuxTypes de cheveux possibles
	private String[] ListeCouleurCheveux =new String[]{"lisses" ,"bouclés", "ondulés"};; //Couleurs de cheveux possibles
	private String[] ListeCouleurYeux =new String[]{"lisses" ,"bouclés", "ondulés"};; //Couleurs d'yeux possibles
    private String[] ListeAccessoire =new String[]{"lunettes", "Rien"};; //Accessoires possibles
    private String[] ListePays =new String[]{"Inde", "Chine"};; //Pays possibles
    private String[] ListeNoms =new String[]{"Ajouter tous les noms? les récupérer ?"};; //Pays possibles
    
    
        
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
    
    public String getValeur(){ 
        return (String) boxValeur.getSelectedItem(); }
    
    
    public String[] getListeGenre(){ return ListeGenre;} 
    public String[] getListeTypeCheveux(){return ListeTypeCheveux;}
    public String[] getListeCouleurCheveux(){return ListeCouleurCheveux;}
    public String[] getListeCouleurYeux(){return ListeCouleurYeux;}
    public String[] getListeAccessoire(){return ListeAccessoire;}
    public String[] getListePays(){return ListePays;}
    public String[] getListeNoms(){return ListeNoms;}
        

	public JComboBox getboxValeur(){
		return boxValeur;
	}
    
   

    
   /** public String[] getContentBox(JComboBox box){
        JComboBox box1=JComboBox(String[] tableau) ;
        return tableau ; 
    }**/
        
    
    
    //méthode pour rafrachir la 2e comBoBox en fonction de la première
    public String[] adapterBoxValeur(){
        
        String attribut=this.getAttribut();
        String[] valeurs2 = {""}; 
        
        
        
        switch(attribut) {
			
			case "Genre":
			//valeurs2 = modifListeValeur("Genre"); //Je n'arrive pas à le modifier donc je l'ai instancié ici
            boxValeur = new JComboBox(getListeGenre()); 
            valeurs2 = getListeGenre();
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            //repaint(); 
            validate(); 
            
			break;
            
            
            case "Type de cheveux":
			//valeurs2 = modifListeValeur("Type de cheveux"); //Je n'arrive pas à le modifier donc je l'ai instancié ici
            boxValeur = new JComboBox(getListeTypeCheveux()); 
            valeurs2 = getListeTypeCheveux();
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            //repaint(); 
            validate(); 
			break;
            
            
            case "Couleur de cheveux":
			//valeurs2 = modifListeValeur("Type de cheveux"); //Je n'arrive pas à le modifier donc je l'ai instancié ici
            boxValeur = new JComboBox(getListeCouleurCheveux()); 
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            //repaint(); 
            validate(); 
			break;
            
            
            case "Couleur des yeux":
			//valeurs2 = modifListeValeur("Type de cheveux"); //Je n'arrive pas à le modifier donc je l'ai instancié ici
            boxValeur = new JComboBox(getListeCouleurYeux()); 
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            //repaint(); 
            validate(); 
			break;
            
            case "Accessoire":
			//valeurs2 = modifListeValeur("Type de cheveux"); //Je n'arrive pas à le modifier donc je l'ai instancié ici
            boxValeur = new JComboBox(getListeAccessoire()); 
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            //repaint(); 
            validate(); 
			break;
            
            case "Pays":
			//valeurs2 = modifListeValeur("Type de cheveux"); //Je n'arrive pas à le modifier donc je l'ai instancié ici
            boxValeur = new JComboBox(getListePays()); 
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            //repaint(); 
            validate(); 
			break;
            
            case "Nom":
			//valeurs2 = modifListeValeur("Type de cheveux"); //Je n'arrive pas à le modifier donc je l'ai instancié ici
            boxValeur = new JComboBox(getListeNoms()); 
            panelTerciaire.removeAll() ; 
            panelTerciaire.add(boxAttribut);
            panelTerciaire.add(boxValeur);
            panelTerciaire.add(btnDemander);
            //repaint(); 
            validate(); 
			break;
            
            
        }
        return valeurs2; 
    }
    
    public void refreshList(){
         
        //Regarder ce sur quoi on a cliqué dans la 
            //Parcourir le tableau en question
            //Regarder quel indice est égal à ce qu'on a cliqué
            //Recréer le tableau sans cet indice
            
        String[] tab = new String[0]; 
        tab = adapterBoxValeur(); 
        int tailleTableau = tab.length ; 
        
        for(int i=0; i<tab.length; i++) {
            if(getValeur().equals(tab[i])) {
                
                for(int j=i+1; j<tailleTableau; j++){ 
				tab[j-1]=tab[j]; //Chaque valeur plus loin que la valeur souhaitant être retiré va être décalé d'une place en avant
				System.out.println(tab[j]);		
                }
                
				tailleTableau=tailleTableau-1;	
				for(int k=0; k<tailleTableau; k++){
                    System.out.println(tab[k]);
				}
            }
        }
    }
                
                
        //Copier le tableau en ne mettant pas l'élément cliqué
        
            

    


    
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
