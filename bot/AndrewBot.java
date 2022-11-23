package bot;

import runner.*;
import java.lang.Math;

public class AndrewBot extends Bot {
    protected int _getMove(Game game) {
      int roundNum = game.getNumRounds();
      if(roundNum > 1) {
    	  return 1;
      }else {
    	  return 98;
      }
    }
}