package command;

import algorithmes.DiffusionEpoqAlgo;
import mainPack.Capteur;


public class algoEpoqueCMD implements command {

    private Capteur _c;
	
   public algoEpoqueCMD(Capteur capt){
	    _c=capt;
   }	

	public void executer() {
		_c.setAlgoDiffusion(new DiffusionEpoqAlgo());
	}

}
