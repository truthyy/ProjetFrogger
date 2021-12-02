package frog;
import util.Case;
import util.Direction;
import gameCommons.Game;

public class FrogInf extends Frog { //classe qui hérite d'une classe
Game game;
Case position;
Direction direction;


    public FrogInf(Game game) {
        super(game);
        this.position = new Case(this.game.width/2, 1);
    }

    public void move(Direction key) {
        this.direction = key;

        //Mm thing sauf qu'on ra-joute une lane a chaque fois qu'on avance
        if (key == Direction.up) {
            //this.position = new Case(this.position.absc, this.position.ord);
            //this.game.score++;
           // this.game.environment.up();
            this.game.testLose();
        } else if (key == Direction.down) {
            //this.position = new Case(this.position.absc, this.position.ord - 1);
          //  this.game.score--;
          //  this.game.environment.down();
            this.game.testLose();
        } else if (key == Direction.right && this.position.absc < this.game.width - 1)
            this.position = new Case(this.position.absc + 1, this.position.ord);
        else if (key == Direction.left && this.position.absc > 0)
            this.position = new Case(this.position.absc - 1, this.position.ord);
    }

}

