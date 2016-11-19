package edu.androidclub.domain;

// Абстрактный класс абстрактного предмета - ему нужна реализация в виде конкретных предметов
// Он тоже неизменяемый - т.к. все поля final
public abstract class Item {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    // Получить имя
    public String getName() {
        return name;
    }
}
