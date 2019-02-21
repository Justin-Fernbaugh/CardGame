import java.util.ArrayList;

class Player {


    public static int playerNumber;
    //playerNumber++;
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
    



}