package algorithmes;

import java.util.ArrayList;

import util.Capteur;

/**
 *  Algo  Diffusion Sequentielle 
 *  
 */
public class DiffusionSeqAlgo implements AlgoDiffusion {

	private int _nbObservers = 0;
	private int _nbUpdatesReq = 0;
	private Capteur _capteur;
	private ArrayList<Integer> listValues; // Garde les differentes valeur du capteur
	private int curr_index_value; // Geré les valeur a envoyer aux observateurs

	public DiffusionSeqAlgo(){
		
		listValues = new ArrayList<Integer> ();
	}
	
	/**
	 * @param c : Capteur 
	 * @param nbObs:  Observers number 
	 */
	public void configure(Capteur c, int nbObs) {
		listValues = new ArrayList<Integer>();
		curr_index_value = -1;//
		_capteur = c;
		_nbObservers = nbObs;
	}
	
    /**
     * Tick Action 
     */
	public void executeTick() {
        int capt_value = _capteur.algo2CapteurGetValue();
		listValues.add(capt_value);
		_capteur.setValue(capt_value + 1);

		if ((curr_index_value == -1) // first émmision
				|| (_nbUpdatesReq >= _nbObservers) // received all get values
													// from observers
		) {
			curr_index_value++;
			_nbUpdatesReq = 0;
			_capteur.notifyObservers();

		}
	}
  
	/**
	 * @return : The current value of the Object 
	 *           this strategy manages 
	 */
	public int executeGetValue() {
		assert (curr_index_value < listValues.size() && curr_index_value > -1);
		_nbUpdatesReq++;
		System.out.println(" Get value : req num : " + _nbUpdatesReq
				+ " --- nb obs: " + _nbObservers);
		return listValues.get(curr_index_value);
	}

	/**
	 *  Méthode pour le teste 
	 *  Injection d'un capteur pour L'Algo de diffusion
	 * @param c
	 */
	public void setCapteur(Capteur c){
		this._capteur = c;
	}
}
