package runner;

import java.util.*;
import bot.*;

public class Runner {
    private static final String WINNER = "\u001b[32;1m";
    private static final String BLUE = "\u001b[34m";
    private static final String GRAY = "\u001b[38;5;242m";
    private static final String RESET = "\u001b[0m";

    private Bot[] bots;
    private int[] scores;
    private List<int[]> history;

    public Runner(Bot[] bots) {
        this.bots = bots.clone();
        this.scores = new int[bots.length];
    }

    public String getStandingString() {
        int topScore = 0;
        for (int score : scores)
            topScore = Math.max(topScore, score);

        StringBuilder sb = new StringBuilder();
        for (int b = 0; b < bots.length; b++) {
            String name = String.format("%-20s   ", bots[b].toString());
            String text = String.format(" %3d", scores[b]);
            if (scores[b] == topScore)
                sb.append(WINNER);
            sb.append(name);
            sb.append(text);
            sb.append(RESET);
            sb.append("\n");
        }
        return sb.toString();
    }

    private void playTournament() {
        for (int gameNum = 1; gameNum <= 100; gameNum++) {
            System.out.println(GRAY+"GAME " + gameNum+RESET);
            Game game = new Game(bots);
            game.play();
            System.out.println(game.getHistoryString());
            for (int winner : game.getWinners())
                scores[winner]++;
        }

        System.out.println(BLUE+"FINAL STANDINGS"+RESET);
        System.out.println(getStandingString());
    }

    public static void shuffle(Bot[] bots) {
        for (int i = bots.length - 1; i > 0; i--) {
            int s = (int)(Math.random() * (i + 1));
            Bot tmp = bots[s];
            bots[s] = bots[i];
            bots[i] = tmp;
        }
    }

    public static void main(String args[]) {
        Bot[] bots = {
            new AndrewBot(),
            new AndrewSaboBot(),
            new BabisBot(),
            new BrianBot(),
            new CarefulBot(),
            new CopyCat(),
            new GaryBot(),
            new GreedyBot(),
            new LessGreedyBot(),
            new RandomBot(),
            new TensBot(),
            new VincentBot(),
            new WahBot(),
            new YourMomBot(),
        };
        shuffle(bots);
        Runner runner = new Runner(bots);
        runner.playTournament();
    }
}