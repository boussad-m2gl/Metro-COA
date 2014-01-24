package command;

import util.Capteur;

/**
 * 
 * Command de Start
 * 
 * demarrer le fonctionement du capteur
 * 
 */
public class StartCMD implements command {

	private Capteur _cpt;

	/**
	 * construteur
	 * 
	 * @param cpt
	 *            capteur
	 */
	public StartCMD(Capteur cpt) {
		_cpt = cpt;
	}

	public void executer() {
		_cpt.start();
	}

}
