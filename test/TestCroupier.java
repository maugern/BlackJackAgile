
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestCroupier{
  private Croupier reference = new Croupier();
  private ArrayList<Carte> test_listeDeCarte = new ArrayList<Carte>();
  
  
  @Test
  public void test_getValeurDeLaMain(){
	test_listeDeCarte.add(new Carte(12,1));
    reference.setListeCarteDuCroupier(test_listeDeCarte);
    assertEquals(reference.getValeurDeLaMain(), 12);
    
    test_listeDeCarte.add(new Carte(1,2));
    reference = new Croupier();
    reference.setListeCarteDuCroupier(test_listeDeCarte);
    assertEquals(reference.getValeurDeLaMain(), 13);
    
    test_listeDeCarte.add(new Carte(7,2));
    reference = new Croupier();
    reference.setListeCarteDuCroupier(test_listeDeCarte);
    assertEquals(reference.getValeurDeLaMain(), 20);
  }
  
  @Test
  public void test_pioche(){
	  reference = new Croupier();
	  test_listeDeCarte.add(new Carte(2,3));
	  reference.setListeCarteDuCroupier(test_listeDeCarte);
	  reference.pioche(new Carte(5,1));
	  assertEquals(reference.getListeCarteDuCroupier().size(), 4);
	  
	  reference.pioche(new Carte(5,3));
	  assertEquals(reference.getListeCarteDuCroupier().size(), 4);
  }
}
