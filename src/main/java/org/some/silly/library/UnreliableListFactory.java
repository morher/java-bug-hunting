package org.some.silly.library;

import java.util.List;

public class UnreliableListFactory<T> implements ListFactory<T> {

    @Override
    public List<T> createList() {
        // This implementation is really naughty...
        return null;
    }

}
