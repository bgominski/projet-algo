import java.util.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
public class MainQuiEstCe {
	
	public static void main (String[] args) {
		//Création du jeu
		Jeu jeu = new Jeu(); 
		//Création de la fenêtre de jeu
        FenetreAccueil f1= new FenetreAccueil(jeu); 	
	}
}
