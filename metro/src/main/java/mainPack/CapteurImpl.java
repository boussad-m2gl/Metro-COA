package mainPack;

import java.util.ArrayList;

import observer.OberserverDeCapteur;
import observer.Observer;
import observer.Subject;
import algorithmes.AlgoDiffusion;

import command.ClickCMD;

public class CapteurImpl implements Capteur {

	private AlgoDiffusion algoDiffusion;
	private ArrayList<OberserverDeCapteur> liObs;
	private Horloge horloge;
	private int capteurvalue = 0; // la valeur du capteur

	private int _versionEpoq=0;
	
	public int get_versionEpoq() {
		return _versionEpoq;
	}

	public void set_versionEpoq(int _versionEpoq) {
		this._versionEpoq = _versionEpoq;
	}

	CapteurImpl() {

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
		capteurvalue = 0;  // reset of capteur value 
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

	public void notifyObservers(EpoqMessage msg){
		
		for (OberserverDeCapteur c : liObs) {
			c.update(msg);
		}
	}
	public void setValue(int v) {
		capteurvalue = v;
	}

	public void attach(Afficheur o) {
		System.out.println("capteurImp attach o");
		CanalImpl can = new CanalImpl(this);
		can.setAfficheur(o);
		liObs.add(can); // creation d'un canal pour chaque afficheur

	}

	public void detach(Observer<Subject> o) {
		// liObs.remove(o);
		// parcours la liste de canneaux et enlever la canal qui contient
		// l'afficheur o
	}

	public void attach(Observer<Subject> o) {
		// TODO Auto-generated method stub
		System.out.println("capteurImp attach o");
	}

	public void start() {
		horloge.startChrono();
	}

	public void stop() {
		horloge.stopChrono();
	}

}
