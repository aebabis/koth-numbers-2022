package runner;

import bot.*;

public class Runner {
    private Bot[] bots;
    private int[] scores;

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
                sb.append(Colors.WINNER);
            sb.append(name);
            sb.append(text);
            sb.append(Colors.RESET);
            sb.append("\n");
        }
        return sb.toString();
    }

    private void playTournament() {
        for (int gameNum = 1; gameNum <= 100; gameNum++) {
            System.out.println(Colors.GRAY+"GAME " + gameNum+Colors.RESET);
            Game game = new Game(bots);
            game.play();
            System.out.println(game.getHistoryString());
            for (int winner : game.getWinners())
                scores[winner]++;
        }

        System.out.println(Colors.BLUE+"FINAL STANDINGS"+Colors.RESET);
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
            new GreedyBot(),
            new YourMomBot(),
            new BabisBot(),
            new LessGreedyBot(),
            new RandomBot(),
            new CopyCat(),
            new BrianBot()
        };
        shuffle(bots);
        Runner runner = new Runner(bots);
        runner.playTournament();
    }
}