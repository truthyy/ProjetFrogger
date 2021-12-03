package frogSquel2.src.environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class EnvInf implements IEnvironment{
    private Game game;
    private ArrayList<Lane> lane;

    public EnvInf(Game game) {
        this.game = game;
        this.lane = new ArrayList<>();

        this.lane.add(new Lane(game, 0,0.));

        for (int i = 1; i <= game.height - 1; i++) {
            this.lane.add(new Lane(game, i,game.defaultDensity));
        }
        this.lane.add(new Lane(game, game.height, game.defaultDensity));
    }
    /*private ArrayList<Lane> initializeLaneInf(){
        ArrayList<Lane> initialized = new ArrayList<>();
        initialized.add(new Lane(game, 0, 0));
        initialized.add(new Lane(game, 1, 0));

        for(int i = 2; i < this.game.height; i++){
            initialized.add(new Lane(game, i, this.game.defaultDensity));
        }
        return initialized;
    }*/


    public boolean isSafe(Case c) {
        return lane.get(c.ord).isSafe(c);
    }

    public boolean isWinningPosition(Case c) {
        return false;
    }

    public void update() {
        for (Lane l : this.lane)
            l.update();
    }

    public ArrayList<Lane> getLane() {
        return lane;
    }

    public void majAllLanes() {
        for (int i = 0; i < lane.size(); i++) {
            //lane.get(i).majLane();
            lane.get(i).majAllCars();
            // System.out.println(lane.get(i).getOrd() +": "+lane.get(i).toString()+"\n");
        }
    }



}
