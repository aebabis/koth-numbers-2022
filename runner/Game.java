package runner;

import java.util.*;
import java.util.concurrent.*;
import bot.*;

public class Game {
    private Bot[] bots;
    private boolean[] alive;
    private List<Round> rounds;
    private List<Integer> winners;

    public Game(Bot[] bots) {
        this.bots = bots.clone();
        this.alive = RunnerUtils.makeAliveList(bots);
        this.rounds = new ArrayList<Round>();
    }

    public List<Integer> getWinners() {
        return winners;
    }

    public int getNumBots() {
        return bots.length;
    }

    public boolean isBotAlive(int i) {
        return alive[i];
    }

    public String getBotName(int i) {
        return bots[i].toString();
    }

    public int getNumAlive() {
        return RunnerUtils.countAlive(alive);
    }

    public int getNumRounds() {
        return rounds.size();
    }

    public Round getRound(int round) {
        return rounds.get(round);
    }

    public void play() {

        while (RunnerUtils.countAlive(alive) > 2) {
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(bots.length);
            int[] moves = new int[bots.length];
            for (int i = 0; i < bots.length; i++)
                if (alive[i])
                    executor.submit(new MoveRunner(bots[i], moves, i));

            executor.shutdown();
            try {
                executor.awaitTermination(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.err.println(e);
                executor.shutdownNow();
            }
            Round round = new Round(moves);

            List<Integer> losingMoves = round.getLosingMoves();

            for (int i = 0; i < bots.length; i++)
                if (losingMoves.contains(moves[i]))
                    alive[i] = false;

            rounds.add(round);
        }

        winners = new LinkedList<Integer>();
        for (int i = 0; i < alive.length; i++)
            if (alive[i])
                winners.add(i);
    }

    public String getHistoryString() {
        StringBuilder sb = new StringBuilder();
        for (int b = 0; b < bots.length; b++) {
            String name = String.format("%-20s   ", bots[b].toString());
            if (alive[b])
                sb.append(Colors.SURVIVOR);
            sb.append(name);
            for (Round round : rounds) {
                int move = round.getMoves()[b];
                if (move == 0) {
                    sb.append(Colors.GRAY + "   -");
                } else {
                    String text = String.format(" %3d", round.getMoves()[b]);
                    if (round.getLosingMoves().contains(move))
                        sb.append(Colors.RED + text + Colors.RESET);
                    else
                        sb.append(text);
                }
            }
            sb.append(Colors.RESET);
            sb.append("\n");
        }
        return sb.toString();
    }

    private class MoveRunner implements Runnable {
        Bot bot;
        int[] moves;
        int i;

        public MoveRunner(Bot bot, int[] moves, int i) {
            this.bot = bot;
            this.moves = moves;
            this.i = i;
        }

        public void run() {
            moves[i] = 1;
            moves[i] = bot.getMove(Game.this);
        }

        public String toString() {
            return bot.toString();
        }
    }
}