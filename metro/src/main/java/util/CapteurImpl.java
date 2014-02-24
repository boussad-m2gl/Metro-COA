package util;

import ihm.Afficheur;

import java.util.ArrayList;
import observer.OberserverDeCapteur;
import algorithmes.AlgoDiffusion;
import command.ClickCMD;

/**
 * 
 * Le capteur
 * 
 */
public class CapteurImpl implements Capteur {

	private AlgoDiffusion algoDiffusion;
	private ArrayList<OberserverDeCapteur> liObs;
	private Horloge horloge;
	private int capteurvalue = 0; // la valeur du capteur
	private int _versionEpoq = 0;

	public int get_versionEpoq() {
		return _versionEpoq;
	}

	public void set_versionEpoq(int _versionEpoq) {
		this._versionEpoq = _versionEpoq;
	}

	/**
	 * contruteur
	 */
	public CapteurImpl() {

		liObs = new ArrayList<OberserverDeCapteur>();
		// configure de l'horloge
		ClickCMD cmdclick = new ClickCMD(this);
		horloge = new Horloge();
		horloge.activerPeriodiquement(cmdclick, 500);
	}

	public AlgoDiffusion getAlgoDiffusion() {
		return algoDiffusion;
	}

	public void setAlgoDiffusion(AlgoDiffusion algoDiffusion) {
		capteurvalue = 0; // reset of capteur value
		this.algoDiffusion = algoDiffusion;
		this.algoDiffusion.configure(this, liObs.size());

	}

	public int getValue() {
		return algoDiffusion.executeGetValue();
	}

	public int algo2CapteurGetValue() {
		return capteurvalue;
	}

	public void tick() {
		algoDiffusion.executeTick();
	}

	public void notifyObservers() {

		for (OberserverDeCapteur c : liObs) {
			c.update(this);
		}
	}

	public void notifyObservers(EpoqMessage msg) {

		for (OberserverDeCapteur c : liObs) {
			c.update(msg);
		}
	}

	public void setValue(int v) {
		capteurvalue = v;
	}

	public void attach(Object o) {
		System.out.println("capteurImp attach o");
		CanalImpl can = new CanalImpl(this);
		can.setAfficheur((Afficheur) o);
		liObs.add(can); // creation d'un canal pour chaque afficheur

	}
	
	public void detach(Object o) {
		 liObs.remove((OberserverDeCapteur)o);
		
	}
    
	/**
	 * démmarer le capteur
	 */
	public void start() {
		horloge.startChrono();
	}
    /**
     * arreter le capteur 
     */
	public void stop() {
		horloge.stopChrono();
	}
    
	/**
	 * Injecter  l'horloge  : seulement pour le teste
	 * 
	 * @param horloge: Horloge a injecter 
	 */
	public void   setHologe(Horloge horloge){
		this.horloge = horloge;
	}
	
}
