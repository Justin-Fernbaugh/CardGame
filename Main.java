import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Main 
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static Scanner scanner = new Scanner(System.in);

    public static Player player1 = new Player(20, 1);
    public static Player player2 = new Player(20, 2);

    //name, damage, manaCost, (Optional) effect
    public static Card devCard = new Card("devCard", player1.getHealth(), 2);
    public static Card fireball = new Card("FireBall", 5, 2);
    public static Card ice = new Card("Ice", 5, 2);
    public static Card stopwatch = new Card("Stopwatch", 0, 10, 1);

    //
    public static ArrayList<Card> allCards = new ArrayList<Card>();
    //
    public static void main(String[] args) 
    {
        player2.addCardToInventory(fireball);
        player1.addCardToInventory(fireball);

        //
        startGame();
        
    }

    public static void startupEntries()
    {
        //Adds all cards to a ArrayList
        allCards.add(fireball);
        allCards.add(ice);
        allCards.add(stopwatch);
        


        System.out.println(ANSI_RED + "Card Game v0.01" + ANSI_RESET);
        System.out.println("The game plays in turns with each player getting an action.");

    }
    public static void turnReset()
    {
        Random rand = new Random();
        int n = rand.nextInt(allCards.size());
        int m = rand.nextInt(allCards.size());

        player1.addCardToInventory(allCards.get(n));
        player2.addCardToInventory(allCards.get(m));
        //Give each player mana back.
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

    public static void actionDecide(Player playerToDecide, Player opponent)
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
        String userInput = scanner.nextLine().toLowerCase();
        //Check if user input is equal to card option in cardsToStringArray. - DONE
        
        for(int i = 0; i < playerToDecide.getInventory().size(); i++)
        {
            if(userInput.equals(cardsToStringArray[i]))
            {
                int damageToGive = playerToDecide.getInventory().get(i).getDamage();
                opponent.takeDamage(damageToGive);
                playerToDecide.removeCardFromInventory(i);
                System.out.println(String.format("Player%s has taken %s damage, and now has %s health.", opponent.getPlayerInt(), damageToGive, opponent.getHealth()));
                break;
            }
            else if(userInput.equals("{devCard}"))
            {
                opponent.takeDamage(devCard.getDamage());
                System.out.println(String.format("Player%s has taken %s damage, and now has %s health.", opponent.getPlayerInt(), devCard.getDamage(), opponent.getHealth()));
                break;
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
                //System.out.println(player2.getHealth());
                endGame(player2);
                break;
            }

            //
            if(turnCounter == true)
            {
                actionDecide(player1, player2);
                System.out.println("player1")
                
            }
            else if(turnCounter == false)
            {
                actionDecide(player2, player1);

            }
            turnCounter = !turnCounter;
            turnReset();
        }
    }

}