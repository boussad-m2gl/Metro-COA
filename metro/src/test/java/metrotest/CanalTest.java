package metrotest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import ihm.Afficheur;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import util.CanalImpl;
import util.Capteur;

@RunWith(MockitoJUnitRunner.class)
public class CanalTest {

	public CanalTest(){}
	
	@Test 
	public void updateTest(){
		  
		  CanalImpl can= new CanalImpl(null);
		  Afficheur affmock  = mock( Afficheur.class);
          can.setAfficheur(affmock);
          can.update((Capteur)null);
          verify(affmock).update(can); 
		  
		  System.out.println("  Hello toto how are you .... ");
	}
	
	  
}
