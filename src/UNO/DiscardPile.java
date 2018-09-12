package UNO;

import java.util.ArrayList;
import java.util.List;

/**
 * All three of us worked on this class
 */
public class DiscardPile {

    private List<Card> faceUpPile = new ArrayList<>();


    public DiscardPile() {
    }

    /**
     * Marin
     * @return
     */
    public int numberOfCardsInTheFaceUpPile() {
        return faceUpPile.size();

    }


    /**Abdullah
     *
     * @param card
     */
    public void placeCardOnFaceUpPile(Card card) {
        faceUpPile.add(card);
    }

    /**
     * Abdullah
     * @return
     */
    public List<Card> viewFaceUpPile() {
        return faceUpPile;
    }

    /**
     * Sarah
     * @return
     */
    public Card showTopCard() {
        int topCard = faceUpPile.size() - 1;
        return faceUpPile.get(topCard);
    }

    /**
     * Marin
     * @return
     */
    public Card getBottomCard() {
        return faceUpPile.remove(0);
    }


}
