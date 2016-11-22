package edu.androidclub;

import edu.androidclub.domain.Item;
import edu.androidclub.domain.ItemBox;

import java.util.Stack;

/*
    Реализация витрины аппарата
* */
public class ProductsBox implements ItemBox {

    private ItemInfoScheme scheme;
    private VoidItem voidItem;
    public Screen screen;


    // Требует схему при создании
    public ProductsBox(ItemInfoScheme scheme) {
        this.scheme = scheme;
        this.voidItem = new VoidItem();
        this.screen = new Screen();
        screen.update(scheme);
    }

    private Stack getItems(Coordinates coordinates){
        try{
            Stack<Item> items = scheme.get(coordinates);
            return items;
        }
        // неверные координаты
        catch(NullPointerException e){
            screen.setNotice("Ошибка!");
            screen.update(scheme);
            return null;
        }
    }

    // Выдать предмет по координатам
    @Override
    public Item emit(Coordinates coordinates) {
        // Получить стопку предметов на позиции
        Stack<Item> items = getItems(coordinates);
        if (this.amount(coordinates) > 0) {
            // Возвращаем верхний элемент и удаляем его с вершины стопки
            Item top = items.pop();
            screen.setNotice("продан " + top.getName() + " на (" + coordinates.getRow() + ", " + coordinates.getColumn() + ") за " + top.getCost() + " денег");
            screen.update(scheme);
            return top;

        }
        else if(this.amount(coordinates) == -1){
            screen.setNotice("Обращение к несуществующей/пустой ячейке");
            screen.update(scheme);
            return voidItem;
        }
        else{
            // Вернуть пустой предмет? о_О
            // Тут возникла проблема, т.к. вне зависимости от условий мы вызываем метод getName()
            // и я не знал, как вырутиться
            // Мне кажется, я сделал костыль
            screen.setNotice("Ячейка (" + coordinates.getRow() + ", " + coordinates.getColumn() + ") пуста!");
            screen.update(scheme);
            return voidItem;
        }
    }

    @Override
    public int amount(Coordinates coordinates) {
        // Получить стопку предметов на позиции
        Stack<Item> items = getItems(coordinates);
        if(items != null) {
            // Вернуть количество
            return items.size();
        }
        else{
            return -1;
        }
    }


}
















