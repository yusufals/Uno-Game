package Arcade;

import Exceptions.*;
import UNO.UnoGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * A class used to run a text-based arcade machine.
 *
 * @author Roger Howell
 * @version 2018.09.10-001
 */
public class ArcadeMachine {

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    private Map<String, UnoGame> availableGames;
    private TextGame currentGame;

    public ArcadeMachine() throws NoCardRemainingException, OneCardAllowedException {
        currentGame = new TextGameImplementation();
        this.availableGames = new HashMap<>();

        // Default available game(s) - to help with running/re-running the game.
        this.addGame("Uno Game", new UnoGame());
    }

    /**
     * @param gameId The string that the user will need to type in to select the game.
     * @param game   The game itself.
     */
    private void addGame(String gameId, UnoGame game) {
        this.availableGames.put(gameId, game);
    }

    /**
     * This message takes in the user command and either handles it directly (interacting with the arcade machine) else passes it to the current game.
     *
     * @throws IOException
     */
    public void run() throws IOException, InvalidCardException, MaxPlayerReachedException, NoCardRemainingException {

        System.out.println("Welcome to Sarah, Abdullah and Marin's Arcade!");

        while (true) {
            System.out.println("Please type: 'Arcade help' to get help");
            System.out.println("");
            System.out.println("------");
            System.out.println("Game status: " + getStatus());
            System.out.print(">>> ");

            String commandString = br.readLine();


            Command command = new Command(commandString);
            if (command.equals("exit")) {
                break;
            } else {
                try {
                    runCommand(commandString);
                } catch (InsufficientFundsException e) {
                    System.out.println("Not enough funds.");
                } catch (InvalidCommandException e) {
                    System.out.println("Invalid Command.");
                    printArcadeHelpMessage();
                } catch (InvalidNumberOfPlayersException e) {
                    System.out.println("Cannot start the game with the current number of players.");
                }


            }
        }
    }

    /**
     * Prints out the arcade's help message.
     */
    private void printArcadeHelpMessage() {
        System.out.println("Arcade Commands:");
        System.out.println("arcade help            : help using the arcade");
        System.out.println("selectGame <game name> : select a given game");
        System.out.println("insert coin            : to insert a coin");
        System.out.println("add player             : to add a player");
        System.out.println("setup game             : after adding players");
        System.out.println("start game             : when you are ready to play");
        System.out.println("exit                   : exit the arcade");
        System.out.println("");
        System.out.println("Available Games: ");
        for (String gameName : availableGames.keySet()) {
            System.out.println("  - " + gameName);
        }

        System.out.println("");
        System.out.println("Game Commands: ");
        if (currentGame != null) {
            System.out.println(currentGame.getHelp());
        } else {
            System.out.println("No game selected. Select a game for game-specific commands.");
        }
    }

    /**
     * @return A string showing which game is being played.
     */
    private String getStatus() {
        if (currentGame == null) {
            return "No game selected.";
        } else {
            return "Currently playing: " + currentGame.getGameName();
        }
    }


    /**
     * @param command
     * @throws InvalidCommandException
     * @throws InsufficientFundsException
     * @throws InvalidNumberOfPlayersException
     */
    private void runCommand(String command) throws InvalidCommandException, InsufficientFundsException, InvalidNumberOfPlayersException, IOException, InvalidCardException, NoCardRemainingException, MaxPlayerReachedException {
        if (command.equals("arcade help")) {
            // Arcade help message.
            printArcadeHelpMessage();
        } else if (command.equals(("insert coin"))) {
            currentGame.insertCoin();
            System.out.println("one coin has been inserted");
            System.out.println("currently you have: " + currentGame.getCoins() + " coins");
        } else if (command.equals("add player")) {
            currentGame.addPlayer();
            System.out.println("There are currently:  " + currentGame.getPlayers() + "players in the game");
        } else if (command.equals("setup game")) {

            currentGame.startGame();

        } else if (command.equalsIgnoreCase("start game")) {
            boolean isGameRunning = true;
            while (isGameRunning) {

                System.out.println("Players in the game " + currentGame.getPlayers());
                currentGame.getTotalCardsInPlayerHand();
                System.out.println("Last visible card is " + currentGame.showDiscard());

                System.out.println("You are player : " + currentGame.getCurrentPlayer() +
                        " and your cards are: " + currentGame.showPlayerHand());

                System.out.println("Please select the card number you'd like to play," +
                        " 0 is the far left, and increments by one");
                String cardNumber = br.readLine();
                if (cardNumber.equalsIgnoreCase("exit")) {
                    isGameRunning = false;
                } else {
                    try {
                        int number = Integer.parseInt(cardNumber);
                        currentGame.playTurn(number);
                    } catch (InvalidCardException e) {
                        System.out.println("Invalid card");
                    } catch (NoCardRemainingException e) {
                        e.printStackTrace();
                    }

                }

            }

        }


    }
}






