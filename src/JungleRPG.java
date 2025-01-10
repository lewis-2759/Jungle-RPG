import java.util.Scanner;

public class JungleRPG {

        public static Player createPlayer() {
            Scanner scanner = new Scanner(System.in);
            String name = "";
            //strength, dexterith, intellect, luck, defense
            int[] stats = new int[5];
            int health = 300;
            Player playerInit = new Player(name,health, stats);
            scanner.close();

            return playerInit;
        }



        public static void main(String[] args) throws Exception {
            
        Scanner scanner = new Scanner(System.in);

        //intro to game
        System.out.println("Welcome to Jungle RPG!");
        System.out.println("In this game, you will create a hero and try to last as long as you can.");

        //player creation
        Player user = createPlayer();

        //set the stage for the beginning of the game

        //game loop
        while (user.isAlive()){
            break;
        }


        //GAME OVER HERE - output some stats on how user did



        //close scanner
        scanner.close();
    }
}
