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
        Player player = new Player("Player One");
        game.addPlayer();

        assertEquals(1, game.getPlayerCount());

    }

    @Test
    public void testCardsInPlayerHands() throws NoCardRemainingException, MaxPlayerReachedException, OneCardAllowedException {

        UnoGame game = new UnoGame();
        Player player = new Player("Player One");
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
        Player firstPlayer = new Player("Player One");
        game.addPlayer();
        game.giveCardsToPlayers();
        System.out.println(game.getPlayer(0));
        System.out.println(game.getTheCardsPlayer(0));

        System.out.println(game.getTopDiscard());

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

    @Test
    public void testUNOGAME() throws OneCardAllowedException, NoCardRemainingException, MaxPlayerReachedException {
        UnoGame game = new UnoGame();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.addPlayer();
        game.giveCardsToPlayers();
        System.out.println(game.getPlayers());
        System.out.println(game.getTopDiscard());
        System.out.println(game.getPlayer(0)+""+ game.getTheCardsPlayer(0));
        System.out.println(game.getPlayer(1)+""+ game.getTheCardsPlayer(1));
        System.out.println(game.getPlayer(2)+""+ game.getTheCardsPlayer(2));
        System.out.println(game.getPlayer(3)+""+ game.getTheCardsPlayer(3));
        System.out.println(game.getPlayer(4)+""+ game.getTheCardsPlayer(4));
        System.out.println(game.getPlayer(5)+""+ game.getTheCardsPlayer(5));
        System.out.println(game.getPlayer(6)+""+ game.getTheCardsPlayer(6));
        game.playTurn(2,0);
        System.out.println(game.getTheCardsPlayer(2));
        System.out.println(game.getCurrentPlayer()+1);





    }
}