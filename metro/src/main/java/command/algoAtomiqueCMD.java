package command;

import algorithmes.DiffusionAtomiqAlgo;
import mainPack.Capteur;


public class algoAtomiqueCMD implements command {

	private Capteur _c;
	
	public algoAtomiqueCMD (Capteur c){
		 _c=c;
	 }
	public void executer() {
		 System.out.println("aloAtomiqueCMD:  set diffusion atomique ");
		_c.setAlgoDiffusion(new DiffusionAtomiqAlgo());
	}
	
}
