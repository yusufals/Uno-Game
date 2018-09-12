package UNO;

import Exceptions.NoCardRemainingException;

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

    public UnoGame() throws NoCardRemainingException {
        discardPile = new DiscardPile();
        unoDeck = new UnoDeck();
        player = new Player();
//        unoDeck.shuffleDeck();
        addIntitalCardToDiscardPile();

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

    public void addPlayer(Player player) {

        players.add(player);
    }

    public int getPlayerCount() {

        return players.size();
    }

    public int getPlayerHandSize(int playerLocation) {
        return players.get(playerLocation).getNumberOfCards();

    }

    public int getDeckSize() {
        return unoDeck.getNumberOfCards();

    }

    public List<Card> getTheCardsPlayer(int playerLocation) {
        return players.get(playerLocation).viewCardsInPlayerHand();

    }

    //    public void addCardsToDiscardFromPlayer(Card card, Player player){
    //Abdullah to work on this method
    public void checkDiscardPile() {
        if (discardPile.totalInTheFaceUpPile() > 100) {
            for (int i = 0; i < 100; i++) {
                unoDeck.addCardToDeck(discardPile.getBottomCard());
            }

        }
    }

    public boolean addCardsToDiscardFromPlayer(int playerNumber, int cardPosition) {
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


    public int getSizeOfDiscardPile() {
        return discardPile.totalInTheFaceUpPile();
    }

    private void addIntitalCardToDiscardPile() throws NoCardRemainingException {
//        unoDeck.shuffleDeck();
        discardPile.placeCardOnFaceUpPile(unoDeck.takeTopCard());

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
