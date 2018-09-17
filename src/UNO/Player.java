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


    public Player(String ID) {
        this.ID = ID;
    }


    public int getNumberOfCards() {
        return playerHand.size();
    }

    public void addCard(Card lastCard) {
        playerHand.add(lastCard);
    }


    //method added to get the card from selected position
    public Card getSelectedCard(int position) throws InvalidCardException {
        if (position < 0 || position > playerHand.size()) {
            throw new InvalidCardException();
        } else {
            Card selectedCard = playerHand.get(position);
            return selectedCard;
        }
    }

    public Card removeSelected(int position) {
        Card selectedCard = playerHand.get(position);
        playerHand.remove(position);
        return selectedCard;
    }


    public List<Card> viewCardsInPlayerHand() {
        return playerHand;
    }

    @Override
    public String toString() {

        return this.ID;
    }

    public String getID() {
        return ID;
    }
}


