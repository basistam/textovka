package com.majky.textovka.core;

import com.majky.textovka.items.Item;

public class Path {
    private final Room toRoom;
    private final Item protectedBy;

    /**
     * Creates unprotected path between rooms
     * @param toRoom
     */
    public Path(Room toRoom) {
        this.toRoom = toRoom;
        this.protectedBy = null;
    }

    /**
     * Creates path between rooms only accessible while owning specific item
     * @param toRoom
     * @param protectedBy
     */
    public Path(Room toRoom, Item protectedBy) {
        this.toRoom = toRoom;
        this.protectedBy = protectedBy;
    }

    public boolean isProtected() {
        return protectedBy != null;
    }

    public Room getToRoom() {
        return toRoom;
    }

    public Item getProtectedBy() {
        return protectedBy;
    }
}
