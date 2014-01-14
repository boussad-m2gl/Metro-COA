package algorithmes;

import mainPack.Capteur;

public class DiffusionAtomiqAlgo implements AlgoDiffusion {

	private int _nbObservers = 0;
	private int _nbUpdatesReq = 0;
	private boolean _updatePossible = true;
	private Capteur _capteur;

	public void configure(Capteur c, int nbObs) {

		_nbObservers = nbObs;
		_nbUpdatesReq = 0;
		_capteur = c;
		_updatePossible = true;
	}

	public void executeTick() {
		if (_updatePossible) {
			_updatePossible = false;
			_capteur.setValue(_capteur.getValue() + 1);
			_capteur.notifyObservers(); // update vers les canneaux
		} else {
			// Simply ignore this tick
			System.out.println("******* click ignored ***** ");
		}
	}

	public int executeGetValue() {
		_nbUpdatesReq++;
		if (_nbUpdatesReq == _nbObservers) {
			_updatePossible = true;
			_nbUpdatesReq = 0;
		}
		return _capteur.algo2CapteurGetValue();
	}
}
