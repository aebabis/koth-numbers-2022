package bot;

import runner.*;

public class YourMomBot extends Bot {
    protected int _getMove(Game game) {
        int hashtag = (int) Math.round(Math.random() * game.getNumRounds());
        if (hashtag == 0) {
            hashtag += (int) (Math.random()) * game.getNumAlive();
        } else {
        return (int) (Math.random() * game.getNumAlive()) + 1;
        }
        return hashtag;
    }
}