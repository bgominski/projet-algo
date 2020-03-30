import javax.swing.*; //Besoin de ce package pour lire les images

public class Personnage {
	
	// ATTRIBUTS
	private String nom;
	private String genre;
	private String typeCheveux;
	private String couleurCheveux;
	private String couleurYeux;
	private String couleurPeau;
    private ImageIcon photo; // Pour afficher la photo correspondant au personnage 
	
	// MÉTHODES
	
	//Constructeur
	public Personnage(String nom, String genre, String typeCheveux, String couleurCheveux, String couleurYeux, String couleurPeau, ImageIcon photo)  {
		this.nom=nom;
		this.genre=genre;
		this.typeCheveux=typeCheveux;
		this.couleurCheveux=couleurCheveux;
		this.couleurYeux=couleurYeux;
		this.couleurPeau=couleurPeau;
        this.photo=photo; 
        
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
	
	public String getCouleurPeau() {
		return couleurPeau;	
        }
        
    public ImageIcon getPhoto() {
        return photo; 
        }
    
		
	//toString
	public String toString(){
		String res="Le personnage est " +this.getNom()+" : c'est un(e) "+this.getGenre()+
		" aux cheveux "+this.getCouleurCheveux()+" et " + this.getTypeCheveux()+
		" , aux yeux "+this.getCouleurYeux()+" et à la peau "+this.getCouleurPeau()+" alors voilà à quoi il ressemble !"+photo;
		return res ;
		}
		
}

