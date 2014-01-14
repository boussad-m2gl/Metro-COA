package mainPack;

import algorithmes.AlgoDiffusion;
import observer.Subject;


public interface Capteur extends Subject {
	
	public int getValue();
	public void setValue(int v);
	public void tick();
	public void start();
	public void stop();
	public void notifyObservers();
	public AlgoDiffusion getAlgoDiffusion(); 
	public void setAlgoDiffusion(AlgoDiffusion algoDiffusion); 
	public int algo2CapteurGetValue();
}
