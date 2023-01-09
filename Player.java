import java.util.Random;
import java.util.ArrayList;
/**
 * This class will hold the cards that this current player will have this game.
 * @author Jeremywang
 */
public class Player
{	
	/**an ArrayList called "hand" of type Card is created*/
    private ArrayList<Card> hand = new ArrayList<Card>();
    /**create a string variable "name" and initialize its value*/
    private String name = "Default";
    /**create an integer variable "score" and initialize its value*/
    private int score=0;
    /**create a new random number generator*/
    Random rand = new Random();
    
    /**
     * create a constructor "Player" to input players' names, 
     * When constructing this player, it will accept a name as parameter. 
     * The player will go by this name throughout the game.
     * @param nameParam user input of players' names
     */
    public Player(String nameParam)
    {
        name = nameParam;
        if (nameParam.equals(""))
        {
            name="Default";
        }
    }
    /**
     * This method accepts a Card, and adds it to the player's hand arraylist. 
     * It doesn't need to return anything.
     * @param cardParam objects with data type Card
     */
    public void addCard(Card cardParam)
    {
        hand.add(cardParam);
    }
    /**
     * This method returns how many hands the current player has won.
     * @return return the integer value of variable score
     */
    public int getScore()
    {
        return score;
    }
    /**
     * create a getter method "getName" to allow other classes have access to private variable name
     * @return return the string value of variable name
     */
    public String getName()
    {
        return name;
    }
    /**
     * This method returns a list of all the cards the player currently holds. 
     * It should call the getShortName() of each Card currently held. 
     * This information will be used elsewhere for output.
     * @return return the string values of variable builder
     */
    public String getHand()
    {
        String builder="";
        for (Card c:hand)
        {
            builder+=c.getShortName();
        }
        return builder;
    }
    /**
     * This method will pick a card at random from the cards the Player has, remove it from the arraylist, and return it.
     * @return return null
     */
    public Card playCard()
    {
        if (hand.size()==0) 
        {
            System.out.print("Player:  Request made to play a card when hand is empty.");
            return null;
        }
        
        //Play a card at random.
        //Report which card was played.
        int removeCard = rand.nextInt(hand.size());
        Card chosenCard = hand.get(removeCard);
        hand.remove(chosenCard);
        return chosenCard;
    }
    /**
     * If a player won a hand, this method gets called. It will increment an internal variable (which getScore() will reference).
     */
    public void handWon()
    {
        score++;
    }
    /**
     * A call to this method clears out the arraylist and resets the score, so a fresh game can be played.
     */
    public void reset()
    {
        hand.clear();
        //Empty hand arraylist;
        score=0;
    }
}
