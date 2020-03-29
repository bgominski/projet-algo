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
public class Jeu {
	
	//ATTRIBUTS
	private String pseudo;
	private Personnage qui;
	private LinkedList<Personnage> ListePersonnage=new LinkedList<Personnage>();
	/*private LinkedList<String> ListeNom=new LinkedList<String>();
	private LinkedList<String> ListeGenre=new LinkedList<String>();
	private LinkedList<String> ListeTypeCheveux=new LinkedList<String>();
	private LinkedList<String> ListeCouleurCheveux=new LinkedList<String>();
	private LinkedList<String> ListeCouleurYeux=new LinkedList<String>();
	private LinkedList<String> ListeCouleurPeau=new LinkedList<String>();
	*/
	
	//MÉTHODES
	
	// Création des personnages disponibles (À MODIFIER)
	public void creerListePerso(){
		Personnage p0 = new Personnage("Benjamin","homme","bouclés","blond","marron","claire");
		ListePersonnage.add(p0);
		Personnage p1 = new Personnage("Thomas","homme","bouclés","noir","marron","claire");
		ListePersonnage.add(p1);
		Personnage p2 = new Personnage("Laura","femme","bouclés","bruns","marron","claire");
		ListePersonnage.add(p2);
		Personnage p3 = new Personnage("Solenn","femme","ondulés","chatain","bleus","claire");
		ListePersonnage.add(p3);
		Personnage p4 = new Personnage("Clément","homme","lisses","blond","marron","claire");
		ListePersonnage.add(p4);
		Personnage p5 = new Personnage("Emma","femme","bouclés","noir","marron","brune");
		ListePersonnage.add(p5);
		}
		
	// Getters
	public String getPseudo(){
		return this.pseudo;
		}
		
	public Personnage getQui(){
		return this.qui;
		}
	
	public LinkedList<Personnage> getListePersonnage() {
		return this.ListePersonnage;
		}
	
	//Setters
	public void setPseudo(String pseudo){
		this.pseudo=pseudo;
		}
		
	public void setQui(Personnage p){
		this.qui=p;
		}
	
	
	//Boucle de Jeu	
	//À compléter
	
	/* niveau IA :
	 * Question sur une caractéristique 
	 * si non : rayer tout pers. ayant cette caract.
	 * si oui : rayer tout pers n'ayant pas cette caract. 
		*/
	}


