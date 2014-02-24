package ihm;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import util.Capteur;
import util.CapteurImpl;

import command.StartCMD;
import command.StopCMD;
import command.algoAtomiqueCMD;
import command.algoEpoqueCMD;
import command.algoSequentielCMD;

/**
 *   L'IHM  de l'Application 
 *
 */
public class IHM extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int NB_AFFICHEUR = 3;
	private Capteur c;
	ArrayList<JLabel> liLabels;
	ArrayList<Afficheur> liAfficheurs; // Les afficheurs qui observent le
										// capteur

	JButton startBut;
	JButton stopBut;

	// Liste Des Commandes
	StartCMD startcmd;
	StopCMD stopcmd;
	algoAtomiqueCMD atomiquecmd;
	algoSequentielCMD seqcmd;
	algoEpoqueCMD epoquecmd;

	/**
	 * construteur
	 */
	public IHM() {

		getContentPane().setLayout(new BorderLayout());

		// panel afficheur
		JPanel panAff = new JPanel();
		panAff.setLayout(new FlowLayout());

		// instantiation des composants
		liLabels = new ArrayList<JLabel>();
		for (int i = 0; i < NB_AFFICHEUR; i++) {
			JLabel labaff = new JLabel(" Afficheur  " + (i + 1) + " : ");
			liLabels.add(labaff);
		}
        // création de afficheurs
		liAfficheurs = new ArrayList<Afficheur>();
		for (int i = 0; i < NB_AFFICHEUR; i++) {
			JTextArea labaff = new JTextArea(2, 2);
			liAfficheurs.add(new Afficheur(labaff));
		}

		for (int i = 0; i < NB_AFFICHEUR; i++) {
			panAff.add(liLabels.get(i));
			panAff.add(((Afficheur) liAfficheurs.get(i)).getComponent());
		}

		getContentPane().add(panAff, BorderLayout.CENTER);
		// Algorithmes de diffusion

		ButtonGroup bgAlgoGroup = new ButtonGroup();
		JPanel algoPanel = new JPanel();
		algoPanel.setBorder(BorderFactory.createTitledBorder("Algo"));

		// DIFF  Atomique
		JRadioButton jrdbAtomiqueDiff = new JRadioButton("Atomique diffusion");
		algoPanel.add(jrdbAtomiqueDiff);
		jrdbAtomiqueDiff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopcmd.executer();
				atomiquecmd = new algoAtomiqueCMD(c);
				atomiquecmd.executer();
				startcmd.executer();
			}

		});
		
         //DIFF Sequentielle
		JRadioButton jrdbSeqDiff = new JRadioButton("Sequentielle diffusion");
		algoPanel.add(jrdbSeqDiff);
		jrdbSeqDiff.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				stopcmd.executer();
				seqcmd = new algoSequentielCMD(c);
				seqcmd.executer();
				startcmd.executer();
			}

		});
		
        // DIFF Epoque
		JRadioButton jrdbEpoqDiff = new JRadioButton("Epoque diffusion");
		algoPanel.add(jrdbEpoqDiff);
		jrdbEpoqDiff.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				stopcmd.executer();
				epoquecmd = new algoEpoqueCMD(c);
				epoquecmd.executer();
				startcmd.executer();
			}

		});

		bgAlgoGroup.add(jrdbEpoqDiff);
		bgAlgoGroup.add(jrdbAtomiqueDiff);
		bgAlgoGroup.add(jrdbSeqDiff);

		getContentPane().add(algoPanel, BorderLayout.NORTH);
		this.setPreferredSize(new Dimension(800, 200));
		this.setTitle("GHED-PU");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public JFrame getParentFrame() {
		return this;
	}
	
    /**
     * Configurer les capteur dans l'ihm
     * 
     * @param c : Capteur
     */
	public void setCapteur(Capteur c) {

		System.out.println("IHM : set capteur called");
		this.c = c;
		// register auprés du capteur
		registerObservers((CapteurImpl) c);
		startcmd = new StartCMD(c);
		stopcmd = new StopCMD(c);
		
	}

	/**
	 * enregistrer les observervateurs 
	 * 
	 * @param c
	 */
	private void registerObservers(CapteurImpl c) {
		System.out.println("IHM: register " + liAfficheurs.size()
				+ " observers");
		for (int i = 0; i < liAfficheurs.size(); i++) {
			c.attach((Afficheur) liAfficheurs.get(i));
		}
	}
     /**
      * Obtenir un afficheur 
      * @param index  : index de l'afficheur
      * @return
      */
	public Afficheur getAfficheur(int index) {
		assert (index >= 0 && index < liAfficheurs.size());
		return (Afficheur) liAfficheurs.get(index);

	}

}
