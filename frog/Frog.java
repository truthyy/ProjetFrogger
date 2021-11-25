package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Case Position; //dans quelle partie il se trouve
	private Direction Direct;
	public Frog(Game game) {
		this.Position = new Case(0,0);
	}


	@Override
	public Case getPosition() { //donne la position actuelle de la grenouille

		return Position;
	}

	@Override
	public Direction getDirection() {

		return Direct; //donne direction actuelle de la grenouille
	}

	@Override
	public void move(Direction key) { // on veut modifier la direction de la grenouille et mettre a jour la case

	if ( key == Direction.down){
			this.Position = new Case(Position.absc, Position.ord -1);
	}
	else if ( key == Direction.up){
			this.Position = new Case(Position.absc, Position.ord +1);
		}
	else if ( key == Direction.left){
			this.Position = new Case(Position.absc-1, Position.ord);
	}
	else if ( key == Direction.right){
			this.Position = new Case(Position.absc+1, Position.ord);
		}


}
}
