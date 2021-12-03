package frog;
import frogSquel2.src.environment.Lane;
import gameCommons.IFrog;
import graphicalElements.Element;
import util.Case;
import util.Direction;
import gameCommons.Game;

import java.awt.*;

public class FrogInf implements IFrog {
    private Game game;
    private Case position; //dans quelle partie il se trouve
    private Direction direct;

    public FrogInf(Game game) {
        this.game = game;
        this.position = new Case(0,0);
        this.direct = Direction.left;
    }

    @Override
    public Case getPosition() { //donne la position actuelle de la grenouille
        return position;
    }

    @Override
    public Direction getDirection() {
        return direct; //donne direction actuelle de la grenouille
    }

    @Override
    public void move(Direction key) { // on veut modifier la direction de la grenouille et mettre a jour la case

        if ( key == Direction.down){
            this.position = new Case(position.absc, position.ord -1);
        }
        else if ( key == Direction.up){
            //game.getEnvinf().majAllLanes();
            game.getEnvinf().getLane().add(new Lane(game, game.getEnvinf().getLane().size(), game.defaultDensity));
            this.position = new Case(position.absc, position.ord +1);
            /*System.out.println(position.absc + ", " + position.ord+"\n");
            for(Lane l : game.getEnvinf().getLane())
                System.out.println(l.getOrd());*/
        }
        else if ( key == Direction.left){
            this.position = new Case(position.absc-1, position.ord);
        }
        else if ( key == Direction.right){
            this.position = new Case(position.absc+1, position.ord);
        }
    }
}

