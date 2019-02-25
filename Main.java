class Main 
{
    //
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static Player player1 = new Player(20, 1);
    public static Player player2 = new Player(20, 2);
    public Card devCard = new Card("devCard", 10, 2);
    public static void main(String[] args) 
    {
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
        System.out.println(other.getHealth());
        System.out.println("Player " + other.getPlayerInt() + " has lost the game.");

    }

    public static void actionDecide(Player other)
    {

        //String[] cardNamesString;
        

        String test = "test";
        System.out.println(String.format("What card would player" + other.getPlayerNumber() + " like to play? (%s)", test));

    }

    public static void startGame()
    {
        startupEntries();
        boolean turnCounter = true;
        while(true)
        {
            if(player1.getHealth() >= 0)
            {
                endGame(player1);
                break;
            }
            else if(player2.getHealth() >= 0)
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