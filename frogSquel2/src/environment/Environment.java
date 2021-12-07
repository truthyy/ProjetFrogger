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

        this.lane.add(new Lane(game, 0,0.)); //AP

        for (int i = 1; i <= game.height - 1; i++) {
            this.lane.add(new Lane(game, i,game.defaultDensity));
        }
        this.lane.add(new Lane(game, game.height,0.));
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

    @Override
    public ArrayList<Lane> getLane() {
        return null;
    }

    @Override
    public void majAllLanes() {

    }


}


