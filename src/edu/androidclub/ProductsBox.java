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
        if (items.empty()) {
            return null;
        }

        // Возвращаем верхний элемент и удаляем его с вершины стопки
        return items.pop();
    }


    public String thereAre(Coordinates coordinates) {
        Stack<Item> items = scheme.get(coordinates);
        if (items.empty()) {
            return "Запрашиваемого предмета нет";
        }
        else{
            return "Запрашиваемый предмет есть";
        }
    }
}



















