package edu.androidclub;

import edu.androidclub.domain.AppScreen;
import edu.androidclub.domain.Item;

public class PrintInfo implements AppScreen {

    // Информация после покупки товара
    @Override
    public void printText(Item item) {
        System.out.println("[Товар]: " + item.getName());
        System.out.println("[Цена]: " + item.getPrice());
    }

    @Override
    public void printText(boolean isAviable) {
        System.out.println("==============================================");
        System.out.println("[В наличии]: " + (isAviable ? "Да" : "Нет"));
    }

    @Override
    public void clear() {
        for(int i = 60; i > 0; i--)
            System.out.println();
    }

}
