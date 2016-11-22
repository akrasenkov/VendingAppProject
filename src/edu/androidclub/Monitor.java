package edu.androidclub;

import edu.androidclub.domain.AppScreen;

/**
 * Created by Владислав on 22.11.2016.
 */
public class Monitor implements AppScreen {

    public void printText(String text){
        System.out.println(text);
    }

    public void clear(){

        for(int i = 0; i < 30 ; i++){
            System.out.println(" ");
        }

    }
}
