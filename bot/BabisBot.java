package bot;

import runner.*;

public class BabisBot extends Bot {
    protected int _getMove(Game game) {
        int numAlive = game.getNumAlive();
        if (numAlive == 3)
            return 1 + (int)(Math.random() * 2);
        else
            return numAlive + (int)(Math.random() * numAlive * 1.5);
    }
}