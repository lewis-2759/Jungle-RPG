public class Enemy {
    private Ability one;
    private Ability two;
    private String name;
    private int health;
    private int maxHealth;
    private int level;
    private int modifierRemaining;
    private boolean hasModifierCurrent;
    private int modifier;

    public Enemy(String name, Ability one, Ability two, int health, int level) {
        this.name = name;
        this.one = one;
        this.two = two;
        this.health = health;
        this.maxHealth = health;
        this.level = level;
    }

    public boolean isAfflictedBySpecial(){
        return this.modifier == 1 || this.modifier == 2 || this.modifier == 3 || this.modifier == 7 || this.modifier== 8;
    }

    public void printSpecialMessage(){
        switch (this.modifier){
            case 1:
                System.out.println("The enemy is slowed!");
                System.out.println("The enemy missed their turn!");
                break;
            case 2:
                System.out.println("The enemy is stunned!");
                System.out.println("The enemy missed their turn!");
                break;
            case 3:
                System.out.println("The enemy is frozen!");
                System.out.println("The enemy missed their turn!");
                break;
            case 7:
                System.out.println("The enemy is trapped!");
                System.out.println("The enemy missed their turn!");
                break;
            case 8:
                System.out.println("The enemy is slowed!");
                System.out.println("The enemy missed their turn!");
                break;
        }
    }

    public int getModifierTurns(){
        return this.modifierRemaining;
    }

    public void setModifier(int modifier){
        modifierRemaining = 3;
        hasModifierCurrent = true;
        this.modifier = modifier;

    }

    public boolean isAfflicted(){
        return this.hasModifierCurrent;
    }

    public void decrementModifier(){
        switch (this.modifier){
            case 1:
                //slow
                System.out.println("The enemy is slowed!");
                break;
            case 2:
                //stun
                System.out.println("The enemy is stunned!");
                break;
            case 3:
                //freeze
                System.out.println("The enemy is frozen!");
                break;
            case 4:
                //burn
                System.out.println("The enemy is burning!");
                int damage = (int)  (this.health * .2);
                this.takeDamage(damage);
                System.out.println("The burn deals " + damage + " damage!");
                break;
            case 5:
                //bleed
                System.out.println("The enemy is bleeding!");
                damage = (int)  (this.health * .15);
                this.takeDamage(damage);
                System.out.println("The bleed deals " + damage + " damage!");
                break;
            case 6:
                //poison
                System.out.println("The enemy is poisoned!");
                damage = (int)  (this.health * .15);
                this.takeDamage(damage);
                System.out.println("The poison deals " + damage + " damage!");
                break;
            case 7:
                //trap
                System.out.println("The enemy is trapped!");

                break;
            case 8:
                //slow
                System.out.println("The enemy is slowed!");

                break;
            case 9:
                //fear
                System.out.println("The enemy is feared!");
                damage = (int)  (this.health * .05);
                this.takeDamage(damage);
                System.out.println("The fear deals " + damage + " damage!");
                break;
            case 10:
                //curse
                System.out.println("The enemy is cursed!");
                 damage = (int)  (this.health * .2);
                this.takeDamage(damage);
                System.out.println("The curse deals " + damage + " damage!");
                break;
        }
        this.modifierRemaining--;
        if(this.modifierRemaining == 0){
            this.hasModifierCurrent = false;
        }
    }
    // 0 = no modifier
    //Warriors - slow, stun 1-2
    //Mage - freeze, burn 3-4
    //Rogue - bleed, poison 5-6
    //Archer - trap, slow 7-8
    //Warlock - fear, curse 9-10

    public int getModifierNum(){
        return this.modifier;
    }
    public String getModifier(){
       switch (this.modifier){
        case 0:
            return "no modifier";
       case 1:
            return "Slow";
        case 2:
            return "Stun";
        case 3:
            return "Freeze";
        case 4:
            return "Burn";
        case 5:
            return "Bleed";
        case 6:
            return "Poison";
        case 7:
            return "Trap";
        case 8:
            return "Slow";
        case 9:
            return "Fear";
        case 10:
            return "Curse";
        default:
            return "no modifier";
       }
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

    public int getMaxHealth() {
        return this.health;
    }


    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public Ability getAbility(){
        //enemies will randomly use one of their two abilities
        if(Math.random() < 0.5){
            return this.one;
        } else {
            return this.two;
        }
    }

}
