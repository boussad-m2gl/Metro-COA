package util;

import ihm.Afficheur;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import observer.ObserveurDeCanal;
import callable.GetValueCallable;
import callable.MyExecutorService;
import callable.UpdateAfficheurCallable;
import callable.UpdateAfficheurCallableEpoque;

/**
 * implement de capteur
 * 
 */
public class CanalImpl implements Canal {

	private Capteur _capteur;
	private ObserveurDeCanal _afficheur;
	private int Min = 1;
	private int Max = 10;
	private int innerDlay = Min + (int) (Math.random() * ((Max - Min) + 1));

	/**
	 * construteur
	 * 
	 * @param capteur
	 *            un capteur
	 */
	public CanalImpl(Capteur capteur) {
		_capteur = capteur;
	}

	public Capteur getCapteur() {
		return _capteur;
	}

	public void setCapteur(Capteur capteur) {
		this._capteur = capteur;
	}

	public ObserveurDeCanal getAfficheur() {
		return _afficheur;
	}

	public void setAfficheur(ObserveurDeCanal afficheur) {
		this._afficheur = afficheur;
	}

	public void update(Capteur subject) {

		UpdateAfficheurCallable cUpdateAff = new UpdateAfficheurCallable(this,
				(Afficheur) _afficheur);
		MyExecutorService.submit(cUpdateAff, innerDlay * 100); // innerDlay *
																// 100

		// System.out.println("   Canal notify Afficheur ... ");
		// _afficheur.update((Canal)this);
	}

	public int getValue() {

		GetValueCallable cGetVal = new GetValueCallable(_capteur);
		Future<Integer> f = MyExecutorService.submit(cGetVal, innerDlay * 100); // innerDlay
																				// *
																				// 100
		try {
			return f.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		return 0;
	}

	public void attach(Object o) {
		// this._afficheur = (Observer<Canal>) o;
		_afficheur = (ObserveurDeCanal) o;
	}

	public void detach(Object o) {

		if (o instanceof ObserveurDeCanal) {
			_afficheur = null;
		}

	}

	/**
	 * Method used to update Afficheur dans la strategie de diffusion par epoque
	 */
	public void update(EpoqMessage msg) {

		UpdateAfficheurCallableEpoque callableEpoquSart = new UpdateAfficheurCallableEpoque(
				msg, (Afficheur) _afficheur);
		Future<Integer> f = MyExecutorService.submit(callableEpoquSart,
				innerDlay * 100);
		// _afficheur.update(msg); in case of synchro
	}

}
