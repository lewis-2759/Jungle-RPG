public class Warlock extends GameClass{
    private final Ability [] abilityList;
    
    @Override
    public Ability[] getAbilityList(){
        return this.abilityList;
    }
    public Warlock(){
        super("Warlock");
             abilityList = new Ability[5];
             abilityList[0] = new Ability("Shadowblast", 10, 0);
             abilityList[1] = new Ability("Dark Omen", 20, 10); //dark omen will curse
             abilityList[2] = new Ability("Demonic Prayer", 30, 0);  
             abilityList[3] = new Ability("Unleash Demon", 45, 9);  //unleash demon will fear
             abilityList[4] = new Ability("Obliterate", 75, 0);
       }
}
