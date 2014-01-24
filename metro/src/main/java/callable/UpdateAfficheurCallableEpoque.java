package callable;

import java.util.concurrent.Callable;

import util.Afficheur;
import util.Canal;
import util.EpoqMessage;


public class UpdateAfficheurCallableEpoque implements Callable{

	private EpoqMessage _mssg;
	private Afficheur _observer;
	
	public UpdateAfficheurCallableEpoque(EpoqMessage mssg, Afficheur aff){
		
		_mssg=mssg;
		_observer=aff;
	}
	
	public Object call() throws Exception {
		_observer.update(_mssg);
		return null;
	}

}
