package com.majky.textovka.core;

import com.majky.textovka.items.Item;

import java.util.Set;

public interface Storage {
    Set<Item> getItems();

    void addItem(Item item);

    void removeItem(Item item);
}
