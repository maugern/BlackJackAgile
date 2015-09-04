import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Jeu {

	// Création du croupier
	final Croupier croupier = new Croupier();

	// Contient toutes les cartes mises en jeu
	private ArrayList<Carte> sabot = new ArrayList<Carte>();

	// D�finit l'arri�re-plan de la fen�tre de jeu
	private JLabel fond = new JLabel(new ImageIcon(getClass().getResource(
			"fond.jpg")));
	// Tire une nouvelle carte
	private JButton tirer = new JButton();

	// Reste dur la table sans piocher

	private JButton rester = new JButton("Rester");
	// Affichage des jetons
	private JLabel score = new JLabel();

	// Affichage du score de la main
	private JLabel scoreMain = new JLabel();

	// Carte du joueur
	private Carte carteC1 = new Carte();
	private Carte carteC2 = new Carte();
	private Carte carteC3 = new Carte();
	private Carte carteC4 = new Carte();
	private Carte carteC5 = new Carte();
	// Affiche l'image des cartes du joueur
	private JLabel imageC1 = new JLabel();
	private JLabel imageC2 = new JLabel();
	private JLabel imageC3 = new JLabel();
	private JLabel imageC4 = new JLabel();
	private JLabel imageC5 = new JLabel();

	// Cartes du croupier
	private Carte carteCroupier1 = new Carte();
	private Carte carteCroupier2 = new Carte();
	private Carte carteCroupier3 = new Carte();
	private Carte carteCroupier4 = new Carte();
	private Carte carteCroupier5 = new Carte();
	// Affiche l'image des cartes du croupier
	private JLabel imageCroupier1 = new JLabel();
	private JLabel imageCroupier2 = new JLabel();
	private JLabel imageCroupier3 = new JLabel();
	private JLabel imageCroupier4 = new JLabel();
	private JLabel imageCroupier5 = new JLabel();

	/*
	 * Constructeur principal permettant de lancer le jeu
	 */
	public Jeu(final JFrame f, final Joueur j1) {

		initSabot();

		// D�finit les param�tres de base de la fen�tre
		f.setIconImage(new ImageIcon(getClass().getResource("favicon.png"))
				.getImage());
		f.setPreferredSize(new Dimension(1000, 750));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Gestion du background
		fond.setLocation(0, 0);

		// Gestion du bouton Rester
		rester.setBounds(10, 120, 200, 100);
		rester.setBackground(Color.WHITE);
		rester.setFocusable(false);
		rester.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				
				while (croupier.getValeurDeLaMain() < 17
						&& carteCroupier5.getValeur() == 0) {
					
					System.out.println(croupier.getValeurDeLaMain());
					
					if (carteCroupier2.getValeur() == 0) {

						carteCroupier2 = tirer();
						refreshCarte(carteCroupier2, imageCroupier2);
					} else if (carteCroupier3.getValeur() == 0) {

						carteCroupier3 = tirer();
						refreshCarte(carteCroupier3, imageCroupier3);
					} else if (carteCroupier4.getValeur() == 0) {

						carteCroupier4 = tirer();
						refreshCarte(carteCroupier4, imageCroupier4);
					} else if (carteCroupier5.getValeur() == 0) {

						carteCroupier5 = tirer();
						refreshCarte(carteCroupier5, imageCroupier5);
					}
				}
			}
		});

		// Gestion du bouton tirer
		tirer.setText("Tirer");
		tirer.setBounds(10, 10, 200, 100);
		tirer.setBackground(Color.WHITE);
		tirer.setFocusable(false);
		tirer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (carteC3.getValeur() == 0) {

					carteC3 = tirer(j1);
					refreshCarte(carteC3, imageC3);

					scoreMain.setText("" + j1.getValeurDeLaMain());
				} else if (carteC4.getValeur() == 0) {

					carteC4 = tirer(j1);
					refreshCarte(carteC4, imageC4);

					scoreMain.setText("" + j1.getValeurDeLaMain());
				} else if (carteC5.getValeur() == 0) {

					carteC5 = tirer(j1);
					refreshCarte(carteC5, imageC5);

					scoreMain.setText("" + j1.getValeurDeLaMain());
				}

				if (j1.getValeurDeLaMain() > 21) {
					j1.perdLaManche();
					f.dispose();
					j1.listeCarteDuJoueur = new ArrayList<Carte>();
					final JFrame f = new JFrame("BlackJack");

					javax.swing.SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							new Mise(f, j1);
						}
					});
				}

			}
		});

		// Affichage des jetons
		score.setText("" + j1.getJetons());
		score.setBounds(875, 600, 70, 70);
		score.setFont(new Font("Helvetica", 0, 48));
		score.setForeground(Color.WHITE);

		// Gestion de l'image de la premi�re carte
		carteC1 = tirer(j1);
		refreshCarte(carteC1, imageC1);
		carteC2 = tirer(j1);
		refreshCarte(carteC2, imageC2);
		carteCroupier1 = tirer();
		refreshCarte(carteCroupier1, imageCroupier1);

		scoreMain.setText("" + j1.getValeurDeLaMain());
		scoreMain.setBounds(100, 400, 70, 70);
		scoreMain.setFont(new Font("Helvetica", 0, 48));
		scoreMain.setForeground(Color.WHITE);

		imageC1.setBounds(25, 475, 150, 219);
		imageC2.setBounds(175, 475, 150, 219);
		imageC3.setBounds(325, 475, 150, 219);
		imageC4.setBounds(475, 475, 150, 219);
		imageC5.setBounds(625, 475, 150, 219);

		imageCroupier1.setBounds(825, 25, 150, 219);
		imageCroupier2.setBounds(675, 25, 150, 219);
		imageCroupier3.setBounds(525, 25, 150, 219);
		imageCroupier4.setBounds(375, 25, 150, 219);
		imageCroupier5.setBounds(225, 25, 150, 219);

		// Ajoute tous les composants au panel
		f.getContentPane().add(tirer);
		f.getContentPane().add(rester);
		f.getContentPane().add(imageC1);
		f.getContentPane().add(imageC2);
		f.getContentPane().add(imageC3);
		f.getContentPane().add(imageC4);
		f.getContentPane().add(imageC5);
		f.getContentPane().add(imageCroupier1);
		f.getContentPane().add(imageCroupier2);
		f.getContentPane().add(imageCroupier3);
		f.getContentPane().add(imageCroupier4);
		f.getContentPane().add(imageCroupier5);
		f.getContentPane().add(score);
		f.getContentPane().add(scoreMain);
		f.getContentPane().add(fond);

		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	/*
	 * Donne au label la valeur d'une carte al�atoire pr�sente dans le sabot
	 */
	public Carte tirer(final Joueur j1) {
		Random r = new Random();
		int index = r.nextInt(sabot.size());
		Carte c = sabot.get(index);
		j1.pioche(c);
		return c;
	}

	public Carte tirer() {
		Random r = new Random();
		int index = r.nextInt(sabot.size());
		Carte c = sabot.get(index);
		croupier.pioche(c);
		return c;
	}

	/*
	 * Rafraichit l'image de la carte
	 */
	public void refreshCarte(Carte c, JLabel i) {

		String name = "";
		if (c.getSymbole() == 0) {
			name = "Coeur/C";
		} else if (c.getSymbole() == 1) {
			name = "Trefle/T";
		} else if (c.getSymbole() == 2) {
			name = "Carreau/C";
		} else {
			name = "Pique/P";
		}

		name = name + c.getValeur() + ".png";

		i.setIcon(new ImageIcon(getClass().getResource(name)));
	}

	/*
	 * Initialise le sabot avec 13 cartes par symbole (soit 1 paquet de cartes)
	 */
	public void initSabot() {
		sabot = new ArrayList<Carte>();
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				sabot.add(new Carte(j, i));
			}
		}

	}

}
