package edu.androidclub;

import edu.androidclub.domain.Item;

public class ScreenInput
{
    static public void clear()
    {
        for (int i=0; i<50 ; i++)
            System.out.println();
    }

    static public void  printItemInfo(Item item)
    {
        System.out.print("|      №      "+item.getNumber());
        System.out.println(Spaces(18-Integer.toString(item.getNumber()).length())+'|');
        System.out.print("|      Товар:  "+item.getName());
        System.out.println(Spaces(18-item.getName().length())+'|');
        System.out.print("|      Цена:   "+item.getPrice());
        System.out.println(Spaces(18-Float.toString(item.getPrice()).length())+'|');
        System.out.println("+--------------------------------+");
    }

    static private String Spaces(int n)
    {
        String s = new String();
        for (int i=0;i<n;i++)
        {
            s=s+" ";
        }
        return s;
    }
    static public void printText(String text)
    {
        System.out.println(text);
    }

    static public void printItemsInfo(ItemInfoScheme iis)
    {
        System.out.println();
    };
}
