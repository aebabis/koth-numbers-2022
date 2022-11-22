package bot;

import runner.*;
import java.lang.Math;

public class AndrewBot extends Bot {
    protected int _getMove(Game game) {
      int numAlive = game.getNumAlive();
	  if(numAlive >= 5) {
    	  return (int)(Math.random()*5)+3;
      }
      return (int)(Math.random()*2)+1;
    }
}