package edu.androidclub.domain;

import edu.androidclub.ItemInfoScheme;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
* Класс, описывающий функционал базы данных - постоянного хранилища
* */
public interface Database {

    ItemInfoScheme loadScheme() throws IOException;
    void persistScheme(ItemInfoScheme scheme) throws IOException;

}