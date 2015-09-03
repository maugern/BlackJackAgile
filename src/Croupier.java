import java.util.ArrayList;


public class Croupier {
	private int valeurDeLaMain;
	private int jetons;
	private ArrayList<Carte> listeCarteDuCroupier = new ArrayList<Carte>();
	
	public Croupier(){
		this.setJetons((int) Double.POSITIVE_INFINITY); //La banque a argent infinit
		this.valeurDeLaMain = 0;
	}
	
	public int getValeurDeLaMain(){
		for(int i = 0; i < listeCarteDuCroupier.size(); i++){
			if(listeCarteDuCroupier.get(i).getValeur() == 1){ //si c'est un as
				if(valeurDeLaMain <= 10){ //si la valeur de main est inferieur ou egale a 10, l'as prend pour valeur 11
					valeurDeLaMain += 11;
				}else{
					valeurDeLaMain += 1; //si la valeur de la main est superieur a 10, l'as prend pour valeur 1
				}
			}else{
				valeurDeLaMain += listeCarteDuCroupier.get(i).getValeur();
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
	
}
