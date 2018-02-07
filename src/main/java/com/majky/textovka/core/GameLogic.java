package com.majky.textovka.core;

import com.majky.textovka.actions.Action;
import com.majky.textovka.actions.MoveAction;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
            executeAction(actions.get(chosenOption - 1), player);
        }

        play(player);
    }

    private void executeAction(Action action, Player player) {
        if (action instanceof MoveAction) {
            ((MoveAction) action).execute(player);
        }
    }

    private void printGameStatus(Player player) {
        System.out.println(String.format("Room:\n %s", player.getCurrentRoom().getDescription()));
        System.out.println(String.format("Inventory:\n %s", player.getInventory()));

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

        player.getCurrentRoom().getPaths().forEach(path -> actions.add(new MoveAction(path.getToRoom())));

        return actions;
    }
}
