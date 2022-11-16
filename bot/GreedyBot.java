package bot;

import runner.*;

public class GreedyBot extends Bot {
    protected int _getMove(Game game) {
        return 1; // The best move, assuming no one else takes it.
    }
}