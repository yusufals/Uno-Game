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

    public void wildChangeColour(String userInput) {
        //Add codes for user to select the colour
    }
    public void skipTurn(){
        unoGame.switchToNextPlayer();
    }

    public void reverseTurn(){
        //Add codes to reverse direction
    }

    private void switchPlayer(){
        //Method for switching players
    }




    public void pickUpCard() throws NoCardRemainingException {
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
    }

}
