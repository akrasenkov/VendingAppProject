package edu.androidclub;

import edu.androidclub.domain.AppScreen;
import edu.androidclub.domain.Item;
import edu.androidclub.domain.ItemBox;
import edu.androidclub.domain.Keypad;
import edu.androidclub.items.Cola;
import edu.androidclub.items.Fanta;
import edu.androidclub.items.Pulpy;
import edu.androidclub.items.Sprite;

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
    }

    private void populateItemBox() {
        ItemInfoScheme scheme = new ItemInfoScheme();
        Stack<Item> items11 = new Stack<>();
        Stack<Item> items12 = new Stack<>();
        Stack<Item> items21 = new Stack<>();
        Stack<Item> items22 = new Stack<>();

        populateStack(items11, "Cola", 15);
        populateStack(items12, "Fanta", 2);
        populateStack(items21, "Sprite", 1);
        populateStack(items22, "Pulpy", 5);

        scheme.put(new Coordinates(1, 1), items11);
        scheme.put(new Coordinates(1, 2), items12);
        scheme.put(new Coordinates(2, 1), items21);
        scheme.put(new Coordinates(2, 2), items22);

        itemBox = new ProductsBox(scheme);
    }

    private void populateStack(Stack<Item> stack, String name, int count) {
        for (int i = 0; i < count; i++) {
            if (name.equals("Cola")) {
                stack.push(new Cola());
            }
            if (name.equals("Sprite")) {
                stack.push(new Sprite());
            }
            if (name.equals("Fanta")) {
                stack.push(new Fanta());
            }
            if (name.equals("Pulpy")) {
                stack.push(new Pulpy());
            }
        }
    }
}