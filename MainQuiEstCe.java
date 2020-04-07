import java.util.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
public class MainQuiEstCe {
	
	public static void main (String[] args) {
		
		// Test classe Personnage
        ImageIcon im1 = new ImageIcon("/Users/emmanuelle/Desktop/21 ROUSSI Emmanuelle.JPG");

         //Personnage p12 = new Personnage("GRANGE Quentin","homme","lisses","bruns","marrons",im1);
		 Jeu jeu = new Jeu(); 
		 FenetreAccueil f1= new FenetreAccueil(); 
         
         
         System.out.println(jeu.getQui()); 
         
         
		 //FenetreJeu f2= new FenetreJeu(); 
		 //jeu.setQui( p12);
         IA TESTIA = new IA(jeu);
        
     while (!TESTIA.PersonnageFound()){
			System.out.println("nouvelle boucle");
            TESTIA.afficheListe();
            Question Query = TESTIA.QuestionIA(); 
            System.out.println(Query.toString());
            System.out.println("Veuillez saisir réponse :");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
          
            char carac = str.charAt(0);
            boolean ans;
            if (carac=='o'){ans=true;}
            else {ans=false;}
            System.out.println("Vous avez saisi : " + ans);
            TESTIA.UpdateListes(ans,Query);
        } 
        
       System.out.println("Notre ordinateur t'as démasqué... aurais-tu un crush sur "+jeu.getQui()+" ? :)");
       
       
   
        
        
				
	
	}
}

