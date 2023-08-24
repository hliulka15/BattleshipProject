package InterfaceExample;

import java.util.*;

public class SortingExample {

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<Item>();
        Item item1 = new Item(10,20);
        Item item2 = new Item(20,30);
        Item item3 = new Item(15,20);
        items.add(item1);
        items.add(item2);
        items.add(item3);

        //how do we compare items
        Collections.sort(items);
        for(Item item : items){
            System.out.println("item value: " + item.getValue() + " item weight: " + item.getWeight());
        }
    }
    
}
