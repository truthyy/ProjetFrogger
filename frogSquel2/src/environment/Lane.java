package frogSquel2.src.environment;
import java.util.ArrayList;
import util.Case;
import gameCommons.Game;

public class Lane {
	private Game game;
	public int ord;
	private int speed;
	private ArrayList<Car> cars;
	private boolean leftToRight;
	private double density;
	private int timer;

	// TODO : Constructeur(s)
	public Lane(Game game, int ord, double density) {
		this.game = game;
		this.ord = ord;
		this.speed = game.randomGen.nextInt(2)+1; //AP
		this.cars = new ArrayList<>();
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = density;
		this.timer = 0;

		for(int i = 0 ;i < 10; i++){ //AP  essayer davoir une chance parmi les 10
			moveCars(true); //pour des voitures des le debut
			mayAddCar();
		}

	}
		// TODO

		public void update(){ //AP
			timer++;
			if(timer == speed){
				this.moveCars(true);
				this.mayAddCar();
				timer = 0;
			}else{
				this.moveCars(false);
			}
		}

		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e



	// TODO : ajout de methodes

	public boolean isSafe(Case c){ //Return true si la case cst safe (si il n'y a pas de voiture sur la case c)
		for(Car car : this.cars) {
			if (car.coversCase(c))
				return false;
		}
		return true;
	}

	private void moveCars(boolean bouge) { //AP fait avancer les car et ajoutent à lintrface grphique
		for (Car c : this.cars) {
			c.move(bouge);
		}removeOldCars();
	}

	private void removeOldCars() {  //enleve anciennes voitures
		ArrayList<Car> toBeRemoved = new ArrayList<>();

		for(Car c : this.cars) {
			if (!c.appearsInBounds()) {
				toBeRemoved.add(c);
			}
		}
		for(Car c : toBeRemoved) {
			this.cars.remove(c);
		}
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

public void majAllCars(){
		for(int i = 0; i < cars.size(); i++){
			cars.get(i).majCar();
		}
}
	public void majLane(){ //AP P3
		ord = ord - 1;
	}

	public int getOrd() {
		return ord;
	}

	public String toString(){
		String res = "";
		for(Car c : cars)
			res+=c.toString()+ "/ ";
		return res;
	}
}
