public class Enemy {
    private Ability one;
    private Ability two;
    private String name;
    private int health;
    private int level;

    public Enemy(String name, Ability one, Ability two, int health, int level) {
        this.name = name;
        this.one = one;
        this.two = two;
        this.health = health;
        this.level = level;
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
