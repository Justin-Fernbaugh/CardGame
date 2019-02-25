import java.util.ArrayList;

class Player {


    public static int playerNumber;
    int health;
    ArrayList<Card> playerCards = new ArrayList<Card>();
    private int mana;

    public Player(int health)
    {
        playerNumber++;
        health = this.health;
    }

    public int getPlayerNumber()
    {
        return(playerNumber);
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
            retrievedCards[i] = playerCards.get(i).toString();
        }
        return(retrievedCards);
        
    }
    



}