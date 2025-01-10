public class Ability {
    String name;
    int damage;
    //we have 10 ability modifiers, each class has 2 with their abilities
    // 0 = no modifier
    //Warriors - slow, stun 1-2
    //Mage - freeze, burn 3-4
    //Rogue - bleed, poison 5-6
    //Archer - trap, slow 7-8
    //Warlock - fear, curse 9-10
    int modifier;   

    public Ability(String name, int damage, int modifier){
        this.name = name;
        this.damage = damage;
        this.modifier = modifier;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for damage
    public int getDamage() {
        return damage;
    }

    // Getter for modifier
    public int getModifier() {
        return modifier;
    }

    public boolean hasModifier(){
        return modifier != 0;
    }
    
}
