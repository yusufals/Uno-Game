package UNO;

import Exceptions.MaxPlayerReachedException;
import Exceptions.NoCardRemainingException;
import Exceptions.OneCardAllowedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Sarah has worked on this class
 */
public class UnoGame {
    private DiscardPile discardPile;
    private UnoDeck unoDeck;
    private Player player;
    private List<Player> players = new ArrayList<>();
    boolean isCardPlayed;
    private PlayerStorage playerStorage;

    public UnoGame() throws NoCardRemainingException, OneCardAllowedException {
        discardPile = new DiscardPile();
        unoDeck = new UnoDeck();
        player = new Player();
        playerStorage= new PlayerStorage();

//        unoDeck.shuffleDeck();
        addFirstCardToDiscardPile();

    }

    public void giveCardsToPlayers() throws NoCardRemainingException {
        //for each player in the playerslist
        for (int i = 0; i < players.size(); i++) {
            //give seven cards from deck to each player
            players.get(i).addCard(unoDeck.takeTopCard());
            players.get(i).addCard(unoDeck.takeTopCard());
            players.get(i).addCard(unoDeck.takeTopCard());
            players.get(i).addCard(unoDeck.takeTopCard());
            players.get(i).addCard(unoDeck.takeTopCard());
            players.get(i).addCard(unoDeck.takeTopCard());
            players.get(i).addCard(unoDeck.takeTopCard());
        }
    }

    /**
     * Sarah created this method
     * @throws MaxPlayerReachedException
     */
    public void addPlayer() throws MaxPlayerReachedException {
        if ((playerStorage.getSizeOfDatabase() == 0)
            || (players.size()>10)){
            throw new MaxPlayerReachedException();

        }
        players.add(playerStorage.getFirstPlayer());
        //illegal exception for more than 10 players
        //if players in database is zero then dont let them add any more players

    }

    /**
     * Sarah created this method. This returns the total number of players from the players list
     * @return
     */
    public int getPlayerCount() {

        return players.size();
    }

    /**
     * This method counts the number of cards in the players hand
     * @param playerLocation
     * @return
     */
    public int getPlayerHandSize(int playerLocation) {
        return players.get(playerLocation).getNumberOfCards();

    }

    /**
     * This methods counts the number of cards in the deck
     * @return
     */
    public int getDeckSize() {
        return unoDeck.getNumberOfCards();

    }

    /**
     * This method finds the players card location on the players hand when the game is running
     * @param playerLocation
     * @return
     */
    public List<Card> getTheCardsPlayer(int playerLocation) {
        return players.get(playerLocation).viewCardsInPlayerHand();

    }


    /**
     * Written by Abdullah. This method checks the discard pile to make sure that once the pile is at a 100 cards it adds the 100 cards back to the facedown deck.
     */
    //    public void addCardsToDiscardPileFromPlayer(Card card, Player player){
    //Abdullah to work on this method
    public void checkDiscardPile() {
        if (discardPile.totalInTheFaceUpPile() > 100) {
            for (int i = 0; i < 100; i++) {
                unoDeck.addCardToDeck(discardPile.getBottomCard());
            }

        }
    }


    /**
     * This method adds a card from the exact location that the player selects from the players hand to the discard/FaceUp pile
     * @param playerNumber
     * @param cardPosition
     * @return
     */
    public boolean addCardsToDiscardPileFromPlayer(int playerNumber, int cardPosition) {
        //this next line below removes the card due to getSelectedCard method
        //maybe create a removeselected card method separately
        Card card = players.get(playerNumber).getSelectedCard(cardPosition);
        if (discardPile.showTopCard().getColour() == card.getColour() ||
                discardPile.showTopCard().getNumber() == card.getNumber()) {
            discardPile.placeCardOnFaceUpPile(players.get(playerNumber).removeSelected(cardPosition));
            isCardPlayed = true;
        }
        return isCardPlayed;
    }

    /**
     * This card gets the number of cards in the faceUp/discard pile.
     * @return
     */

    public int getSizeOfDiscardPile() {
        return discardPile.totalInTheFaceUpPile();
    }

    /**
     * This method adds the cards from the deck to the discard pile / face up pile.
     * @throws NoCardRemainingException
     */
    public void addFirstCardToDiscardPile() throws NoCardRemainingException, OneCardAllowedException {
//        unoDeck.shuffleDeck();

        if (discardPile.totalInTheFaceUpPile()==0){
            discardPile.placeCardOnFaceUpPile(unoDeck.takeTopCard());

        }
        throw new OneCardAllowedException();

    }



    public Player getPlayer() {
        return player;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Card getTopDiscard(){
        return discardPile.showTopCard();
    }
}
