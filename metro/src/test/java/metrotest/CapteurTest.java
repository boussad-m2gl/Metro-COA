package metrotest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import util.Capteur;
import util.CapteurImpl;
import util.Horloge;
import algorithmes.AlgoDiffusion;
import algorithmes.DiffusionAtomiqAlgo;

/**
 * Teste du  Capteur   
 *
 */

/**
 * Canal Test
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class CapteurTest {

	private Capteur _capteur;
	private Horloge _horlogeMock;
	private AlgoDiffusion _algoDiff;
	private AlgoDiffusion _algoDiffMock;

	@Before
	public void setUp() throws Exception {
		
		_capteur = new CapteurImpl();
		_horlogeMock = mock(Horloge.class);
		_algoDiff = new DiffusionAtomiqAlgo();
		_algoDiffMock = mock(DiffusionAtomiqAlgo.class);

	}

	/**
	 * Test du Capteur _ vs Intération avec son algo de diffusion , L'Horloge
	 * 
	 */
	@Test
	public void capteurTest() {

		_capteur.setAlgoDiffusion(_algoDiff);
		assertEquals(_algoDiff.hashCode(), _capteur.getAlgoDiffusion()
				.hashCode());

		_capteur.setAlgoDiffusion(_algoDiffMock);
		_capteur.getValue();
		verify(_algoDiffMock).executeGetValue();
		_capteur.tick();
		verify(_algoDiffMock).executeTick();

		((CapteurImpl) _capteur).setHologe(_horlogeMock);
		_capteur.start();
		verify(_horlogeMock).startChrono();
		_capteur.stop();
		verify(_horlogeMock).stopChrono();

	}

	@After
	public void tearDown() throws Exception {

		_capteur = null;
		_horlogeMock = null;
		_algoDiff = null;
		_algoDiffMock = null;
	}

}
