package com.senik11.domain;

import com.senik11.Coordinates;

/*
    Интерфейс, описывающий функционал (что умеет) нашей витрины (коробки с продуктами)
* */
public interface ItemBox {

    /* Выдать предмет по его координатам */
    Item emit(Coordinates coordinates);

}
