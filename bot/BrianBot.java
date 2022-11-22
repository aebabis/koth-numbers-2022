package bot;

import runner.*;

public class BrianBot extends Bot {
    protected int _getMove(Game game) {
        int theNumber = 4;

        if (game.getNumRounds() > 0){
            theNumber--;
        }

        return theNumber;
    }
}