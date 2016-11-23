package edu.androidclub.domain;

import edu.androidclub.Coordinates;

import java.util.Stack;

/*
    Интерфейс, описывающий функционал (что умеет) нашей витрины (коробки с продуктами)
* */
public interface ItemBox {

    /* Выдать предмет по его координатам */
    Item emit(Coordinates coordinates);
    boolean hasItem(Stack<Item> items);

}
