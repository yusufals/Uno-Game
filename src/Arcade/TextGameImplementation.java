package Arcade;

import Exceptions.*;
import UNO.Player;
import UNO.UnoGame;

import java.util.List;


public class TextGameImplementation implements TextGame {
    UnoGame game;
    private int coins;

    public TextGameImplementation() throws OneCardAllowedException, NoCardRemainingException {

        game = new UnoGame();
    }


    public String getGameName() {

        return null;
    }

    public void insertCoin() {
        coins++;
    }

    public void startGame() throws InvalidNumberOfPlayersException {
        if(game.getPlayerCount()<2){
            throw new InvalidNumberOfPlayersException();
        }

    }

    public void endGame() {

    }

    public String getGameState() {

        return null;
    }

    public String sendCommand(Command command) throws InvalidCommandException {
        return null;
    }

    public void addPlayer() throws InsufficientFundsException {
        if (coins < 1) {
            throw new InsufficientFundsException();
        } else
            try {
                game.addPlayer();
            } catch (MaxPlayerReachedException e) {
                e.printStackTrace();
                System.out.println("Maximum players has been added");
            }
    }

    public void removePlayer() throws MaxPlayerReachedException {
        game.removePlayer();
    }

    public List<Player> getPlayers() {
        return game.getPlayers();
    }

    public String getScoreboard() {
        return null;
    }

    public String getHelp() {
        return null;
    }

    public int getCoins() {
        return coins;
    }
}



