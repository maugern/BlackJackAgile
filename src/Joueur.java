import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Joueur {
	
	private int valeurDeLaMain;
	private int jetons;
	private int mise;
	private ArrayList<Carte> listeCarteDuJoueur = new ArrayList<Carte>();
	
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
