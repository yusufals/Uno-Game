package UNO;

import Exceptions.NoCardRemainingException;
import Exceptions.OneCardAllowedException;

public class ActionCardRules extends UnoGame {
    public ActionCardRules() throws NoCardRemainingException, OneCardAllowedException {
    }

    public void drawTwoCads() throws NoCardRemainingException {

        //add two cards to the current player from deck
        getPlayers().get(getCurrentPlayer()).addCard(getUnoDeck().takeTopCard());
        getPlayers().get(getCurrentPlayer()).addCard(getUnoDeck().takeTopCard());

    }
}
