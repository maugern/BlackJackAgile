
public class Joueur {
	
	private int money;
	private int mise;
	
	public Joueur(int money){
		this.setMoney(money);
	}
	
	public void perd(int perte){
		this.money -= perte;
	}
	
	public void gagne(int gain){
		this.money += gain;
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
