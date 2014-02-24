package metrotest;

import static org.junit.Assert.assertEquals;
import ihm.Afficheur;

import javax.swing.JTextArea;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import util.CanalImpl;
import util.Capteur;
import util.CapteurImpl;

/**
 * Canal Test
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class CanalTest {

	private Afficheur _afficheur;
	private Capteur _capteur;

	@Before
	public void setUp() throws Exception {

		_afficheur = new Afficheur(new JTextArea());
		_capteur = new CapteurImpl();
	}
  
	/**
	 * Test du Canal , vs son Afficheur et son Capteur   
	 */
	@Test
	public void canalTest() {

		CanalImpl canal = new CanalImpl(_capteur);
		canal.setAfficheur(_afficheur);
		assertEquals(_afficheur.hashCode(), canal.getAfficheur().hashCode());

		canal.attach(_afficheur);
		assertEquals(_afficheur.hashCode(), canal.getAfficheur().hashCode());

		canal.detach(_afficheur);
		assertEquals(canal.getAfficheur(), null);

		canal.setCapteur(_capteur);
		assertEquals(canal.getCapteur().hashCode(), _capteur.hashCode());

	}

	@After
	public void tearDown() throws Exception {
		_afficheur = null;
		_capteur = null;
	}

}
