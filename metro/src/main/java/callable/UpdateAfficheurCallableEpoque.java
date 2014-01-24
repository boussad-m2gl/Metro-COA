package callable;

import ihm.Afficheur;

import java.util.concurrent.Callable;

import util.EpoqMessage;

/**
 * 
 * Callable pour mise a jour afficheur par l'algo epoque
 * 
 */
public class UpdateAfficheurCallableEpoque implements Callable {

	private EpoqMessage _mssg;
	private Afficheur _observer;

	/**
	 * 
	 * @param mssg
	 * @param aff
	 */
	public UpdateAfficheurCallableEpoque(EpoqMessage mssg, Afficheur aff) {

		_mssg = mssg;
		_observer = aff;
	}

	public Object call() throws Exception {
		_observer.update(_mssg);
		return null;
	}

}
