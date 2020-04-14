import java.util.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
public class MainTESTIA {
	
	public static void main (String[] args) {
		
        Jeu jeu= new Jeu(); 
        IA TESTIA = new IA(jeu);
        
     
		while (!TESTIA.PersonnageFound()){
			System.out.println("nouvelle boucle");
            System.out.println(TESTIA.affichePersoPossibles());
            Question Query = TESTIA.QuestionIA(); 
            
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
        
       System.out.println();
       
       
   
        
        
				
	
	}
}

