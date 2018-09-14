package Testing;
/**
 * Abdullah has worked on this test class
 */

import Exceptions.NoCardRemainingException;
import UNO.Card;
import UNO.CardColour;
import UNO.CardNumber;
import UNO.UnoDeck;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeck {



    @Test
    public void testCreateCard() {
//        Card card = new Card (CardColour.Yellow, CardNumber.ONE);

        CardColour colour = CardColour.Yellow;
        CardNumber number = CardNumber.One;
        Card card = new Card(colour, number);

        assertEquals("Unexpected initial card colour", colour, card.getColour());
        assertEquals("Unexpected initial card number", number, card.getType());
    }

    @Test
    public void testCreateCardNull() {
        CardColour colour = CardColour.Yellow;
        CardNumber number = null;
        Card card = new Card(colour, number);

        assertEquals("Unexpected initial card colour", colour, card.getColour());
        assertEquals("Unexpected initial card number", number, card.getType());

    }

    @Test
    public void testCreateCardsDeck() {
        UnoDeck newDeck = new UnoDeck();
        assertEquals(112, newDeck.getNumberOfCards());
    }

    @Test
    public void testNumberOfCardsReturned() throws NoCardRemainingException {
        UnoDeck newDeck = new UnoDeck();
        newDeck.takeTopCard();
        assertEquals(111, newDeck.getNumberOfCards());
        newDeck.takeTopCard();
        assertEquals(110, newDeck.getNumberOfCards());
    }

    @Test
    public void loopCardRemoval()throws  NoCardRemainingException {
        UnoDeck newDeck = new UnoDeck();
        for (int cardPosition = newDeck.getNumberOfCards()-1; cardPosition >= 0; cardPosition--) {
            newDeck.takeTopCard();
            assertEquals(cardPosition, newDeck.getNumberOfCards());

        }
        assertEquals(0, newDeck.getNumberOfCards());

    }

    @Test
    public void testPrintOutOfAllCards(){
        UnoDeck newDeck = new UnoDeck();
        System.out.println(newDeck.getDeckOfCards()+"\n");
        newDeck.shuffleDeck();
        System.out.println(newDeck.getDeckOfCards());

    }



}
