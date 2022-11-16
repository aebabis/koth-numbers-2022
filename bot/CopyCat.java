package bot;

import runner.*;

public class CopyCat extends Bot {
    protected int _getMove(Game game) {
        int round = game.getNumRounds();
        int numBots = game.getNumBots();

        if (round == 0)
            return numBots;

        int start = (int) (Math.random() * numBots);
        while (!game.isBotAlive(start) || toString().equals(game.getBotName(start)))
            start = (start + 1) % numBots;

        return game.getRound(round - 1).getMoves()[start];
    }
}