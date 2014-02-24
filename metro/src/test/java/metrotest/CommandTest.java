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

import command.ClickCMD;
import command.StartCMD;
import command.StopCMD;

/**
 * Test des commandes
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class CommandTest {

	private ClickCMD _clickCmd;
	private StartCMD _startCmd;
	private StopCMD _stopCmd;
	private Capteur _capteurMock;

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Test des commandes tick , start et stop
	 */
	@Test
	public void commandesTest() {

		_capteurMock = mock(CapteurImpl.class);

		// Click Command
		_clickCmd = new ClickCMD(_capteurMock);
		_clickCmd.executer();
		verify(_capteurMock).tick();

		// Start Command
		_startCmd = new StartCMD(_capteurMock);
		_startCmd.executer();
		verify(_capteurMock).start();

		// Stop Command

		_stopCmd = new StopCMD(_capteurMock);
		_stopCmd.executer();
		verify(_capteurMock).stop();

	}

	@After
	public void tearDown() throws Exception {
		_clickCmd = null;
		_startCmd = null;
		_stopCmd = null;
	}

}
