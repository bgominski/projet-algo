


public class Question {
    
    
    
    //ATTRIBUTS
    
    private int indiceListe;
    private int indiceAttribut;
    private String nomListe;
    private String valeurAttribut;
    
    //CONSTRUCTEUR 
    
    public Question(int indiceListe,int indiceAttribut,String valeurAttribut){
        
        
        this.indiceListe = indiceListe ; 
        this.indiceAttribut = indiceAttribut ; 
        this.valeurAttribut = valeurAttribut ; 
        
        if(indiceListe==0){nomListe="Genre";}
		if(indiceListe==1){nomListe="Couleur Cheveux";}
		if(indiceListe==2){nomListe="Type Cheveux";}
		if(indiceListe==3){nomListe="Couleur Yeux";}
		//if(indiceListe==4){nomListe="Couleur Peau";}
        
        this.nomListe = nomListe;
    }
    
    public String toString(){
        return "  Le personnage a la caractérique "+nomListe+" de type "+valeurAttribut+" ?";
    }
    
    //GETTERs
    
    public int getindiceListe(){return indiceListe;}
    public int getindiceAttribut(){return indiceAttribut;}
    public String getnomList(){return nomListe;}
    public String getvaleurAttribut(){return valeurAttribut;}
    
}


