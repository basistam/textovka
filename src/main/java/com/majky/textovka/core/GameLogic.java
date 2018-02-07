package com.majky.textovka.core;

import com.majky.textovka.actions.Action;
import com.majky.textovka.actions.MoveAction;
import com.majky.textovka.actions.TransferItem;
import com.majky.textovka.items.Item;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameLogic {
    public void play(Player player) {
        System.out.println("\n==================\n");
        printGameStatus(player);
        List<Action> actions = generateActions(player);
        printOptions(actions);

        int chosenOption = readFromKeyboard();

        if (chosenOption > actions.size()) {
            System.out.println("Wrong entry");
        } else {
            actions.get(chosenOption - 1).execute();
        }

        play(player);
    }

    private void printGameStatus(Player player) {
        System.out.println(String.format("Room:\n %s", player.getCurrentRoom().getDescription()));
        System.out.println(String.format("Items in room:\n%s", player.getCurrentRoom().getItems().stream().map(Item::getDescription).collect(Collectors.joining("\n", " ", ""))));
        System.out.println(String.format("Inventory:\n %s", player.getItems().stream().map(Item::getDescription).collect(Collectors.joining("\n", " ", ""))));

    }

    private void printOptions(List<Action> actions) {
        System.out.println("Actions:");
        for (int i = 0; i < actions.size(); i++) {
            Action action = actions.get(i);
            System.out.println(String.format(" %2d - %s", i + 1, action.getDescription()));
        }
    }

    private int readFromKeyboard() {
        System.out.print(" > ");
        Scanner scanner = new Scanner(System.in);
        return Integer.valueOf(scanner.next());
    }

    private List<Action> generateActions(Player player) {
        List<Action> actions = new LinkedList<>();

        final Room currentRoom = player.getCurrentRoom();

        currentRoom.getPaths().forEach(path -> actions.add(new MoveAction(path.getToRoom(), player)));
        currentRoom.getItems().forEach(item -> actions.add(new TransferItem(item, currentRoom, player)));

        return actions;
    }
}
