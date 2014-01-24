package main;

import util.Capteur;
import util.CapteurImpl;
import util.IHM;

/***
 * 
 * Enter point of program
 * 
 * @author Boussad , PU
 *
 */
public class AppliLauncher {

	/**
	 * 
	 * enter point
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {

		Capteur capt = new CapteurImpl();
		IHM ihm = new IHM();
		ihm.setCapteur(capt);
		// l'ihm va faire set strategy sur le capteur
	}

}
