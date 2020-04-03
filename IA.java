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
    //Accès au nom du personnage pour le check final avec la méthode Personnage.getNom()
    
    
	//Liste des personnages donnés par la méthode Jeu
	private ArrayList<Personnage> ListePersonnageInit;
    
    //Liste re-updated à chaque question : c'est le "pool" de l'ordi
	private ArrayList<Personnage> ListePersonnagePossibles;
	
	
    //Listes constituées des caractéristiques des personnages donnés par la méthode Jeu
    private ArrayList<String> ListeGenre=new ArrayList<String>();
	private ArrayList<String> ListeTypeCheveux=new ArrayList<String>();
	private ArrayList<String> ListeCouleurCheveux=new ArrayList<String>();
	private ArrayList<String> ListeCouleurYeux=new ArrayList<String>();
	private ArrayList<String> ListeCouleurPeau=new ArrayList<String>();
	//Indexation de ces listes pour une utilisation plus rapide
    private ArrayList<ArrayList<String>> ListeListe= new ArrayList<ArrayList<String>>();
    
  
    
    
	//Constructeur
	public IA(ArrayList<Personnage> ListePersonnageInit){
		
		this.ListePersonnageInit=(ArrayList<Personnage>)ListePersonnageInit.clone();
		this.ListePersonnagePossibles=(ArrayList<Personnage>)ListePersonnageInit.clone();
        
        
        this.MAJListes(ListePersonnageInit);
		    
	}
	
	
	public Question QuestionIA(){
       
        /*Si une liste ne comporte qu'1 élément,la question ne peut pas porter dessus*/
     
       
        int compteur=10;            //valeur pour initialiser
        int indiceListe=0;
        
        //Pour chaque Liste de caractéristiques : 
        for(ArrayList A : ListeListe){
            
            
            
            //Si la taille de la liste est inférieure à compteur et ce n'est pas la dernière liste
            if( A.size()<=compteur && indiceListe!=(ListeListe.size()-1) ){       //&& indiceListe!=(ListeListe.size()-1) : condition pour éviter IndexOutofBounds 
                compteur=A.size();                                                
                indiceListe++;
                }
                
          
            //Si la liste ne contient qu'un élément ET que c'est la dernière Liste : on décremente indiceListe jusqu'à obtenir une liste de plus d'un String
            int j=indiceListe;
            if(A.size()==1 && indiceListe==ListeListe.size()-1){
                while(ListeListe.get(j).size()==1){indiceListe--;j=indiceListe;}
            }
            
            //Si la liste ne contient qu'un élément mais que ce n'est pas la dernière liste, on la passe
            if (A.size()==1 && indiceListe!=(ListeListe.size()-1)){
                indiceListe++;
            }
            
        
            
        }
       
        
        //On choisit un élément dans liste d'indice indiceListe
        //Random rand1 = new Random(); 
		//int indiceAttribut = rand1.nextInt(ListeListe.get(indiceListe).size()  );
        
        int indiceAttribut =(int)(Math.random() * ((ListeListe.get(indiceListe).size())));
        
        
        
        
      
        
        //Question :
        Question Q = new Question(indiceListe,indiceAttribut,ListeListe.get(indiceListe).get(indiceAttribut));
        
        return Q;
   }
     
   public void UpdateListes(boolean Ans,Question Q){
       
       
      
        //Pour chaque personnage dans liste des choix possibles
        //on crée une  liste Personnage pour pouvoir modifier ListePersonnagePossible DANS la boucle for each
        ArrayList<Personnage> ListePersonnageTEMP=new ArrayList<Personnage>();
        ListePersonnageTEMP=(ArrayList<Personnage>)ListePersonnagePossibles.clone();
        for (Personnage P : ListePersonnagePossibles){
           
            //Valeur à éliminer ou à garder (Question posée par QuestionIA)
            String V=null;
           
            switch (Q.indiceListe){
                case 0 : V=P.getGenre();break;        //afin que String V soit initialisé
                case 1 : V=P.getTypeCheveux();break;
                case 2 : V=P.getCouleurCheveux();break;
                case 3 : V=P.getCouleurYeux();break;
                //case 4 : V=P.getCouleurPeau();break;
            }
            
        
        
            //Si le personnage cherché A cette caractéristique-là
            //on enlève tous les personnages n'ayant pas cette caractéristique-là
            if(Ans && (V!=Q.valeurAttribut)){
                System.out.println("*");
                ListePersonnageTEMP.remove(P);}
            
            //Si le personnage cherché N'a PAS cette caractéristique-là
            //on enlève tous les personnages l'ayant
           if ((!Ans) && V==Q.valeurAttribut){
                System.out.println("*");
                ListePersonnageTEMP.remove(P);}
            
            
            
        }
        
         for(Personnage P : ListePersonnageTEMP){
            
            System.out.println(P.toString());
        }
        ListePersonnagePossibles.clear();
        ListePersonnagePossibles=(ArrayList<Personnage>)ListePersonnageTEMP.clone();
       
        //UPDATE FINAL DES LISTES
        MAJListes(ListePersonnagePossibles);
		
   }
   
    //Met à jour les listes selon les personnages présents dans liste en paramètre ListePersonnage
    public void MAJListes(ArrayList<Personnage> ListePersonnage){
        
        ListeGenre.clear();
        ListeTypeCheveux.clear();
        ListeCouleurCheveux.clear();
        ListeCouleurYeux.clear();
        ListeCouleurPeau.clear();
        
		for(Personnage a : ListePersonnage){
			if(!ListeGenre.contains(a.getGenre())){ListeGenre.add(a.getGenre());}
			
			if(!ListeTypeCheveux.contains(a.getTypeCheveux())){ListeTypeCheveux.add(a.getTypeCheveux());}
			
			if(!ListeCouleurCheveux.contains(a.getCouleurCheveux())){ListeCouleurCheveux.add(a.getCouleurCheveux());}
			
			if(!ListeCouleurYeux.contains(a.getCouleurYeux())){ListeCouleurYeux.add(a.getCouleurYeux());}
			
			//if(!ListeCouleurPeau.contains(a.getCouleurPeau())){ListeCouleurPeau.add(a.getCouleurPeau());}
			
		}
        
        //UPDATE LISTE LISTE
        ListeListe.clear();
        
        ListeListe.add(ListeGenre);
		ListeListe.add(ListeTypeCheveux);
		ListeListe.add(ListeCouleurCheveux);
		ListeListe.add(ListeCouleurYeux);
		ListeListe.add(ListeCouleurPeau);
        
        
        
        
    }
   
   //Pour savoir si l'IA a éliminé toutes les possibilités
   public int TailleListe(){return ListePersonnagePossibles.size();}
   
   //Renvoie TRUE si le personnage a été trouvé
    public boolean PersonnageFound(){
       if (ListePersonnagePossibles.size()==1){
           return true;
       }
       return false;
   
   }
   
   
   
       
       
   
  
	   
}

