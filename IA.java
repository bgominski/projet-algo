import java.util.*;

public class IA {
	
    
	//ATTRIBUTS

	//Liste des personnages donnés par Jeu
	final ArrayList<Personnage> ListePersonnageInit;
    
    //Liste re-updated à chaque question : c'est le "pool" de l'ordi
	private ArrayList<Personnage> ListePersonnagePossibles;
	
	
    //Listes constituées des caractéristiques des personnages donnés par la méthode Jeu
    private ArrayList<String> ListeGenre=new ArrayList<String>();
	private ArrayList<String> ListeTypeCheveux=new ArrayList<String>();
	private ArrayList<String> ListeCouleurCheveux=new ArrayList<String>();
	private ArrayList<String> ListeCouleurYeux=new ArrayList<String>();
    
    private ArrayList<String> ListeAccessoire= new ArrayList<String>();
    private ArrayList<String> ListePays= new ArrayList<String>();
	//Indexation de ces listes pour une utilisation plus rapide
    private ArrayList<ArrayList<String>> ListeListe= new ArrayList<ArrayList<String>>();
    
  
    
    
	//Constructeur
	public IA(Jeu jeu){
		
		this.ListePersonnageInit=(ArrayList<Personnage>)(jeu.getListePersonnage().clone());
		this.ListePersonnagePossibles=(ArrayList<Personnage>)(ListePersonnageInit.clone());
        
        
        this.MAJListes(ListePersonnageInit);
		    
	}
	
	//CHOISIR LA QUESTION A POSER
	public Question QuestionIA(){
       
        
        //On détermine la liste la plus petite 
        int compteur=20;            //valeur pour initialiser
        int indiceListe=0;
        for(ArrayList A : ListeListe){
              //Si une liste ne comporte qu'1 élément,la question ne peut pas porter dessus
                
            if( A.size()<=compteur && indiceListe!=(ListeListe.size()-1) ){
                compteur=A.size();
                indiceListe++;
                
                }
            if (A.size()==1 && indiceListe!=(ListeListe.size()-1)){
                indiceListe++;
            }
            
            int j=indiceListe;
            if(A.size()==1 && indiceListe==ListeListe.size()-1){
                while(ListeListe.get(j).size()==1 && indiceListe!=0){indiceListe--;j=indiceListe;}
            }
        
            
        }
        System.out.println("indiceListe= "+indiceListe);
       
        
        //On choisit un élément dans liste d'indice indiceListe
        
        int indiceAttribut =(int)(Math.random() * (ListeListe.get(indiceListe).size())); 
        System.out.println("indiceattribut= "+indiceAttribut);
        
        //Question :
        Question Q = new Question(indiceListe,indiceAttribut,ListeListe.get(indiceListe).get(indiceAttribut));
        System.out.println(Q.toString());
        
        return Q;
    }
     
    
    public void UpdateListes(boolean Ans,Question Q){
       
       
      
        //Pour chaque personnage dans liste des choix possibles
        //on crée une  liste Personnage pour pouvoir modifier ListePersonnagePossible DANS la boucle for each
        ArrayList<Personnage> ListePersonnageTEMP=new ArrayList<Personnage>();
        ListePersonnageTEMP=(ArrayList<Personnage>)(ListePersonnagePossibles.clone());
        
        System.out.println("//INFO DEBUG\\");
        for (Personnage P : ListePersonnagePossibles){
           
            //Valeur à éliminer ou à garder (Question posée par QuestionIA)
            String V=null;
           
            switch (Q.getindiceListe()){
                case 0 : V=P.getGenre();break;        //afin que String V soit initialisé
                case 1 : V=P.getCouleurCheveux();break;
                case 2 : V=P.getTypeCheveux();break;
                case 3 : V=P.getCouleurYeux();break;
                case 4 : V=P.getAccessoire();break;
                case 5 : V=P.getPays();break;
                //case 4 : V=P.getCouleurPeau();break;
            }
            System.out.println(V+Q.getvaleurAttribut());
            
        
        
            //Si le personnage cherché A cette caractéristique-là
            //on enlève tous les personnages n'ayant pas cette caractéristique-là
            if(Ans && (V!=Q.getvaleurAttribut())){
                System.out.println("*");
                ListePersonnageTEMP.remove(P);}
            
            //Si le personnage cherché N'a PAS cette caractéristique-là
            //on enlève tous les personnages l'ayant
           if ((!Ans) && V==Q.getvaleurAttribut()){
                System.out.println("*");
                ListePersonnageTEMP.remove(P);}
            
            
            
        }
        System.out.println("//FIN INFO DEBUG\\");
        
       
        ListePersonnagePossibles.clear();
        ListePersonnagePossibles=(ArrayList<Personnage>)(ListePersonnageTEMP.clone());
        System.out.println("Il reste "+ListePersonnagePossibles.size()+" personnages");
       
        //UPDATE FINAL DES LISTES
        MAJListes(ListePersonnagePossibles);
		
   }
   
    //Met à jour les listes selon les personnages présents dans liste en paramètre ListePersonnage
    public void MAJListes(ArrayList<Personnage> ListePersonnage){
        
        ListeGenre.clear();
        ListeTypeCheveux.clear();
        ListeCouleurCheveux.clear();
        ListeCouleurYeux.clear();
        //ListeCouleurPeau.clear();
        ListeAccessoire.clear();  
        ListePays.clear();      
		for(Personnage a : ListePersonnage){
			if(!ListeGenre.contains(a.getGenre())){ListeGenre.add(a.getGenre());}
			
			if(!ListeTypeCheveux.contains(a.getTypeCheveux())){ListeTypeCheveux.add(a.getTypeCheveux());}
			
			if(!ListeCouleurCheveux.contains(a.getCouleurCheveux())){ListeCouleurCheveux.add(a.getCouleurCheveux());}
			
			if(!ListeCouleurYeux.contains(a.getCouleurYeux())){ListeCouleurYeux.add(a.getCouleurYeux());}
            
            if(!ListeAccessoire.contains(a.getAccessoire())){ListeAccessoire.add(a.getAccessoire());}
			
			if(!ListePays.contains(a.getPays())){ListePays.add(a.getPays());}
			
		}
        
        //UPDATE LISTE LISTE
        ListeListe.clear();
                
        ListeListe.add(ListeGenre);		
		ListeListe.add(ListeCouleurCheveux);        
        ListeListe.add(ListeTypeCheveux);
		ListeListe.add(ListeCouleurYeux);
        ListeListe.add(ListeAccessoire);
        ListeListe.add(ListePays);
        
        
        //débuggage
          for(ArrayList A : ListeListe){
              System.out.println(A.size());
          }
        
        
        
        
    }
   
   //POUR RENVOYER LE PERSONNAGE TROUVÉ
   public Personnage affichePersonnage(){
        return ListePersonnagePossibles.get(0);
      }
    
    public String affichePersoPossibles(){ //Récupère les description des perso possibles pour affichage console
	   String res="";
       for(Personnage A : ListePersonnagePossibles){
              res=res+"\n"+(A.toString());
          }
          return res;
      }
   
   //Renvoie TRUE si le personnage a été trouvé
    public boolean PersonnageFound(){
       if (ListePersonnagePossibles.size()==1){
           return true;
       }
       return false;
   
   }
   
       
	   
}

