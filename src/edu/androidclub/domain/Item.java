package edu.androidclub.domain;

// Абстрактный класс абстрактного предмета - ему нужна реализация в виде конкретных предметов
// Он тоже неизменяемый - т.к. все поля final
public abstract class Item {
    private final String name;
    private final Integer cost;

    public Item(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    // Получить имя
    public String getName() {
        return name;
    }
    //Получить цену
    public Integer getCost() {
        return cost;
    }
}
