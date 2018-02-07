package com.majky.textovka.actions;

import com.majky.textovka.core.Player;
import com.majky.textovka.core.Room;

public class MoveAction implements Action<Player> {
    private final Room toRoom;

    public MoveAction(Room toRoom) {
        this.toRoom = toRoom;
    }

    public void execute(Player player) {
        player.setCurrentRoom(toRoom);
    }

    @Override
    public String getDescription() {
        return String.format("Move to room %s", toRoom.getName());
    }
}
