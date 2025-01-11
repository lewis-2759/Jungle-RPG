public class Mage extends GameClass{
    private final Ability [] abilityList;
    
    @Override
    public Ability[] getAbilityList(){
        return this.abilityList;
    }

    public Mage(){
        super("Mage");
             abilityList = new Ability[5];
             abilityList[0] = new Ability("Arcane Blast", 10, 0);
             abilityList[1] = new Ability("Mana Burn", 20, 0);
             abilityList[2] = new Ability("Frostbolt", 30, 3);   //Frostbolt will freeze
             abilityList[3] = new Ability("Fireblast", 50, 4);   //fireblast will burn
             abilityList[4] = new Ability("Blizzard", 60, 3);   //blizzard will freeze
       }
}
