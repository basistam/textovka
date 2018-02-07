package com.majky.textovka.actions;

public interface Action<T> {
    void execute(T subject);

    String getDescription();
}
