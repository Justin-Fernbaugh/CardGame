class Player {


    int health;

    public Player(int health)
    {
        health = this.health;
    }
    public void takeDamage(int damageTaken)
    {
        this.health = health - damageTaken;
    }

}