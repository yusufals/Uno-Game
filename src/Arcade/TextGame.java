package Arcade;

import Exceptions.InsufficientFundsException;
import Exceptions.InvalidCommandException;
import Exceptions.InvalidNumberOfPlayersException;
import UNO.Player;

import java.util.List;

//import Arcade.Model.Command;
//import Arcade.Model.Player;

/**
 * The interface which all text game within the arcade must implement.
 *
 * Update (2018.09.10-002) - Added methods to get the game name and game-specific help.
 *
 * @author Roger Howell
 * @version 2018.09.10-002
 */
public interface TextGame {

    String getGameName();

    void insertCoin();

    void startGame() throws InvalidNumberOfPlayersException;

    void endGame();

    String getGameState();

    String sendCommand(Command command) throws InvalidCommandException;

    void addPlayer(Player player) throws InsufficientFundsException;

    void removePlayer(Player player);

    List<Player> getPlayers();

    String getScoreboard();

    String getHelp();
}

