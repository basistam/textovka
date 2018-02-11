package com.majky.textovka.core;

import com.majky.textovka.items.Sword;
import com.majky.textovka.persons.BasicPerson;
import com.majky.textovka.persons.Person;

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
        Person zid = new BasicPerson("Zid", "Strasny zid");

        startingRoom.addPath(new Path(anotherRoom));
        anotherRoom.addPath(new Path(startingRoom));
        anotherRoom.addItem(new Sword("Mec, brutalny"));
        anotherRoom.addPerson(zid);

        player.setCurrentRoom(startingRoom);
    }
}
