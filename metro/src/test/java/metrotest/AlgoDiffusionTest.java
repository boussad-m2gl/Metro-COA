package metrotest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import util.Capteur;
import util.CapteurImpl;
import algorithmes.DiffusionAtomiqAlgo;
import algorithmes.DiffusionEpoqAlgo;
import algorithmes.DiffusionSeqAlgo;

/**
 * 
 * Test du capteur
 */
@RunWith(MockitoJUnitRunner.class)
public class AlgoDiffusionTest {

	private Capteur _c;
	private Capteur _capteurMock;

	private DiffusionAtomiqAlgo _diffusionAtomique;
	private DiffusionAtomiqAlgo _diffusionAtomiqueMock;

	private DiffusionSeqAlgo _diffusionSeq;
	private DiffusionSeqAlgo _diffusionSeqMock;

	private DiffusionEpoqAlgo _diffusionEpoq;
	private DiffusionEpoqAlgo _diffusionEpoqMock;

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Test de la méthode Tick
	 */
	@Test
	public void testAlgoAtomique() {

		_c = new CapteurImpl();
		_capteurMock = mock(CapteurImpl.class);

		_diffusionAtomique = new DiffusionAtomiqAlgo();
		_diffusionAtomiqueMock = mock(DiffusionAtomiqAlgo.class);

		// 1: -- Diffusion atomique : Intération entre capteur et l'algo de
		// diffusion

		_c.setAlgoDiffusion(_diffusionAtomiqueMock);
		verify(_diffusionAtomiqueMock).configure(_c, 0);

		_diffusionAtomique.setCapteur(_capteurMock);
		_diffusionAtomique.executeTick();
		verify(_capteurMock).algo2CapteurGetValue();
		verify(_capteurMock).notifyObservers();

	}

	/**
	 * Test de la méthode Tick
	 */
	@Test
	public void testAlgoSeq() {
		
		_c = new CapteurImpl();
		_capteurMock = mock(CapteurImpl.class);

		_diffusionSeq = new DiffusionSeqAlgo();
		_diffusionSeqMock = mock(DiffusionSeqAlgo.class);

		// 2: -- Diffusion Sequentielle : Intération entre capteur et l'algo de
		// diffusion
		_c.setAlgoDiffusion(_diffusionSeqMock);
		verify(_diffusionSeqMock).configure(_c, 0);
		_diffusionSeq.setCapteur(_capteurMock);
		_diffusionSeq.executeTick();
		verify(_capteurMock).algo2CapteurGetValue();
		verify(_capteurMock).notifyObservers();

	}

	/**
	 * Test de la méthode Tick
	 */
	@Test
	public void testAlgoEpoq() {
		
		_c = new CapteurImpl();
		_capteurMock = mock(CapteurImpl.class);

		_diffusionEpoq = new DiffusionEpoqAlgo();
		_diffusionEpoqMock = mock(DiffusionEpoqAlgo.class);

		// 3: -- Diffusion Epoque : Intération entre capteur et l'algo de
		// diffusion
		_c.setAlgoDiffusion(_diffusionEpoqMock);
		verify(_diffusionEpoqMock).configure(_c, 0);
		_diffusionEpoq.setCapteur(_capteurMock);
		_diffusionEpoq.executeTick();
		verify(_capteurMock).algo2CapteurGetValue();
		verify(_capteurMock).get_versionEpoq();

	}

	@After
	public void tearDown() throws Exception {
		_c = null;
		_capteurMock = null;
		_diffusionAtomique = null;
		_diffusionAtomiqueMock = null;
		_diffusionSeq = null;
		_diffusionSeqMock = null;
		_diffusionEpoq = null;
		_diffusionEpoqMock = null;

	}

}
