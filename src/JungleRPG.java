import java.util.Random;
import java.util.Scanner;

public class JungleRPG {


    public static void potionDropped(Character player){
        Random random = new Random();
        if(random.nextInt(100) < 20){
            player.getPotion();
            System.out.println("You notice a health potion on the ground!");
        }
    }
   
   
    public static Enemy createEnemy(Character player, Ability[] enemyAbilities, String[] enemyNames){
        Random random = new Random();
        int enemyLevel = random.nextInt(-2, 2);
        enemyLevel += player.getLevel();
        int enemyName = random.nextInt(enemyNames.length);
        int enemyAbilityOne = random.nextInt(enemyAbilities.length);
        int enemyAbilityTwo = random.nextInt(enemyAbilities.length);
        int randomHealthModifier = random.nextInt(-10,10) + 1;
        int enemyHealth = player.getMaxHealth() + randomHealthModifier;
        return new Enemy(enemyNames[enemyName], enemyAbilities[enemyAbilityOne], enemyAbilities[enemyAbilityTwo], enemyHealth, enemyLevel);
    }
   
   
    public static boolean encounterEnemy(Character player){
        Random random = new Random();
        if(random.nextInt(100) < 33){
            System.out.println("You have encountered an enemy!");
            return true;
        }
        int luck = player.getLuck();
        for(int i = 0; i < luck; i++){
            if(random.nextInt(100) == 37){
                System.out.println("Enemy avoided due to luck!");
                return false;
            }
        }
        System.out.println("There are no enemies around currently ...");
        
        return false;
    }


    public static int roll(Character player){
        int luck = player.getLuck();
        int luckSteps = 0;
        Random random = new Random();
        int steps = random.nextInt(10) + 1;
        for(int i =0 ; i< luck; i++){
            if(random.nextInt(100) < 20){
                luckSteps++;
            }
        }
        steps += luckSteps;
        return steps;
    }
    
    
    public static void printModifier(int modifier){
        String [] modifierNames = {"No Modifier", "Slow", "Stun", "Freeze", "Burn", "Bleed", "Poison", "Trap", "Slow", "Fear", "Curse"};
        System.out.println("Modifier: " + modifierNames[modifier]);
    }

    
    public static int takeTurn(Character player, Enemy enemy, Scanner scanner){
        System.out.println("It is your turn to attack.");
        System.out.println("The enemy has " + enemy.getHealth() + " health remaining.");
        int level = player.getLevel();
        int abilityCount =0;
        if(level >= 30){
            abilityCount = 5;
        }
        else if(level > 20){
            abilityCount = 4;
        }
        else if(level > 10){
            abilityCount = 3;
        }
        else if(level > 5){
            abilityCount = 2;
        }
        else {
            abilityCount = 1;
        }

        System.out.println("You may choose from the following abilities: ");
        Ability [] abilities = player.getCharacterClass().getAbilityList();
        for(int i = 0; i < abilityCount; i++){
            
            System.out.println((i + 1) + ". " + abilities[i].getName() + " - " + abilities[i].getDamage() + " damage.");
            if(abilities[i].hasModifier()){
                printModifier(abilities[i].getModifier());
            }
        }
        System.out.print("Choose an ability: ");
        int abilityChoice = scanner.nextInt();
        while(abilityChoice < 1 || abilityChoice > abilityCount){
            System.out.print("Please enter a valid ability number: ");
            abilityChoice = scanner.nextInt();
        }
        Ability chosenAbility = abilities[abilityChoice - 1];
        int damageDealt = chosenAbility.getDamage();
        enemy.takeDamage(damageDealt);
        System.out.println("You use " + chosenAbility.getName() + "!");
        System.out.println("It deals " + damageDealt + " damage!");
        System.out.println("The enemy now has " + enemy.getHealth() + " health remaining.");
        System.out.println("---------------------------------------------");

        return damageDealt;

    }


    public static void tutorialLevel(Character player){
        //30 health enemy, drops 10 gold and a healing potion
        Scanner scanner = new Scanner(System.in);
        System.out.println("Just before entering the jungle, you encounter a small evil creature with bone-thin arms, no skin, and beady eyes.");
        System.out.println("It looks at you, eyeing your possessions, and you know it is time to fight.");
        System.out.println("---------------------------------------------");
        scanner.nextLine();
        Enemy tutorialEnemy = new Enemy("Skinless Creature", new Ability("Bite", 9, 0), new Ability("Claw", 8, 5), 30, 1);

        System.out.println("Combat is turn based. Every fight, you will go first.");
        System.out.println("You will have a choice of abilities to use, each with a different effect and damage.");
        System.out.println("The enemy will then attack you with one of its abilities.");
        System.out.println("The fight will continue until one of you has fallen.");
        System.out.println("---------------------------------------------");
        scanner.nextLine();
        System.out.println("Enemies will drop gold and potentially items when defeated.");
        System.out.println("You will also gain experience for defeating enemies.");
        System.out.println("When you have enough experience, you will level up and gain a skill point.");
        System.out.println("You can use skill points to increase your attributes.");
        System.out.println("---------------------------------------------");
        scanner.nextLine();

        while(tutorialEnemy.isAlive()){
           
            takeTurn(player, tutorialEnemy, scanner);
            if(tutorialEnemy.isAlive()){
            System.out.println("Now it is time for the Skinless Creature to attack.");
            Ability enemyAbility = tutorialEnemy.getAbility();
            Random random = new Random();
            int baseDamage = enemyAbility.getDamage();
            int variance = (int) (baseDamage * 0.2);
            int damageDealt = baseDamage + random.nextInt(2 * variance + 1) - variance;

            System.out.println("The Skinless Creature uses " + enemyAbility.getName() + "!");
            System.out.println("It deals " + damageDealt + " damage!");
            player.takeDamage(damageDealt);
            System.out.println("You have " + player.getHealth() + " health remaining.");
            System.out.println("---------------------------------------------");
            }

        }


        System.out.println("You have defeated Skinless Creature!");
        System.out.println("---------------------------------------------");
        System.out.println("You have gained 10 gold and a healing potion.");
        System.out.println("Health potions can be used to restore 25% of your health.");
        System.out.println("You have also gained 25 experience.");
        System.out.println("You still need 75 experience to level up.");
        scanner.nextLine();
        player.findGold(10);
        player.getPotion();
        player.gainExperience(25);


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
        scanner.nextLine();
        System.out.println("Attributes: ");
        System.out.println("Strength: Melee damage, health and defense.");
        System.out.println("Dexterity: Ranged attacks and dodging.");
        System.out.println("Intellect: Spell power and experience rate.");
        System.out.println("Luck: Crit chance and gold droprate.");

        int statsRemaining = 25;

        String [] statNames = {"Strength", "Dexterity", "Intellect", "Luck"};
        System.out.println("---------------------------------------------");
        scanner.nextLine();
    
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
        Scanner scanner = new Scanner(System.in);
        //once level 15, it is always 5000
        final int[] EXP_TO_NEXT_LEVEL = {0,100, 200, 300, 400, 500, 750, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 5000};
        final int MAX_EXP_15 = 5000;

        final String [] modifierNames = {"No Modifier", "Slow", "Stun", "Freeze", "Burn", "Bleed", "Poison", "Trap", "Slow", "Fear", "Curse"};

        final Ability [] enemyAbilities = {new Ability("Bite", 9, 0), new Ability("Claw", 8, 5), new Ability("Intimidate", 9, 0), new Ability("Maul", 7, 1), new Ability("Roar", 8, 9), new Ability("Swipe", 7, 0), new Ability("Tear", 9, 0), new Ability("Thrash", 10, 2)};
        final String [] enemyNames = {"Jungle Rat", "Giant Spider", "Wild Boar", "Giant Snake", "Jungle Bear", "Jungle Panther", "Jungle Tiger", "Massive Gorilla", "Cannibal", "Rogue Wizard", "Jungle Demon", "Jungle Dragon"};
        int stepsWalked = 0;
        int goldCollected = 0;
        int enemiesKilled = 0;
        int totalDamageDealt = 0;

        //explain the game here better
        System.out.println("Welcome to Jungle RPG!");
        System.out.println("This is a turn based combat RPG style survival game.");
        System.out.println("Hit enter in order to continue whenever the text is paused.");
        System.out.println("---------------------------------------------");
        scanner.nextLine();

        Character player = createCharacter();

        outputIntro();
        scanner.nextLine();

        System.out.println("Would you like to begin the tutorial level? (y/n)");
        String tutorial = scanner.nextLine();
        while(!tutorial.equals("y") && !tutorial.equals("n")){
            System.out.print("Please enter y or n: ");
            tutorial = scanner.nextLine();
        }
        if(tutorial.equals("y")){
            tutorialLevel(player);
            enemiesKilled = 1;
            goldCollected = 10;
            totalDamageDealt = 30;
            System.out.println("---------------------------------------------");
            scanner.nextLine();
            System.out.println("After defeating the Skinless Creature, a wild wizard passes you by.");
            System.out.println("He looks at you and says, 'You have potential, but you are not ready for the jungle.'");
            System.out.println("He waves his hand and you are transported to the entrance of the jungle.");
            System.out.println("You have been given a second chance, as he heals your wounds and gives you a small bag of 20 gold.");
            System.out.println("He wishes you luck and disappears in a flash.");
            System.out.println("---------------------------------------------");
            scanner.nextLine();
            goldCollected += 20;
            player.findGold(20);
        }

        System.out.println("As you slowly creep into the dark jungle, many sounds fill your ears.");
        System.out.println("There are many enemies here, and you must be prepared to fight.");
        System.out.println("At any moment one might appear.");
        System.out.println("You wonder if you will ever see the light of day again ...");
        System.out.println("---------------------------------------------");
        scanner.nextLine();

        //main gameplay loop - we travel a certain distance (random roll based on luck)
        Enemy currentEnemy;
        while(player.isAlive()){
           int steps =  roll(player);
           stepsWalked += steps;
           System.out.println("You walk " + steps + " steps.");
           System.out.println("---------------------------------------------");
           scanner.nextLine();
           //fix this
            if(encounterEnemy(player)){
               currentEnemy =  createEnemy(player, enemyAbilities, enemyNames);
                System.out.println("You have encountered a " + currentEnemy.getName() + "!");
                System.out.println("Prepare to fight!");
                System.out.println("---------------------------------------------");
                scanner.nextLine();
                while(player.isAlive() && currentEnemy.isAlive()){
                    totalDamageDealt += takeTurn(player, currentEnemy, scanner);
                    if(currentEnemy.isAlive()){
                    System.out.println("Now it is time for the " + currentEnemy.getName() + " to attack.");
                    Ability enemyAbility = currentEnemy.getAbility();
                    Random random = new Random();
                    int baseDamage = enemyAbility.getDamage();
                    int variance = (int) (baseDamage * 0.2);
                    int damageDealt = baseDamage + random.nextInt(2 * variance + 1) - variance;

                    System.out.println("The " + currentEnemy.getName() + " uses " + enemyAbility.getName() + "!");
                    System.out.println("It deals " + damageDealt + " damage!");
                    player.takeDamage(damageDealt);
                    System.out.println("You have " + player.getHealth() + " health remaining.");
                    System.out.println("---------------------------------------------");
                    scanner.nextLine();
                    }
                }

                if(player.isAlive()){
                    System.out.println("You have defeated the " + currentEnemy.getName() + "!");
                    Random random = new Random();
                    int goldModifier = random.nextInt(0, 10) + 1;
                    int experienceModifier = random.nextInt(-10, 10) + 1;
                    int goldDropped = (currentEnemy.getLevel() * 3 / 2 + goldModifier ) / 2;
                    if(goldDropped < 0){
                        goldDropped += 10;
                    }
                    int expGained = currentEnemy.getLevel() * 20 + experienceModifier;
                    if(expGained <= 0 ){
                        expGained += 10;
                    }
                    player.gainExperience(expGained);
                    int expNeeded;
                    if(player.getLevel()>14){
                        expNeeded = MAX_EXP_15 - player.getExperience();
                    }
                    else {
                        expNeeded = EXP_TO_NEXT_LEVEL[player.getLevel()] - player.getExperience();
                    }
                    System.out.println("You have gained " + goldDropped + " gold.");
                    potionDropped(player);
                    System.out.println("You have also gained " + expGained + " experience.");
                    if(expNeeded > 0){
                    System.out.println("You still need " + expNeeded + " experience to level up.");
                    } else {
                        int skillChoice = -1;
                        while(skillChoice < 1 || skillChoice > 4){
                            System.out.println("You have leveled up! Choose a skill to increase: ");
                            System.out.println("1. Strength");
                            System.out.println("2. Dexterity");
                            System.out.println("3. Intellect");
                            System.out.println("4. Luck");
                            System.out.print("Choose a skill: ");
                            skillChoice = scanner.nextInt();
                            if(skillChoice < 1 || skillChoice > 4){
                                System.out.println("Please enter a valid skill number 1-4.");
                            }
                        }
                        player.levelUp(skillChoice);
                        System.out.println("---------------------------------------------");
                        System.out.println("You have leveled up! You are now level " + player.getLevel() + "!");
                        System.out.println("You have gained 10 health and are now at " + player.getHealth() + " health.");
                        System.out.println("Your current skill points are now: ");
                        System.out.println("Strength: " + player.getStrength());
                        System.out.println("Dexterity: " + player.getDexterity());
                        System.out.println("Intellect: " + player.getIntellect());
                        System.out.println("Luck: " + player.getLuck());

                        if(player.getLevel() == 5 || player.getLevel() == 10 || player.getLevel() == 15 || player.getLevel() == 20 || player.getLevel() == 30){
                            System.out.println("You have unlocked a new ability!");
                        }
                    }
                    System.out.println("---------------------------------------------");
                    scanner.nextLine();
                    goldCollected += goldDropped;
                    player.findGold(goldDropped);
                    enemiesKilled++;
                    totalDamageDealt += currentEnemy.getMaxHealth();
                }
            }
        }

        scanner.nextLine();
        System.out.println("---------------------------------------------");
        System.out.println("You have died in the jungle, as all eventually do.");
        System.out.println("---------------------------------------------");
        scanner.nextLine();
        System.out.println("You walked " + stepsWalked + " steps.");
        if(enemiesKilled == 1){
            System.out.println("You killed " + enemiesKilled + " enemy.");
        } else {
        System.out.println("You killed " + enemiesKilled + " enemies.");
        }
        System.out.println("You collected " + goldCollected + " gold.");
        System.out.println("You dealt " + totalDamageDealt + " damage.");
        System.out.println("Thank you for playing Jungle RPG!");
        System.out.println("---------------------------------------------");

        scanner.close();

    }
}