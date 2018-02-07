package com.majky.textovka.core;

import com.majky.textovka.items.Item;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private Set<Item> inventory = new HashSet<Item>();

    private Room currentRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void putInInventory(Item item) {
        inventory.add(item);
    }

    public void removeFromInventory(Item item) {
        inventory.remove(item);
    }

    public Set<Item> getInventory() {
        return inventory;
    }
}
