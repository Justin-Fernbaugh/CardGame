import java.util.ArrayList;

class Player {


    public static int playerNumber;
    int health;
    ArrayList<Object> playerCards = new ArrayList<Object>();

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
    
    public void addCardToInventory(Object other)
    {
        playerCards.add(other);

    }

    public ArrayList<Object> getInventory()
    {
        return(playerCards);
        
    }

    public String[] getCardNames()
    {
        String[] temp;
        for(int i = 0; i < playerCards.size(); i++)
        {
            //temp[i] = playerCards.get(i).name();


        }

        String[] hhh = {"a", "a"};
        return(hhh);
        
    }
    



}