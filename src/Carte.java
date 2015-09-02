public class Carte {

	private int valeur;
	private int symbole;

	public Carte(int valeur, int symbole) {
		this.valeur = valeur;
		this.symbole = symbole;
	}

	public String toString() {
		return "Valeur (" + valeur + ") - Symbole (" + symbole + ")";
	}

}
