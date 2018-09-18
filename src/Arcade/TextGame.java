package Arcade;

import Exceptions.*;
import UNO.Card;
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

    void startGame() throws InvalidNumberOfPlayersException, NoCardRemainingException;

    void endGame();

    String getGameState();

    String sendCommand(Command command) throws InvalidCommandException;

    void addPlayer() throws InsufficientFundsException, MaxPlayerReachedException;

    void removePlayer() throws MaxPlayerReachedException, InvalidNumberOfPlayersException;

    List<Player> getPlayers();
    void giveCardsToNewPlayer() throws NoCardRemainingException;
    boolean getStartGame();

    String getScoreboard() throws InvalidCardException;
    Card showDiscard();
    String getHelp();
    List<Card> showPlayerHand();
    void getTotalCardsInPlayerHand();

    void handOutCards() throws NoCardRemainingException;

    int getCoins();
    void playTurn(int cardToPlay) throws NoCardRemainingException, InvalidCardException;
    Player getCurrentPlayer() throws InvalidNumberOfPlayersException;
    int currentScore() throws InvalidCardException;
}

