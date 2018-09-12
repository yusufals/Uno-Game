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

    public UnoGame() {
    discardPile=new DiscardPile();
    unoDeck= new UnoDeck();
    player= new Player();


    }

    /**
     * This method distributes cards to players and throws an exception when there are no more cards left from the deck.
     * @throws NoCardRemainingException
     */

    public void giveCardsToPlayers() throws NoCardRemainingException{
        //for each player in the playerslist
        for(int i=0; i<players.size(); i++){
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
     * This method creates a new player
     * @param player
     */
    public void addPlayer(Player player) {

        players.add(player);
    }

    /**
     * This method counts the total number of players
     * @return number of players playing
     */
    public int getPlayerCount(){

        return players.size();
    }

    /**
     * This method gets the number of cards in the players hand and gets the number of total cards
     * @param playerLocation
     * @return
     */

    public int getPlayerHandSize(int playerLocation){
        return players.get(playerLocation).getNumberOfCards();

    }

    /**
     * This method finds the total number of cards in the deck
     * @return
     */
    public int getDeckSize(){
        return unoDeck.getNumberOfCards();

    }

    /**
     *
     * @param playerLocation
     * @return
     */
    public List<Card> getTheCardsPlayer(int playerLocation){
        return players.get(playerLocation).viewCardsInPlayerHand();

    }

//    public void addCardsToDiscardFromPlayer(Card card, Player player){
    //Abdullah to work on this method
    public void addCardsToDiscardFromPlayer(int playerNumber){
        if(discardPile.numberOfCardsInTheFaceUpPile()>100){
            for(int i=0; i<100; i++){
                unoDeck.addCardToDeck(discardPile.getBottomCard());
            }

        }
        //for the top card on discard pile
//        card.getColour();
            //if the colour on playerhandcard == colour on top discard card
            // or type on player hand == type on top discard card
        //play card
        discardPile.placeCardOnFaceUpPile(players.get(playerNumber).reduceCardsInPlayerHands());
//        discardPile.placeCardOnFaceUpPile(player.reduceCardsInPlayerHands());
        //else if the colour on playerhand is black
        //play card
        // else add a card to player hand from deck


    }



    public int getSizeOfDiscardPile(){
        return discardPile.numberOfCardsInTheFaceUpPile();
    }



}
