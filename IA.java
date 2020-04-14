/*
 * IA.java
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
 
 
 
 /*
  * Lexique : 
  * Attributs :  pour désigner les attributs d'un personnage, comme les yeux, les cheveux...
  * Valeur : pour désigner la valeur de l'attribut, comme vert, bleu, blanc...
  * 
  * 
  * 
  * 
  * 
  * 
  */
  
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
	//private ArrayList<String> ListeCouleurPeau=new ArrayList<String>();
	//Indexation de ces listes pour une utilisation plus rapide
    private ArrayList<ArrayList<String>> ListeListe= new ArrayList<ArrayList<String>>();
    
  
    
    
	//Constructeur
	public IA(Jeu jeu){
		
		this.ListePersonnageInit=(ArrayList<Personnage>)((jeu.getListePersonnage()).clone());
		this.ListePersonnagePossibles=(ArrayList<Personnage>)(ListePersonnageInit.clone());
        
        
        this.MAJListes(ListePersonnageInit);
		    
	}
	
	
	public Question QuestionIA(){
       
        
        //On détermine la liste la plus petite 
     
        // && indiceListe!=(ListeListe.size()-1) : condition pour éviter IndexOutofBounds 
        int compteur=10;            //valeur pour initialiser
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
        //Random rand1 = new Random(); 
		//int indiceAttribut = rand1.nextInt(ListeListe.get(indiceListe).size()  );
        
        int indiceAttribut =(int)(Math.random() * (ListeListe.get(indiceListe).size())); 
        System.out.println("indiceattribut= "+indiceAttribut);
        
        //Question :
        Question Q = new Question(indiceListe,indiceAttribut,ListeListe.get(indiceListe).get(indiceAttribut));
        
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
       
        
		for(Personnage a : ListePersonnage){
			if(!ListeGenre.contains(a.getGenre())){ListeGenre.add(a.getGenre());}
			
			if(!ListeTypeCheveux.contains(a.getTypeCheveux())){ListeTypeCheveux.add(a.getTypeCheveux());}
			
			if(!ListeCouleurCheveux.contains(a.getCouleurCheveux())){ListeCouleurCheveux.add(a.getCouleurCheveux());}
			
			if(!ListeCouleurYeux.contains(a.getCouleurYeux())){ListeCouleurYeux.add(a.getCouleurYeux());}
			
			
			
		}
        
        //UPDATE LISTE LISTE
        ListeListe.clear();
                
        ListeListe.add(ListeGenre);		
		ListeListe.add(ListeCouleurCheveux);        
        ListeListe.add(ListeTypeCheveux);
		ListeListe.add(ListeCouleurYeux);
		
        //ListeListe.add(ListeCouleurPeau);
        
        
          for(ArrayList A : ListeListe){
              System.out.println(A.size());
          }
        
        
        
        
    }
   
   //Pour savoir si l'IA a éliminé toutes les possibilités
   public void afficheListe(){
       for(Personnage A : ListePersonnagePossibles){
              System.out.println(A.toString());
          }
      }
   
   //Renvoie TRUE si le personnage a été trouvé
    public boolean PersonnageFound(){
       if (ListePersonnagePossibles.size()==1){
           System.out.println("Notre ordinateur t'as démasqué... aurais-tu un crush sur "+" ? :)"+ListePersonnagePossibles.get(0).toString());
           return true;
       }
       else
       return false;
   
   }
   
       
	   
}

