package UNO;

import Exceptions.InvalidCardException;
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
    private int currentPlayer = 0;
    private Card visibleCard;
    ActionCardRules actionCardRules;
    private CardColour currentColour;
    private CardType currentType;

    public UnoGame() throws NoCardRemainingException, OneCardAllowedException {
        discardPile = new DiscardPile();
        unoDeck = new UnoDeck();
        playerStorage = new PlayerStorage();
        UnoGame currentUnoGame = this;
        actionCardRules = new ActionCardRules(currentUnoGame);
        unoDeck.shuffleDeck();
        addFirstCardToDiscardPile();
    }

    public void giveCardsToPlayers() throws NoCardRemainingException {
        //for each player in the players list
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


    public void removePlayer() throws MaxPlayerReachedException {
        Player x = players.remove(players.size() - 1);
        playerStorage.removePlayerFromGame(x);
    }

    /**
     * Sarah created this method
     *
     * @throws MaxPlayerReachedException
     */
    public void addPlayer() throws MaxPlayerReachedException {
        if ((playerStorage.getSizeOfDatabase() == 0)
                || (players.size() > 10)) {
            throw new MaxPlayerReachedException();

        }
        players.add(playerStorage.getFirstPlayer());
    }

    /**
     * Sarah created this method. This returns the total number of players from the players list
     *
     * @return
     */
    public int getPlayerCount() {

        return players.size();
    }

    /**
     * This method counts the number of cards in the players hand
     *
     * @param playerLocation
     * @return
     */
    public int getPlayerHandSize(int playerLocation) {
        return players.get(playerLocation).getNumberOfCards();

    }

    /**
     * This methods counts the number of cards in the deck
     *
     * @return
     */
    public int getDeckSize() {
        return unoDeck.getNumberOfCards();

    }

    /**
     * This method finds the players card location on the players hand when the game is running
     *
     * @param playerLocation
     * @return
     */
    public List<Card> getTheCardsPlayer(int playerLocation) {
        return players.get(playerLocation).viewCardsInPlayerHand();

    }
    public List<Card> getCurrentPlayerHand() {
        return players.get(currentPlayer).viewCardsInPlayerHand();
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

    public boolean playTurn(int cardPosition) throws NoCardRemainingException, InvalidCardException {
        this.visibleCard = discardPile.showTopCard();
        currentColour = visibleCard.getColour();
        Card playerSelectedCard = players.get(currentPlayer).getSelectedCard(cardPosition);
        if(cardPosition<0 ||
            cardPosition>players.get(currentPlayer).getNumberOfCards()){
            throw new InvalidCardException();
        }

        if (visibleCard.getType() == CardNumber.PlusTwo) {
            actionCardRules.drawTwoCards();
            changeType();
            isCardPlayed = true;
        } else if (visibleCard.getType() == CardAction.WildFour) {
            actionCardRules.drawFourCards();
            changeType();
            isCardPlayed = true;
        } else if (visibleCard.getType() == CardNumber.Skip) {
            actionCardRules.skipTurn();
            changeType();
            isCardPlayed = true;
        } else if (currentColour == playerSelectedCard.getColour() ||
                discardPile.showTopCard().getType() == playerSelectedCard.getType() ||
                playerSelectedCard.getType() == CardAction.Wild) {
            discardPile.placeCardOnFaceUpPile(players.get(currentPlayer).removeSelected(cardPosition));
            switchToNextPlayer();
            if (playerSelectedCard.getType() == CardAction.Wild) {
                if (currentColour == CardColour.Red) {
                    setCurrentColour(CardColour.Blue);
                } else if (currentColour == CardColour.Blue) {
                    setCurrentColour(CardColour.Green);
                } else if (currentColour == CardColour.Green) {
                    setCurrentColour(CardColour.Yellow);
                } else {
                    setCurrentColour(CardColour.Red);
                }

            }
            isCardPlayed = true;
        } else {
            actionCardRules.pickUpCard();
            switchToNextPlayer();

        }


        return isCardPlayed;
    }

    /**
     * This method adds a card from the exact location that the player selects from the players hand to the discard/FaceUp pile
     *
     * @param playerNumber
     * @param cardPosition
     * @return
     */


    /**
     * This card gets the number of cards in the faceUp/discard pile.
     *
     * @return
     */

    public int getSizeOfDiscardPile() {
        return discardPile.totalInTheFaceUpPile();
    }

    /**
     * This method adds the cards from the deck to the discard pile / face up pile.
     *
     * @throws NoCardRemainingException
     */
    public void addFirstCardToDiscardPile() throws NoCardRemainingException, OneCardAllowedException {
//        unoDeck.shuffleDeck();

        if (discardPile.totalInTheFaceUpPile() == 0) {
            discardPile.placeCardOnFaceUpPile(unoDeck.takeTopCard());
        } else {

            throw new OneCardAllowedException();
        }
    }


    public Player getPlayer(int index) {
        return players.get(index);
    }
    public Player getPlayerX() {
        return players.get(currentPlayer);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Card getTopDiscard() {
        return discardPile.showTopCard();
    }

    public UnoDeck getUnoDeck() {
        return unoDeck;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchToNextPlayer() {
        if (currentPlayer < (players.size() - 1)) {
            currentPlayer++;
        } else if (currentPlayer == (players.size() - 1)) {
            currentPlayer = 0;
        }

    }

    public String getCurrentPlayerName() {
        return player.getID();

    }

    public void setCurrentColour(CardColour colour) {
        this.currentColour = colour;
    }
    private void changeType(){

        Card blueCard =new Card(CardColour.Blue, CardNumber.One);
        Card redCard =new Card(CardColour.Red, CardNumber.One);
        Card greenCard =new Card(CardColour.Green, CardNumber.One);
        Card yellowCard =new Card(CardColour.Yellow, CardNumber.One);

        if (visibleCard.getColour()==CardColour.Blue){
            visibleCard = blueCard;
        } else if (visibleCard.getColour()==CardColour.Red){
            visibleCard = redCard;
        } else if (visibleCard.getColour()==CardColour.Green){
            visibleCard = greenCard;
        } else if (visibleCard.getColour()==CardColour.Yellow){
            visibleCard = yellowCard;
        }

    }


}
