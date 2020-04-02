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
		
		this.ListePersonnageInit=ListePersonnageInit;
		this.ListePersonnagePossibles=ListePersonnageInit;
		
		 //Constitution des listes de références SANS doublons
		for(Personnage a : ListePersonnageInit){
			if(!ListeGenre.contains(a.getGenre())){ListeGenre.add(a.getGenre());}
			
			if(!ListeTypeCheveux.contains(a.getTypeCheveux())){ListeTypeCheveux.add(a.getTypeCheveux());}
			
			if(!ListeCouleurCheveux.contains(a.getCouleurCheveux())){ListeCouleurCheveux.add(a.getCouleurCheveux());}
			
			if(!ListeCouleurYeux.contains(a.getCouleurYeux())){ListeCouleurYeux.add(a.getCouleurYeux());}
			
			if(!ListeCouleurPeau.contains(a.getCouleurPeau())){ListeCouleurPeau.add(a.getCouleurPeau());}
			
		}
        
        ListeListe.add(ListeGenre);
		ListeListe.add(ListeTypeCheveux);
		ListeListe.add(ListeCouleurCheveux);
		ListeListe.add(ListeCouleurYeux);
		ListeListe.add(ListeCouleurPeau);
        
        
	}
	
	
	public Question QuestionIA(){
       
        
        //On détermine la liste la plus petite
        int compteur=10;            //valeur pour initialiser
        int indiceListe=0;
        for(ArrayList A : ListeListe){
            if(A.size()<=compteur){
                compteur=A.size();
                indiceListe++;
                }
            }
        
        //On choisit un élément dans liste d'indice indiceListe
        Random rand1 = new Random(); 
		int indiceAttribut = rand1.nextInt(ListeListe.get(indiceListe).size()  );
        
        
        
        
      
        
        //Question :
        Question Q = new Question(indiceListe,indiceAttribut,ListeListe.get(indiceListe).get(indiceAttribut));
        
        return Q;
   }
                        // NON     COULEURYEUX MARRONS indiceListe = 3
   public void UpdateListes(boolean Ans,Question Q){
        //Pour chaque personnage dans liste des choix possibles
        //on crée une  liste Personnage pour pouvoir modifier DANS la boucle for each
        ArrayList<Personnage> ListePersonnageTEMP=new ArrayList<Personnage>();
        ListePersonnageTEMP=ListePersonnagePossibles;
        for (Personnage P : ListePersonnagePossibles){
           
            //Valeur à éliminer ou à garder (Question posée par QuestionIA)
            String V;
            switch (Q.indiceListe){
                default : V=P.getGenre();           //afin que String V soit initialisé
                case 1 : V=P.getTypeCheveux();
                case 2 : V=P.getCouleurCheveux();
                case 3 : V=P.getCouleurYeux();
                case 4 : V=P.getCouleurPeau();
            }
        
            
            //Si le personnage cherché A cette caractéristique-là
            //on enlève tous les personnages n'ayant pas cette caractéristique-là
            if(Ans && (V!=Q.valeurAttribut)){ListePersonnageTEMP.remove(P);}
            
            //Si le personnage cherché N'a PAS cette caractéristique-là
            //on enlève tous les personnages l'ayant
            else if (!Ans && V==Q.valeurAttribut){ListePersonnageTEMP.remove(P);}
            
            
            
        }
        ListePersonnagePossibles.clear();
        ListePersonnagePossibles=ListePersonnageTEMP;
        //UPDATE FINAL DES LISTES
        ListeGenre.clear();
        ListeTypeCheveux.clear();
        ListeCouleurCheveux.clear();
        ListeCouleurYeux.clear();
        ListeCouleurPeau.clear();
        
		for(Personnage a : ListePersonnagePossibles){
			if(!ListeGenre.contains(a.getGenre())){ListeGenre.add(a.getGenre());}
			
			if(!ListeTypeCheveux.contains(a.getTypeCheveux())){ListeTypeCheveux.add(a.getTypeCheveux());}
			
			if(!ListeCouleurCheveux.contains(a.getCouleurCheveux())){ListeCouleurCheveux.add(a.getCouleurCheveux());}
			
			if(!ListeCouleurYeux.contains(a.getCouleurYeux())){ListeCouleurYeux.add(a.getCouleurYeux());}
			
			if(!ListeCouleurPeau.contains(a.getCouleurPeau())){ListeCouleurPeau.add(a.getCouleurPeau());}
			
		}
        
        ListeListe.add(ListeGenre);
		ListeListe.add(ListeTypeCheveux);
		ListeListe.add(ListeCouleurCheveux);
		ListeListe.add(ListeCouleurYeux);
		ListeListe.add(ListeCouleurPeau);
        
        
        //Si il ne reste qu'un élément dans une liste, on "verrouille" cette liste, l'IA ne peut plus poser de questions dessus
        for(ArrayList L : ListeListe){
            if (L.size()==1){ListeListe.remove(L);}
        }
		
   }
   
   public int TailleListe(){
       
       
       return this.ListePersonnagePossibles.size();
   }
   
   public ArrayList<Personnage> getPersonnage(){
       return (ListePersonnagePossibles);
   }
       
   
       
       
   
  
	   
}

