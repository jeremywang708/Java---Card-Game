/**
 * File name: Lab4.java
 * Author: Yun Wang, ID# 041069121
 * Course: CST8132 – OOP, Lab Section: 302
 * Lab: 04
 * Date: 2022-11-08
 * Professor: Gustavo Adami
 */
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * This class serves to run the card game
 * @author Jeremywang
 * @version this is the 11th version
 * @see CardTemplate
 * @see Card
 * @see Player
 * @since version 11
 */
public class Lab4
{
    /**Declare that there are 4 players in this card game*/
	final int MAX_PLAYERS = 4;
    /**Create an arraylist deck with type Class Card*/
    ArrayList<Card> deck = new ArrayList<Card>();
    /**Create an array playList with type Class Player*/
    Player[] playerList = new Player[MAX_PLAYERS];
    /**the variable STARTING is a constant initialized with value 0*/
    public final int STARTING=0;
    /**the variable IN_PROGRESS is a constant initialized with value 1*/
    public final int IN_PROGRESS=1;
    /**the variable FINISHED is a constant initialized with value 2*/
    public final int FINISHED=2;
    /**assign the constant variable STARTING to variable status*/
    public int status=STARTING;
    /**the variable roundnum is a constant initialized with value 0*/
    public int roundnum=0;
    /**the variable curPlayer is a constant initialized with value 0*/
    public int curPlayer = 0;
    /**create an object rand using the constructor Random*/
    Random rand = new Random();
    /**create keyboard object for users to prompt input*/
    Scanner keyboard = new Scanner(System.in);
    
    /**The main method serves to run the program by creating an object l4 using Lab4 constructor
     * @param args the start of running the program
     */
    public static void main(String[] args)
    {
        @SuppressWarnings("unused")
		Lab4 l4 = new Lab4();
    }
    /**Create a constructor Lab4*/
    public Lab4()
    {
        for (int iSuit = 0;iSuit<4;iSuit++)
        {
            for (int iRank = 0;iRank<13;iRank++)
            {
                deck.add(new Card(iRank, iSuit));
            }
        }
        //Cards are now created.
        
        startGame();

        
 
        //Menu loop
        boolean quitting=false;
        while(!quitting)
        {
            dealCards();
            quitting = showRound();
            
            //read menu
            //do menu items
        }
        System.out.println("Thanks for playing!\nThis Auto-Cards implementation by Yun Wang.");
    }
    /**This showRound method serves to repeat 13 rounds using do-while loop and conclude a winner eventually, 
     * it returns boolean values based on different scenarios.
     * @return boolean values, true and false
     */
    public boolean showRound()
    {
        int roundNum=1;
        int playerOffset=0;
        String response="";
        

        do
        {
            System.out.println("This is round "+roundNum+".");
            //Show of hands.
            for (int i=0;i<MAX_PLAYERS;i++)
            {
                System.out.println(playerList[i].getName()+"("+playerList[i].getScore()+
                                   " hands won):"+playerList[i].getHand());
            }

            //User bail out chance.
            System.out.println("Enter q to quit, anything else to play out this round: ");
            response = keyboard.nextLine();
            if (response.equals("q")||response.equals("Q")) return true;

            //Players play cards.
            for (int i=0;i<MAX_PLAYERS;i++)
            {
                int curPlayer=(i+playerOffset)%MAX_PLAYERS;
                Card tempCard = playerList[curPlayer].playCard();
                System.out.println(playerList[curPlayer].getName()+" plays "+tempCard.getLongName());
                deck.add(tempCard);
            }

            //Pick a winner.
            playerOffset=rand.nextInt(MAX_PLAYERS);
            System.out.println(playerList[playerOffset].getName()+" wins this hand!\n");
            playerList[playerOffset].handWon();
            roundNum++;

            //Is it game over yet?
        }
        while (roundNum<14);

        System.out.println("Game over!");
        System.out.println("Final scores:");
        int max=0;
        int chosenPlayer=0;
        for (int i=0;i<MAX_PLAYERS;i++)
        {
            System.out.println(playerList[i].getName()+" with "+playerList[i].getScore()+" hands won.");
            if (playerList[i].getScore()>max)
            {
                max=playerList[i].getScore();
                chosenPlayer=i;
            }
        }
        System.out.println(playerList[chosenPlayer].getName()+" has won! (unless they tied)");
        System.out.println("\nAnother game? y to continue: ");

        response = keyboard.nextLine();
        if (response.equals("y")||response.equals("Y")) return false;
        return true;
        
    }
    /**
     * This method serves to deal cards, it is called by the Lab4 constructor in this class and it returns noting 
     */
    public void dealCards()
    {
        //Clear players out.
        for (int i=0;i<MAX_PLAYERS;i++)
        {
            playerList[i].reset();
        }
        
        System.out.println("Dealing cards...");
        int cardSel = 0;
        int deckSize=deck.size();
        for (int i=0;i<deckSize;i++)
        {
            cardSel = rand.nextInt(deck.size());
            playerList[i%MAX_PLAYERS].addCard(deck.get(cardSel));
            deck.remove(cardSel);
        }
    }
    
    
    /**
     * This method serves to start the card game by letting users input player names which are over three characters long,
     * and put each player name into the according playerList array elements, it eventually returns nothing.
     */
    public void startGame()
    {
        System.out.println("Welcome to Auto-Cards.");
        System.out.println("Before we start, let's name the four players.");
        
        String name="";
        for (int i=0;i<MAX_PLAYERS;i++)
        {
            do 
            {
                System.out.print("Enter player "+(i+1)+"'s name: ");
                name=keyboard.nextLine();
                if (name.length()<3) System.out.println("Names must be at least three characters long.");
            }
            while (name.length()<3);
            playerList[i]=new Player(name);
        }
        
    }
    
    
}