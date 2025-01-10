public class Archer extends GameClass{
    private final Ability [] abilityList;

    @Override
    public Ability[] getAbilityList(){
        return this.abilityList;
    }
    public Archer(){
        super("Archer");
             abilityList = new Ability[5];
             abilityList[0] = new Ability("Arrow Shot", 10, 0);
             abilityList[1] = new Ability("Trap", 20, 7);   //this will trap
             abilityList[2] = new Ability("Poisoned arrow", 23, 6);   //poisoned arrow will poison
             abilityList[3] = new Ability("Viper's Sting", 50, 7);   //this will slow
             abilityList[3] = new Ability("Thrill of the Hunt", 83, 0); 
       }
}
