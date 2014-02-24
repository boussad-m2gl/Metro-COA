package algorithmes;

import util.Capteur;

/**
 * 
 * Algorithme de diffusion atomique
 *
 */
public class DiffusionAtomiqAlgo implements AlgoDiffusion {

	private int _nbObservers = 0;
	private int _nbUpdatesReq = 0;
	private boolean _updatePossible = true;
	private Capteur _capteur;

	/**
	 *   Configration de l'algorithme de diffusion atomique
	 *   
	 * @param c : capteur
	 * @param nObs : nombre d'observateur
	 */
	public void configure(Capteur c, int nbObs) {

		_nbObservers = nbObs;
		_nbUpdatesReq = 0;
		_capteur = c;
		_updatePossible = true;
	}
   /**
    * Executer un tick 
    */
	public void executeTick() {
		
		if (_updatePossible == true) {
			
			_updatePossible = false;
			_capteur.setValue(_capteur.algo2CapteurGetValue() + 1);
			_capteur.notifyObservers(); // update vers les canneaux
		
		} else {
			// Simply ignore this tick
			System.out.println("******* click ignored ***** ");
		}
	}
	
    /**
     *  Executer GetVelue
     *  @return  : La valuer de l'objet geré par ce capteur 
     */
	public int executeGetValue() {
		_nbUpdatesReq++;
		
		if (_nbUpdatesReq == _nbObservers) {
			_updatePossible = true;
			_nbUpdatesReq = 0;
		}
		
		return _capteur.algo2CapteurGetValue();
	}
	
	/**
	 *  Method only for test 
	 *  Set le capteur
	 * @param c : capteur
	 */
	public void setCapteur(Capteur c){
		this._capteur =c;
	}
}
