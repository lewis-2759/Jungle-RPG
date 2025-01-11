public class Rogue extends GameClass{
    private final Ability [] abilityList;

    @Override
    public Ability[] getAbilityList(){
        return this.abilityList;
    }

    public Rogue(){
        super("Rogue");
             abilityList = new Ability[5];
             abilityList[0] = new Ability("Stab", 10, 0);
             abilityList[1] = new Ability("Bamboozle", 20, 0);
             abilityList[2] = new Ability("Slice", 30, 5);   //slice will bleed
             abilityList[3] = new Ability("Poison", 50,6);   //poison will poison
             abilityList[4] = new Ability("Blade Flurry", 70, 0);
       }
    
}
