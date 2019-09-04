package org.some.silly.library;

import java.util.List;

public interface ListFactory<T> {
    List<T> createList();
}
