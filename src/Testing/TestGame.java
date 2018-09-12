package Testing;

/**
 * Sarah has worked on this test class
 */
import Exceptions.NoCardRemainingException;
import UNO.Player;
import UNO.UnoGame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestGame {

    @Test
    public void testAddPlayer() {
        UnoGame game = new UnoGame();
        Player player = new Player();
        game.addPlayer(player);

        assertEquals(1, game.getPlayerCount());

    }

    @Test
    public void testCardsInPlayerHands() throws NoCardRemainingException {

        UnoGame game = new UnoGame();
        Player player = new Player();
        game.addPlayer(player);
        game.addPlayer(player);
        game.addPlayer(player);
        assertEquals(3, game.getPlayerCount());
        game.giveCardsToPlayers();
        System.out.println(game.getPlayerHandSize(0));
        assertEquals(91, game.getDeckSize());
    }







    @Test
    public void test100Cards() throws NoCardRemainingException{
        UnoGame game = new UnoGame();
        Player player = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        Player player5 = new Player();
        game.addPlayer(player);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);
        game.giveCardsToPlayers();
        System.out.println(game.getDeckSize());
        game.addCardsToDiscardFromPlayer(0);
        game.addCardsToDiscardFromPlayer(0);
        game.addCardsToDiscardFromPlayer(0);
        game.addCardsToDiscardFromPlayer(0);
        game.addCardsToDiscardFromPlayer(0);
        game.addCardsToDiscardFromPlayer(1);
        game.addCardsToDiscardFromPlayer(1);
        game.addCardsToDiscardFromPlayer(1);
        game.addCardsToDiscardFromPlayer(1);
        game.addCardsToDiscardFromPlayer(1);
        System.out.println(game.getPlayerHandSize(0));
        System.out.println(game.getPlayerHandSize(1));
        System.out.println(game.getDeckSize());
        game.addCardsToDiscardFromPlayer(2);
        game.addCardsToDiscardFromPlayer(2);
        System.out.println(game.getDeckSize());
        System.out.println(game.getSizeOfDiscardPile());
    }
}