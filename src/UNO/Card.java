package UNO;

/**
 * Sarah has worked on this class
 */
public class Card {
    CardColour colour;
    CardType cardType;


    public Card(CardColour colour, CardType cardType){
        this.colour=colour;
        this.cardType=cardType;
    }

    public CardColour getColour() {
        return colour;
    }

    public CardType getNumber() {
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
