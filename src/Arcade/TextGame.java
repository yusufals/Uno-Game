package Arcade;

import Exceptions.InsufficientFundsException;
import Exceptions.InvalidCommandException;
import Exceptions.InvalidNumberOfPlayersException;
import Exceptions.MaxPlayerReachedException;
import UNO.Player;

import java.util.List;

/**
 * The interface which all text game within the arcade must implement.
 * <p>
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

    void addPlayer() throws InsufficientFundsException;

    void removePlayer() throws MaxPlayerReachedException;

    List<Player> getPlayers();

    String getScoreboard();

    String getHelp();
}

