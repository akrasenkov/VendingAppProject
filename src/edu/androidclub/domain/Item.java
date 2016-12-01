package edu.androidclub.domain;

import edu.androidclub.items.Cola;
import edu.androidclub.items.Fanta;
import edu.androidclub.items.Pulpy;
import edu.androidclub.items.Sprite;

// Абстрактный класс абстрактного предмета - ему нужна реализация в виде конкретных предметов
// Он тоже неизменяемый - т.к. все поля final
public abstract class Item {
    private final String name;
    private final int cost;

    public Item(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    // Получить имя
    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public static Item forNameAndCost(String name, int cost) {
        switch (name) {
            case "Cola" : return new Cola(cost);
            case "Fanta" : return new Fanta(cost);
            case "Pulpy" : return new Pulpy(cost);
            case "Sprite" : return new Sprite(cost);
        }
        return null;
    }
}
