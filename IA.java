/*
 * Jeu.java
 * 
 * Copyright 2020 Emmanuelle ROUSSI <emmanuelle@airdeemmanuelle.insa-lyon.fr>
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

import java.util.*;
public class IA {
	
	//ATTRIBUTS
	
	private LinkedList<Personnage> ListePersonnageInit;
	private LinkedList<Personnage> ListePersonnagePossibles;
	//private LinkedList<String> ListeNom=new LinkedList<String>();
	private LinkedList<String> ListeGenre=new LinkedList<String>();
	private LinkedList<String> ListeTypeCheveux=new LinkedList<String>();
	private LinkedList<String> ListeCouleurCheveux=new LinkedList<String>();
	private LinkedList<String> ListeCouleurYeux=new LinkedList<String>();
	private LinkedList<String> ListeCouleurPeau=new LinkedList<String>();
	private LinkedList<LinkedList> ListeListe= new LinkedList<LinkedList>();
	
	
	public IA(LinkedList<Personnage> ListePersonnageInit){
		
		this.ListePersonnageInit=ListePersonnageInit;
		this.ListePersonnagePossibles=ListePersonnageInit;
		
		//Constitution des listes de références SANS doublons
		for(Personnage a : ListePersonnageInit){
			if(!ListeGenre.contains(a.getGenre())){ListeGenre.add(a.getGenre());}
			
			if(!ListeTypeCheveux.contains(a.getTypeCheveux())){ListeGenre.add(a.getTypeCheveux());}
			
			if(!ListeCouleurCheveux.contains(a.getCouleurCheveux())){ListeGenre.add(a.getCouleurCheveux());}
			
			if(!ListeCouleurYeux.contains(a.getCouleurYeux())){ListeGenre.add(a.getCouleurYeux());}
			
			if(!ListeCouleurPeau.contains(a.getCouleurPeau())){ListeGenre.add(a.getCouleurPeau());}
			
		}
		
		ListeListe.add(ListeGenre);
		ListeListe.add(ListeTypeCheveux);
		ListeListe.add(ListeCouleurCheveux);
		ListeListe.add(ListeCouleurYeux);
		ListeListe.add(ListeCouleurPeau);
	}
	
	
	public String[] QuestionIA(){
		
		LinkedList<String> Choix = new LinkedList<String>();
		//LinkedList copie de la liste d'un type donné
		
		
		String[] Question= new String[2];
		//Question[0] : type
		//Question[1] : valeur
		
		
		//Choix random d'un type de caractéristique(Liste)
		//la liste doit contenir plus d'1 valeur
		Random rand1 = new Random(); 
		int indiceListe = rand1.nextInt(6);
		Choix = (LinkedList) ListeListe.get(indiceListe).clone();
		
		do{
			indiceListe = rand1.nextInt(6);
			Choix = (LinkedList) ListeListe.get(indiceListe).clone();
		}while(Choix.size()!=1);
		
		
		
		//obligé de faire ça? pour l'affichage de la question en interface
		if(indiceListe==0){Question[0]="Genre";}
		if(indiceListe==1){Question[1]="Type Cheveux";}
		if(indiceListe==2){Question[2]="Couleur Cheveux";}
		if(indiceListe==3){Question[3]="Couleur Yeux";}
		if(indiceListe==4){Question[4]="Couleur Peau";}
		
		
		
		
		//Choix random de valeur d'un type de caractéristique parmi celles présentes
		
		Random rand2 = new Random(); 
		int indiceValeur = rand2.nextInt(Choix.size()+1);
			
		Question[1]=Choix.get(indiceValeur);
		
		return Question;    
   }
   
   public void UpdateListes(boolean Ans,String[] Q){
	   
	   if(Ans){
	   }
   }
   
  
	   
}

