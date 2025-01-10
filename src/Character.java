public class Character {
    private int health;
    private int abilityPower;
    private int characterClass;
    private int strength;   //melee damage, health, defense
    private int dexterity;  //ranged attacks and dodging
    private int intellect;  //spell power
    private int luck;   //this will affect crit chance
    private int[] ability = new int[5];
    private final String name;

    public Character(String name, int health, int abilityPower, int characterClass, int stats[]) {
        this.name = name;
        this.health = health;
        this.abilityPower = abilityPower;
        this.characterClass = characterClass;
        this.strength = stats[0];
        this.dexterity = stats[1];
        this.intellect = stats[2];
        this.luck = stats[3];
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public int getHealth() {
        return this.health;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return this.name;
    }
}