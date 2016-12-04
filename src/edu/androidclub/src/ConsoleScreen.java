import edu.androidclub.domain.AppScreen;

import java.io.PrintStream;

public class ConsoleScreen implements AppScreen {

    private static final String LINE_BORDER = "###";

    private final PrintStream ps = System.out;

    @Override
    public void printText(String text) {
        ps.println(LINE_BORDER + " " + text + " " + LINE_BORDER);
    }

    @Override
    public void clear() {
        for (int i = 0; i < 15; i++) {
            ps.println();
        }
    }

}
