package callable;

import java.util.concurrent.Callable;

import mainPack.Afficheur;
import mainPack.Canal;

public class UpdateAfficheurCallable implements Callable{

	private Canal subject;
	private Afficheur observer;
	
	public UpdateAfficheurCallable(Canal can, Afficheur aff){
		
		subject=can;
		observer=aff;
	}
	
	public Object call() throws Exception {
		
		// -- wait(for a certain periode)
		//wait(5);
		observer.update(subject);
		return null;
	}

}
