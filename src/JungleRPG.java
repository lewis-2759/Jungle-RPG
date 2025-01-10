import java.util.Scanner;

public class JungleRPG {

    public static void tutorialLevel(Character player){

    }

    public static void outputIntro(){
        System.out.println("You are on a mission to enter the dangerous jungle of Janguquisha.");
        System.out.println("It is said that no one has ever survived longer than a week here.");
        System.out.println("Your goal is to survive as long as you can, and grow as strong as you can.");
        System.out.println("Only then will you be able to tame the jungle.");
        System.out.println("Good luck ...");
        System.out.println("---------------------------------------------");
    }

    public static Character createCharacter() {
        //ADD INPUT VALIDATION FOR INT PARSING 

         Scanner scanner = new Scanner(System.in);
         String confirm = "n";
         String name = "";
         int classChoice = 0;
         int [] stats = new int[4];

        while(confirm.equals("n")){
            classChoice = 0;
            stats = new int[4];
            name = "";

        System.out.print("Enter your character's name: ");
        while(name.equals("")){
            name = scanner.nextLine();
            if(name.equals("")){
                System.out.print("Please enter a name: ");
            }
        }
        System.out.println("Greetings " + name + "!");
        System.out.println("---------------------------------------------");
        System.out.println("Choose a class: ");

        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Rogue");
        System.out.println("4. Warlock");
        System.out.println("5. Archer");

        while(classChoice < 1 || classChoice > 5){
            System.out.print("Choose a class: ");
            classChoice = scanner.nextInt();
            if(classChoice < 1 || classChoice > 5){
                System.out.println("Please enter a valid class number 1-5 ");
            }
        }
        System.out.println("---------------------------------------------");

        String [] classNames = {"Warrior", "Mage", "Rogue", "Warlock", "Archer"};
        System.out.println("You have chosen the " + classNames[classChoice - 1] + " class.");

    
        System.out.println("Now you will be selecting the attributes for your character.");
        System.out.println("You are given 25 skill points to spend.");
        System.out.println("You can put up to 10 skill points in each attribute, or none at all.");
        System.out.println("---------------------------------------------");
        System.out.println("Strength: Melee damage, health and defense.");
        System.out.println("Dexterity: Ranged attacks and dodging.");
        System.out.println("Intellect: Spell power.");
        System.out.println("Luck: Crit chance and gold droprate.");

        int statsRemaining = 25;

        String [] statNames = {"Strength", "Dexterity", "Intellect", "Luck"};
        System.out.println("---------------------------------------------");

        for(int i = 0; i < stats.length; i++){

            if(statsRemaining > 0){
            System.out.println("You have " + statsRemaining + " skill points remaining.");
            System.out.print("Enter points for attribute " + statNames[i] + ": ");
            int temp = scanner.nextInt();
            while(temp < 0 || temp > 10){
                System.out.print("Please enter a valid number between 0 and 10: ");
                temp = scanner.nextInt();
            }
            if(temp > statsRemaining){
                System.out.println("You do not have enough skill points to put that many in this attribute.");
                System.out.println("Putting your remaining " + statsRemaining + " skill points in " + statNames[i] + ".");
                stats[i] = statsRemaining;
                statsRemaining = 0;
            } else {
                stats[i] = temp;
                statsRemaining -= temp;
            }
            }
        }  
        System.out.println("---------------------------------------------");
        System.out.println("You have put your skill points in the following attributes: ");
        for(int i = 0; i < stats.length; i++){
            System.out.println(statNames[i] + ": " + stats[i]);
        }
        System.out.println("---------------------------------------------");
        System.out.println("Character creation complete! ");
        System.out.println("Would you like to continue with this character? (y/n)");
        confirm = scanner.nextLine();
        while(!confirm.equals("y") && !confirm.equals("n")){
            System.out.print("Please enter y or n: ");
            confirm = scanner.nextLine();
        }
        }

        System.out.println("---------------------------------------------");

        scanner.close();

        GameClass classChosen;
        switch(classChoice) {
            case 1:
                classChosen = new Warrior();
                break;
            case 2:
                classChosen = new Mage();
                break;
            case 3:
                classChosen = new Rogue();
                break;
            case 4:
                classChosen = new Warlock();
                break;
            case 5:
                classChosen = new Archer();
                break;
            default:
            //default to warrior, this should never happen
                classChosen = new Warrior();
                break;
        }
        Character player =  new Character(name, classChosen, stats);
        return player;
    }
    public static void main(String[] args) {
        //once level 15, it is always 5000
        final int[] EXP_TO_NEXT_LEVEL = {0,100, 200, 300, 400, 500, 750, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 5000};
        final int MAX_EXP_15 = 5000;

        final String [] modifierNames = {"No Modifier", "Slow", "Stun", "Freeze", "Burn", "Bleed", "Poison", "Trap", "Slow", "Fear", "Curse"};

        final Ability [] enemyAbilities = {new Ability("Bite", 9, 0), new Ability("Claw", 8, 5), new Ability("Intimidate", 9, 0), new Ability("Maul", 7, 1), new Ability("Roar", 8, 9), new Ability("Swipe", 7, 0), new Ability("Tear", 9, 0), new Ability("Thrash", 10, 2)};
        int stepsWalked = 0;
        int goldCollected = 0;
        int enemiesKilled = 0;
        int totalDamageDealt = 0;

        //explain the game here better
        System.out.println("Welcome to Jungle RPG!");

        Character player = createCharacter();

        outputIntro();

        tutorialLevel(player);
        enemiesKilled = 1;
        goldCollected = 10;
        totalDamageDealt = 30;

        //main gameplay loop - we travel a certain distance (random roll based on luck)
        //we encounter a monster (based on luck and dexterity, strength hurts you here)

        //if we encounter a monster begin the combat loop until the enemy or you are dead

        //if you survive, give exp, if level up, give attribute points and maybe skill

        //roll for a healing potion or gold

        //gain exp from walking and killing monsters

        //every level up, give 1 skill point, at level 5, 10 , 20, 30 - a new ability



        System.out.println("---------------------------------------------");
        System.out.println("You have died in the jungle, as all eventually do.");
        System.out.println("You walked " + stepsWalked + " steps.");
        System.out.println("You killed " + enemiesKilled + " enemies.");
        System.out.println("You collected " + goldCollected + " gold.");
        System.out.println("You dealt " + totalDamageDealt + " damage.");



    }
}