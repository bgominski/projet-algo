/*
 * TestRejouer.java
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
 import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;


public class TestRejouer {
	
	public static void main (String[] args) {
		//Création du jeu
		Jeu jeu = new Jeu(); 
		//Création de la fenêtre d'acceuil
        FenetreAccueil f1= new FenetreAccueil(jeu); 
        //Création de la fenêtre de jeu
        FenetreJeu f2 =new FenetreJeu(f1);
        //Création de la fenêtre fin de jeu
        FenetreRejouer f3= new FenetreRejouer(f2);
        
	}
}

