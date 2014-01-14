package callable;

import java.util.concurrent.Callable;


import mainPack.Capteur;

public class GetValueCallable  implements Callable<Integer>{

	private Capteur _subject;
	
	
	public GetValueCallable (Capteur cap){
		_subject=cap;
	}
	public Integer call() throws Exception {
		
		return _subject.getValue();
	}

}
