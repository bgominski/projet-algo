


public class Question {
    
    
    
    //ATTRIBUTS
    
    public int indiceListe;
    public int indiceAttribut;
    public String nomListe;
    public String valeurAttribut;
    
    //CONSTRUCTEUR 
    
    public Question(int indiceListe,int indiceAttribut,String valeurAttribut){
        
        
        this.indiceListe = indiceListe ; 
        this.indiceAttribut = indiceAttribut ; 
        this.valeurAttribut = valeurAttribut ; 
        
        if(indiceListe==0){nomListe="Genre";}
		if(indiceListe==1){nomListe="Type Cheveux";}
		if(indiceListe==2){nomListe="Couleur Cheveux";}
		if(indiceListe==3){nomListe="Couleur Yeux";}
		if(indiceListe==4){nomListe="Couleur Peau";}
        
        this.nomListe = nomListe;
    }
    
    public String toString(){
        return indiceListe+"  "+indiceAttribut+"  Le personnage a "+nomListe+" de type "+valeurAttribut;
    }
    
    
    
    
}


