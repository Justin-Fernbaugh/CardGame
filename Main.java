class Main 
{
    //

    public static Player player1 = new Player(20);
    public static Player player2 = new Player(20);
    public static void main(String[] args) 
    {
        /*Gonna need to implement an interface "card"
        then create a class each time for a new card
        */
        
    }

    public void startupEntries()
    {
        System.out.println("Card Game v0.01");
        System.out.println("The game plays in turns with each player getting an action.");

    }

    public void endGame(Player other)
    {
        System.out.println("Player " + other.getPlayerNumber() + " has lost the game.");

    }

    public void actionDecide(Player other)
    {
        System.out.println("What card would player" + other.getPlayerNumber() + " like to play? (FILL WITH CARDS)");

    }

    public void startGame()
    {
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
                endGame(player2);
                break;
            }
            if(turnCounter == true)
            {
                
            }

        }
    }

}