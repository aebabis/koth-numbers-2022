package bot;
import runner.*;

public class TensBot extends Bot {
	protected int _getMove(Game game) {
		return (int) Math.round(2*(Math.ceil(Math.random()*10)));
	}
}