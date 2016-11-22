package edu.androidclub;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;
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
    public String emit(Coordinates coordinates) {
        // Получить стопку предметов на позиции
        Stack<Item> items = scheme.get(coordinates);
        if (items.empty()) {
            return "нет в наличии" + "\n----------------------------";
        }

        // Возвращаем верхний элемент и удаляем его с вершины стопки
        return items.pop().getName() + "\n----------------------------";
    }
    @Override
    public String check(Coordinates coordinates) {
        Stack<Item> items = scheme.get(coordinates);
        if (items.empty()) {
            return "нет в наличии" + "\n----------------------------";
        }
        else {
            return "в наличии, цена " + items.peek().getCost() + "\n----------------------------";
        }
        }
    }
















