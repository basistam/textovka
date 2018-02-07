package com.majky.textovka.core;

import com.majky.textovka.items.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Room {
    private final String name;
    private final String description;
    private List<Item> items = new ArrayList<Item>();
    private List<Path> paths = new LinkedList<Path>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addPath(Path path) {
        paths.add(path);
    }

    public List<Path> getPaths() {
        return paths;
    }

    public String getName() {
        return name;
    }
}
