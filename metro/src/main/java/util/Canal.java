package util;

import observer.OberserverDeCapteur;
import observer.ObserveurDeCanal;
import observer.Subject;

/**
 * 
 * Canal
 * 
 */
public interface Canal extends Subject, OberserverDeCapteur {

	/**
	 * recuperer un capteur
	 * 
	 * @return un capteur
	 */
	public Capteur getCapteur();

	/**
	 * configurer un capteur
	 * 
	 * @param capteur
	 *            un capteur
	 */
	public void setCapteur(Capteur capteur);

	/**
	 * recuperer un afficheur
	 * 
	 * @returnun afficheur
	 */
	public ObserveurDeCanal getAfficheur();

	public void update(Capteur subject);

	/**
	 * recupper un valeur venant de capteur
	 * 
	 * @return
	 */
	public int getValue();
	// public void update(EpoqMessage msg);

}
