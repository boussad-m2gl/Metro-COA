package mainPack;

import javax.swing.JTextArea;

import observer.OberserverDeCapteur;
import observer.ObserveurDeCanal;

public class Afficheur implements ObserveurDeCanal {

	private JTextArea afficheur; 
	
	public Afficheur(JTextArea c){
		afficheur=c;
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
	}

	

}