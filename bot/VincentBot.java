package bot;

import runner.*;

public class VincentBot extends Bot{
    protected int _getMove(Game game) {
    	int dif = game.getNumBots() - game.getNumAlive();
    	if(dif >0 && dif <=5) {
    		dif= dif *2 + 1;
    	} else {
    		dif =3;
    	}
    	return (int) (dif + dif * 0.5 * game.getNumRounds());
    }
}