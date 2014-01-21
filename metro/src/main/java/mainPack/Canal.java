package mainPack;

import observer.OberserverDeCapteur;
import observer.Observer;
import observer.ObserveurDeCanal;
import observer.Subject;

public interface Canal  extends Subject,OberserverDeCapteur {
	
	public Capteur getCapteur(); 
	public void setCapteur(Capteur capteur);
	public ObserveurDeCanal getAfficheur();
	public void update(Capteur subject);
    public int getValue();
   // public void update(EpoqMessage msg);

}
