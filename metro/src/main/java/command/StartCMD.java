package command;

import mainPack.Capteur;

public class StartCMD implements command {

    private Capteur _cpt; 
	
	public StartCMD(Capteur cpt){
		 _cpt=cpt;
	} 
	public void executer() {
		_cpt.start();
	}

}
