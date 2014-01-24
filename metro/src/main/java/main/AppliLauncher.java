package main;

import ihm.IHM;
import util.Capteur;
import util.CapteurImpl;

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
	}

}
