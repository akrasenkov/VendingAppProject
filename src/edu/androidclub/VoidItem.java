package edu.androidclub;

import edu.androidclub.domain.Item;

/**
 * Created by WinDA on 22.11.2016.
 */
// пустой предмет
public class VoidItem extends Item {
    public VoidItem() {
        super("Пустота", 0); // Вызов конструктора класса-родителя (класса Item)
    }
}
