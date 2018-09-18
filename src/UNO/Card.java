package UNO;

/**
 * Sarah has worked on this class
 */
public class Card {
    //Changed to private
    private CardColour colour;
    private CardType cardType;

    /**
     * This constructor instatiates colour and cardType
     * @param colour
     * @param cardType
     */
    public Card(CardColour colour, CardType cardType){
        this.colour=colour;
        this.cardType=cardType;
    }

    /**
     * This methods gets the colour played
     * @returns CardColour
     */
    public CardColour getColour() {
        return colour;
    }

    /**
     * This method gets the card number or Card Action.
     * @returns the CardType
     */
    public CardType getType() {
        return cardType;
    }

    /**
     * This method overrides the toString method
     * @return
     */
    @Override
    public String toString(){
        if (colour==null){
            System.out.println("null");
        }
          return
                  colour.toString() +
                          " - " +
                         cardType.toString() ;

    }
}
