import java.util.*;
import javax.swing.*;
public class MainQuiEstCe {
	
	public static void main (String[] args) {
		
		// Test classe Personnage
        ImageIcon imagePerso = new ImageIcon("/Users/alainboulard/Desktop/Capture d’écran 2020-03-28 à 20.11.02.png");
		Personnage p2 = new Personnage("Laura","femme","bouclés","bruns","marrons","claire", imagePerso);
		
		 //FenetreAccueil f= new FenetreAccueil(20);
        //FenetreAccueil f1= new FenetreAccueil(20); 
        FenetreJeu f= new FenetreJeu();
				
	
	}
}

