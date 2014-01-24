package observer;

import util.EpoqMessage;

public interface Observer<T> {
	
	public void update(T subject);
	public void update(EpoqMessage msgepoq);

}
