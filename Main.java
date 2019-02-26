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
    public static void turnReset()
    {
        //add a random card to each player inventory
    }

    public static void endGame(Player playerKilled)
    {
        if(playerKilled.getHealth() <= 20)
        {
            System.out.println("Health when killed: " + playerKilled.getHealth());
            System.out.println("Player " + playerKilled.getPlayerInt() + " has lost the game.");
        }
        else
        {
            System.out.println("Error, health left: " + playerKilled.getHealth());
        }
    }

    public static void actionDecide(Player playerToDecide, player opponent)
    {
        String cardsToString = "";
        String[] cardsToStringArray = new String[playerToDecide.getCardNames().length];
        for(int i = 0; i < playerToDecide.getCardNames().length; i++)
        {
            cardsToStringArray = playerToDecide.getCardNames();
            if(i + 1 < cardsToStringArray.length)
            {
                cardsToString += cardsToStringArray[i] + ", ";
            }
            else
            {
                cardsToString += cardsToStringArray[i];
            }
        }
        System.out.println(String.format("What card would %s player" + playerToDecide.getPlayerInt() + " %slike to play? (%s)", ANSI_RED, ANSI_RESET, cardsToString));
        String userInput = scanner.nextLine();
        //Check if user input is equal to card option in cardsToStringArray. - DONE
        for(int i = 0; i < cardsToStringArray.length; i++)
        {
            if(userInput.equals(cardsToStringArray[i]))
            {;
                opponent.takeDamage(cardtoPlay.getDamage());
                playerToDecide.removeCardFromInventory(i);
            }
        }

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
                actionDecide(player1, player2);
                
            }
            else if(turnCounter == false)
            {
                actionDecide(player2, player1);

            }
            turnCounter = !turnCounter;

        }
    }

}