import java.util.Scanner;

public class JungleRPG {

    public static Character createCharacter() {
         Scanner scanner = new Scanner(System.in);

        //get name VALIDATE
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        //select a class VALIDATE
        System.out.println("Choose a class: ");
        int classChoice = 0;


        //pick attributes, give 25 points to put 1-10 in each VALIDATE
        int [] stats = new int[4];


        //return the newly created character
        return new Character(name, 300, 0, classChoice, stats);
    }
    public static void main(String[] args) {
        
        //explain the game here better
        System.out.println("Welcome to Jungle RPG!");

        //create a character
        Character player = createCharacter();

        //now give the intro to the game scenario
        //you are on a mission to enter the dangerous jungle of janguquisha, it is said that no one has ever survived
        //you are to survive as long as you can, and grow as strong as you can so that you may tame the jungle

        //we will now enter the tutorial level (just to give tips and get player to level 2)

        //now we will enter THE JUNGLE
        //main gameplay loop - we travel a certain distance (random roll based on luck)
        //we encounter a monster (based on luck and dexterity, strength hurts you here)

        //if we encounter a monster begin the combat loop until the enemy or you are dead

        //if you survive, give exp, if level up, give attribute points

        //roll for a random piece of loot from enemies

        //every # of steps, find an item upgrade



        //after the game is over, we will report the players stats to them on how they did, and how long they survived



    }
}