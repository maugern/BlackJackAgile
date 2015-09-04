import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Joueur {

	private int valeurDeLaMain;
	private int jetons;
	private int mise;
	private boolean isSplit = false;
	public ArrayList<Carte> listeCarteDuJoueur = new ArrayList<Carte>();
	public ArrayList<Carte> split_1 = new ArrayList<Carte>();
	public ArrayList<Carte> split_2 = new ArrayList<Carte>();

	public Joueur() {
		this.setJetons(10);
		this.valeurDeLaMain = 0;
	}

	public Joueur(int jetons) {
		this.jetons = jetons;
		this.valeurDeLaMain = 0;
	}

	public int getValeurDeLaMain(){
		valeurDeLaMain = 0;
		if(isSplit){//nouvelle partie du code
			int valeur_split1 = 0;
			int valeur_split2 = 0;
			for(int i = 0; i < split_1.size(); i++){
				if(split_1.get(i).getValeur() == 1){ //si c'est un as
					if(valeur_split1 <= 10){ //si la valeur de main est inferieur ou egale a 10, l'as prend pour valeur 11
						valeur_split1 += 11;
					}else{
						valeur_split1 += 1; //si la valeur de la main est superieur a 10, l'as prend pour valeur 1
					}
				}else if(split_1.get(i).getValeur() >= 10){
					valeur_split1 += 10;
				}
				
				else{
					valeur_split1 += split_1.get(i).getValeur();
				}
			}
			for(int i = 0; i < split_2.size(); i++){
				if(split_2.get(i).getValeur() == 1){ //si c'est un as
					if(valeur_split2 <= 10){ //si la valeur de main est inferieur ou egale a 10, l'as prend pour valeur 11
						valeur_split2 += 11;
					}else{
						valeur_split2 += 1; //si la valeur de la main est superieur a 10, l'as prend pour valeur 1
					}
				}else if(split_2.get(i).getValeur() >= 10){
					valeur_split2 += 10;
				}
				
				else{
					valeur_split2 += split_2.get(i).getValeur();
				}
			}
			if(valeur_split1 > valeur_split2 && valeur_split1 <= 21){ //on retourne la valeur du plus grand split inferieur ou egale à 21
				return valeur_split1;
			}else{
				return valeur_split2;
			}
			
			
		}else{ //si il est pas split, on le calcule normalement
			for(int i = 0; i < listeCarteDuJoueur.size(); i++){
				if(listeCarteDuJoueur.get(i).getValeur() == 1){ //si c'est un as
					if(valeurDeLaMain <= 10){ //si la valeur de main est inferieur ou egale a 10, l'as prend pour valeur 11
						valeurDeLaMain += 11;
					}else{
						valeurDeLaMain += 1; //si la valeur de la main est superieur a 10, l'as prend pour valeur 1
					}
				}else if(listeCarteDuJoueur.get(i).getValeur() >= 10){
					valeurDeLaMain += 10;
				}
				
				else{
					valeurDeLaMain += listeCarteDuJoueur.get(i).getValeur();
				}
			}
		}
		return valeurDeLaMain;
	}

	public void pioche(Carte carte) {
		if(isSplit){
			split_1.add(carte);
			split_2.add(carte);
		}else {
			if(listeCarteDuJoueur.size() < 5) {
			listeCarteDuJoueur.add(carte);
			}
		}
	}	

	public boolean isBlackJack() {
		return getValeurDeLaMain() == 21;
	}
	
	public boolean isSplitable(){
		return listeCarteDuJoueur.get(0).getValeur() == listeCarteDuJoueur.get(1).getValeur();
	}
	
	public void split(){
		split_1.add(listeCarteDuJoueur.get(0));
		split_2.add(listeCarteDuJoueur.get(1));
		listeCarteDuJoueur.remove(listeCarteDuJoueur.get(0));
		listeCarteDuJoueur.remove(listeCarteDuJoueur.get(1));
		isSplit = true;
	}
	
	

	public void gagneLaManche() {
		JOptionPane.showMessageDialog (null, "Vous remportez cette manche! \n Vous avez gagné " + mise + "€ !" , "Manche gagné!", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void perdLaManche() {
		JOptionPane.showMessageDialog (null, "Vous perdez cette manche \n Vous avez perdu " + mise + "€ !" , "Manche perdu!", JOptionPane.INFORMATION_MESSAGE);
		
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

	public void setMise(int mise) {
		if (mise <= jetons) {
			this.mise = mise;
		} else {
			JOptionPane.showMessageDialog(null,
					"Vous n'avez plus assez d'argent!", "BlackJackAgile",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
