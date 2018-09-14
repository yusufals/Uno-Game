package UNO;

/**
 * Sarah has worked on this class
 */
public class Card {
    //Changed to private
    private CardColour colour;
    private CardType cardType;


    public Card(CardColour colour, CardType cardType){
        this.colour=colour;
        this.cardType=cardType;
    }

    public CardColour getColour() {
        return colour;
    }

    public CardType getType() {
        return cardType;
    }

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
