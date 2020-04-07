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
import javax.swing.*;
public class Jeu {
	
	//ATTRIBUTS
	private String pseudo;
	private Personnage qui;
	private LinkedList<Personnage> ListePersonnage=new LinkedList<Personnage>();
	
	//MÉTHODES
	
	// Création des personnages disponibles (À MODIFIER)
	public Jeu(){
		creerListePerso();
	}
	
	public void creerListePerso(){

		ImageIcon im1 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/3 BIKIKRE Gabriel.jpeg.png");
		Personnage p1 = new Personnage("BIKIKRE Gabriel","homme","bouclés","bruns","marrons",im1);
		ListePersonnage.add(p1);
		ImageIcon im2 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/5 BEUGIN Maéva.png");
		Personnage p2 = new Personnage("BEUGIN Maeva","femme","lisses","blonds","marrons",im2);
		ListePersonnage.add(p2);
		ImageIcon im3 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/6 BOULARD Solenn.png");
		Personnage p3 = new Personnage("BOULARD Solenn","femme","lisses","chatains","bleus",im3);
		ListePersonnage.add(p3);
		ImageIcon im4 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/4 BEGAZO Gabriel.png");
		Personnage p4 = new Personnage("BEGAZO Gabriel","femme","lisses","bruns","marrons",im4);
		ListePersonnage.add(p4);
		ImageIcon im5 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/7 CANJURA Sonia.png");
		Personnage p5 = new Personnage("CANJURA Sonia","femme","lisses","noirs","marrons",im5);
		ListePersonnage.add(p5);
		ImageIcon im7 = new ImageIcon("/Users/emmanuelle/Desktop/21 ROUSSI Emmanuelle.JPG");
		Personnage p7 = new Personnage("CLAUDE Edouard","homme","bouclés","blonds","bleus",im7);
		ListePersonnage.add(p7);
		ImageIcon im8= new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/9 DRUTEL Maxence.png");
		Personnage p8 = new Personnage("DRUTEL Maxence","homme","lisses","bruns","marrons",im8);
		ListePersonnage.add(p8);
		ImageIcon im9 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/10 DAGHNI Samya.png");
		Personnage p9 = new Personnage("DAGHNI Samya","femme","bouclés","bruns","marrons",im9);
		ListePersonnage.add(p9);
		ImageIcon im10 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/11 FAURE Ninon.png");
		Personnage p10 = new Personnage("FAURE Ninon","femme","bouclés","chatains","marrons",im10);
		ListePersonnage.add(p10);
		ImageIcon im11 = new ImageIcon("/Users/emmanuelle/Desktop/21 ROUSSI Emmanuelle.JPG");
		Personnage p11 = new Personnage("GOMINSKI Benjamin","homme","lisses","blonds","bleus",im11);
		ListePersonnage.add(p11);
		ImageIcon im12 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/13 GRANGE Quentin.png");
		Personnage p12 = new Personnage("GRANGE Quentin","homme","lisses","bruns","marrons",im12);
		ListePersonnage.add(p12);
		ImageIcon im13 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/14 HARDY Guenael.png");
		Personnage p13 = new Personnage("HARDY Guenael","homme","bouclés","noirs","marrons",im13);
		ListePersonnage.add(p13);
		ImageIcon im14 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/15 LENGANEY Nicolas.png");
		Personnage p14 = new Personnage("LENGANEY Nicolas","homme","lisses","bruns","marrons",im14);
		ListePersonnage.add(p14);
		ImageIcon im15 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/19 RAGOT Andres.png");
		Personnage p15 = new Personnage("RAGOT Andres","homme","lisses","bruns","marrons",im15);
		ListePersonnage.add(p15);
        ImageIcon im16 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/16 MARTINEZ Karina.png");
		Personnage p16 = new Personnage("MARTINEZ Karina","femme","bouclés","bruns","marrons",im16);
		ListePersonnage.add(p16);
		ImageIcon im17 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/20 ROUGIER Julia.png");
		Personnage p17 = new Personnage("ROUGIER Julia","femme","lisses","bruns","bleus",im17);
		ListePersonnage.add(p17);
		ImageIcon im18 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/21 ROUSSI Emmanuelle.JPG");
		Personnage p18 = new Personnage("ROUSSI Emmanuelle","femme","bouclés","noirs","marrons",im18);
		ListePersonnage.add(p18);
		ImageIcon im19 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/21 ROUSSI Emmanuelle.JPG");
		Personnage p19 = new Personnage("SANDOZ Alexandre","homme","bouclés","chatains","marrons",im19);
		ListePersonnage.add(p19);
		ImageIcon im20 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/23 SIMONNET Léa.png");
		Personnage p20 = new Personnage("SIMONNET Léa","femme","bouclés","chatains","marrons",im20);
		ListePersonnage.add(p20);
		ImageIcon im21 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/24 VARGAS Diego.png");
		Personnage p21 = new Personnage("VARGAS Diego","homme","lisses","bruns","marrons",im21);
		ListePersonnage.add(p21);
        
        qui = p1 ; //instanciation dun personnage
		
		}
	
		
		
	// Getters
	public String getPseudo(){
		return this.pseudo;
		}
		
	public String gettoStringQui(){
		return qui.toString();
		}
		
	public Personnage getQui(){
		return qui;
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


