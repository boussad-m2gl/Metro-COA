package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executor Service Proxy 
 * 
 */
public class MyExecutorServiceProxy {

	private static final int NTHREDS = 5; // fixer le nombre de threads dans le
											// système
	static ScheduledExecutorService scheduledExecutorService = Executors
			.newScheduledThreadPool(NTHREDS);

	/**
	 * ceer un scheduler pour callable
	 * 
	 * @param worker
	 *            callable object 
	 * @param time
	 *            delay time
	 * @return résultat d'execution par le schedule
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Future submit(Callable worker, long time) {

		return scheduledExecutorService.schedule(worker, time,
				TimeUnit.MILLISECONDS);

	}

}
