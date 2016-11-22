package edu.androidclub;

import edu.androidclub.domain.AppScreen;

import java.util.StringJoiner;

/**
 * Created by WinDA on 22.11.2016.
 */
public class Screen implements AppScreen{
    String notice;

    public Screen(){
        setNotice("Купи еду");
    }
/*
    [Сообщение]

    |----------|----------|
    |Спрайт[65]|          |
    |----------|----------|
    |Фанта[55] |          |
    |----------|----------|
    */

    @Override
    public void update(ItemInfoScheme scheme) {
        clear();
        System.out.println(getNotice()); // Текст сверху

        // Определяем размеры прямоугольника и ячейки
        int maxRow = 0;
        int maxCol = 0;
        int minRow = 0;
        int minCol = 0;
        int maxLength = 1;
        for(Coordinates i: scheme.keySet()){
            // ищем наибольшую и наименьшую Y
            if(i.getColumn() > maxCol){
                maxCol = i.getColumn();
            }
            else if(i.getColumn() < minCol){
                minCol = i.getColumn();
            }

            // ищем наибольший и наименьший X
            if(i.getRow() > maxRow){
                maxRow = i.getRow();
            }
            else if(i.getRow() < minRow){
                minRow = i.getRow();
            }

            if(scheme.get(i) != null && scheme.get(i).size() > 0){
                if(scheme.get(i).lastElement().getName().length() > maxLength){
                    maxLength = scheme.get(i).lastElement().getName().length();
                }
            }
        }

        maxLength += 10; // Добавить места для цены и количества

        String emptyCell = multiply(" ", maxLength);

        // Начинаем рисование
        String barrier = "|" + multiply("-", maxLength);
        System.out.print(multiply(barrier, maxCol - minCol));
        System.out.println("|");
        for(int i = minRow; i <= maxRow; i++){
            for(int j = minCol; j <= maxCol; j++){
                System.out.print("|");

                Coordinates coordinates = new Coordinates(i, j);

                if(scheme.get(coordinates) != null && scheme.get(coordinates).size() > 0){
                    String name = scheme.get(coordinates).lastElement().getName();
                    int cost = scheme.get(coordinates).lastElement().getCost();
                    int amount = scheme.get(coordinates).size();

                    //Это костыль для красоты
                    int s1 = ("" + cost).length();
                    int s2 = ("" + amount).length();

                    System.out.print(name + "[" + cost + "]" + "(" + amount + ")" + multiply(" ", maxLength - name.length() - 4 - s1 - s2));
                }
                else{
                    System.out.print(emptyCell);
                }
            }
            System.out.println("|");
            System.out.print(multiply(barrier, maxCol - minCol));
            System.out.println("|");
        }
    }

    @Override
    public void setNotice(String text) {
        this.notice = "   [" + text + "]";
    }

    @Override
    public String getNotice() {
        return this.notice;
    }

    @Override
    public void clear() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    private String multiply(String s, int amount){
        String res = new String(s);
        for(int j = 0; j < amount; j++){
            res = res + s;
        }
        return res.toString();
    }

}
