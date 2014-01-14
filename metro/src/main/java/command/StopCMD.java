package command;

import mainPack.Capteur;

public class StopCMD  implements command {

	Capteur _cpt; 
	
	public StopCMD(Capteur cpt){
		 _cpt=cpt;
	} 
	public void executer() {
		_cpt.stop();
	}

}
