package UNO;

import Exceptions.NoCardRemainingException;
import Exceptions.OneCardAllowedException;

public class ActionCardRules  {

    UnoGame unoGame;

    public ActionCardRules(UnoGame unoGame) throws NoCardRemainingException, OneCardAllowedException {
        this.unoGame = unoGame;
    }

    public void drawTwoCads() throws NoCardRemainingException {

        //add two cards to the current player from deck
       unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());

    }
}
