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
	public void attach(Observer<Subject> o);

	/**
	 * detacher un observer
	 * 
	 * @param o
	 *            observer
	 */
	public void detach(Observer<Subject> o);
}
