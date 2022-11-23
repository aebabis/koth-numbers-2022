package bot;
import runner.*;

public class TensBot extends Bot {
	protected int _getMove(Game game) {
		int num = (int)(2*(Math.ceil(Math.random()*10)));
		if (num > game.getNumAlive() && game.getNumAlive() > 4) {
			if (num > 10) {
				if (((num / 2) % 2) != 0) {
					num = (num / 2) - 1;
				} else {
					num = (num / 2);
				}
			}
		} else {
			return game.getNumAlive();
		}
		if (Math.abs(num - game.getNumAlive()) != 0) {
		return (int) num;
		} else {
			return 2;
		}
	}
} 