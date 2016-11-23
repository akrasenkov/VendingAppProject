package edu.androidclub.domain;

import edu.androidclub.ItemInfoScheme;

/*
* Интерфейс, представляющий собой описание функционал экрана аппарата
* */
public interface AppScreen {
    void printText(String text);
    void printItemInfo(Item item);
    void printItemsInfo(ItemInfoScheme iis);
    void clear();
}
