/**
 * This class serves as the parent class.
 * @author Jeremywang
 */
public interface CardGameRule
{
    //All values are static, as they won't vary from instance to instance.
    //Why use extra memory when we don't need to?
    
    //Convenience constants:
	/**create an integer variable "MAX_CARDS" and initialize its value with {@value #MAX_CARDS : 52}*/
    final static int MAX_CARDS = 52;
    /**create an integer variable "MAX_SUITS" and initialize its value with {@value #MAX_SUITS : 4}*/
    final static int MAX_SUITS = 4;
    /**create an integer variable "MAX_FACES" and initialize its value with {@value #MAX_FACES : 13}*/
    final static int MAX_FACES = 13;
 
    // Contains the Unicode symbols for solid spades, hollow hearts,
    // hollow diamonds and solid clubs, respectively.  Try commenting it out if you're on a Linux or Mac
    // to see what happens?  If you see gibberish, use the other suitShort definition below.
    // static char[] suitShort = new char[]{'\u9824', '\u9825', '\u9826', '\u9827'};
    
    // Windows console does not render unicode characters.  Use the below line for all
    // Windows implementations:
    /**
     * create a char type array which contains one letter abbreviation of different suits
     */
    static char[] suitShort = new char[]{'s', 'h', 'd', 'c'};
    
    //To be used to assemble your card names:
    /**
     * create a string type array which contains capital letter abbreviation of different faces
     */
    static String[] rankShort = new String[]{"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    /**
     * create a string type array which contains full letter name of different suits
     */
    static String[] suitLong = new String[]{"Spades", "Hearts", "Diamonds", "Clubs"};
    /**
     * create a string type array which contains full letter name of different faces
     */
    static String[] rankLong = new String[]{"Ace", "King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven",
        "Six", "Five", "Four", "Three", "Two"};
        
    //Method to return the "short name" of the card, drawn from the various Short arrays:
    //ie: "Ac" for "Ace of Clubs".
    /**Method getShortName() should return the "short name" of the card.
     * @return suitShort rankShort*/
    public String getShortName();
    
    //Method to return the full name of the card, drawn from the various Long arrays:
    //ie: "Ace of Clubs"
    /**Method getLongName() should return the "long name" of the card.
     * @return suitLong rankLong*/
    public String getLongName();
}


