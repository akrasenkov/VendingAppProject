

import edu.androidclub.domain.AppScreen;
import edu.androidclub.domain.Item;


public class ScreenOutput implements AppScreen
{

    static public void printText(String text)
    {
        System.out.println(text);
    }

    static public void clear()
    {
        for(int i = 0; i < 50; i++)
        {
            System.out.println();
        }

    }

    static public void printItemInfo(Item item)
    {
        System.out.println("Выдан товар: " + item.getName() + " по цене - " + item.getPrice());
    }


}