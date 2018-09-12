package Arcade;

import Exceptions.InsufficientFundsException;
import Exceptions.InvalidCommandException;
import Exceptions.InvalidNumberOfPlayersException;
import UNO.Player;

import java.util.List;

public class TextGameImplementation implements TextGame {

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

    public void addPlayer(Player player) throws InsufficientFundsException {
    }

    public void removePlayer(Player player){

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



