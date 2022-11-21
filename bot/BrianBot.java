package bot;

import runner.*;

public class BrianBot extends Bot {
    protected int _getMove(Game game) {
        int theNumber = 4;

        if (game.getNumRounds() > 0){
            if (theNumber > 10){
            theNumber -= game.getNumAlive();
            }

            theNumber--;
        }

        return theNumber;
    }
}