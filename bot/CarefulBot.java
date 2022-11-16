package bot;

import runner.*;

public class CarefulBot extends Bot {
    protected int _getMove(Game game) {
        return 99; // Perhaps a bit too careful
    }
}