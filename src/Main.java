import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		final JFrame f = new JFrame("BlackJack");

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Jeu(f);
			}
		});

	}

}
