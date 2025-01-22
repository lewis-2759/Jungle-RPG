

public class Character {
    private int health;
    private int maxHealth;
    GameClass characterClass;
    private int strength;   //melee damage, health, defense
    private int dexterity;  //ranged attacks and dodging
    private int intellect;  //spell power
    private int luck;   //this will affect crit chance
    private int level;
    private int experience;
    private int gold;
    private int healthPotions;
    private final String name;


    public Character(String name, GameClass characterClassChosen, int stats[]) {
        this.name = name;
        this.health = 30; //default health is 100
        this.maxHealth = 30;

        this.strength = stats[0];
        this.dexterity = stats[1];
        this.intellect = stats[2];
        this.luck = stats[3];

        this.level = 1;
        this.experience = 0;
        this.gold = 0;
        this.healthPotions = 0;
        this.characterClass = characterClassChosen;
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

    public void setHealth(int health){
        this.health = health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
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

    public void gainExperience(int exp) {
        this.experience += exp;
    }

    public int getGold(){
        return this.gold;
    }

    public void findGold(int gold){
        this.gold += gold;
    }

    public void getPotion(){
        this.healthPotions++;
    }

    public boolean hasPotion(){
        return this.healthPotions > 0;
    }

    public void usePotion(){
        int healthGained = (int)(this.maxHealth * 0.5);
        if(this.healthPotions > 0){
            this.health += healthGained;
            this.healthPotions--;
        }
        if(this.health > this.maxHealth){
            this.health = this.maxHealth;
        }
        System.out.println("You used a health potion and gained " + healthGained + " health");
    }

    public void levelUp(int skillChoice){   //0 = strength, 1 = dexterity, 2 = intellect, 3 = luck
        this.level++;
        this.experience = 0;
        this.maxHealth += 10;
        this.health = this.maxHealth;
        switch(skillChoice){
            case 0:
                this.strength += 1;
                break;
            case 1:
                this.dexterity += 1;
                break;
            case 2:
                this.intellect += 1;
                break;
            case 3:
                this.luck += 1;
                break;
            default:
                System.out.println("Invalid skill choice"); //this should never happen
        }
    }
}