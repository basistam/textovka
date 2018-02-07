package com.majky.textovka.actions;

import com.majky.textovka.core.Player;
import com.majky.textovka.core.Room;

public class MoveAction implements Action {
    private final Room toRoom;
    private final Player player;

    public MoveAction(Room toRoom, Player player) {
        this.toRoom = toRoom;
        this.player = player;
    }

    public void execute() {
        player.setCurrentRoom(toRoom);
    }

    @Override
    public String getDescription() {
        return String.format("Move to room %s", toRoom.getName());
    }
}
