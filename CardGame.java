/**
 * This class serves as the child class.
 * @author Jeremywang
 * @version this is the 11th version
 * @see Player
 * @see CardTemplate
 * @see Lab4
 * @since Version 11
 */
public class Card implements CardTemplate
{
	/**create an integer variable with value 52, referring to 52 cards in total*/
    int MAX_CARDS = 52;
    /**create an integer variable with value 4, referring to 4 suits in total*/
    int MAX_SUITS = 4;
    /**create an integer variable with value 13, referring to 13 cards in each suit*/
    int MAX_FACES = 13;
 

    /**create an integer variable curSuit*/
    int curSuit;
    /**create an integer variable curRank*/
    int curRank;
    /**
     * create a constructor "Card" to deal cards, constrain the 
     * 
     * @param rankParam one of the parameters for user input
     * @param suitParam one of the parameters for user input
     */
    public Card(int rankParam, int suitParam)
    {
        curSuit=suitParam;
        curRank=rankParam;
        
        if (suitParam<0||suitParam>MAX_SUITS)
        {
            curSuit = 0;
            System.out.println("Error generating card for value "+suitParam+", "+rankParam);
        }
        
        if (rankParam<0||rankParam>MAX_FACES)
        {
            curRank = 0;
            System.out.println("Error generating card for value "+suitParam+", "+rankParam);
        }

    }
 
    /**
     * create a method "getShortName" to return the "short name" of the card 
     * @return string values of according elements in array rankShort and array suitShort
     */
    public String getShortName()
    {
        return rankShort[curRank]+suitShort[curSuit]+" ";
    }
    /**
     * create a method "getLongName" to return the "long name" of the card 
     * @return string values of according elements in array rankLong and array suitLong
     */
    public String getLongName()
    {
        return rankLong[curRank]+" of "+suitLong[curSuit];
    }
}