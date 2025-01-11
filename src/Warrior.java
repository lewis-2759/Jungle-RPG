public class Warrior extends GameClass{
   private final Ability [] abilityList;
    
   @Override
   public Ability[] getAbilityList(){
    return this.abilityList;
   }

   public Warrior(){
    super("Warrior");
         abilityList = new Ability[5];
         abilityList[0] = new Ability("Slash", 10, 0);
         abilityList[1] = new Ability("Whack", 20, 0);
         abilityList[2] = new Ability("Shield Slam", 30, 2);   //shield slam will stun
         abilityList[3] = new Ability("Maul", 50, 1);   //maul will slow
         abilityList[4] = new Ability("Devastate", 70, 0);
   }
}
