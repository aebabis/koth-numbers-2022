package bot;

import runner.*;

public class RandomBot extends Bot {
    protected int _getMove(Game game) {
        return (int) (Math.random() * game.getNumAlive()) + 1;
    }
}