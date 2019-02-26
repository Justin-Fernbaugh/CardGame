class Card
{

    public static int cardNumber;
    private String name;
    private int damage;
    private int manaCost;
    private int effectNumber;


    public Card(String name, int damage, int manaCost)
    {
        cardNumber++;
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
    }
    /*public Card(String name, int damage, int manaCost, int effectNumber)
    {
        cardNumber++;
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
        this.effectNumber = effectNumber;
    }
*/
    public String name()
    {
        return(this.name);

    }

    public int getDamage()
    {
        return(this.damage);
    }

    public int getManaCost()
    {
        return(this.manaCost);
        
    }
    public int getEffect()
    {
        return(this.effectNumber);
    }
}