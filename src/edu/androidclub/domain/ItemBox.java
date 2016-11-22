package edu.androidclub.domain;

import edu.androidclub.Coordinates;

/*
    Интерфейс, описывающий функционал (что умеет) нашей витрины (коробки с продуктами)
* */
public interface ItemBox {

    /* Выдать предмет по его координатам */
    String emit(Coordinates coordinates);
    /*Проверка наличия предмета*/
    String check(Coordinates coordinates);

}
