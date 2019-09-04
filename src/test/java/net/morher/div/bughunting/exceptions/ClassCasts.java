package net.morher.div.bughunting.exceptions;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ClassCasts {

    @Test
    public void thisWillWork() {
        List<String> list = new ArrayList<>();

        ArrayList<String> arrayList = (ArrayList<String>) list;

        arrayList.add("Yey!");
    }

    public List<String> createExplodingList() {
        List<String> list = new ArrayList<>();

        // Adding a String is fine...
        list.add("Yey!");

        // No problem casting to a type higher in the hierarchy...
        Object obj = list;

        // No problem casting back, but with wrong generic type...
        List<Integer> integerList = (List<Integer>) obj;

        // No problem adding an int...
        integerList.add(42);

        return list;
    }

    @Test
    public void useStringFromExplodingList() {
        List<String> list = createExplodingList();

        String firstItem = list.get(0);

        System.out.println(firstItem);
    }

    @Test
    public void useSecondItemFromExplodingList() {
        List<String> list = createExplodingList();

        // Whoops... Second item is not a String...
        String secondItem = list.get(1);

        System.out.println(secondItem);
    }

}
