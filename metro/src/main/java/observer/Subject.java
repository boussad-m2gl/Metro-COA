package observer;

public interface Subject {
	
	public void attach(Observer<Subject> o);

	public void detach(Observer<Subject> o);
}
