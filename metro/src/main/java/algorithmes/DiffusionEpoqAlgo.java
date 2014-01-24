package algorithmes;

import util.Capteur;
import util.EpoqMessage;

//TODO
public class DiffusionEpoqAlgo implements AlgoDiffusion {

	private Capteur _capteur;

	public void configure(Capteur c, int nbObs) {
		_capteur = c;
	}

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

	public int executeGetValue() {
		return _capteur.algo2CapteurGetValue();
	}
}
