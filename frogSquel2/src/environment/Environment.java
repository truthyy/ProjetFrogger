package frogSquel2.src.environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
    //TODO
    private Game game;
    private ArrayList<Lane> lane;

    public Environment(Game game) {
        this.game = game;
        this.lane = new ArrayList<>();

        this.lane.add(new Lane(game, 0,game.defaultDensity));

        for (int i = 1; i < game.height - 1; i++) {
            this.lane.add(new Lane(game, i,game.defaultDensity));
        }
        this.lane.add(new Lane(game, game.height,game.defaultDensity));
    }
    private ArrayList<Lane> initializeLaneInf(){
        ArrayList<Lane> initialized = new ArrayList<>();
        initialized.add(new Lane(game, 0, 0));
        initialized.add(new Lane(game, 1, 0));

        for(int i = 2; i < this.game.height; i++){
            initialized.add(new Lane(game, i, this.game.defaultDensity));
        }
        return initialized;
    }


    public boolean isSafe(Case c) {
                return lane.get(c.ord).isSafe(c);
    }

    public boolean isWinningPosition(Case c) {
        return (c.ord == this.game.height - 1);
    }

    public void update() {
        for (Lane l : this.lane)
            l.update();
    }
}


