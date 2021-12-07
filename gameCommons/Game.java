package gameCommons;
import java.awt.Color;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import frog.Frog;
import frog.FrogInf;
import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;

public class Game {

	public final Random randomGen = new Random();

	// Caracteristique de la partie
	public final int width;
	public final int height;
	public final int minSpeedInTimerLoops;
	public final double defaultDensity;
	private Timer t = new Timer(); //Ajout timer  AP
	int temps = 0;
	// Lien aux objets utilis�s
	private IEnvironment environment;
	private IFrog frog;
	private IFroggerGraphics graphic;

	/**
	 * 
	 * @param graphic
	 *            l'interface graphique
	 * @param width
	 *            largeur en cases
	 * @param height
	 *            hauteur en cases
	 * @param minSpeedInTimerLoop
	 *            Vitesse minimale, en nombre de tour de timer avant d�placement
	 * @param defaultDensity
	 *            densite de voiture utilisee par defaut pour les routes
	 */
	public Game(IFroggerGraphics graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity) {
		super();
		this.graphic = graphic;
		this.width = width;
		this.height = height;
		this.minSpeedInTimerLoops = minSpeedInTimerLoop;
		this.defaultDensity = defaultDensity;
		t.schedule(new TimerTask() { //AP
			@Override
			public void run() {
				temps++;
			}
		}, 1000, 1000); //milisecondes
	}

	/**
	 * Lie l'objet frog à la partie
	 * 
	 * @param frog
	 */
	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	/**
	 * Lie l'objet environment a la partie
	 * 
	 * @param environment
	 */
	public void setEnvironment(IEnvironment environment) {
		this.environment = environment;
	}

	/**
	 * 
	 * @return l'interface graphique
	 */
	public IFroggerGraphics getGraphic() {
		return graphic;
	}

	/**
	 * Teste si la partie est perdue et lance un �cran de fin appropri� si tel
	 * est le cas
	 * 
	 * @return true si le partie est perdue
	 */
	public boolean testLose() { //AP
		// TODO
	if (!this.environment.isSafe(this.frog.getPosition())){
		if(frog instanceof Frog)
			this.graphic.endGameScreen("perdu, "+"Score = "+frog.getPosition().ord); //grenouille fixe
		else {
			FrogInf test = (FrogInf) frog;  //on fait un cast
			t.cancel();
			this.graphic.endGameScreen("perdu, " + "temps = " + temps+"s"+"/Score = "+test.getScore());
		}
			return true; //perdu
	}else{
		return false; //pas perdu
	}
	}

	/**
	 * Teste si la partie est gagnee et lance un �cran de fin appropri� si tel
	 * est le cas
	 * 
	 * @return true si la partie est gagn�e
	 */
	public boolean testWin() {
		// TODO
		if (this.environment.isWinningPosition(this.frog.getPosition())) {
			this.graphic.endGameScreen("gagné" );
			return true;
		}else{
			return false;
		}

	}

	/**
	 * Actualise l'environnement, affiche la grenouille et verifie la fin de
	 * partie.
	 */
	public void update() {
		graphic.clear();
		environment.update();
		this.graphic.add(new Element(frog.getPosition(), Color.GREEN));
		testLose();
		if (frog instanceof Frog) //Ajout de cette condition sinon partie normale non fonctionnelle
			testWin();
	}

	public IEnvironment getEnvinf(){
		return environment;
	}


}
