
package Testing;

/**
 * Marin has worked on this class
 */

import Exceptions.NoCardRemainingException;
import UNO.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestPlayer {


    @Test
    public void createPlayer() {
        Player player = new Player();
        assertEquals(0, player.getNumberOfCards());

    }

    @Test
    public void addOneCardToPlayersHand() {
        Card testCard = new Card(CardColour.Yellow, CardNumber.Eight);
        Player player = new Player();
        player.addCard(testCard);
        assertEquals(1, player.getNumberOfCards());


    }

    @Test
    public void testAddACardFromUnoDeck() throws NoCardRemainingException {

        UnoDeck unoDeck = new UnoDeck();
        Player newPlayer = new Player();
        unoDeck.shuffleDeck();
        assertEquals(112, unoDeck.getNumberOfCards());
        System.out.println("Number of Cards in the Deck is " + unoDeck.getNumberOfCards());
        assertEquals(0, newPlayer.getNumberOfCards());
        System.out.println("Number of Cards in the PlayerHand is " + newPlayer.getNumberOfCards());
        newPlayer.addCard(unoDeck.takeTopCard());
        assertEquals(111, unoDeck.getNumberOfCards());
        System.out.println("Number of Cards in the Deck is " + unoDeck.getNumberOfCards());
        assertEquals(1, newPlayer.getNumberOfCards());
        System.out.println(newPlayer.viewCardsInPlayerHand());
        System.out.println("Number of Cards in the PlayerHand is " + newPlayer.getNumberOfCards());


    }
    @Test
    public void testAdding7CardsToPlayerHand()throws  NoCardRemainingException{

        UnoDeck unoDeck = new UnoDeck();
        Player newPlayer = new Player();
        Player player2 = new Player();
        unoDeck.shuffleDeck();
        newPlayer.addCard(unoDeck.takeTopCard());
        newPlayer.addCard(unoDeck.takeTopCard());
        newPlayer.addCard(unoDeck.takeTopCard());
        newPlayer.addCard(unoDeck.takeTopCard());
        newPlayer.addCard(unoDeck.takeTopCard());
        newPlayer.addCard(unoDeck.takeTopCard());
        newPlayer.addCard(unoDeck.takeTopCard());
        assertEquals(105,unoDeck.getNumberOfCards());
        assertEquals(7,newPlayer.getNumberOfCards());
        System.out.println(newPlayer.viewCardsInPlayerHand());
        System.out.println(unoDeck.getNumberOfCards());
        System.out.println(newPlayer.getNumberOfCards());
        player2.addCard(unoDeck.takeTopCard());
        player2.addCard(unoDeck.takeTopCard());
        player2.addCard(unoDeck.takeTopCard());
        player2.addCard(unoDeck.takeTopCard());
        player2.addCard(unoDeck.takeTopCard());
        player2.addCard(unoDeck.takeTopCard());
        player2.addCard(unoDeck.takeTopCard());
        System.out.println(unoDeck.getNumberOfCards());



    }


}
