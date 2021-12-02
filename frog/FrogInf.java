package frog;
import frogSquel2.src.environment.EnvInf;
import frogSquel2.src.environment.Environment;
import frogSquel2.src.environment.Lane;
import gameCommons.IFrog;
import util.Case;
import util.Direction;
import gameCommons.Game;

public class FrogInf implements IFrog {
    private Game game;
    private Case Position; //dans quelle partie il se trouve
    private Direction Direct;

    public FrogInf(Game game) {
        this.game = game;
        this.Position = new Case(0,0);
        this.Direct = Direction.left;
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
            game.getEnvinf().getLane().add(new Lane(game, game.height, game.defaultDensity));
            game.getEnvinf().majAllLanes();
            game.getEnvinf().majAllCars();

        }
        else if ( key == Direction.left){
            this.Position = new Case(Position.absc-1, Position.ord);
        }
        else if ( key == Direction.right){
            this.Position = new Case(Position.absc+1, Position.ord);
        }
    }
}

