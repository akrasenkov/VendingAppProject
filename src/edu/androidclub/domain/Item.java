package edu.androidclub.domain;

// Абстрактный класс абстрактного предмета - ему нужна реализация в виде конкретных предметов
// Он тоже неизменяемый - т.к. все поля final
public abstract class Item {
    private final String name;
    private final int number;
    private final float price;

    public Item(int number, String name, float price)
    {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    // Получить имя
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public float getPrice() {
        return price;
    }
}
