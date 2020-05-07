<<<<<<< HEAD
=======
/*
 * IA.java   used by Jeu.java
 * 
 * Copyright 2020 GOMINSKI BENJAMIN
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
 
 // LAST EDIT : 07/05/2020 14:20
 
 /*
  * Lexique : 
  * Attributs :  pour désigner les attributs d'un personnage, comme les yeux, les cheveux...
  * Valeur : pour désigner la valeur de l'attribut, comme vert, bleu, blanc...
  * 
  * 
  */
  
>>>>>>> parent of f1e2595... Revert "Commentaire IA.java"
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
<<<<<<< HEAD
=======
    
    /* La première version comprenait l'attribut couleur peau que nous avons par la suite enlevé
     */
	//private ArrayList<String> ListeCouleurPeau=new ArrayList<String>();
    
    
>>>>>>> parent of f1e2595... Revert "Commentaire IA.java"
	//Indexation de ces listes pour une utilisation plus rapide
    private ArrayList<ArrayList<String>> ListeListe= new ArrayList<ArrayList<String>>();
    
  
    
    
	/* Constructeur
     * 
     * @param : jeu de type Jeu
     * 
     * Crée la liste de personnage possibles : c'est le "pool" des choix pour l'ordinateur
     * 
     * Utilise méthode MAJListes */
     
	public IA(Jeu jeu){
		
		this.ListePersonnageInit=(ArrayList<Personnage>)(jeu.getListePersonnage().clone());
		this.ListePersonnagePossibles=(ArrayList<Personnage>)(ListePersonnageInit.clone());
        
        
        this.MAJListes(ListePersonnageInit);
		    
	}
    
	
<<<<<<< HEAD
	//CHOISIR LA QUESTION A POSER
=======
	/* Méthode principale : 
     * 
     * Aucun paramètre.
     * 
     * Renvoie une Question, cf Question.java 
     */
     
>>>>>>> parent of f1e2595... Revert "Commentaire IA.java"
	public Question QuestionIA(){
       
        
        //On détermine la liste la plus petite 
<<<<<<< HEAD
        int compteur=20;            //valeur pour initialiser
=======
     
        // && indiceListe!=(ListeListe.size()-1) : condition pour éviter IndexOutofBounds 
        
        int compteur=100;            //valeur maximale non atteinte pour initialiser
>>>>>>> parent of f1e2595... Revert "Commentaire IA.java"
        int indiceListe=0;
        for(ArrayList A : ListeListe){
            
              
            //Si deux listes de taille égales, la liste choisie sera celle avec l'indice le plus élevé
            if( A.size()<=compteur && indiceListe!=(ListeListe.size()-1) ){
                compteur=A.size();
                indiceListe++;
                
                }
            /* Si une liste ne comporte qu'1 élément,la question ne peut pas porter dessus
             * 
             * De plus, on s'assure que l'indice choisi n'est pas OutOfBounds dans ListeListe
             */
             
            if (A.size()==1 && indiceListe!=(ListeListe.size()-1)){
                indiceListe++;
            }
            
            int j=indiceListe;
            if(A.size()==1 && indiceListe==ListeListe.size()-1){
                while(ListeListe.get(j).size()==1 && indiceListe!=0){indiceListe--;j=indiceListe;}
            }
        
            
        }
        
       
        
<<<<<<< HEAD
        //On choisit un élément dans liste d'indice indiceListe
=======
        /* On choisit un élément dans liste d'indice indiceListe
         * 
         * 1ère version : utilisation de l'objet Random, qui s'avère ne pas être nécessaire
         * 
         * Random rand1 = new Random(); 
         * int indiceAttribut = rand1.nextInt(ListeListe.get(indiceListe).size()  );
         * 
         */
         
        
>>>>>>> parent of f1e2595... Revert "Commentaire IA.java"
        
        int indiceAttribut =(int)(Math.random() * (ListeListe.get(indiceListe).size())); 

        
        //Question :
        Question Q = new Question(indiceListe,indiceAttribut,ListeListe.get(indiceListe).get(indiceAttribut));
        
        
        return Q;
    }
     
<<<<<<< HEAD
    
=======
     
    /* Méthode UpdateListes
     * 
     * @param : boolean Ans : réponse à la question donnée par l'utilisateur par l'interface
     *          Question Q : la question auquelle l'utilisateur a répondu
     * 
     * Ne renvoie rien.
     * 
     * Utilise méthode MAJListes afin de reconstituer le "pool" de l'ordinateur, en fonction de la réponse à la Question posée.
     */
     
     
>>>>>>> parent of f1e2595... Revert "Commentaire IA.java"
    public void UpdateListes(boolean Ans,Question Q){
       
       
      
        //Pour chaque personnage dans liste des choix possibles
        //on crée une  liste Personnage TEMPoraire pour pouvoir modifier ListePersonnagePossible DANS la boucle for each
        ArrayList<Personnage> ListePersonnageTEMP=new ArrayList<Personnage>();
        ListePersonnageTEMP=(ArrayList<Personnage>)(ListePersonnagePossibles.clone());
        
        
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
       
        
       
        ListePersonnagePossibles.clear();
        ListePersonnagePossibles=(ArrayList<Personnage>)(ListePersonnageTEMP.clone());
        
       
        //UPDATE FINAL DES LISTES
        MAJListes(ListePersonnagePossibles);
		
   }
   
    //Met à jour les listes selon les personnages présents dans liste en paramètre ListePersonnage
    public void MAJListes(ArrayList<Personnage> ListePersonnage){
        
        ListeGenre.clear();
        ListeTypeCheveux.clear();
        ListeCouleurCheveux.clear();
        ListeCouleurYeux.clear();
        ListeAccessoire.clear();  
        ListePays.clear(); 
        //ListeCouleurPeau.clear(); enlevé
        
         
        //Listes sans doublons
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
        
<<<<<<< HEAD
        
        //débuggage
          for(ArrayList A : ListeListe){
              System.out.println(A.size());
          }
        
        
=======
		
        //ListeListe.add(ListeCouleurPeau); enlevé
>>>>>>> parent of f1e2595... Revert "Commentaire IA.java"
        
        
    }
   
<<<<<<< HEAD
   //POUR RENVOYER LE PERSONNAGE TROUVÉ
=======
   //Renvoie le personnage trouvé
>>>>>>> parent of f1e2595... Revert "Commentaire IA.java"
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

