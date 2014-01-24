package metrotest;



import ihm.Afficheur;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import util.Canal;
import util.CanalImpl;
import util.Capteur;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CanalTest {

	public CanalTest(){}
	
	@Test 
	public void updateTest(){
		  
		  CanalImpl can= new CanalImpl(null);
		  Afficheur affmock  = mock( Afficheur.class);
          can.setAfficheur(affmock);
          can.update((Capteur)null);
          verify(affmock).update((Canal)null); 
		  // 
	}
	  
}
