public class Carte {

	private int valeur;
	private int symbole;

	/*
	 * Cr�er une carte avec la valeur v (comprise entre 1 et 13) et un symbole
	 * (compris entre 0 et 3)
	 */
	
	public Carte(){}
	public Carte(int v, int s) {
		valeur = v;
		symbole = s;
	}

	public String toString() {
		return "Valeur (" + valeur + ") - Symbole (" + symbole + ")";
	}

	public int getValeur() {
		return valeur;
	}

	public int getSymbole() {
		return symbole;
	}

}
