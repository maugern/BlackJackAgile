
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestCroupier{
  private Croupier reference = new Croupier();
  private ArrayList<Carte> test_listeDeCarte = new ArrayList<Carte>();
  
  
  @Test
  public void test_getValeurDeLaMain(){
	test_listeDeCarte.add(new Carte(13,1));
    reference.setListeCarteDuCroupier (test_listeDeCarte);
    assertEquals(reference.getValeurDeLaMain(), 10);
    
    test_listeDeCarte.add(new Carte(1,2));
    reference.setListeCarteDuCroupier(test_listeDeCarte);
    assertEquals(reference.getValeurDeLaMain(), 21);
    
    test_listeDeCarte.add(new Carte(1,1));
    reference.setListeCarteDuCroupier(test_listeDeCarte);
    assertEquals(reference.getValeurDeLaMain(), 12);
  }
  
  @Test
  public void test_pioche(){
	  test_listeDeCarte = new ArrayList<Carte>();
	  
	  test_listeDeCarte.add(new Carte(1,1));
	  test_listeDeCarte.add(new Carte(1,1));
	  
	  reference = new Croupier();
	  
	  test_listeDeCarte.add(new Carte(2,3));
	  reference.setListeCarteDuCroupier(test_listeDeCarte);
	  
	  reference.pioche(new Carte(5,1));
	  assertEquals(reference.getListeCarteDuCroupier().size(), 4);
	  
	  reference.pioche(new Carte(5,3));
	  assertEquals(reference.getListeCarteDuCroupier().size(), 5);
	  
	  reference.pioche(new Carte(9,3));
	  assertEquals(reference.getListeCarteDuCroupier().size(), 5);
  }
}
