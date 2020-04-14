import javax.swing.*;
import java.util.*;

public class Personnage {
	
	// ATTRIBUTS
	private String nom;
	private String genre;
	private String typeCheveux;
	private String couleurCheveux;
	private String couleurYeux;
	private ImageIcon image; // Pour afficher la photo correspondant au personnage 
	
	// MÉTHODES
	
	//Constructeur
	public Personnage(String nom, String genre, String typeCheveux, String couleurCheveux, String couleurYeux, ImageIcon image)  {
		this.nom=nom;
		this.genre=genre;
		this.typeCheveux=typeCheveux;
		this.couleurCheveux=couleurCheveux;
		this.couleurYeux=couleurYeux;
		this.image=image; 
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
       //à modifier 
    public String getAccessoire() {
		return " ";	
		}
    public String getPays() {
		return " ";	
		}

	public ImageIcon getImage() {
		return image ;
	}
    
    /**public String getStringImage() {
       // return image.toString ; 
    }**/
		
	//toString
	public String toString(){
		String res=this.getNom()+" : c'est un(e) "+this.getGenre()+
		" aux cheveux "+this.getCouleurCheveux()+" et " + this.getTypeCheveux()+
		" , et aux yeux "+this.getCouleurYeux();
		return res ;
		}
	//equals
	public boolean equals(Personnage p) {
		boolean res=false;
		
		if (nom==p.getNom() && genre==p.getGenre() &&
		typeCheveux==p.getTypeCheveux() && couleurCheveux==p.getCouleurCheveux()&&
		couleurYeux==p.getCouleurYeux() && image==p.getImage())
		     res=true;
		    
		return res;
	}
		
}

