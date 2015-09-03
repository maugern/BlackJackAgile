import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mise {

	private int mise = 1;
	private JButton augmenter = new JButton("Augmenter");
	private JButton diminuer = new JButton("Diminuer");
	private JButton texte = new JButton("Mise : " + mise);

	public Mise(final JFrame f, final Joueur j1) {
		f.setIconImage(new ImageIcon(getClass().getResource("favicon.png"))
				.getImage());
		f.setPreferredSize(new Dimension(200, 300));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(3, 1));

		
		augmenter.setBackground(Color.GREEN);
		augmenter.setForeground(Color.WHITE);
		augmenter.setFocusable(false);
		diminuer.setBackground(Color.RED);
		diminuer.setForeground(Color.WHITE);
		diminuer.setFocusable(false);
		texte.setBackground(Color.WHITE);
		texte.setFocusable(false);
		texte.setFont(new Font("Helvetica", 1, 24));
		
		augmenter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mise < j1.getJetons()){
					mise++;
					texte.setText("Mise : " + mise);
				}
				
			}
		});
		
		diminuer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mise > 1){
					mise--;
					texte.setText("Mise : " + mise);
				}
				
			}
		});
		
		texte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j1.setMise(mise);
				j1.setJetons(j1.getJetons()-mise);

				f.dispose();
				final JFrame f = new JFrame("BlackJack");
				
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new Jeu(f,j1);
					}
				});
			}
		});
		
		f.getContentPane().add(augmenter);
		f.getContentPane().add(texte);
		f.getContentPane().add(diminuer);

		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
