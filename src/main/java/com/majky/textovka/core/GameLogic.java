package com.majky.textovka.core;

import com.majky.textovka.actions.Action;
import com.majky.textovka.actions.MoveAction;
import com.majky.textovka.actions.TalkAction;
import com.majky.textovka.actions.TransferItem;
import com.majky.textovka.items.Item;
import com.majky.textovka.persons.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameLogic {

    private static final Collector<CharSequence, ?, String> COLLECTOR = Collectors.joining("\n", " ", "");

    public void play(Player player) {
        System.out.println("\n==================\n");
        printGameStatus(player);
        List<Action> actions = generateActions(player);
        printOptions(actions);

        int chosenOption = readFromKeyboard();

        if (chosenOption == 0) {
            return;
        }

        if (chosenOption > actions.size()) {
            System.out.println("Wrong entry");
        } else {
            actions.get(chosenOption - 1).execute();
        }

        play(player);
    }

    private void printGameStatus(Player player) {
        Room currentRoom = player.getCurrentRoom();
        System.out.println(String.format("Room:\n %s", currentRoom.getDescription()));
        if (currentRoom.getItems().size() > 0) {
            printList("Items", currentRoom.getItems().stream().map(Item::getDescription));
        }
        if (player.getItems().size() > 0) {
            printList("Inventory", player.getItems().stream().map(Item::getDescription));
        }
        if (currentRoom.getPersons().size() > 0) {
            printList("Persons", currentRoom.getPersons().stream().map(Person::getName));
        }
    }

    private void printList(String listName, Stream<String> stream) {
        System.out.println(String.format("%s:\n%s", listName, stream.collect(COLLECTOR)));
    }

    private void printOptions(List<Action> actions) {
        System.out.println("Actions:");
        for (int i = 0; i < actions.size(); i++) {
            Action action = actions.get(i);
            System.out.println(String.format(" %d - %s", i + 1, action.getDescription()));
        }
        System.out.println("\n 0 - End Game");
    }

    private int readFromKeyboard() {
        System.out.print("\n> ");
        Scanner scanner = new Scanner(System.in);
        return Integer.valueOf(scanner.next());
    }

    private List<Action> generateActions(Player player) {
        List<Action> actions = new LinkedList<>();

        final Room currentRoom = player.getCurrentRoom();

        currentRoom.getPaths().forEach(path -> actions.add(new MoveAction(path.getToRoom(), player)));
        currentRoom.getItems().forEach(item -> actions.add(new TransferItem(item, currentRoom, player)));
        currentRoom.getPersons().stream().filter(person -> !person.talkedTo()).forEach(person -> actions.add(new TalkAction(person)));

        return actions;
    }
}
