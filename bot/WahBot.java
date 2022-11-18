package bot;

import runner.*;

public class WahBot extends Bot {
    protected int _getMove(Game game) {
        return (int) (Math.random() * game.getNumAlive()) + 3 ; // Perhaps a bit too wah
    }
}