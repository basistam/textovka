package com.majky.textovka.core;

import com.majky.textovka.items.Sword;

public class Game {
    private Player player;
    private GameLogic gameLogic = new GameLogic();

    public void start() {
        resetGame();

        gameLogic.play(player);
    }

    private void resetGame() {
        player = new Player();

        setUpWorld();
    }

    private void setUpWorld() {
        Room startingRoom = new Room("Nadvorie", "Nadvorie hradu.");
        Room anotherRoom = new Room("Predsien", "Miestnost, kamenne steny");

        startingRoom.addPath(new Path(anotherRoom));
        anotherRoom.addPath(new Path(startingRoom));
        anotherRoom.addItem(new Sword("Mec, brutalny"));

        player.setCurrentRoom(startingRoom);
    }
}
