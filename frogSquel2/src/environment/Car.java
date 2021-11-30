package frogSquel2.src.environment;
import java.awt.Color;
import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE; //ne peut pas etre changé dans les methodes

	//TODO Constructeur(s)
	public Car(Game game, Case leftPosition,boolean leftToRight){
		this.game = game;
		this.leftPosition = leftPosition;
		this.leftToRight = leftToRight;
		this.length = game.randomGen.nextInt(3)+1;
	}
	//TODO : ajout de methodes

	private int isGoingLeft() { //si elle va en avant +1 sinon reviens en arrière -1
		if (this.leftToRight) {
			return 1;
		}
		return -1;
	}


	public void move(){ //Si "true", fait avancer la voiture. Affiche la voiture dans tout les cas
			if (!(this.leftPosition.absc > 0 || isGoingLeft() == 1)) {
				Case c;
				c = new Case(leftPosition.absc + 1, leftPosition.ord);
				leftPosition = c;
			}
		if (!(this.leftPosition.ord > 0 || !(isGoingLeft() == 1))) {
			Case c;
			c = new Case(leftPosition.absc - 1, leftPosition.ord);
			leftPosition = c;
		}
			addToGraphics();
	}

	public boolean appearsInBounds() { // return true si la voiture est dans la grille du game, false sinon
		return(this.leftPosition.absc < game.width && this.leftPosition.absc + this.length >= 0);
	}


	public boolean coversCase(Case pos){ //Retrun true si il y a une voiture sur la case c, false sinon
	if(pos.ord!=this.leftPosition.ord && pos.absc!=this.leftPosition.absc && pos.absc <= this.leftPosition.absc+this.length){
		return false;
		}else{
		return true; // position superieure
		// à l'ancienne position et nouvelle case inferieur a lancienne position + la longueur
	}
		}

		public void addCarGraphic(){
			this.addToGraphics();
		}



	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic().add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
