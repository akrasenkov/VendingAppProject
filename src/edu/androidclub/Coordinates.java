package edu.androidclub;

import java.util.Objects;

/*
    Класс, представляющий собой координаты в сетке предметов.
    Все поля ФИНАЛЬНЫЕ - класс НЕИЗМЕНЯЕМЫЙ (immutable)
*/
public class Coordinates {

    private final int row;
    private final int column;

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    /*
        Далее идут методы, необходимые для хранения в HashMap - пока можно просто скопировать
    */

    // Метод, проверяющий совпадения объекта "o" с текущим
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return row == that.row &&
                column == that.column;
    }

    // Метод, получение хеш-кода текущего объекта
    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
