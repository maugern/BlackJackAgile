<<<<<<< HEAD

public class Main {
	public static void main(String args[]){
		System.out.println("Hello world");
	}
=======
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

>>>>>>> 211cc80684f7c77d3bba11557873aac22c18c27a
}
