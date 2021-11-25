package frogSquel2.src.environment;
import java.util.ArrayList;
import util.Case;
import gameCommons.Game;

public class Lane {
	private Game game;
	public int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;

	// TODO : Constructeur(s)
	public Lane(Game game, int ord, double density) {
		this.game = game;
		this.ord = ord;
		this.speed = game.randomGen.nextInt(1);
		this.cars = new ArrayList<Car>();
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = density;
		//this.timer = 0;
		for(int i = 0; i < game.width ; ++i) {
			this.moveCars(true);
			this.mayAddCar();

		// TODO

		public void update(){
			if(this.speed < this.timer){
				this.timer = 0;
				this.MoveCars(true);
				this.mayAddCar();
			}else{
				this.MoveCars(false);
			}
			this.timer++;
		}
		}
		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

	}

	// TODO : ajout de methodes

	public boolean isSafe(Case c){ //Return true si la case cst safe (si il n'y a pas de voiture sur la case c)
		for(Car c : this.cars) {
			if (c.isOn(pos))
				return false;
		}
		return true;
	}

	private void moveCars(boolean ok){ //fait avncr les car et ajoutent à lintrface grphique
		for(Car c : this.cars){
			c.move(ok);
	}}

	private void removeOldCars() {  //enleve anciennes voitures
		ArrayList<Car> toBeRemoved = new ArrayList<>();

		for(Car c : this.cars)
			if(!c.appearsInBounds()) {
				toBeRemoved.add(c);
			}

		for(Car c : toBeRemoved)
			this.cars.remove(c);
	}



	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au debut de la voie avec probabilite egale a la
	 * densite, si la premiere case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}
