package com.majky.textovka.actions;

import com.majky.textovka.core.Storage;
import com.majky.textovka.items.Item;

public class TransferItem implements Action {
    private final Item item;
    private final Storage storageFrom;
    private final Storage storageTo;

    public TransferItem(Item item, Storage storageFrom, Storage storageTo) {
        this.item = item;
        this.storageFrom = storageFrom;
        this.storageTo = storageTo;
    }

    @Override
    public void execute() {
        storageFrom.removeItem(item);
        storageTo.addItem(item);
    }

    @Override
    public String getDescription() {
        return String.format("Take %s", item.getDescription());
    }
}
