package edu.androidclub;

import edu.androidclub.domain.AppScreen;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by Владислав on 22.11.2016.
 */
public class Monitor implements AppScreen {
    private final PrintStream ps = System.out;

    public void printText(String text){
        ps.println("|-------------------------------|" + "\n" + "| " +text + "|" + "\n" + "|-------------------------------|");
    }

    public void clear(){

        for(int i = 0; i < 30 ; i++){
            ps.println(" ");
        }

    }
}
