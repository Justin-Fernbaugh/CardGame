import java.util.Scanner;

class Main 
{
    //
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static Scanner scanner = new Scanner(System.in);

    public static Player player1 = new Player(20, 1);
    public static Player player2 = new Player(20, 2);
    public static Card devCard = new Card("devCard", 10, 2);
    public static void main(String[] args) 
    {
        player1.addCardToInventory(devCard);
        player2.addCardToInventory(devCard);
        player1.addCardToInventory(devCard);
        player2.addCardToInventory(devCard);
        /*Gonna need to implement an interface "card"
        then create a class each time for a new card
        */
        startGame();
        
    }

    public static void startupEntries()
    {
        System.out.println(ANSI_RED + "Card Game v0.01" + ANSI_RESET);
        System.out.println("The game plays in turns with each player getting an action.");

    }

    public static void endGame(Player other)
    {
        if(other.getHealth() <= 20)
        {
            System.out.println("Health when killed: " + other.getHealth());
            System.out.println("Player " + other.getPlayerInt() + " has lost the game.");
        }
        else
        {
            System.out.println("Error, health left: " + other.getHealth());
        }
        //System.out.println(other.getHealth());
        

    }

    public static void actionDecide(Player other)
    {
        String temp = "";
        for(int i = 0; i < other.getCardNames().length; i++)
        {
            String[] tempArray = other.getCardNames();
            if(i + 1 < tempArray.length)
            {
                temp += tempArray[i] + ", ";
            }
            else
            {
                temp += tempArray[i];
            }
            

        }
        System.out.println(String.format("What card would player" + other.getPlayerInt() + " like to play? (%s)", temp));
        String userInput = scanner.nextLine();

    }

    public static void startGame()
    {
        startupEntries();
        boolean turnCounter = true;
        while(true)
        {
            if(player1.getHealth() <= 0)
            {
                endGame(player1);
                break;
            }
            else if(player2.getHealth() <= 0)
            {
                System.out.println(player2.getHealth());
                endGame(player2);
                break;
            }

            //
            if(turnCounter == true)
            {
                actionDecide(player1);
                
            }
            else if(turnCounter == false)
            {
                actionDecide(player2);

            }
            turnCounter = !turnCounter;

        }
    }

}