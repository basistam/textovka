package com.majky.textovka.persons;

import com.majky.textovka.items.Item;

import java.util.HashSet;
import java.util.Set;

public class BasicPerson implements Person {
    private Set<Item> list = new HashSet<>();
    private final String description;
    private final String name;
    private boolean talkedTo;

    public BasicPerson(String description, String name) {
        this.description = description;
        this.name = name;

        talkedTo = false;
    }

    @Override
    public Set<Item> getItems() {
        return list;
    }

    @Override
    public void addItem(Item item) {
        list.add(item);
    }

    @Override
    public void removeItem(Item item) {
        list.remove(item);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getStory() {
        return description;
    }

    @Override
    public boolean talkedTo() {
        return talkedTo;
    }

    @Override
    public void talkTo() {
        talkedTo = true;
    }
}
