package edu.androidclub;

import edu.androidclub.domain.Item;
import edu.androidclub.domain.ItemBox;

import java.util.Stack;

/*
    Реализация витрины аппарата
* */
public class ProductsBox implements ItemBox {

    private ItemInfoScheme scheme;

    // Требует схему при создании
    public ProductsBox(ItemInfoScheme scheme) {
        this.scheme = scheme;
    }

    // Выдать предмет по координатам
    @Override
    public Item emit(Coordinates coordinates) {
        // Получить стопку предметов на позиции
        Stack<Item> items = scheme.get(coordinates);

        // Если пусто - возвращаем пустоту
            return items.pop();
    }

    public boolean Check(Coordinates coordinates) {
        Stack<Item> items = scheme.get(coordinates);
        if (items.empty()) {
            return false;
        }
        return true;
    }
}
















