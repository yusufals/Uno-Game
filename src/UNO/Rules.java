package UNO;

import Exceptions.NoCardRemainingException;
import Exceptions.OneCardAllowedException;

/**
 * Created by capranom on 12/09/2018.
 */
public class Rules {

    Player player;
    UnoGame game;
    PlayerStorage playersInGame;

   public Rules() throws NoCardRemainingException, OneCardAllowedException {
        player = new Player();
        game = new UnoGame();
        playersInGame = new PlayerStorage();
    }

    public void switchPlayer(){

    }

}
