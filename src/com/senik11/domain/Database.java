package com.senik11.domain;

import com.senik11.ItemInfoScheme;

/*
* Класс, описывающий функционал базы данных - постоянного хранилища
* */
public interface Database {

    ItemInfoScheme loadScheme();
    void persistScheme(ItemInfoScheme scheme);

}
