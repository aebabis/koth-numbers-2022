package bot;

import runner.*;

public abstract class Bot {
    /**
     * @param contestants An array of all contestants who've played this round,
     *                    including this Bot.
     * @param alive       An array of booleans indicating if the corresponding bot
     *                    in contestants is still alive and able to make moves.
     * @return            an int strictly greater than 0 that the bot chooses
     *                    for its move. If any other bot chooses the same move,
     *                    both are eliminated.
     */
    protected abstract int _getMove(Game game);

    public final int getMove(Game game) {
        try {
            int move = _getMove(game);
            if (move < 1)
                return 1;
            return move;
        } catch (Exception e) {
            return 1;
        }
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}