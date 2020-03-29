public class Personnage {
	
	// ATTRIBUTS
	private String nom;
	private String genre;
	private String typeCheveux;
	private String couleurCheveux;
	private String couleurYeux;
	private String couleurPeau;
	
	// MÉTHODES
	
	//Constructeur
	public Personnage(String nom, String genre, String typeCheveux, String couleurCheveux, String couleurYeux, String couleurPeau)  {
		this.nom=nom;
		this.genre=genre;
		this.typeCheveux=typeCheveux;
		this.couleurCheveux=couleurCheveux;
		this.couleurYeux=couleurYeux;
		this.couleurPeau=couleurPeau;
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
		
	//toString
	public String toString(){
		String res="Le personnage est " +this.getNom()+" : c'est un(e) "+this.getGenre()+
		" aux cheveux "+this.getCouleurCheveux()+" et " + this.getTypeCheveux()+
		" , aux yeux "+this.getCouleurYeux()+" et à la peau "+this.getCouleurPeau();
		return res ;
		}
		
}

