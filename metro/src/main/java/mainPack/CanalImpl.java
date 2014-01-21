package mainPack;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import observer.Observer;
import observer.ObserveurDeCanal;
import observer.Subject;
import callable.GetValueCallable;
import callable.MyExecutorService;
import callable.UpdateAfficheurCallable;

public class CanalImpl implements Canal {

	private Capteur _capteur;
	private ObserveurDeCanal _afficheur;

	private int Min = 1;
	private int Max = 10;
	private int innerDlay = Min + (int) (Math.random() * ((Max - Min) + 1));

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

	// TODO pas besoin de capteur car il est comme variable interne
	public void update(Capteur subject) {

	/*	System.out.println("update canal Impl called : create a callable."
				+ innerDlay);*/
		UpdateAfficheurCallable cUpdateAff = new UpdateAfficheurCallable(this,
				(Afficheur) _afficheur);
		MyExecutorService.submit(cUpdateAff, innerDlay * 100); //innerDlay * 100
		 
	//	   System.out.println("   Canal notify Afficheur ... ");
	//	 _afficheur.update((Canal)this);
	}

	public int getValue() {

		
		GetValueCallable cGetVal = new GetValueCallable(_capteur);
		Future<Integer> f = MyExecutorService.submit(cGetVal, innerDlay * 100); //  innerDlay * 100
		try {
			return f.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return 0;
		//System.out.println("   Canal makes get value  ... ");
		//return _capteur.getValue();
	}

	public void attach(Observer<Subject> o) {
		// TODO Auto-generated method stub
	}

	public void detach(Observer<Subject> o) {
		// TODO Auto-generated method stub
	}

	//  Normaly this will be used in the epoq diffusion strategy
	public void update(EpoqMessage msg) {
		//  call update to affiheur 
		
		//TODO : Create a callable epocallable.. and schedulerExecutorservice , but first test with that
		// synchronized version
		_afficheur.update(msg);
	}

}
