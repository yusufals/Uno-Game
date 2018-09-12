package UNO;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Marin has worked on this class
 */
public class Player {
    private List<Card> playerHand = new ArrayList<>();


    public Player() {

    }



    public int getNumberOfCards() {
        return playerHand.size();
    }

    public void addCard(Card lastCard) {
//        Card newCard = new Card(CardColour.Yellow, CardNumber.Eight);
        playerHand.add(lastCard);
    }


    public Card reduceCardsInPlayerHands() {
        int cardPosition = getNumberOfCards() - 1;
        Card lastCard = playerHand.get(cardPosition);
        playerHand.remove(cardPosition);
        return lastCard;
    }



    public List<Card> viewCardsInPlayerHand() {
        return playerHand;
    }

}


