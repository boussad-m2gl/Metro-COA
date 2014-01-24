package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executor Service
 * 
 */
public class MyExecutorService {

	private static final int NTHREDS = 5;
	private static ExecutorService executor = Executors
			.newFixedThreadPool(NTHREDS);
	static ScheduledExecutorService scheduledExecutorService = Executors
			.newScheduledThreadPool(NTHREDS);

	/**
	 * ceer un scedule pour callable
	 * 
	 * @param worker
	 *            callable
	 * @param time
	 *            delay time
	 * @return resultat d'execution par schedule
	 */
	public static Future submit(Callable worker, long time) {

		return scheduledExecutorService.schedule(worker, time,
				TimeUnit.MILLISECONDS);

	}

}
