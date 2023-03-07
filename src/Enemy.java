import java.util.Random;

public class Enemy {
    private int hitPoints;
    private int enemyNumber;
    private String enemyName;
    private static final String[] enemyType = {null, "Bat", "Goblin", "Skeleton", "Zombie"};
    
    public Enemy(int enNumber) {    // sets Enemy to given value - assigns HP amount and 'name' based on given enemyNumber
        this.enemyNumber = enNumber;
        this.enemyName = enemyType[this.enemyNumber];
        if (this.enemyNumber == 0) {
            this.hitPoints = 0;
        } else if (this.enemyNumber == 1) {
            this.hitPoints = 6;
        } else if (this.enemyNumber == 2) {
            this.hitPoints = 12;
        } else if (this.enemyNumber == 3) {
            this.hitPoints = 16;
        } else if (this.enemyNumber == 4) {
            this.hitPoints = 20;
        }
    }
    public String toString() {
        return this.enemyName;
    }

    public int attack() {       // attack method generates random int equal to enemyNumber or less, then adds it to enemyNumber & returns as int
        Random rand = new Random();
        int damageRNG = rand.nextInt(this.enemyNumber + 1);
        int damage = this.enemyNumber + damageRNG;
        return damage;
    }
    public int getHP() {
        return this.hitPoints;
    }
    public void damage(int damage) {    // damage method takes int input and reduces enemy HP value by that amuont
        this.hitPoints = this.hitPoints - damage;
    }
    public int getEnNumber() {
        return this.enemyNumber;
    }

}
