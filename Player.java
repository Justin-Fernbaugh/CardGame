import java.util.ArrayList;

class Player {


    public static int playerNumber;
    private int health;
    private ArrayList<Card> playerCards = new ArrayList<Card>();
    private int mana;
    private int playerInt;

    public Player(int health, int playerInt)
    {
        playerNumber++;
        mana = 10;
        health = this.health;
        this.playerInt = playerInt;
        this.health = 20;
    }

    public int getPlayerNumber()
    {
        return(playerNumber);
    }
    public int getPlayerInt()
    {
        return(this.playerInt);
    }

    public void takeDamage(int damageTaken)
    {
        this.health = health - damageTaken;
    }
    public int getHealth()  
    {
        return(this.health);
    }
    
    public void addCardToInventory(Card other)
    {
        playerCards.add(other);

    }

    public ArrayList<Card> getInventory()
    {
        return(playerCards);
        
    }

    public String[] getCardNames()
    {
        String[] retrievedCards = new String[playerCards.size()];
        for(int i = 0; i < playerCards.size(); i++)
        {
            retrievedCards[i] = playerCards.get(i).name().toString();
        }
        return(retrievedCards);
        
    }
    



}