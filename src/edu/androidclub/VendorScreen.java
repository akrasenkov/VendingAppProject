package edu.androidclub;

import edu.androidclub.domain.AppScreen;

public class VendorScreen implements AppScreen {
    @Override
    public void printText(String text) {
        String name = text.substring(0, text.lastIndexOf(" "));
        String cost = text.substring(text.lastIndexOf(" ")+1, text.length());
        System.out.println(" ____________________________________________ ");
        System.out.println("||| Name:  |||||||||||||||||||| Cost:  |||||||");
        System.out.println(" -------------------------------------------- ");
        System.out.print("||| "); System.out.printf("%-18.18s", name);
        System.out.print("||||||||| "); System.out.printf( "%-5.5s", cost); System.out.println("  |||||||");
        System.out.println(" -------------------------------------------- ");
    }

    @Override
    public void clear() {
        printText(" ");
    }
}
