package net.morher.div.bughunting.exceptions;

import java.util.List;
import org.junit.Test;
import org.some.silly.library.ListFactory;
import org.some.silly.library.UnreliableListFactory;

/**
 * In this class we are going to explore causes for NullPointerException.
 * 
 * @author Morten Hermansen
 */
public class NullPointers {
    private final ListFactory<String> listFactory = new UnreliableListFactory<>();

    /**
     * In this method we will foolishly try to use an uninitialized object. Noticed that the IDE will warn about this variable
     * being null;
     */
    @Test
    public void useUninitializedObject() {
        List<String> uninitializedList = null;

        uninitializedList.add("Whoooops!");
    }

    /**
     * In this method we are very trusty of our libraries and expect them to behave good. The {@link UnreliableListFactory} does
     * actually return null instead of a list, so this will fail as in {@link #useUninitializedObject}, but notice that we get
     * no warning from the IDE at this time.
     */
    @Test
    public void useUninitializedObjectFromOutsideSource() {
        List<String> uninitializedList = listFactory.createList();

        uninitializedList.add("Whoooops!");
    }

    /**
     * Adds one to the provided value. Notice that we take an {@link Integer} and forwards it to {@link #addOne}. However,
     * {@link #addOne} might return null. Because this method returns the primitive int, nulls are not allowed.
     * 
     * @param value
     * @return
     */
    public int increment(Integer value) {
        return addOne(value);
    }

    /**
     * In this method we are checking for null-values before performing the operation
     * 
     * @param value
     *            The value
     * @return The value plus one, or null if value was null.
     */
    public Integer addOne(Integer value) {
        if (value != null) {
            return value + 1;
        }

        return null;
    }

    /**
     * The method {@link #addOne} should handle null-input
     */
    @Test
    public void addOneToNull() {
        addOne(null);
    }

    /**
     * The method {@link #increment} can take null as input, that is not a problem. However, when {@link #addOne}
     */
    @Test
    public void incrementNull() {
        increment(null);
    }
}
