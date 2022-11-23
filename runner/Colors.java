package runner;

public class Colors {
	private static final boolean isWindows = System.getProperty("os.name").startsWith("Windows");
    public static final String RED =      isWindows ? "" : "\u001b[31m";
    public static final String SURVIVOR = isWindows ? "" : "\u001b[92m";
    public static final String WINNER =   isWindows ? "" : "\u001b[32;1m";
    public static final String BLUE =     isWindows ? "" : "\u001b[34m";
    public static final String GRAY =     isWindows ? "" : "\u001b[38;5;242m";
    public static final String RESET =    isWindows ? "" : "\u001b[0m";
}
