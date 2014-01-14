package mainPack;

import java.awt.BorderLayout;
import java.awt.Color;
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

import command.StartCMD;
import command.StopCMD;
import command.algoAtomiqueCMD;
import command.algoEpoqueCMD;
import command.algoSequentielCMD;

public class IHM extends JFrame {

	public static final int NB_AFFICHEUR = 3;

	private Capteur c;

	ArrayList<JLabel> liLabels;
	ArrayList<Afficheur> liAfficheurs; // Les afficheurs qui observent le
										// capteur

	JButton startBut;
	JButton stopBut;

	// List of commandes
	StartCMD startcmd;
	StopCMD stopcmd;
	algoAtomiqueCMD atomiquecmd = null;
	algoSequentielCMD seqcmd = null;
	algoEpoqueCMD epoquecmd = null;

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

		JRadioButton jrdbAtomiqueDiff = new JRadioButton("Atomique diffusion");
		algoPanel.add(jrdbAtomiqueDiff);
		jrdbAtomiqueDiff.setSelected(true);
		
		

		jrdbAtomiqueDiff.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				atomiquecmd = new algoAtomiqueCMD(c);
				atomiquecmd.executer();
			}

		});

		JRadioButton jrdbSeqDiff = new JRadioButton("Sequentielle diffusion");
		algoPanel.add(jrdbSeqDiff);

		jrdbSeqDiff.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// algoSequentielCMD.executer();
			}

		});

		JRadioButton jrdbEpoqDiff = new JRadioButton("Epoque diffusion");
		algoPanel.add(jrdbEpoqDiff);

		jrdbEpoqDiff.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// algoEpoqueCMD.executer();
			}

		});

		bgAlgoGroup.add(jrdbEpoqDiff);
		bgAlgoGroup.add(jrdbAtomiqueDiff);
		bgAlgoGroup.add(jrdbSeqDiff);

		getContentPane().add(algoPanel, BorderLayout.NORTH);

		// Ajout des boutons start et stop :
		startBut = new JButton("START");
		startBut.setBackground(Color.GREEN);
		stopBut = new JButton("STOP");
		stopBut.setBackground(Color.ORANGE);
		JPanel jPanBut = new JPanel();
		jPanBut.setLayout(new BorderLayout());
		jPanBut.add(startBut, BorderLayout.WEST);
		jPanBut.add(stopBut, BorderLayout.EAST);
		getContentPane().add(jPanBut, BorderLayout.SOUTH);
		// association des command

		startBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("start command order");
				if (atomiquecmd == null && seqcmd == null && epoquecmd == null) {
					// JOptionPane.showInternalMessageDialog(getParentFrame(),
					// "choose a strategy !", "", 0, null);
				} else {
					System.out.println("strategies not null");
					startcmd.executer();
				}

			}

		});

		stopBut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("stop command order");
				stopcmd.executer();
			}

		});

		this.setPreferredSize(new Dimension(800, 500));
		// this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JFrame getParentFrame() {
		return this;
	}

	public void setCapteur(Capteur c) {

		System.out.println("IHM : set capteur called");
		this.c = c;
		// register auprés du capteur

		registerObservers((CapteurImpl) c);
		startcmd = new StartCMD(c);
		stopcmd = new StopCMD(c);
		
		atomiquecmd = new algoAtomiqueCMD(c);
		atomiquecmd.executer();
		
	}

	private void registerObservers(CapteurImpl c) {
		System.out.println("IHM: register " + liAfficheurs.size()
				+ " observers");
		for (int i = 0; i < liAfficheurs.size(); i++) {
			c.attach((Afficheur) liAfficheurs.get(i));
		}
	}

	/*public static void main(String args[]) {
		new IHM();
	}
*/
	public Afficheur getAfficheur(int index) {
		assert (index >= 0 && index < liAfficheurs.size());
		return (Afficheur) liAfficheurs.get(index);

	}

}
