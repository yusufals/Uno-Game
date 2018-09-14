package Testing;

/**
 * Sarah has worked on this test class
 * Abdullah has worked on this test class
 */

import Exceptions.MaxPlayerReachedException;
import Exceptions.NoCardRemainingException;
import Exceptions.OneCardAllowedException;
import UNO.Player;
import UNO.UnoGame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestGame {

    public TestGame() throws NoCardRemainingException {
    }

    @Test
    public void testAddPlayer() throws NoCardRemainingException, MaxPlayerReachedException, OneCardAllowedException {
        UnoGame game = new UnoGame();
        Player player = new Player();
        game.addPlayer();

        assertEquals(1, game.getPlayerCount());

    }

    @Test
    public void testCardsInPlayerHands() throws NoCardRemainingException, MaxPlayerReachedException, OneCardAllowedException {

        UnoGame game = new UnoGame();
        Player player = new Player();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        assertEquals(3, game.getPlayerCount());
        game.giveCardsToPlayers();
        System.out.println(game.getPlayerHandSize(0));
        assertEquals(91, game.getDeckSize());
    }

    @Test
    public void testPlayCardToSeeIfITMatches() throws NoCardRemainingException, MaxPlayerReachedException, OneCardAllowedException {

        UnoGame game = new UnoGame();
        Player firstPlayer = new Player();
        game.addPlayer();
        game.giveCardsToPlayers();
        System.out.println(game.getPlayer());
        System.out.println(game.getTheCardsPlayer(0));

        System.out.println(game.getTopDiscard());
        assertEquals(true, game.addCardsToDiscardPileFromPlayer(0, 3));

        System.out.println(game.getTheCardsPlayer(0));
        System.out.println(game.getTopDiscard());


    }

    @Test
    public void testAddPlayers() throws NoCardRemainingException, MaxPlayerReachedException, OneCardAllowedException {
        UnoGame game = new UnoGame();
        game.addPlayer();
        assertEquals(1, game.getPlayerCount());
        game.addPlayer();
        assertEquals(2, game.getPlayerCount());

    }

    @Test (expected = MaxPlayerReachedException.class)
    public void testMaxPlayerReached() throws NoCardRemainingException, MaxPlayerReachedException, OneCardAllowedException {
        UnoGame game = new UnoGame();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        assertEquals(10, game.getPlayerCount());
        game.addPlayer();
        //(expected = ArithmeticException.class)



    }

    @Test //(expected = OneCardAllowedException.class)
    public void oneCardInBeginningOfGame () throws OneCardAllowedException, NoCardRemainingException {
        UnoGame game= new UnoGame();
        game.addFirstCardToDiscardPile();


    }
}