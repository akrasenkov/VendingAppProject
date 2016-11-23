package edu.androidclub;

import edu.androidclub.domain.AppScreen;
import edu.androidclub.domain.Item;
import edu.androidclub.domain.ItemBox;
import edu.androidclub.domain.Keypad;

import java.io.IOException;
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
        Runnable va = new VendingAutomat();
        va.run();
    }

    /*
        Метод тестирования нашего приложения.
        Здесь мы создадим случайные данные о продуктах и заполним ими наш "автомат", чтобы протестировать то, что
        уже написано
    */
    private void test() {

    }
}
