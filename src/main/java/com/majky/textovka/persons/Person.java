package com.majky.textovka.persons;

import com.majky.textovka.core.Storage;

public interface Person extends Storage {
    String getName();

    String getStory();

    boolean talkedTo();

    void talkTo();
}
