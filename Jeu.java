import java.util.*;
import javax.swing.*; //Pour image
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
    
    //Création d'une instance d'image pour que ça compile avec la classe Personnage qui a été modifiée
    ImageIcon imagePerso = new ImageIcon("/Users/alainboulard/Desktop/Capture d’écran 2020-03-28 à 20.11.02.png");
	
	// Création des personnages disponibles (À MODIFIER)
	public void creerListePerso(){
		Personnage p0 = new Personnage("Benjamin","homme","bouclés","blond","marron","claire", imagePerso);
		ListePersonnage.add(p0);
		Personnage p1 = new Personnage("Thomas","homme","bouclés","noir","marron","claire",  imagePerso);
		ListePersonnage.add(p1);
		Personnage p2 = new Personnage("Laura","femme","bouclés","bruns","marron","claire",  imagePerso);
		ListePersonnage.add(p2);
		Personnage p3 = new Personnage("Solenn","femme","ondulés","chatain","bleus","claire",  imagePerso);
		ListePersonnage.add(p3);
		Personnage p4 = new Personnage("Clément","homme","lisses","blond","marron","claire",  imagePerso);
		ListePersonnage.add(p4);
		Personnage p5 = new Personnage("Emma","femme","bouclés","noir","marron","brune",  imagePerso);
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


