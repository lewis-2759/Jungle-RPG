// Player.java
public class Player extends Character {

    //each player will have five stats
    protected int strength;
    protected int dexterity;
    protected int intellect;
    protected int luck;
    protected int defense;

    public Player(String name, int health, int[] stats) {
        super(name, health);
        this.strength = stats[0]; 
        this.dexterity = stats[1];
        this.intellect = stats[2];
        this.luck = stats[3];
        this.defense = stats[4];

    }

    // Additional player-specific methods can be added here
}
