package util;

import observer.Subject;
import algorithmes.AlgoDiffusion;

/**
 * 
 * interface de capteur
 * 
 */
public interface Capteur extends Subject {
	/**
	 * recuperer sa valeur
	 * 
	 * @return un valeur venant de capteur
	 */
	public int getValue();

	/**
	 * mettre sa valeur
	 * 
	 * @param v
	 *            un valeur venant de capteur
	 */
	public void setValue(int v);

	/**
	 * tick
	 */
	public void tick();

	/**
	 * start le fonctionement
	 */
	public void start();

	/**
	 * stop le fonctionement
	 */
	public void stop();

	/**
	 * notifier observers
	 */
	public void notifyObservers();

	/**
	 * retrouner l'instance de l'algo diffusion
	 * 
	 * @return l'algo diffusion
	 */
	public AlgoDiffusion getAlgoDiffusion();

	/**
	 * mettre l'instance de l'algo diffusion
	 * 
	 * @param algoDiffusion
	 *            l'algo diffusion
	 */
	public void setAlgoDiffusion(AlgoDiffusion algoDiffusion);

	/**
	 * recuperer un valeur par l'algo epoque
	 * 
	 * @return un valeur par l'algo epoque
	 */
	public int algo2CapteurGetValue();

	/**
	 * retourner le numero de version
	 * 
	 * @return le numero de version
	 */
	public int get_versionEpoq();

	/**
	 * mettre le numero de version
	 * 
	 * @param _versionEpoq
	 *            le numero de version
	 */
	public void set_versionEpoq(int _versionEpoq);

	/**
	 * notifier tous les observers
	 * 
	 * @param msg
	 *            un message epoque
	 */
	public void notifyObservers(EpoqMessage msg);

}
