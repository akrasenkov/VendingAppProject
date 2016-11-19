package edu.androidclub.domain;

import edu.androidclub.ItemInfoScheme;

/*
* Класс, описывающий функционал базы данных - постоянного хранилища
* */
public interface Database {

    ItemInfoScheme loadScheme();
    void persistScheme(ItemInfoScheme scheme);

}
