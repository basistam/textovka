package com.majky.textovka.items;

public class Sword implements Item {
    private String description;

    public Sword(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
