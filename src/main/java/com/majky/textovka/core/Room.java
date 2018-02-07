package com.majky.textovka.core;

import com.majky.textovka.items.Item;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Room implements Storage {
    private final String name;
    private final String description;
    private Set<Item> items = new HashSet<Item>();
    private List<Path> paths = new LinkedList<Path>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public Set<Item> getItems() {
        return items;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
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
