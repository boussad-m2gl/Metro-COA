package command;

import util.Capteur;
import algorithmes.DiffusionEpoqAlgo;


public class algoEpoqueCMD implements command {

    private Capteur _c;
	
   public algoEpoqueCMD(Capteur capt){
	    _c=capt;
   }	

	public void executer() {
		_c.setAlgoDiffusion(new DiffusionEpoqAlgo());
	}

}
