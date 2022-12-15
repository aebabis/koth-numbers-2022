package bot;

import runner.*;


public class MyBot extends Bot {
    protected int _getMove(Game game) {
       int numAlive = game.getNumAlive();
       return (int) (Math.random() + game.getNumAlive()) * 3;
    }
}
