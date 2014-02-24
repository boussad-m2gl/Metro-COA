package util;

import java.util.Timer;
import java.util.TimerTask;

import command.command;

/**
 * Horloge :  - Le composant qui genère des signaux 
 *            - On programme des taches qui seront exécutées aprés un delay
 * 
 * */
public class Horloge {

	private command clickC;
	private Timer timer; // timer pour la commande marquer temps
	private long periodActiveCmd = 200; // ms


	/**
	 * contructeur
	 */
	public Horloge() {

		timer = new Timer();
	}

	/**
	 * Commence le chronometrage pour executer une tache / command internce
	 * clickC
	 * */
	public void startChrono() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				clickC.executer();
			}
		}, 0, periodActiveCmd);
	}

	/**
	 * Arrete l'executation de la tache en cours
	 * */
	public void stopChrono() {
		timer.cancel();
	}

	/**
	 * Permet d'activer periodiquement une command apres delais en MiliSecond
	 * 
	 * @param cmdClick
	 *            commande de click
	 * @param periodEnMSecondes
	 *            period en mscondes
	 */
	public void activerPeriodiquement(command cmdClick, float periodEnMSecondes) {

		clickC = cmdClick;
		periodActiveCmd = (long) periodEnMSecondes;

	}

	/**
	 * Mise a jour de l'etat interne de l'horloge vis a vis de son controleur
	 * 
	 * */
	public void update() {
		stopChrono();
		// periodActiveCmd = (long) ((new Double(1000)) / (new Double(
		// controleur.getTempo()) / 60));
		startChrono();
	}

}
