package command;

import util.Capteur;
import algorithmes.DiffusionAtomiqAlgo;

/**
 * 
 * Commande
 *     L'algo de diffusion atomique
 * 
 */
public class algoAtomiqueCMD implements command {

	private Capteur _c;

	/**
	 * constructeur 
	 * @param c capteur
	 */
	public algoAtomiqueCMD(Capteur c) {
		_c = c;
	}

	/**
	 * exectuer l'algo
	 */
	public void executer() {
		System.out.println("aloAtomiqueCMD:  set diffusion atomique ");
		_c.setAlgoDiffusion(new DiffusionAtomiqAlgo());
	}

}
