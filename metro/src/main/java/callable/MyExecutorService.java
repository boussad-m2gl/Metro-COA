package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyExecutorService {
	
	private static final int NTHREDS = 5;
	private static ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
	
	public  static Future submit(Callable worker){
		return executor.submit(worker);
	}
}
