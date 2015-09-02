import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jeu extends JPanel {

	// Variables de jeu
	private int nbCartes = 52;
	private int[][] sabot = new int[13][4];

	// Composants graphiques
	JButton boutonSabot = new JButton("Sabot : " + nbCartes);

	public Jeu(JFrame f) {
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(600, 400));

		boutonSabot.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (nbCartes > 0) {
					nbCartes--;
					boutonSabot.setText("Sabot : " + nbCartes);

					// A CHANGER
					/*
					 * int e; Random r = new Random(); e = r.nextInt(2);
					 * tirerCarte(valeur, symbole);
					 */
				}
			}
		});

		this.add(boutonSabot);

		GroupLayout layout = new GroupLayout(f.getContentPane());
		f.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(this,
				GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(this,
				GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE));

		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	private Carte tirerCarte(int valeur, int symbole) {
		Carte c = new Carte(valeur, symbole);
		return c;
	}

	private void initSabot() {

	}
}
