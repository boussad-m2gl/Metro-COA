package algorithmes;

import util.Capteur;

/**
 * 
 * interface du algo diffusion
 * 
 */
public interface AlgoDiffusion {

	/**
	 * configurer l'algo diffusion
	 * 
	 * @param c un capteur
	 * @param nbObs nombre d'observeur
	 */
	public void configure(Capteur c, int nbObs);

	/**
	 * 
	 * tick une fois
	 * 
	 */
	public void executeTick();

   /**
    * 
    * recuperer la valeur d'execution
    * 
    * @return la valeur d'execution
    */
	public int executeGetValue();
}
