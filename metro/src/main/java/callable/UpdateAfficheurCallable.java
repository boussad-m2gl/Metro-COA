package callable;

import ihm.Afficheur;

import java.util.concurrent.Callable;

import util.Canal;

/**
 * 
 * Callable pour mise a jour de l'afficheur
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
		return null;  //  Operation de update pas besoin d'une
		              //  d'une valeur de retour 
	}

}
