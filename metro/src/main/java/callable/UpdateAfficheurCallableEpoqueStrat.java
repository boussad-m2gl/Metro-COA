package callable;

import java.util.concurrent.Callable;

import mainPack.Afficheur;
import mainPack.Canal;
import mainPack.EpoqMessage;

public class UpdateAfficheurCallableEpoqueStrat implements Callable{

	private EpoqMessage _mssg;
	private Afficheur _observer;
	
	public UpdateAfficheurCallableEpoqueStrat(EpoqMessage mssg, Afficheur aff){
		
		_mssg=mssg;
		_observer=aff;
	}
	
	public Object call() throws Exception {
		_observer.update(_mssg);
		return null;
	}

}
