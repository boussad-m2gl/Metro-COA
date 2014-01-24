package algorithmes;

import java.util.ArrayList;

import util.Capteur;

public class DiffusionSeqAlgo implements AlgoDiffusion {

	private int _nbObservers = 0;
	private int _nbUpdatesReq = 0;
	private Capteur _capteur;
	private ArrayList<Integer> listValues; // store different value of Capteur
	private int curr_index_value; // Manage the value to sent

	public void configure(Capteur c, int nbObs) {
		listValues = new ArrayList<Integer>();
		curr_index_value = -1;//
		_capteur = c;
		_nbObservers = nbObs;
	}

	public void executeTick() {

		listValues.add(_capteur.algo2CapteurGetValue());
		_capteur.setValue(_capteur.algo2CapteurGetValue() + 1);

		if ((curr_index_value == -1) // first émmision
				|| (_nbUpdatesReq == _nbObservers) // received all get values
													// from observers
		) {
			curr_index_value++;
			_nbUpdatesReq = 0;
			_capteur.notifyObservers();

		}
	}

	public int executeGetValue() {
		assert (curr_index_value < listValues.size() && curr_index_value > -1);
		_nbUpdatesReq++;
		System.out.println(" Get value : req num : " + _nbUpdatesReq
				+ " --- nb obs: " + _nbObservers);
		return listValues.get(curr_index_value);
	}

}
