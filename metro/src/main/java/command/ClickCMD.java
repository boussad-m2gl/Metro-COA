package command;

import util.Capteur;

/**
 * 
 * Command de Click
 * 
 */
public class ClickCMD implements command {

	private Capteur _capteur;

	/**
	 * 
	 * constructeur
	 * 
	 * @param capteur
	 *            capteur
	 */
	public ClickCMD(Capteur capteur) {
		_capteur = capteur;
	}

	public void executer() {
		_capteur.tick();
	}

}
