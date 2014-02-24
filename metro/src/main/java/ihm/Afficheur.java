package ihm;

import javax.swing.JTextArea;

import observer.ObserveurDeCanal;
import util.Canal;
import util.CanalImpl;
import util.EpoqMessage;

/**
 * 
 * Afficheur : 
 * 
 *   Joue la role de l'Observateur du Canale 
 * 
 */
public class Afficheur implements ObserveurDeCanal {

	private JTextArea afficheur;
	private int myEposqVersion = -1;

	/**
	 * construteur
	 * 
	 * @param c
	 *            JTextArea
	 */
	public Afficheur(JTextArea c) {
		afficheur = c;
		myEposqVersion = -1;
	}

	/**
	 * configurer un JTextArea
	 * 
	 * @param c
	 *            JTextArea
	 */
	public void setComponent(JTextArea c) {
		afficheur = c;
	}

	/**
	 * recuperer afficheur(JTextArea)
	 * 
	 * @return afficheur(JTextArea)
	 */
	public JTextArea getComponent() {
		return afficheur;
	}

	/**
	 * @param subject : Mise a jour de l'afficheur
	 *                 via le sujet
	 */
	public void update(Canal subject) {
		int val = ((CanalImpl) subject).getValue();
		afficheur.setText(String.valueOf(val));
		// Faire face au changement de strategie
		myEposqVersion = -1;
	}

	/**
	 *  @param msgepoq : Mettre a jour l'afficheur  par 
	 *                  un message (strategie de gestion par époque)
	 */
	public void update(EpoqMessage msgepoq) {

		if (myEposqVersion < msgepoq.get_versionNumber()) {

			afficheur.setText(String.valueOf(msgepoq.get_value()));
			myEposqVersion = msgepoq.get_versionNumber();
		
		}else{
			  // receiving an old version : simply ignore it
		} 
	}

}