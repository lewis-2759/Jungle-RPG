

public class Character {
    private int health;
    GameClass characterClass;
    private int strength;   //melee damage, health, defense
    private int dexterity;  //ranged attacks and dodging
    private int intellect;  //spell power
    private int luck;   //this will affect crit chance
    private int level;
    private int experience;
    private int gold;
    private final String name;

    public Character(String name, GameClass characterClass, int stats[]) {
        this.name = name;
        this.health = 300; //default health is 300
        this.characterClass = characterClass;

        this.strength = stats[0];
        this.dexterity = stats[1];
        this.intellect = stats[2];
        this.luck = stats[3];

        this.level = 1;
        this.experience = 0;
        this.gold = 0;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public int getHealth() {
        return this.health;
    }

    public String getName() {
        return this.name;
    }

    public GameClass getCharacterClass() {
        return this.characterClass;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getIntellect() {
        return this.intellect;
    }

    public int getLuck() {
        return this.luck;
    }

    public int getLevel() {
        return this.level;
    }

    public int getExperience() {
        return this.experience;
    }
    public int getGold(){
        return this.gold;
    }

    public void findGold(int gold){
        this.gold += gold;
    }
}