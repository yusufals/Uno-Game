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
     * Marin
     * @return
     */
    public int totalInTheFaceUpPile() {
        return discardPile.size();

    }


    /**Abdullah
     *
     * @param card
     */
    public void placeCardOnFaceUpPile(Card card) {
        discardPile.add(card);
    }

    /**
     * Abdullah
     * @return
     */
    public List<Card> viewDiscardPile() {
        return discardPile;
    }

    /**
     * Sarah
     * @return
     */
    public Card showTopCard() {
        int topCard = discardPile.size() - 1;
        return discardPile.get(topCard);
    }

    /**
     * Marin
     * @return
     */
    public Card getBottomCard() {
        return discardPile.remove(0);
    }


}
