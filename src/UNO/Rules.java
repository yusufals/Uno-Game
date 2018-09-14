package UNO;

import Exceptions.NoCardRemainingException;

/**
 * Created by capranom on 12/09/2018.
 */
public class Rules{

    Player player;
    UnoGame game;

   public Rules() throws NoCardRemainingException {
        player = new Player();
        game = new UnoGame();
    }

    public void switchPlayer(){


    }

}
