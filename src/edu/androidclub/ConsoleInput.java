package edu.androidclub;

import edu.androidclub.domain.Keypad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleInput implements Keypad {

    @Override
    public String readCommand() {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = "";
        try {
            line = bufferedReader.readLine();
        } catch (IOException ioex) {
            System.err.println(ioex.toString());
        }
        return line;
    }

}
