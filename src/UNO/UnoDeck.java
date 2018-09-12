package UNO;

import Exceptions.NoCardRemainingException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abdullah has worked on this class
 */
public class UnoDeck {

    private List<Card> deckOfCards = new ArrayList<>();

    public UnoDeck() {
        setUpDeckOfCards(CardColour.Yellow);
        setUpDeckOfCards(CardColour.Yellow);
        setUpDeckOfCards(CardColour.Blue);
        setUpDeckOfCards(CardColour.Blue);
        setUpDeckOfCards(CardColour.Green);
        setUpDeckOfCards(CardColour.Green);
        setUpDeckOfCards(CardColour.Red);
        setUpDeckOfCards(CardColour.Red);
        setUpDeckOfCards(CardColour.Black);
    }

    /**
     * This method gives us the total number of cards in the DeckOfCards array
     *
     * @return an int which is the total number of cards
     */

    public int getNumberOfCards() {
        return deckOfCards.size();
    }

    /**
     * The method creates a new deck of cards with all the possible combinations from 112 cards.
     *
     * @param colour - takes in a parameter colour from the Constructor of this class and creates all the possible cards for each colour.
     */
    private void setUpDeckOfCards(CardColour colour) {
        // if black,
        //      create wild cards
        // else,
        //      create number cards (for....)
        //
        if (colour == CardColour.Black) {

            Card wildFour1 = new Card(CardColour.Black, CardAction.WildFour);
            Card wildFour2 = new Card(CardColour.Black, CardAction.WildFour);
            Card wildFour3 = new Card(CardColour.Black, CardAction.WildFour);
            Card wildFour4 = new Card(CardColour.Black, CardAction.WildFour);

            Card wildCard1 = new Card(CardColour.Black, CardAction.Wild);
            Card wildCard2 = new Card(CardColour.Black, CardAction.Wild);
            Card wildCard3 = new Card(CardColour.Black, CardAction.Wild);
            Card wildCard4 = new Card(CardColour.Black, CardAction.Wild);
            deckOfCards.add(wildCard1);
            deckOfCards.add(wildCard2);
            deckOfCards.add(wildCard3);
            deckOfCards.add(wildCard4);
            deckOfCards.add(wildFour1);
            deckOfCards.add(wildFour2);
            deckOfCards.add(wildFour3);
            deckOfCards.add(wildFour4);
        } else {

            for (CardNumber number : CardNumber.values()) {

                Card card = new Card(colour, number);
                deckOfCards.add(card);

            }


        }

    }

    /**
     * The method takeTopCard lets a player pick the top card from the deck.
     *
     * @return Card - returns the last card in the array.
     */
    public Card takeTopCard() throws NoCardRemainingException{
        int lastCardPosition = deckOfCards.size() - 1;
        if (lastCardPosition == 0) {
            throw new NoCardRemainingException();
        }
        Card lastCard = deckOfCards.get(lastCardPosition);
        deckOfCards.remove(lastCardPosition);
        return lastCard;
    }

    /**
     * This method shuffles all the cards in the deck.
     */
    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);

    }

    /**
     * This method returns a list of all the cards in the deck.
     *
     * @return List<Card> - returns the List of Cards
     */
    public List<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void addCardToDeck(Card card){
        deckOfCards.add(card);
    }
}
