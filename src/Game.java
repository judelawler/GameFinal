import java.util.*;
// adding comments in progress for other classes
// (Review Comments I'll put in parentheses)

import javax.print.DocFlavor.INPUT_STREAM;

public class Game {

    public static void outside(Player player) {
        Room location = new Room(0);    // creates Room object for outside
        location.examine();
        actions(location, player);  // calls action options
        System.out.println("You enter the first room!\n");  // outside method ends when next room chosen
    }
    public static void room1(Player player) {
        Random rand = new Random();
        Room location = new Room(1);    // Room 1 Room object created
        System.out.println("As you enter the first room, you are attacked by a bat!\n");
        Enemy bat = new Enemy(1);   // create Enemy object w/ enemy number 1
        fight(player, bat);     // calls fight method & sends player & bat (enemy) object
            // when fight ends, returns here
        actions(location, player);  // calls action options
        int chance = rand.nextInt(2);
        if (chance == 1) {      // 50/50 chance of another bat enemy being created & another fight upon choosing to go to next room
            System.out.println("Before you can enter the next room, another bat attacks!\n");
            Enemy bat2 = new Enemy(1);
            fight(player, bat2);
        }
        System.out.println("You bolt into the next room!\n");
    }
    public static void room2(Player player) {
        Room location = new Room(2);    // Room 2 Room object created
        actions(location, player);      // calls action options
        System.out.println("Before you can enter the next room, a goblin springs out from the darkness and attacks!\n");
        Enemy goblin = new Enemy(2);    // goblin enemy created (enemy number 2)
        fight(player, goblin);      // fight method called after player chooses next room in options
        actions(location, player);      // action options called again after fight concludes
        System.out.println("Having defeated the goblin, you now enter the last room!\n");
    }

    public static void room3(Player player) {
        Room location = new Room(3);    // Room 3 Room object created
        System.out.println("As you enter the last room, a skeleton appears out of nowhere to attack you!\n");
        Enemy skeleton1 = new Enemy(3);     // skeleton enemy object created
        fight(player, skeleton1);       // fight called w/ skeleton immediately in room3 method
        actions(location, player);      // action options called after fight concludes
        System.out.println("You sprint toward the exit, but a skeleton and a zombie guard it! The skeleton lurches forward and attacks you!\n");
        Enemy skeleton2 = new Enemy(3);     // creates another skeleton enemy object
        Enemy zombie = new Enemy(4);        // creates zombie enemy object
        fight(player, skeleton2);   // calls fight method w/ second skeleton after player selects next room
        System.out.println("As soon as you defeat the skeleton, the zombie attacks!\n");
        fight(player, zombie);  // calls fight method w/ zombie immediately after skeleoton fight
        System.out.println("Both enemies have been defeated! You sprint outside!\n");   // room3 method concludes immediately after
    }
    public static void actions(Room location, Player player) {  // action options method takes player object and room object
        Scanner input = new Scanner(System.in);
        char action = 'q';
        
        do {    // do/while loop - player can heal or examine room repeatedly, loop eneds when 'n' is chosen
            System.out.println("What will you do? [e]xamine room, [h]eal, or move to the [n]ext room?");
            
             //(If the user inputted nothing, your program would crash before because there is no 0 index a blank string)
             String str = input.nextLine();// character input options of 'a' or 'h'
             if(!str.equals("")){ //(makes sure the user inputted some string before taking the first character)
                action = str.charAt(0);     
             }
            
            
            
            if (action == 'e') {
                location.examine(); // examining room is a method under the Room class
            } else if (action == 'h') {
                player.heal();  // heal is a method under the Player class
                System.out.println("Player HP: " + player.getHP() + "\n");
            }
        } while (action != 'n');    // loop ends immediately when 'n' is selected, and game contineus from where actions was called
    }

    public static void fight(Player player, Enemy enemy) {  // fight method works for any player & enemy object
        Random rand = new Random();
        Scanner attackInput = new Scanner(System.in);
        do {    // do/while loop, checking to see if either player or enemy HP is 0 or lower first, then giving fight options
        if (player.getHP() <= 0) {  // gameOver command runs if player HP is 0 or lower
            System.out.println("You died!");
            gameOver();
        } else {    // fight options occur if player has >0 HP
            System.out.println(enemy + " HP: " + enemy.getHP() + "\n");     // displays enemy HP
            System.out.println("Will you [a]ttack or [h]eal?");

            //(If the user inputted nothing, your program would crash before because there is no 0 index on nothing)
            String input = attackInput.nextLine();// character input options of 'a' or 'h'
            char attackChoice = ' ';
            if(!input.equals("")){ //(makes sure the user inputted some string before taking the first character)
                attackChoice = input.charAt(0);      
            }
            
            if (attackChoice == 'a') {      // 'a' is attack - deals damage to enemy
                System.out.println("You slice at the " + enemy + "!");
                int damageDealt = rand.nextInt(5) + enemy.getEnNumber();    // damage dealt is a random int below 5 plus enemy number
                enemy.damage(damageDealt);
                System.out.println("You dealt " + damageDealt + " damage!");
            } else if (attackChoice == 'h') {   // 'h' is heal - heals player HP
                player.heal();  // heal is a method under the Player class
                System.out.println("Player HP: " + player.getHP());
            }

            int enemyAttack = rand.nextInt(2);  // whether or not an enemy attacks is 50/50
            if (enemyAttack == 1 && enemy.getHP() > 0) {    // also checks if enemy HP is above 0 so that it cannot attack once defeated
                System.out.println("The " + enemy + " attacks you!");
                int damageReceived = enemy.attack();    // enemy damage dealt is determined under enemy class
                player.damage(damageReceived);
                System.out.println("The " + enemy + " dealt " + damageReceived + " damage!");
                System.out.println("Player HP: " + player.getHP());
            }
        }
        if (enemy.getHP() <= 0) {   // prints that enemy was defeated when its HP is 0 or lower
            System.out.println("The " + enemy + " was defeated!\n");
        }
        } while (enemy.getHP() > 0);    // do/while ends here, when enemy HP is 0 or lower
    }
    public static void gameOver() {     // player HP can only be lowered to 0 in a fight - gameOver method runs if it becomes 0 or lower
        System.out.println("Game Over - try again next time!");
        System.exit(0);     // ends program
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the player's name?");
        String playerName = in.nextLine();  // takes scanner input for player name to name Player object
        Player player = new Player(playerName);
        System.out.println("Your name is " + player.toString() + "!\n");
        System.out.println("You are tasked with crossing to the other side of a mountain by means of a dungeon that travels through it. \n"
            + "To reach the other side, you must pass through 3 rooms, each with more dangerous enemies - you will have to fight them off. \n"
            + "Best of luck!\n");
        outside(player);    // calls 'outside' method in main & sends player there
        room1(player);      // does same with 'room1' method - each room is a new method called in main
        room2(player);
        room3(player);
        System.out.println("You emerge on the other side of the mountain! Congratulations!\n");     // successful ending message
    }  
}