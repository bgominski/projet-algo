//interface
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

//son
import java.io.*; 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;


public class Jeu {
	
	//ATTRIBUTS
	private String pseudo;
	private Personnage qui;
	private ArrayList<Personnage> listePersonnage=new ArrayList<Personnage>(); //contient tous les personnages possibles initialement
	private Question question; //contient la dernière question posée par l'IA
	private IA ia;
	
	//MÉTHODES
	
	//Constructeur
	public Jeu(int numeroVersion){
        
        creerListePerso();
        
        if(numeroVersion==1) {
		jouerVersion1();
        }
        
        if(numeroVersion==2){
        jouerVersion2();
        }
            
	}
    	
    //Création des personnages disponibles
	public void creerListePerso(){
        ImageIcon im1 = new ImageIcon(new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/3 BIKIKRE Gabriel.jpeg.png").getImage().getScaledInstance(175,160, Image.SCALE_DEFAULT)) ; 
		Personnage p1 = new Personnage("BIKIKRE Gabriel","homme","frisés","noirs","marrons",im1, "rien", "Guadeloupe");
		listePersonnage.add(p1);
		ImageIcon im2 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/5 BEUGIN Maéva.png");
		Personnage p2 = new Personnage("BEUGIN Maeva","femme","lisses","blonds","marrons",im2, "lunettes", "France");
		listePersonnage.add(p2);
		ImageIcon im3 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/6 BOULARD Solenn.png");
		Personnage p3 = new Personnage("BOULARD Solenn","femme","lisses","chatains","bleus",im3, "rien", "Guadeloupe");
		listePersonnage.add(p3);
		ImageIcon im4 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/4 BEGAZO Gabriel.png");
		Personnage p4 = new Personnage("BEGAZO Gabriel","homme","lisses","bruns","marrons",im4, "rien", "Pérou");
		listePersonnage.add(p4);
		ImageIcon im5 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/7 CANJURA Sonia.png");
		Personnage p5 = new Personnage("CANJURA Sonia","femme","lisses","noirs","marrons",im5, "rien", "El Salvador");
		listePersonnage.add(p5);
		ImageIcon im7 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/8 CLAUDE Edouard.png");
		Personnage p7 = new Personnage("CLAUDE Edouard","homme","bouclés","blonds","bleus",im7, "sa tête", "France");
		listePersonnage.add(p7);
		ImageIcon im8= new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/9 DRUTEL Maxence.png");
		Personnage p8 = new Personnage("DRUTEL Maxence","homme","lisses","chatains","marrons",im8, "rien", "France");
		listePersonnage.add(p8);
		ImageIcon im9 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/10 DAGHNI Samya.png");
		Personnage p9 = new Personnage("DAGHNI Samya","femme","bouclés","bruns","marrons",im9, "rien", "Maroc");
		listePersonnage.add(p9);
		ImageIcon im10 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/11 FAURE Ninon.png");
		Personnage p10 = new Personnage("FAURE Ninon","femme","bouclés","chatains","verts",im10, "lunettes", "Guadeloupe");
		listePersonnage.add(p10);
		ImageIcon im11 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/12 GOMINSKI Benjamin.png");
		Personnage p11 = new Personnage("GOMINSKI Benjamin","homme","frisés","blonds","bleus",im11, "rien", "France");
		listePersonnage.add(p11);
		ImageIcon im12 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/13 GRANGE Quentin.png");
		Personnage p12 = new Personnage("GRANGE Quentin","homme","lisses","chatains","bleus",im12, "lunettes", "France");
		listePersonnage.add(p12);
		ImageIcon im13 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/14 HARDY Guenael.png");
		Personnage p13 = new Personnage("HARDY Guenael","homme","bouclés","noirs","marrons",im13, "rien", "Martinique");
		listePersonnage.add(p13);
		ImageIcon im14 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/15 LENGANEY Nicolas.png");
		Personnage p14 = new Personnage("LENGANEY Nicolas","homme","lisses","noirs","marrons",im14, "lunettes", "Guyane");
		listePersonnage.add(p14);
		ImageIcon im15 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/19 RAGOT Andres.png");
		Personnage p15 = new Personnage("RAGOT Andres","homme","bouclés","bruns","marrons",im15, "rien", "Vénézuela");
		listePersonnage.add(p15);
        ImageIcon im16 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/16 MARTINEZ Karina.png");
		Personnage p16 = new Personnage("MARTINEZ Karina","femme","bouclés","bruns","marrons",im16, "rien", "Panama");
		listePersonnage.add(p16);
		ImageIcon im17 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/20 ROUGIER Julia.png");
		Personnage p17 = new Personnage("ROUGIER Julia","femme","lisses","bruns foncé","bleus",im17, "rien", "Le ciel");
		listePersonnage.add(p17);
		ImageIcon im18 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/21 ROUSSI Emmanuelle.JPG");
		Personnage p18 = new Personnage("ROUSSI Emmanuelle","femme","frisés","noirs","marrons",im18, "sa beauté", "Martinique");
		listePersonnage.add(p18);
        ImageIcon im19 = new ImageIcon(new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/22 SANDOZ Alexandre.png").getImage().getScaledInstance(175,160, Image.SCALE_DEFAULT)) ; 
		Personnage p19 = new Personnage("SANDOZ Alexandre","homme","bouclés","chatains","marrons",im19, "rien", "Guadeloupe");
		listePersonnage.add(p19);
		ImageIcon im20 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/23 SIMONNET Léa.png");
		Personnage p20 = new Personnage("SIMONNET Léa","femme","bouclés","chatains","marrons",im20, "rien", "France");
		listePersonnage.add(p20);
		ImageIcon im21 = new ImageIcon("/Users/alainboulard/Desktop/photos ajustée algo/24 VARGAS Diego.png");
		Personnage p21 = new Personnage("VARGAS Diego","homme","lisses","bicolores","marrons",im21, "rien", "Méééxico");
		listePersonnage.add(p21);
        
        qui = p1 ; //initialisation de la valeur  de "qui" 
		
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
	
	public ArrayList<Personnage> getListePersonnage() {
		return this.listePersonnage;
		}
        
	public Question getQuestion(){
		return this.question;
		}
		
	public IA getIA(){
		return this.ia;
		}
	

	//Setters	
	public void setQui(Personnage p){
		this.qui=p;
		}
		
	public void setQuestion(Question q){
		this.question=q;
		}
    
   //Méthode pour le son     
   public void playSound(String soundName){
   try 
   {
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
    Clip clip = AudioSystem.getClip( );
    clip.open(audioInputStream);
    clip.start( );
   }
   catch(Exception ex)
   {
     System.out.println("Error with playing sound.");
     ex.printStackTrace( );
   }
 }
        
			
	//Boucles de Jeu	
	public void jouerVersion1(){
		ia = new IA(this);
		question = ia.QuestionIA(); //récupère une première question	
        FenetreAccueil f1= new FenetreAccueil(this); //ouvre une fenêtre de jeu de version 1	
	}
    
    public void jouerVersion2(){
		FenetreJeu2 f2 = new FenetreJeu2(this); //ouvre une fenêtre de jeu de version 2
	}
    
}
