package command;

import util.Capteur;
import algorithmes.DiffusionEpoqAlgo;


/**
 * 
 * L'algo de diffusion epoque
 * 
 */
public class algoEpoqueCMD implements command {

    private Capteur _c;
	
	/**
	 * constructeur 
	 * @param capt capteur
	 */
   public algoEpoqueCMD(Capteur capt){
	    _c=capt;
   }	

	public void executer() {
		_c.setAlgoDiffusion(new DiffusionEpoqAlgo());
	}

}
