package bot;

import runner.*;

public class BrianBot extends Bot {
    protected int _getMove(Game game) {
        int theNumber = (int) (Math.random() * game.getNumAlive()) - 1;

        if (theNumber == 0){
            theNumber = (int) (Math.random() * game.getNumAlive()) - 1;
        }

        if (theNumber <= 2){
            theNumber += 1;
        } else if (theNumber >= 10){
            theNumber -= 2;
        }
        return theNumber;
    }
}