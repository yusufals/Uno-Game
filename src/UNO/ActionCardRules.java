package UNO;

import Exceptions.NoCardRemainingException;
import Exceptions.OneCardAllowedException;

public class ActionCardRules  {

    UnoGame unoGame;

    public ActionCardRules(UnoGame unoGame) throws NoCardRemainingException, OneCardAllowedException {
        this.unoGame = unoGame;
    }

    public void drawTwoCards() throws NoCardRemainingException {

        //add two cards to the current player from deck
       unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.switchToNextPlayer();

    }
    public void drawFourCards() throws NoCardRemainingException {

        //add two cards to the current player from deck
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.switchToNextPlayer();
    }

    public void wildChangeColour(){

    }

    public void skipTurn(){
        unoGame.switchToNextPlayer();
    }

    public void reverseTurn(){


    }

    private void switchPlayer(){


    }


    public void pickUpCard() throws NoCardRemainingException {
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
    }

}
