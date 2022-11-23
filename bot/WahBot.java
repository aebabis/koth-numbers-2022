package bot;

import runner.*;

public class WahBot extends Bot {
    protected int _getMove(Game game) {
        int round = game.getNumRounds();
        int numBots = game.getNumBots();

        if (round == 0) {
            return (int) (Math.random() * game.getNumAlive()) + 3;
        } 
        
        return (int) ((Math.random() * Math.random()) * game.getNumRounds()) + 3; // Perhaps a bit too wah
    }
}