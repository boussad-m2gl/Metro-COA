package util;

import ihm.Afficheur;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import observer.ObserveurDeCanal;
import callable.GetValueCallable;
import callable.MyExecutorServiceProxy;
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
	// Delay du capteur
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
	
    /**
     * Mettre a jour le canale via la capteur
     * @param  Capteur 
     */
	public void update(Capteur subject) {

		UpdateAfficheurCallable cUpdateAff = new UpdateAfficheurCallable(this,
				(Afficheur) _afficheur);
		MyExecutorServiceProxy.submit(cUpdateAff, innerDlay * 100); // innerDlay
																	// *
		// 100
	}
    
	/**
	 * GetValue Asynchron
	 */
	public int getValue() {

		GetValueCallable cGetVal = new GetValueCallable(_capteur);
		@SuppressWarnings("unchecked")
		Future<Integer> f = MyExecutorServiceProxy.submit(cGetVal,
				innerDlay * 100); // innerDlay * 100
		
		try {
			 return f.get();
		} catch (InterruptedException e) {
		     e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
    /**
     * @param : O L'objet a attacher
     */
	public void attach(Object o) {
		_afficheur = (ObserveurDeCanal) o;
	}

	/**
	 * @param  : O l'objet a détacher 
	 */
	public void detach(Object o) {

		if (o instanceof ObserveurDeCanal) {
			_afficheur = null;
		}
	}

	/**
	 * Methode utilisée pour mettre a jour l'afficheur dans la strategie de
	 * diffusion par époque
	 */
	public void update(EpoqMessage msg) {

		UpdateAfficheurCallableEpoque callableEpoquSart = new UpdateAfficheurCallableEpoque(
				msg, (Afficheur) _afficheur);
		@SuppressWarnings("unchecked")
		Future<Integer> f = MyExecutorServiceProxy.submit(callableEpoquSart,
				innerDlay * 100);
	}

}
