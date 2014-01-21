package mainPack;

import javax.swing.JTextArea;

import observer.OberserverDeCapteur;
import observer.ObserveurDeCanal;

public class Afficheur implements ObserveurDeCanal {

	private JTextArea afficheur; 
	private int myEposqVersion=-1;
	
	public Afficheur(JTextArea c){
		afficheur=c;
		myEposqVersion=-1;
	}
	
	public void  setComponent(JTextArea c){
		afficheur=c;
	}
		
	public JTextArea  getComponent(){
		  return afficheur;
	}

	public void update(Canal subject) {
		int val = ((CanalImpl)subject).getValue();
		afficheur.setText(String.valueOf(val)); 
		// code seccur  
		myEposqVersion=-1;
	}

	// Epoq startegy method
	public void update(EpoqMessage msgepoq){
		
		if(myEposqVersion < msgepoq.get_versionNumber()){
			afficheur.setText(String.valueOf(msgepoq.get_value()));
			myEposqVersion=msgepoq.get_versionNumber();
		}  // receiving an old version : simply ignore it 
	}

}