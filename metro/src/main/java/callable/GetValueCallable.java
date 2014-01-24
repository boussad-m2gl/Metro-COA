package callable;

import java.util.concurrent.Callable;

import util.Capteur;

/**
 * 
 * Callable pour executer getValue
 * 
 */
public class GetValueCallable implements Callable<Integer> {

	private Capteur _subject;

	/**
	 * Constructeur
	 * 
	 * @param cap
	 *            un capteur
	 */
	public GetValueCallable(Capteur cap) {
		_subject = cap;
	}

	/**
	 * executer pour getValue
	 * 
	 * @return un valeur venant de suject
	 */
	public Integer call() throws Exception {

		return _subject.getValue();
	}

}
