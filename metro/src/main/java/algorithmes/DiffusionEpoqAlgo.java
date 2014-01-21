package algorithmes;

import mainPack.Capteur;
import mainPack.EpoqMessage;

//TODO
public class DiffusionEpoqAlgo implements AlgoDiffusion {

   private Capteur _capteur;
   
   public void configure(Capteur c, int nbObs) {
	    _capteur=c;
   }
	
   public void executeTick() {	
	  int val=_capteur.algo2CapteurGetValue();
	  int ver_epo= _capteur.get_versionEpoq();
	  EpoqMessage epmsg= new EpoqMessage();
	  epmsg.set_value(val); epmsg.set_versionNumber(ver_epo);
	  _capteur.notifyObservers(epmsg);
   }
	
	public int executeGetValue() {
				return 0;
	}
}
