package util;


import java.util.Timer;
import java.util.TimerTask;

import command.command;

/**
 * Horloge : qui est le composant qui genere des signaux 
 * On programme des taches qui seront exécutés 
 * 
 * */
public class Horloge  {

	private command clickC;
	private Timer timer; // timer pour la commande marquer temps
    private long periodActiveCmd=200; // ms
	// private Timer timer2 = new Timer(); // timer pour commander led1 et led2

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
	 * */
	public void activerPeriodiquement(command cmdClick, float periodEnMSecondes) {

		clickC = cmdClick;
		periodActiveCmd = (long) periodEnMSecondes;

	}

	/**
	 * Permet d'activer une commande aprés un delais
	 * */
	/*public void activerApresDelais(Command cmd, float delaisEnSecond) {

		final Command cmtToExecute = cmd;

		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				cmtToExecute.executer();
			}
		}, (long) delaisEnSecond);

	}*/

	/**
	 * Mise a jour de l'etat interne de l'horloge vis a vis de son controleur
	 * 
	 * */
	public void update() {
		stopChrono();
		//periodActiveCmd = (long) ((new Double(1000)) / (new Double(
		//		controleur.getTempo()) / 60));
		startChrono();
	}

}
