package command;

import util.Capteur;

public class ClickCMD implements command {

	private Capteur _capteur;
	
	public ClickCMD(Capteur capteur){
	     _capteur = capteur;
	}
	public void executer() {
		_capteur.tick();
	}

}
