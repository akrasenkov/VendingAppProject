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
    public ProductsBox(ItemInfoScheme scheme) { this.scheme = scheme; }

    // Выдать предмет по координатам
    @Override
    public Item emit(Coordinates coordinates) {
        // Получить стопку предметов на позиции
        Stack<Item> items = scheme.get(coordinates);

        // Если пусто - возвращаем пустоту
        if (items.empty())
            return new Application.Empty();

        // Возвращаем верхний элемент и удаляем его с вершины стопки
        return items.pop();
    }

    // Проверить, есть ли продукт на витрине
    @Override
    public boolean availability(String productName) {

        boolean isAvailability = false;

        for (Stack<Item> value : scheme.values()) {
            if ( !value.isEmpty() && value.peek().getName().equals(productName)){
                isAvailability = true;
                break;
            }
        }

        return isAvailability;
    }
}