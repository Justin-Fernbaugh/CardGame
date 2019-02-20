class Player {


    int health;
    Card[] playerCards;

    public Player(int health)
    {
        health = this.health;
    }
    public void takeDamage(int damageTaken)
    {
        this.health = health - damageTaken;
    }



}