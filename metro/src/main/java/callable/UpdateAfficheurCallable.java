package callable;

import java.util.concurrent.Callable;

import util.Afficheur;
import util.Canal;

/**
 * 
 * Callable pour mis a jour afficheur
 * 
 */
public class UpdateAfficheurCallable implements Callable {

	private Canal subject;
	private Afficheur observer;

	/**
	 * contructeur
	 * 
	 * @param can
	 *            canal
	 * @param aff
	 *            afficheur
	 */
	public UpdateAfficheurCallable(Canal can, Afficheur aff) {

		subject = can;
		observer = aff;
	}

	public Object call() throws Exception {
		observer.update(subject);
		return null;
	}

}
