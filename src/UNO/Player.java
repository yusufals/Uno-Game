package UNO;


import Exceptions.InvalidCardException;

import java.util.ArrayList;
import java.util.List;

/**
 * Marin has worked on this class
 */
public class Player {
    private List<Card> playerHand = new ArrayList<>();
    private String ID;

    /**
     * The constructor insantiates an ID as a String.
     * @param ID
     */
    public Player(String ID) {
        this.ID = ID;
    }

    /**
     * this method gets the number of cards in a players hand.
     * @return
     */
    public int getNumberOfCards() {
        return playerHand.size();
    }

    /**
     * This method adds a card to the players hand
     */
    public void addCard(Card lastCard) {
        playerHand.add(lastCard);
    }

    /**
     * This method gets the card in a players hand according to the selected position.
     * @param position
     * @returns selectedCard
     * @throws InvalidCardException
     */

    public Card getSelectedCard(int position) throws InvalidCardException {
        if (position < 0 || position >= playerHand.size()) {
            throw new InvalidCardException();
        } else {
            Card selectedCard = playerHand.get(position);
            return selectedCard;
        }
    }

    /**
     * This method removes the card selected from the players hand position.
     * @param position - the position in the player hand as an int.
     * @return card selected.
     */
    public Card removeSelected(int position) {
        Card selectedCard = playerHand.get(position);
        playerHand.remove(position);
        return selectedCard;
    }

    /**
     * This method
     * @returns cards from the playerHand as a list
     */
    public List<Card> viewCardsInPlayerHand() {
        return playerHand;
    }

    /**
     * This method overrides the toString method
     * @return
     */
    @Override
    public String toString() {

        return this.ID;
    }

    public String getID() {
        return ID;
    }
}


