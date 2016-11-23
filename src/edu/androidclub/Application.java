package edu.androidclub;

import edu.androidclub.domain.Item;
import edu.androidclub.domain.ItemBox;

import java.util.Stack;

public class Application implements Runnable {

    private static Application app;

    public static void main(String[] args) {
        app = new Application();
        app.run();
    }

    public static Application getInstance() {
        if (app == null) {
            app = new Application();
        }
        return app;
    }

    @Override
    public void run() {
        Runnable va = new VendingAutomat();
        va.run();
    }

    private void test() {
    }
}
