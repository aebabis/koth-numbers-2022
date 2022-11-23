package bot;

import runner.*;

public class GaryBot extends Bot {
    protected int _getMove(Game game) {
        int numAlive = game.getNumAlive();
        int round = game.getNumRounds();
        if (round == 0)
            return numAlive + (int)(Math.random() * numAlive * 3);
        if (numAlive <= 4)
            return 3;
        else if (numAlive <= 2)
            return 1;
        else
            return numAlive / 2 + 2;
    }
}