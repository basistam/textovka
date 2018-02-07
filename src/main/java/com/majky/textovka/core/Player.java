package com.majky.textovka.core;

import com.majky.textovka.items.Item;

import java.util.HashSet;
import java.util.Set;

public class Player implements Storage {
    private Set<Item> inventory = new HashSet<>();

    private Room currentRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public Set<Item> getItems() {
        return inventory;
    }

    @Override
    public void addItem(Item item) {
        inventory.add(item);
    }

    @Override
    public void removeItem(Item item) {
        inventory.remove(item);
    }
}
