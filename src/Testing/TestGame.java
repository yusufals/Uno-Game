package Testing;

/**
 * Sarah has worked on this test class
 * Abdullah has worked on this test class
 */
import Exceptions.NoCardRemainingException;
import UNO.Player;
import UNO.UnoGame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestGame {
    UnoGame game = new UnoGame();
    Player firstPlayer = new Player();

    public TestGame() throws NoCardRemainingException {
    }

    @Test
    public void testAddPlayer() throws NoCardRemainingException {
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
    public void testPlayCardToSeeIfITMatches() throws NoCardRemainingException {

        game.addPlayer(firstPlayer);
        game.giveCardsToPlayers();
        System.out.println(game.getPlayer());
        System.out.println(game.getTheCardsPlayer(0));

        System.out.println(game.getTopDiscard());
        assertEquals(true,game.addCardsToDiscardFromPlayer(0,3));

        System.out.println(game.getTheCardsPlayer(0));
        System.out.println(game.getTopDiscard());


    }
}