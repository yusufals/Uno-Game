package Arcade;

import Exceptions.*;
import UNO.Player;
import UNO.UnoGame;

import java.util.List;

public class TextGameImplementation implements TextGame {
    UnoGame game;

    public TextGameImplementation() throws OneCardAllowedException, NoCardRemainingException {

        game = new UnoGame();
    }


    public String getGameName() {

        return null;
    }

    public void insertCoin() {

    }

    public void startGame() throws InvalidNumberOfPlayersException {
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
        try {
            game.addPlayer();
        } catch (MaxPlayerReachedException e) {
            e.printStackTrace();
        }
    }

    public void removePlayer(){
        game.removePlayer();

    }

    public List<Player> getPlayers() {
        return  null;
    }

    public String getScoreboard() {
        return null;
    }

    public String getHelp() {
        return null;
    }

}



