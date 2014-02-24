package algorithmes;

import util.Capteur;
import util.EpoqMessage;


/**
 * 
 * ALGO Diffusion Epoque 
 *
 */
public class DiffusionEpoqAlgo implements AlgoDiffusion {

	private Capteur _capteur;
    
	/**
	 * @param c :  capteur 
	 * @param nbObs :  Observers number
	 * 
	 */
	public void configure(Capteur c, int nbObs) {
		_capteur = c;
	}
    
	/**
	 * Execute Tick Action 
	 */
	public void executeTick() {

		int val = _capteur.algo2CapteurGetValue();
		int ver_epo = _capteur.get_versionEpoq();
		EpoqMessage epmsg = new EpoqMessage();
		epmsg.set_value(val);
		epmsg.set_versionNumber(ver_epo);
		_capteur.setValue(val + 1);
		_capteur.set_versionEpoq(ver_epo + 1);
		_capteur.notifyObservers(epmsg);
	}
   
	/**
	 * @return  : The current value of the Objet it manages 
	 * 
	 */
	public int executeGetValue() {
		return _capteur.algo2CapteurGetValue();
	}
	
	/**
	 * Injection  d'un capteur : seulement pour les testes 
	 *  
	 * @param c
	 */
	public void setCapteur(Capteur c){
		this._capteur=c;
	}
}
