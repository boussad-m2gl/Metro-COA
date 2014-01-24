package callable;

import java.util.concurrent.Callable;

import util.Afficheur;
import util.Canal;


public class UpdateAfficheurCallable implements Callable{

	private Canal subject;
	private Afficheur observer;
	
	public UpdateAfficheurCallable(Canal can, Afficheur aff){
		
		subject=can;
		observer=aff;
	}
	
	public Object call() throws Exception {
		observer.update(subject);
		return null;
	}

}
