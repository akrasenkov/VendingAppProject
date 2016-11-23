package edu.androidclub;

import edu.androidclub.domain.Item;
import edu.androidclub.domain.ItemBox;

import java.util.Stack;

/*
    Главный класс нашей программы - представляет собой само приложение.
    Реализуем интерфейс Runnable - обозачаем, что этот класс (наше приложение) ЗАПУСКАЕМО,
    или имеет метод run()
*/
public class Application implements Runnable {


    /*
        Храним статический экземпляр нашего приложения
    */
    private static Application app;

    /*
        Точка входа в ПРОГРАММУ
    */
    public static void main(String[] args) {
        // Создаем экземпляр приложения в статической переменной и запускаем его
        app = new Application();
        app.run();
    }

    /*
        С помощью этого метода мы в любом участке кода (тк public static) можем получить наше приложение,
        причём полученный экземпляр будет ОДИНАКОВЫМ ДЛЯ КАЖДОГО ВЫЗОВА МЕТОДА

        (паттерн Singleton)
    */
    public static Application getInstance() {
        if (app == null) { // Если не создан - создаём
            app = new Application();
        }
        return app;
    }

    /*
        Метод запуска приложения как объекта. Определён интерфейсом
    */
    @Override
    public void run() {
        test();
    }

    /*
        Метод тестирования нашего приложения.
        Здесь мы создадим случайные данные о продуктах и заполним ими наш "автомат", чтобы протестировать то, что
        уже написано
    */
    private void test() {
        // Создадим схему продуктов (пустую)
        ItemInfoScheme itemScheme = new ItemInfoScheme();
        // Создадим наборы продуктов для ячеек схемы (пустые)
        Stack<Item> colas = new Stack<>(); // 1
        Stack<Item> sprites = new Stack<>(); // 2

        // Заполним наши наборы продуктами
        colas.push(new Cola());
        colas.push(new Cola());
        colas.push(new Cola());
        sprites.push(new Sprite());
        sprites.push(new Sprite());

        // Создадим объекты-координаты наших наборов продуктов в схеме
        Coordinates colaCors = new Coordinates(1, 1);
        Coordinates spriteCors = new Coordinates(1, 2);

        // Поместии наборы продуктов в схему
        itemScheme.put(colaCors, colas);
        itemScheme.put(spriteCors, sprites);

        // Создадим нашу витрину (коробку продуктов) на основании схемы
        ItemBox itemBox = new ProductsBox(itemScheme);
        // Создадим экран
        VendorScreen screen = new VendorScreen();

        // Протестируем схему - заставим витрину выдавать объекты на заданных координатах
        System.out.println( // Напечатать в консоль
                itemBox.emit( // Выдать предмет
                        new Coordinates(1, 1) // Указываем координату
                )
                .getName() // Получить имя предмета
        ); // OK
        //Выведем информацию о выдоваемом предмете на экран
        screen.printText(itemBox.emit(new Coordinates(1, 1)).toString());
        screen.printText(itemBox.emit(new Coordinates(1, 1)).toString());
        screen.printText(itemBox.emit(new Coordinates(1, 1)).toString());
        screen.printText(itemBox.emit(new Coordinates(1, 1)).toString());
        screen.printText(itemBox.emit(new Coordinates(1, 1)).toString());

    }

    // Опишем Колу как подкласс Предмета
    public static class Cola extends Item {
        public Cola() {
            super("Cola", 10); // Вызов конструктора класса-родителя (класса Item)
        }
    }

    // Опишем Спрайт как подкласс Предмета
    public static class Sprite extends Item {
        public Sprite() {
            super("Sprite", 10);
        }
    }
}
