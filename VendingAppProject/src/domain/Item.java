
package domain;

// Абстрактный класс абстрактного предмета - ему нужна реализация в виде конкретных предметов
// Он тоже неизменяемый - т.к. все поля final
public abstract class Item {
    private final String name;
    private final float price;

    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }

    // Получить имя
    public String getName() {return name;}

    public float getPrice() {return price;}
}