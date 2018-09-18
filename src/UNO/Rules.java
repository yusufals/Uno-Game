package UNO;

import Exceptions.NoCardRemainingException;
import Exceptions.OneCardAllowedException;

public class Rules {

    UnoGame unoGame;

    /**
     * The method instantiates unoGame as unoGame.
     * @param unoGame
     * @throws NoCardRemainingException
     * @throws OneCardAllowedException
     */
    public Rules(UnoGame unoGame) throws NoCardRemainingException, OneCardAllowedException {
        this.unoGame = unoGame;
    }

    /**
     * This method adds two cards from the deck to the player hand
     * @throws NoCardRemainingException
     */
    public void drawTwoCards() throws NoCardRemainingException {

        //add two cards to the current player from deck
       unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.addTempCardToDiscardPile(unoGame.changeType());
        unoGame.switchToNextPlayer();

    }
    /**
     * This method adds four cards from the deck to the player hand
     * @throws NoCardRemainingException
     */
    public void drawFourCards() throws NoCardRemainingException {

        //add two cards to the current player from deck
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
        unoGame.addTempCardToDiscardPile(unoGame.changeType());
        unoGame.switchToNextPlayer();
    }

    /**
     * Allows to change the colour of the card on faceup pile
     * @param userInput takes user input for colour
     */
    public void wildChangeColour(String userInput) {
        //Add codes for user to select the colour
    }

    /**
     * skips turn to next player
     */
    public void skipTurn(){
        unoGame.addTempCardToDiscardPile(unoGame.changeType());
        unoGame.switchToNextPlayer();
    }

    /**
     * switches the direction of play
     */
    public void reverseTurn(){
        //Add codes to reverse direction
    }

    /**
     * switch players
     */
    private void switchPlayer(){
        //Method for switching players
    }


    /**
     * Adds one card to player hand
     * @throws NoCardRemainingException
     */
    public void pickUpCard() throws NoCardRemainingException {
        unoGame.getPlayers().get(unoGame.getCurrentPlayer()).addCard(unoGame.getUnoDeck().takeTopCard());
    }

}
