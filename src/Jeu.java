import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Jeu {

	private Joueur j1 = new Joueur();

	// Contient toutes les cartes mises en jeu
	private ArrayList<Carte> sabot = new ArrayList<Carte>();

	// D�finit l'arri�re-plan de la fen�tre de jeu
	private JLabel fond = new JLabel(new ImageIcon(getClass().getResource(
			"fond.jpg")));
	// Tire une nouvelle carte
	private JButton refresh = new JButton();
	
	private Carte carteC1 = new Carte();
	private Carte carteC2 = new Carte();
	private Carte carteC3 = new Carte();
	private Carte carteC4 = new Carte();
	private Carte carteC5 = new Carte();
	// Affiche l'image de la premi�re carte
	private JLabel imageC1 = new JLabel();
	private JLabel imageC2 = new JLabel();
	private JLabel imageC3 = new JLabel();
	private JLabel imageC4 = new JLabel();
	private JLabel imageC5 = new JLabel();
	

	/*
	 * Constructeur principal permettant de lancer le jeu
	 */
	public Jeu(final JFrame f) {

		initSabot();

		for (int i = 0; i < 5; i++) {

			j1.cartes.add(new Carte(i+1,1));

			j1.listeCarteDuJoueur.add(new Carte(i+1,1));

		}

		// D�finit les param�tres de base de la fen�tre
		f.setIconImage(new ImageIcon(getClass().getResource("favicon.png"))
				.getImage());
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setPreferredSize(new Dimension(1920 / 2, 1080 / 2));
		f.setMinimumSize(new Dimension(1920 / 4, 1080 / 4));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Gestion du background
		fond.setLocation(0, 0);

		// Gestion du bouton refresh
		refresh.setText("Sabot : " + sabot.size());
		refresh.setBounds(0, 0, 200, 100);
		refresh.setBackground(Color.WHITE);
		refresh.setFocusable(false);
		refresh.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (sabot.size() > 0) {
					carteC1 = tirer();
					refreshCarte(carteC1,imageC1);
					carteC2 = tirer();
					refreshCarte(carteC2,imageC2);
				}
			}
		});

		// Gestion de l'image de la premi�re carte
		carteC1 = tirer();
		refreshCarte(carteC1,imageC1);
		carteC2 = tirer();
		refreshCarte(carteC2,imageC2);
		
		
		imageC1.setBounds(25, 500, 150, 219);
		imageC2.setBounds(175, 500, 150, 219);
		imageC3.setBounds(325, 500, 150, 219);
		imageC4.setBounds(475, 500, 150, 219);
		imageC5.setBounds(625, 500, 150, 219);

		// Ajoute tous les composants au panel
		f.getContentPane().add(refresh);
		f.getContentPane().add(imageC1);
		f.getContentPane().add(imageC2);
		f.getContentPane().add(imageC3);
		f.getContentPane().add(imageC4);
		f.getContentPane().add(imageC5);
		f.getContentPane().add(fond);

		f.pack();
		f.setVisible(true);
	}

	/*
	 * Donne au label la valeur d'une carte al�atoire pr�sente dans le sabot
	 */
	public Carte tirer() {
		Random r = new Random();
		int index = r.nextInt(sabot.size());
		Carte c = sabot.get(index);
		sabot.remove(index);
		refresh.setText("Sabot : " + sabot.size());
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
