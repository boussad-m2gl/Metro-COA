package observer;

/**
 * 
 * Subject
 * 
 */
public interface Subject {

	/**
	 * attach un observer
	 * 
	 * @param o
	 *            observer
	 */
	public void attach(Object o);

	/**
	 * detacher un observer
	 * 
	 * @param o
	 *            observer
	 */
	public void detach(Object o);
}
