import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestJoueur {
	private Joueur reference = new Joueur();
	private ArrayList<Carte> test_listeDeCarte = new ArrayList<Carte>();
	private ArrayList<Carte> test_listeDeCarteSplit = new ArrayList<Carte>();
	
	@Test
	public void test_isSplitable(){
		test_listeDeCarteSplit.add(new Carte(8,1));
		test_listeDeCarteSplit.add(new Carte(8,2));
		reference.setListeCarteDuJoueur(test_listeDeCarteSplit);
		assertTrue(reference.isSplitable());
		
		test_listeDeCarte.add(new Carte(8,1));
		test_listeDeCarte.add(new Carte(9,2));
		reference.setListeCarteDuJoueur(test_listeDeCarte);
		assertFalse(reference.isSplitable());
	}
	
	
	@Test
	public void test_getValeurDeLaMain(){
		test_listeDeCarte.clear();
		
		test_listeDeCarte.add(new Carte(12,1));
		reference.setListeCarteDuJoueur(test_listeDeCarte);
		assertEquals(reference.getValeurDeLaMain(), 10);

		test_listeDeCarte.add(new Carte(5,2));
		reference = new Joueur();
		reference.setListeCarteDuJoueur(test_listeDeCarte);
		assertEquals(reference.getValeurDeLaMain(), 15);

		test_listeDeCarte.add(new Carte(10,2));
		reference = new Joueur();
		reference.setListeCarteDuJoueur(test_listeDeCarte);
		assertEquals(reference.getValeurDeLaMain(), 25);
	}
	
	

}
