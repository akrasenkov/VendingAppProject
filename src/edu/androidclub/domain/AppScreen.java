package edu.androidclub.domain;

/*
* Интерфейс, представляющий собой описание функционал экрана аппарата
* */
public interface AppScreen {
    void printText(Item text);
    void printText(boolean isAviable);
    void clear();
}
