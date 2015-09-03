import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Jeu {

	// Contient toutes les cartes mises en jeu
	private ArrayList<Carte> sabot = new ArrayList<Carte>();

	// D�finit l'arri�re-plan de la fen�tre de jeu
	private JLabel fond = new JLabel(new ImageIcon(getClass().getResource(
			"fond.jpg")));
	// Associe une nouvelle valeur au label c1
	private JButton refresh = new JButton();
	// Affiche la valeur et le symbole de la premi�re carte tir�e
	private JLabel c1 = new JLabel();
	private Carte carteC1;
	// Affiche l'image de la premi�re carte
	private JLabel imageC1 = new JLabel();

	/*
	 * Constructeur principal permettant de lancer le jeu
	 */
	public Jeu(final JFrame f) {

		initSabot();

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
					setValue(c1);
					refreshCarte();
				}
			}
		});

		// Gestion de la premi�re carte
		setValue(c1);
		c1.setFont(new Font("Oswald", 0, f.getWidth() / 14));
		c1.setForeground(Color.WHITE);
		c1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		c1.setBounds(0, (f.getHeight() / 4) * 3, f.getWidth(), 75);

		// Gestion de l'image de la premi�re carte
		refreshCarte();
		imageC1.setBounds(25, 500, 150, 219);

		// Ajoute tous les composants au panel
		f.getContentPane().add(refresh);
		f.getContentPane().add(c1);
		f.getContentPane().add(imageC1);
		f.getContentPane().add(fond);

		f.pack();
		f.setVisible(true);
	}

	/*
	 * Donne au label la valeur d'une carte al�atoire pr�sente dans le sabot
	 */
	public void setValue(JLabel l) {
		Random r = new Random();
		int c1Value = r.nextInt(sabot.size());
		Carte c = sabot.get(c1Value);
		l.setText(c.toString());
		carteC1 = c;
		sabot.remove(c1Value);
		refresh.setText("Sabot : " + sabot.size());

	}

	/*
	 * Rafraichit l'image de la carte
	 */
	public void refreshCarte() {
		String name = "";
		if (carteC1.getSymbole() == 0) {
			name = "Coeur/C";
		} else if (carteC1.getSymbole() == 1) {
			name = "Trefle/T";
		} else if (carteC1.getSymbole() == 2) {
			name = "Carreau/C";
		} else {
			name = "Pique/P";
		}

		name = name + carteC1.getValeur() + ".png";

		imageC1.setIcon(new ImageIcon(getClass().getResource(name)));
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
