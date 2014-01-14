package algorithmes;

import mainPack.Capteur;

public interface AlgoDiffusion {

	public void configure(Capteur c, int nbObs);
	public void executeTick();
	public int executeGetValue();
}
