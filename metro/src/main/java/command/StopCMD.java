package command;

import util.Capteur;

/**
 * 
 * Command de Stop
 * 
 * Arreter le fonctionement du capteur
 * 
 */
public class StopCMD implements command {

	Capteur _cpt;

	/**
	 * construteur
	 * 
	 * @param cpt
	 *            capteur
	 */
	public StopCMD(Capteur cpt) {
		_cpt = cpt;
	}

	public void executer() {
		_cpt.stop();
	}

}
