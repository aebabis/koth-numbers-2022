package runner;

import java.util.*;
import bot.*;

public class Round {
    private int[] moves;
    List<Integer> losingMoves;

    public Round(int[] moves) {
        this.moves = moves.clone();
    }

    public int[] getMoves() {
        return moves;
    }

    public List<Integer> getLosingMoves() {
        if (losingMoves != null)
            return losingMoves;
        losingMoves = new ArrayList<Integer>();

        int max = 0;
        Map<Integer, Integer> choiceCounts = new HashMap<Integer, Integer>();
        for (int move : moves) {
            if (move == 0)
                continue;
            max = Math.max(max, move);
            Integer count = choiceCounts.get(move);
            if (count == null)
                choiceCounts.put(move, 1);
            else if (count == 1)
                losingMoves.add(move);
        }
        if (losingMoves.size() == 0)
            losingMoves.add(max);
        return losingMoves;
    }
}