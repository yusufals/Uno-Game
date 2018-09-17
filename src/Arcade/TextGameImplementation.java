package Arcade;

import Exceptions.*;
import UNO.Card;
import UNO.Player;
import UNO.UnoGame;

import java.sql.SQLOutput;
import java.util.List;


public class TextGameImplementation implements TextGame {
    UnoGame game;
    private int coins;

    public TextGameImplementation() throws OneCardAllowedException, NoCardRemainingException {

        game = new UnoGame();
    }


    public String getGameName() {

        return "Uno Game";
    }

    public void insertCoin() {
        coins++;
    }

    public void startGame() throws InvalidNumberOfPlayersException, NoCardRemainingException {
        if (game.getPlayerCount() < 2) {
            throw new InvalidNumberOfPlayersException();
        } else {
            game.giveCardsToPlayers();
        }
    }

    public void endGame() {

    }

    public void playTurn(int cardToPlay) throws NoCardRemainingException, InvalidCardException {
        game.playTurn(cardToPlay);
    }

    public String getGameState() {
        List<Player> x = game.getPlayers();
        System.out.println("Players currently in the game: " + x);
        System.out.println(game.getPlayer(game.getCurrentPlayer()) + " is the current player");

        return "Printed text";
    }

    public String sendCommand(Command command) throws InvalidCommandException {
        return null;
    }

    public void addPlayer() throws InsufficientFundsException, MaxPlayerReachedException {
        if (coins < 1) {
            throw new InsufficientFundsException();
        } else {
            game.addPlayer();
            coins--;
        }
    }

    public void removePlayer() throws MaxPlayerReachedException, InvalidNumberOfPlayersException {
        game.removePlayer();
    }

    public List<Player> getPlayers() {
        return game.getPlayers();
    }

    public String getScoreboard() {
        //Add the scores from the remaining cards of the players
        return "Final score";
    }

    public String getHelp() {
        return null;
    }

    public int getCoins() {
        return coins;
    }

    public void handOutCards() throws NoCardRemainingException {
        game.giveCardsToPlayers();
    }

    public Card showDiscard() {
        return game.getTopDiscard();
    }

    public List<Card> showPlayerHand() {
        return game.getCurrentPlayerHand();

    }

    public void getTotalCardsInPlayerHand() {
        for (int i = 0; i < game.getPlayerCount(); i++) {
            System.out.print(game.getPlayer(i)+"    - ");

            System.out.println(game.getPlayerHandSize(i) + " Cards remaining");
        }
    }

    public Player getCurrentPlayer() throws InvalidNumberOfPlayersException {

        return game.getPlayerX();
    }

    public int currentScore() throws InvalidCardException {

        return game.checkScore();
    }
}



