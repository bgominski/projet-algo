import java.awt.event.*;
import java.util.*;

public class EcouteurJouer implements ActionListener{
	private FenetreAccueil fen;
	private FenetreJeu fen2;
	
	public EcouteurJouer(FenetreAccueil fen) {
		this.fen = fen;
		
	}
    //actionPerformed indique les instructions a executer au clic du bouton
    public void actionPerformed(ActionEvent e){
        //Ferme la fenêtre d'accueil
		fen.hide();
        //Ouvre la fenêtre de jeu
		fen2 = new FenetreJeu(fen);

    }
}
