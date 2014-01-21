package observer;

import mainPack.EpoqMessage;

public interface Observer<T> {
	
	public void update(T subject);
	public void update(EpoqMessage msgepoq);

}
