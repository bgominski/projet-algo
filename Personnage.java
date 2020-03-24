/*
 * Personnage.java
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


public class Personnage implements Comparable<Personnage> {
	
	// ATTRIBUTS
	private String nom;
	private String genre;
	private String typeCheveux;
	private String couleurCheveux;
	private String couleurYeux;
	private String couleurPeau;
	
	// MÉTHODES
	
	//Constructeur
	public Personnage(String nom, String genre, String typeCheveux, String couleurCheveux, String couleurYeux, String couleurPeau)  {
		this.nom=nom;
		this.genre=genre;
		this.typeCheveux=typeCheveux;
		this.couleurCheveux=couleurCheveux;
		this.couleurYeux=couleurYeux;
		this.couleurPeau=couleurPeau;
		}
		
	//Getters
	public String getNom() {
		return nom;
		}
	
	public String getGenre() {
		return genre;
		}
		
	public String getTypeCheveux() {
		return typeCheveux;	
		}
		
	public String getCouleurCheveux() {
		return couleurCheveux;	
		}
		
	public String getCouleurYeux() {
		return couleurYeux;	
		}
	
	public String getCouleurPeau() {
		return couleurPeau;	
		}
		
	//toString
	public String toString(){
		String res="Le personnage est " +this.getNom()+" : c'est un(e) "+this.getGenre()+
		" aux cheveux "+this.getCouleurCheveux()+" et " + this.getTypeCheveux()+
		" , aux yeux "+this.getCouleurYeux()+" et à la peau "+this.getCouleurPeau();
		return res ;
		}
	
	//CompareTo
	
	public int compareTo( Personnage p ) {	
		int res=0;	
		if (this.getNom()==p.getNom() && this.getGenre()==p.getGenre() &&
		 this.getTypeCheveux()==p.getTypeCheveux() && this.getCouleurCheveux()==p.getCouleurCheveux()&&
		 this.getCouleurYeux()==p.getCouleurYeux() && this.getCouleurPeau()==p.getCouleurPeau())
		    res=1;
		return res;
		}
		
}

