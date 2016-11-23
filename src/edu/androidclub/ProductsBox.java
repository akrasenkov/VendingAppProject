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
       if(hasItem(items)) {
            // Возвращаем верхний элемент и удаляем его с вершины стопки
            return items.pop();

        }
        Item noItem = new noItem();
        return noItem;
    }

    @Override
    public boolean hasItem(Stack<Item> items) {
        if(items.empty()) {
            return false;
        }
        return true;
    }

    public static class noItem extends Item{
       public noItem(){
            super("There is no items", 0);
        }
    }
}
















