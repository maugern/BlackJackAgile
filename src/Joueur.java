import java.util.ArrayList;

<<<<<<< HEAD
=======
import javax.swing.JOptionPane;
>>>>>>> 2fb553d720a78d392081d24bc31ebace35794372


public class Joueur {
	
	private int valeurDeLaMain;
	private int jetons;
<<<<<<< HEAD
	public ArrayList<Carte> cartes = new ArrayList<>();
=======
	private int mise;
	public ArrayList<Carte> listeCarteDuJoueur = new ArrayList<Carte>();
>>>>>>> 2fb553d720a78d392081d24bc31ebace35794372
	
	public Joueur(){
		this.setJetons(10);
		
	}
	
	public int getValeurDeLaMain(){
		for(int i = 0; i < listeCarteDuJoueur.size(); i++){
			if(listeCarteDuJoueur.get(i).getValeur() == 1){ //si c'est un as
				if(valeurDeLaMain <= 10){ //si la valeur de main est inferieur ou egale a 10, l'as prend pour valeur 11
					valeurDeLaMain += 11;
				}else{
					valeurDeLaMain += 1; //si la valeur de la main est superieur a 10, l'as prend pour valeur 1
				}
			}else{
				valeurDeLaMain += listeCarteDuJoueur.get(i).getValeur();
			}
		}
		return valeurDeLaMain;
	}
	
	public void pioche(Carte carte){
		listeCarteDuJoueur.add(carte);
	}
	
	public boolean isBlackJack(){
		return getValeurDeLaMain() == 21;
	}

	public int getJetons() {
		return jetons;
	}

	public void setJetons(int jetons) {
		this.jetons = jetons;
	}

	public ArrayList<Carte> getListeCarteDuJoueur() {
		return listeCarteDuJoueur;
	}

	public void setListeCarteDuJoueur(ArrayList<Carte> listeCarteDuJoueur) {
		this.listeCarteDuJoueur = listeCarteDuJoueur;
	}

	public int getMise() {
		return mise;
	}

	public void setMise(int mise){
		if(mise <= jetons){
			this.mise = mise;
		}else{
			JOptionPane.showMessageDialog(null, "Vous n'avez plus assez d'argent!", "BlackJackAgile", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
