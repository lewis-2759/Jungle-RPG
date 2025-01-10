public abstract class GameClass {
    
    protected String name;

    public abstract Ability[] getAbilityList();

    public String getClassName(){
        return this.name;
    }

    public GameClass(String name){
        this.name = name;
    }
}
