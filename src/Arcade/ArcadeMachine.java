package Arcade;

import Exceptions.InsufficientFundsException;
import Exceptions.InvalidCommandException;
import Exceptions.InvalidNumberOfPlayersException;
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
    private Map<String, UnoGame> availableGames;
    private TextGame              currentGame;

    public ArcadeMachine() {
        this.availableGames = new HashMap<>();

        // Default available game(s) - to help with running/re-running the game.
        this.addGame("uno", new UnoGame());
    }

    /**
     * @param gameId The string that the user will need to type in to select the game.
     * @param game   The game itself.
     */
    public void addGame(String gameId, UnoGame game) {
        this.availableGames.put(gameId, game);
    }

    /**
     * This message takes in the user command and either handles it directly (interacting with the arcade machine) else passes it to the current game.
     *
     * @throws IOException
     */
    public void run() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br  = new BufferedReader(isr);

        System.out.println("Welcome to <Team Name>'s Arcade!");

        while (true) {
            System.out.println("");
            System.out.println("------");
            System.out.println("Game status: " + getStatus());
            System.out.print(">>> ");
            String commandString = br.readLine();

            Command command = new Command(commandString);
            if (command.fullCommandString().equals("exit")) {
                break;
            } else {
                try {
                    runCommand(command);
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
    private void runCommand(Command command) throws InvalidCommandException, InsufficientFundsException, InvalidNumberOfPlayersException {
        if (command.fullCommandString().equals("arcade help")) {
            // Arcade help message.
            printArcadeHelpMessage();
        } else if (command.fullCommandString().startsWith("selectGame ")) {
            // Selecting a game within the arcade.
            String[] commandParts = command.getParts();
            if (commandParts.length != 2) {
                throw new InvalidCommandException();
            }

            String selectedGameName = commandParts[1];
            if (!availableGames.containsKey(selectedGameName)) {
                throw new InvalidCommandException(
//                        "Cannot select game - unknown game: " + selectedGameName
                );
            }

//            currentGame = availableGames.get(selectedGameName);
        } else {
            // Otherwise, if not an arcade command, pass the command to the game.
            currentGame.sendCommand(command);
        }
    }


}
