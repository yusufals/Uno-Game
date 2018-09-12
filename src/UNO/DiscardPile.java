package UNO;

import java.util.ArrayList;
import java.util.List;


public class DiscardPile {

    private List<Card> faceUpPile = new ArrayList<>();


    public DiscardPile() {
    }

    public int numberOfCardsInTheFaceUpPile() {
        return faceUpPile.size();

    }


    public void placeCardOnFaceUpPile(Card card) {
        faceUpPile.add(card);
    }

    public List<Card> viewFaceUpPile() {
        return faceUpPile;
    }

    public Card showTopCard() {
        int topCard = faceUpPile.size() - 1;
        return faceUpPile.get(topCard);
    }

    public Card getBottomCard() {
        return faceUpPile.remove(0);
    }


}
