package runner;

import bot.*;
import java.util.*;

public class RunnerUtils {
    public static boolean[] makeAliveList(Bot[] bots) {
        boolean[] alive = new boolean[bots.length];
        for (int i = 0; i < alive.length; i++)
            alive[i] = true;
        return alive;
    }

    public static int countAlive(boolean[] alive) {
        int count = 0;
        for (boolean a : alive)
            if (a) count++;
        return count;
    }
}