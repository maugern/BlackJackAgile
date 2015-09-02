import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jeu extends JPanel {

	// Variables de jeu
	private int nbCartes = 52;
	private ArrayList<Carte> sabot = new ArrayList<Carte>();

	// Composants graphiques
	JButton boutonSabot = new JButton("Sabot : " + nbCartes);
	JLabel labelCarte = new JLabel();

	public Jeu(JFrame f) {
		initSabot();
		
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(600, 400));

		boutonSabot.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (nbCartes > 1) {
					nbCartes--;
					boutonSabot.setText("Sabot : " + nbCartes);

					Carte c = tirerCarte();
					labelCarte.setText(c.toString());
				}
			}
		});

		this.add(boutonSabot);
		this.add(labelCarte);

		labelCarte.setBounds(50, 150, 100, 100);

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

	private Carte tirerCarte() {

		Random r = new Random();
		int i = r.nextInt(nbCartes);
		Carte c = sabot.get(i);
		sabot.remove(i);
		return c;
	}

	private void initSabot() {
		sabot = new ArrayList<Carte>();
		for (int v = 0; v < 13; v++) {
			for (int s = 0; s < 4; s++) {
				sabot.add(new Carte(v, s));
			}
		}
	}
}
