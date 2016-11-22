package edu.androidclub.domain;

import edu.androidclub.ItemInfoScheme;

/*
* Интерфейс, представляющий собой описание функционал экрана аппарата
* */
public interface AppScreen {
    String notice = "";
    void setNotice(String s);
    String getNotice();
    void update(ItemInfoScheme scheme);
    void clear();
}
