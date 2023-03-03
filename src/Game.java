import java.util.*;

public class Game {

    public static void outside(Player player) {
        Room location = new Room(0);
        location.examine();
        actions(location, player);
        System.out.println("You enter the first room!\n");
    }
    public static void room1(Player player) {
        Random rand = new Random();
        Room location = new Room(1);
        System.out.println("As you enter the first room, you are attacked by a bat!\n");
        Enemy bat = new Enemy(1);
        fight(player, bat);
        actions(location, player);
        int chance = rand.nextInt(2);
        if (chance == 1) {
            System.out.println("Before you can enter the next room, another bat attacks!\n");
            Enemy bat2 = new Enemy(1);
            fight(player, bat2);
        }
        System.out.println("You bolt into the next room!\n");
    }
    public static void room2(Player player) {
        Room location = new Room(2);
        actions(location, player);
        System.out.println("Before you can enter the next room, a goblin springs out from the darkness and attacks!\n");
        Enemy goblin = new Enemy(2);
        fight(player, goblin);
        actions(location, player);
        System.out.println("Having defeated the goblin, you now enter the last room!\n");
    }

    public static void room3(Player player) {
        Room location = new Room(3);
        System.out.println("As you enter the last room, a skeleton appears out of nowhere to attack you!\n");
        Enemy skeleton1 = new Enemy(3);
        fight(player, skeleton1);
        actions(location, player);
        System.out.println("You sprint toward the exit, but a skeleton and a zombie guard it! The skeleton lurches forward and attacks you!\n");
        Enemy skeleton2 = new Enemy(3);
        Enemy zombie = new Enemy(4);
        fight(player, skeleton2);
        System.out.println("As soon as you defeat the skeleton, the zombie attacks!\n");
        fight(player, zombie);
        System.out.println("Both enemies have been defeated! You sprint outside!\n");
    }
    public static void actions(Room location, Player player) {
        Scanner input = new Scanner(System.in);
        char action = 'q';
        do {
            System.out.println("What will you do? [e]xamine room, [h]eal, or move to the [n]ext room?");
            action = input.nextLine().charAt(0);
            if (action == 'e') {
                location.examine();
            } else if (action == 'h') {
                player.heal();
                System.out.println("Player HP: " + player.getHP() + "\n");
            }
        } while (action != 'n');
    }

    public static void fight(Player player, Enemy enemy) {
        Random rand = new Random();
        Scanner attackInput = new Scanner(System.in);
        do {
        if (player.getHP() <= 0) {
            System.out.println("You died!");
            gameOver();
        } else {
            System.out.println(enemy + " HP: " + enemy.getHP() + "\n");
            System.out.println("Will you [a]ttack or [h]eal?");
            char attackChoice = attackInput.nextLine().charAt(0);
            if (attackChoice == 'a') {
                System.out.println("You slice at the " + enemy + "!");
                int damageDealt = rand.nextInt(5) + enemy.getEnNumber();
                enemy.damage(damageDealt);
                System.out.println("You dealt " + damageDealt + " damage!");
            } else if (attackChoice == 'h') {
                player.heal();
                System.out.println("Player HP: " + player.getHP());
            }
            int enemyAttack = rand.nextInt(2);
            if (enemyAttack == 1 && enemy.getHP() > 0) {
                System.out.println("The " + enemy + " attacks you!");
                int damageReceived = enemy.attack();
                player.damage(damageReceived);
                System.out.println("The " + enemy + " dealt " + damageReceived + " damage!");
                System.out.println("Player HP: " + player.getHP());
            }
        }
        if (enemy.getHP() <= 0) {
            System.out.println("The " + enemy + " was defeated!\n");
        }
        } while (enemy.getHP() > 0);
    }
    public static void gameOver() {
        System.out.println("Game Over - try again next time!");
        System.exit(0);
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the player's name?");
        String playerName = in.nextLine();
        Player player = new Player(playerName);
        System.out.println("Your name is " + player.toString() + "!\n");
        System.out.println("You are tasked with crossing to the other side of a mountain by means of a dungeon that travels through it. \n"
            + "To reach the other side, you must pass through 3 rooms, each with more dangerous enemies - you will have to fight them off. \n"
            + "Best of luck!\n");
        outside(player);
        room1(player);
        room2(player);
        room3(player);
        System.out.println("You emerge on the other side of the mountain! Congratulations!\n");
    }  
}