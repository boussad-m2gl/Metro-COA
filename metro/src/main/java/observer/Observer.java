package observer;

import util.EpoqMessage;

/**
 * 
 * Oberserver
 * 
 * @param <T>
 *            type de subject
 */
public interface Observer<T> {
	/**
	 * mis a jour subject
	 * 
	 * @param subject
	 *            subject
	 */
	public void update(T subject);

	/**
	 * mis a jour un message epoque
	 * 
	 * @param msgepoq
	 *            un message epoque
	 */
	public void update(EpoqMessage msgepoq);

}
