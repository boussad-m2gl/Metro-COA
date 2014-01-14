package mainPack;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import callable.GetValueCallable;
import callable.MyExecutorService;
import callable.UpdateAfficheurCallable;
import observer.Observer;
import observer.ObserveurDeCanal;
import observer.Subject;

public class CanalImpl implements Canal{

	private Capteur _capteur;
	private ObserveurDeCanal _afficheur;

	public CanalImpl(Capteur capteur){
		_capteur=capteur;
	}
	
	public Capteur getCapteur() {
		return _capteur;
	}

	public void setCapteur(Capteur capteur) {
		this._capteur = capteur;
	}

	public  ObserveurDeCanal getAfficheur() {
		return _afficheur;
	}

	public void setAfficheur( ObserveurDeCanal afficheur) {
		this._afficheur = afficheur;
	}
   
    //TODO pas besoin de capteur car il est comme variable interne
	public void update(Capteur subject) {
	
	   	 System.out.println("update canal Impl called : create a callable.");
	   	 UpdateAfficheurCallable  cUpdateAff=new UpdateAfficheurCallable(this,(Afficheur)_afficheur);
	   	 MyExecutorService.submit(cUpdateAff);
	   	 //_afficheur.update((Canal)this);
	}


	public int getValue() {
	
		System.out.println("canaImpl : get value called , create a callable");
		GetValueCallable  cGetVal= new GetValueCallable(_capteur);
	   	Future<Integer> f= MyExecutorService.submit(cGetVal);
	try {
			return  f.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	    return 0;
	}

	public void attach(Observer<Subject> o) {
		// TODO Auto-generated method stub	
	}

	public void detach(Observer<Subject> o) {
		// TODO Auto-generated method stub
	}
	

}
