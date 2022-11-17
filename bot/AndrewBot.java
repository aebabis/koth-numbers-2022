package bot;

import runner.*;
import java.lang.Math;

public class AndrewBot extends Bot {
    protected int _getMove(Game game) {
      if(LessGreedyBot.isBotAlive == true){
        return ((int)Math.random()*10)+2;
      }else if(GreedyBot.isBotAlive == true){
        return ((int)Math.random()*10)+3;
      }else{
        return ((int)Math.random()*10)
      }     
    }
}