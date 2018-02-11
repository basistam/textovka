package com.majky.textovka.actions;

import com.majky.textovka.persons.Person;

public class TalkAction implements Action {
    private final Person person;

    public TalkAction(Person person) {
        this.person = person;
    }

    @Override
    public void execute() {
        person.talkTo();
    }

    @Override
    public String getDescription() {
        return String.format("Talk to %s", person.getName());
    }
}
