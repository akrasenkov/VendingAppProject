import edu.androidclub.domain.*;
import edu.androidclub.items.Cola;
import edu.androidclub.items.Fanta;
import edu.androidclub.items.Pulpy;
import edu.androidclub.items.Sprite;

import java.io.IOException;
import java.util.Stack;

public class VendingAutomat implements Runnable {

    private Keypad keypad = new ConsoleInput();
    private ItemBox itemBox = null;
    private AppScreen screen = new ConsoleScreen();

    @Override
    public void run() {
        populateItemBox();
        while (true) {
            requestCommand();
        }
    }

    public void stop() {
        try {
            Database db = new FileDatabase();
            db.persistScheme(itemBox.getScheme());
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        System.exit(0);
    }

    private void requestCommand() {
        screen.printText(
                "Hi dear User! Enter 'get #' where # is a product number to get it: "
        );
        Command userCommand = keypad.readCommand();
        if (userCommand.getType().equals(Command.TYPE_GET)) {
            Item item = itemBox.emit((Coordinates) userCommand.getData());
            if (item == null) {
                screen.printText("No items left");
            } else {
                screen.printText(item.getName() + " " + item.getCost());
            }
        }
        if (userCommand.getType().equals(Command.TYPE_STOP)) {
            stop();
        }
    }

    private void populateItemBox() {
        try {
            Database db = new FileDatabase();
            itemBox = new ProductsBox(db.loadScheme());
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

}