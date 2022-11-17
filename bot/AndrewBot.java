package bot;

import runner.*;
import java.lang.Math;

public class AndrewBot extends Bot {
    protected int _getMove(Game game) {
		return (int) (Math.random()*10);
        
    }
}