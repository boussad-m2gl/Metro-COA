package command;

import util.Capteur;
import algorithmes.DiffusionSeqAlgo;

/**
 * 
 * L'algo de diffusion sequentielle
 * 
 */
public class algoSequentielCMD implements command {

	private Capteur _c;

	/**
	 * constructeur
	 * 
	 * @param c
	 *            capteur
	 */
	public algoSequentielCMD(Capteur c) {
		_c = c;
	}

	public void executer() {
		System.out.println("aloSeqCMD:  set diffusion sequentielle ");
		_c.setAlgoDiffusion(new DiffusionSeqAlgo());
	}

}
