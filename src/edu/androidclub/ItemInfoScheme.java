package edu.androidclub;

import edu.androidclub.domain.Item;

import java.util.HashMap;
import java.util.Stack;

/*
 Класс, представляющий собой схему наших предметов на витрине.
 Наследуем его от *то, что после extends*, чтобы каждый раз не писать это *то, что после extends*
 HashMap - хеш-карта - хранилище вида ключ->значение
* */
public class ItemInfoScheme extends HashMap<Coordinates, Stack<Item>> {
}
