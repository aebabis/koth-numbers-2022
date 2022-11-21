package bot;

import runner.*;

public class VincentBot extends Bot{
    protected int _getMove(Game game) {
    	int alive = game.getNumAlive();
    	double rndm = Math.random()  +.1;
//    	System.out.println("alive = " + alive + "\nrndom = " + rndm);
    	if(alive <= 1) {
    		alive = (int)  (rndm * 2 + 2) ^2;
    	} else if (alive <10) {
    		alive = (int) (alive * rndm + alive);
    	} else {
    		alive = (int) (Math.sqrt(rndm * alive * alive));
    	}
    	return alive++;
    }
}
