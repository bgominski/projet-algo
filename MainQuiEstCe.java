import java.util.*;
import javax.swing.*;
public class MainQuiEstCe {
	
	public static void main (String[] args) {
		
		// Test classe Personnage
        ImageIcon imagePerso = new ImageIcon("/Users/alainboulard/Desktop/École/INSA/2A/Info/S4/Projet algo/4_DOCUMENT EXPLICATIF/Photos classe/Capture d’écran 2020-03-28 à 20.11.02.png");
		Personnage p2 = new Personnage("Laura","femme","bouclés","bruns","marrons", imagePerso);
		
		 //FenetreAccueil f= new FenetreAccueil(20);
        FenetreAccueil f1= new FenetreAccueil(20); 
        //FenetreJeu f= new FenetreJeu();
        Jeu jeu = new Jeu(); 
        /**
        //System.out.println((jeu.getListePersonnage().get(19)).getNom()); 
        
        //System.out.println(jeu.getListePersonnage().get(5).getNom()) ; 
        
        
        ArrayList<Personnage> ListePersonnage=new ArrayList<Personnage>();
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
        for(Personnage P : ListePersonnage){
            
            System.out.println(P.toString());
        }
        
         IA TESTIA = new IA(ListePersonnage);
         
     
         
        
     
        while (!TESTIA.PersonnageFound()){
            Question Query = TESTIA.QuestionIA() ; 
            System.out.println(Query.toString());
         
           
           
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez saisir réponse :");
            String str = sc.nextLine();
            char carac = str.charAt(0);
            boolean ans;
            if (carac=='o'){ans=true;}
            else {ans=false;}
            System.out.println("Vous avez saisi : " + ans);
           
          
            TESTIA.UpdateListes(ans,Query);
            
        }
        **/
   
        
        
				
	
	}
}

