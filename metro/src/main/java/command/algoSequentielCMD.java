package command;

import mainPack.Capteur;
import algorithmes.DiffusionSeqAlgo;

public class algoSequentielCMD implements command {

	private Capteur _c;

	public algoSequentielCMD(Capteur c) {
		_c = c;
	}

	public void executer() {
		System.out.println("aloSeqCMD:  set diffusion sequentielle ");
		_c.setAlgoDiffusion(new DiffusionSeqAlgo());
	}

}
