import junit.frame.Asert;
import org.junit.Test;
import java.util.ArrayList;

public class TestCroupier{
  private Croupier reference;
  private ArrayList<Carte> test_listeDeCarte = new ArrayList<Carte>();
  test_listeDeCarte.add(new Carte(5,1));
  test_listeDeCarte.add(new Carte(5,1));
  
  @Test
  public void test_getValeurDeLaMain(){
    reference.setListeDeCarte(test_listeDeCarte);
    assertEquals(referance.getValeurDeLaMain(), 10);
  }
