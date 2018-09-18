package UNO;

import java.util.ArrayList;
import java.util.List;

/**
 * All three of us worked on this class
 */
public class DiscardPile {

    private List<Card> discardPile = new ArrayList<>();


    public DiscardPile() {
    }

    /**
     * Marin created this method. The method gets the total number of cards in the discard pile.
     * @returns the number of cards in discard pile
     */
    public int totalInTheFaceUpPile() {
        return discardPile.size();

    }


    /**Abdullah created this method. The method
     *
     * @param card
     */
    public void placeCardOnFaceUpPile(Card card) {
        discardPile.add(card);
    }

    /**
     * Abdullah created this method.
     * @returns a list of cards from the discard pile
     */
    public List<Card> viewDiscardPile() {
        return discardPile;
    }

    /**
     * Sarah created this method.
     * @returns the card at the last position on the array of the discard pile.
     */
    public Card showTopCard() {
        int topCard = discardPile.size() - 1;
        return discardPile.get(topCard);
    }

    /**
     * Sarah created this method.
     * @returns the initial card in the faceUp pile/ discard pile
     */
    public Card getBottomCard() {
        return discardPile.remove(0);
    }


}
