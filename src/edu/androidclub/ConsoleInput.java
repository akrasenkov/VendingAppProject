package edu.androidclub;

import edu.androidclub.domain.Keypad;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleInput implements Keypad {

    @Override
    public Command readCommand() {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = "";
        try {
            line = bufferedReader.readLine();
        } catch (IOException ioex) {
            System.err.println(ioex.toString());
            System.exit(0);
        }
        return getCommandByString(line);
    }

    private Command getCommandByString(String input) {
        Command result = null;
        String trimInput = input.trim();

        String[] elements = trimInput.split(" ");

        String typeStr = elements[0];

        if (typeStr.equals(Command.TYPE_GET)) {
            String dataStr = elements[1];

            int data = Integer.valueOf(dataStr);
            int x = data / 10;
            int y = data % 10;

            result = new Command(
                    Command.TYPE_GET,
                    new Coordinates(x, y)
            );
        }
        if (typeStr.equals(Command.TYPE_STOP)) {
            result = new Command(
                    Command.TYPE_STOP,
                    null
            );
        }

        return result;
    }

}
