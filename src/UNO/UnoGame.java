package UNO;

import Exceptions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Abdullah worked on this class
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
    Rules rules;
    private CardColour currentColour;
    private CardType currentType;
    private int currentScore;
    private boolean isGameOver = false;

    /**
     * constructs new UnoGame, UnoDeck, PlayerStorage and shuffles the cards
     * @throws NoCardRemainingException
     * @throws OneCardAllowedException
     */
    public UnoGame() throws NoCardRemainingException, OneCardAllowedException {
        discardPile = new DiscardPile();
        unoDeck = new UnoDeck();
        playerStorage = new PlayerStorage();
        UnoGame currentUnoGame = this;
        rules = new Rules(currentUnoGame);
        unoDeck.shuffleDeck();
        addFirstCardToDiscardPile();
    }

    /**
     * Hands 7 cards out to each of the player that has been added to the game
     * @throws NoCardRemainingException
     */
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

    /**
     * If there was a new player added after the game has started, it lets you hand out more cards
     * @throws NoCardRemainingException
     */
    public void giveCardsToNewPlayers() throws NoCardRemainingException {
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getNumberOfCards()==0){
                players.get(i).addCard(unoDeck.takeTopCard());
                players.get(i).addCard(unoDeck.takeTopCard());
                players.get(i).addCard(unoDeck.takeTopCard());
                players.get(i).addCard(unoDeck.takeTopCard());
                players.get(i).addCard(unoDeck.takeTopCard());
                players.get(i).addCard(unoDeck.takeTopCard());
                players.get(i).addCard(unoDeck.takeTopCard());
            }
        }

    }

    /**]
     * Can remove the player from the game
     * @throws MaxPlayerReachedException
     * @throws InvalidNumberOfPlayersException
     */
    public void removePlayer() throws MaxPlayerReachedException, InvalidNumberOfPlayersException {
        if (players.size() == 0) {
            throw new InvalidNumberOfPlayersException();
        } else {
            Player x = players.remove(players.size() - 1);
            playerStorage.removePlayerFromGame(x);
        }
    }

    /**
     * Sarah created this method
     *Adds a player to the game
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

    /**
     * Allows user to play a card if the conditions are fulfilled
     * @param cardPosition position as int to play the card in
     * @return true or false based on if the turn has been played
     * @throws NoCardRemainingException
     * @throws InvalidCardException
     */

    public boolean playTurn(int cardPosition) throws NoCardRemainingException, InvalidCardException {
        this.visibleCard = discardPile.showTopCard();
        currentColour = visibleCard.getColour();
        Card playerSelectedCard = players.get(currentPlayer).getSelectedCard(cardPosition);
        checkScore();
        if (cardPosition < 0 ||
                cardPosition >= players.get(currentPlayer).getNumberOfCards()) {
            throw new InvalidCardException();
        }
        if (visibleCard.getType() == CardAction.WildFour ||
                visibleCard.getType() == CardNumber.Skip ||
                visibleCard.getType() == CardNumber.PlusTwo) {
            wildCardRules();
        } else if (currentColour == playerSelectedCard.getColour() ||
                discardPile.showTopCard().getType() == playerSelectedCard.getType() ||
                playerSelectedCard.getType() == CardAction.Wild ||
                playerSelectedCard.getType() == CardNumber.Zero) {
            discardPile.placeCardOnFaceUpPile(players.get(currentPlayer).removeSelected(cardPosition));
            switchToNextPlayer();
            isCardPlayed = true;
        } else {
            rules.pickUpCard();
            switchToNextPlayer();
        }
        return isCardPlayed;
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


    /**
     *
     * @param index takes an int for position of the player in the array
     * @return Player in that position
     */
    public Player getPlayer(int index) {
        return players.get(index);
    }

    /**
     *
     * @return Player from the when the size of playerlist is not 0
     * @throws InvalidNumberOfPlayersException
     */
    public Player getPlayerX() throws InvalidNumberOfPlayersException {
        if (players.size() == 0) {
            throw new InvalidNumberOfPlayersException();
        } else
            return players.get(currentPlayer);
    }

    /**
     *
     * @return list of Players in the game
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * @return Card - which is the top card on the discard pile
     */
    public Card getTopDiscard() {
        return discardPile.showTopCard();
    }

    /**
     * @return UnoDeck
     */
    public UnoDeck getUnoDeck() {
        return unoDeck;
    }

    /**
     * selected Player position
     * @return
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Switches to next player when a turn has been played
     */
    public void switchToNextPlayer() {
        if (currentPlayer < (players.size() - 1)) {
            currentPlayer++;
        } else if (currentPlayer == (players.size() - 1)) {
            currentPlayer = 0;
        }

    }

    /**
     * Allows to change the card type to a different one when its wild
     * @return returns the new Card
     */
    protected Card changeType() {

        Card blueCard = new Card(CardColour.Blue, CardNumber.Zero);
        Card redCard = new Card(CardColour.Red, CardNumber.Zero);
        Card greenCard = new Card(CardColour.Green, CardNumber.Zero);
        Card yellowCard = new Card(CardColour.Yellow, CardNumber.Zero);
        Card tempCard = null;
        int x = (discardPile.totalInTheFaceUpPile() - 2);
        if (discardPile.viewDiscardPile().get(x).getColour() == CardColour.Blue) {
            tempCard = blueCard;
        } else if (discardPile.viewDiscardPile().get(x).getColour() == CardColour.Red) {
            tempCard = redCard;
        } else if (discardPile.viewDiscardPile().get(x).getColour() == CardColour.Green) {
            tempCard = greenCard;
        } else if (discardPile.viewDiscardPile().get(x).getColour() == CardColour.Yellow) {
            tempCard = yellowCard;
        } else tempCard = blueCard;
        return tempCard;

    }


    private void wildCardRules() throws NoCardRemainingException {
        if (visibleCard.getType() == CardNumber.PlusTwo) {
            rules.drawTwoCards();
            changeType();
            isCardPlayed = true;
        } else if (visibleCard.getType() == CardAction.Wild) {
            changeType();
            isCardPlayed = true;
        } else if (visibleCard.getType() == CardAction.WildFour) {
            rules.drawFourCards();
            changeType();
            isCardPlayed = true;
        } else if (visibleCard.getType() == CardNumber.Skip) {
            rules.skipTurn();
            changeType();
            isCardPlayed = true;
        }


    }

    private boolean isGameOver() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getNumberOfCards() < 1) {
                isGameOver = true;
            } else {
                isGameOver = false;
            }
        }
        return isGameOver;
    }

    /**
     *
     * @return total score as int of all the players that has not won
     * @throws InvalidCardException
     */
    public int checkScore() throws InvalidCardException {
        if (isGameOver()) {
            for (int i = 0; i < players.size(); i++) {
                players.get(i).viewCardsInPlayerHand();
                for (int x = 0; x < getPlayerHandSize(i); x++) {
                    if (players.get(i).getSelectedCard(x).getType() == CardNumber.Zero) {
                        currentScore += 0;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardNumber.One) {
                        currentScore += 1;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardNumber.Two) {
                        currentScore += 2;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardNumber.Three) {
                        currentScore += 3;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardNumber.Four) {
                        currentScore += 4;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardNumber.Five) {
                        currentScore += 5;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardNumber.Six) {
                        currentScore += 6;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardNumber.Seven) {
                        currentScore += 7;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardNumber.Eight) {
                        currentScore += 8;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardNumber.Nine) {
                        currentScore += 9;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardNumber.PlusTwo) {
                        currentScore += 20;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardNumber.Skip) {
                        currentScore += 20;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardAction.WildFour) {
                        currentScore += 50;
                    } else if (players.get(i).getSelectedCard(x).getType() == CardAction.Wild) {
                        currentScore += 50;
                    }
                }
            }
        }
        return currentScore;

    }

    /**
     * used to add a card to top of the deck
     * @param card temporary card
     */
    protected void addTempCardToDiscardPile(Card card) {
        discardPile.placeCardOnFaceUpPile(card);
    }
}
