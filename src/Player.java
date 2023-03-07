public class Player {
    private int hitPoints;
    private String name;



    public Player() {           // base Player stats w/ default name
        this.hitPoints = 20;
        this.name = "Player";
        
    }
    public Player(String nameInput) {   // still sets HP to 20, inputs new name String
        this.hitPoints = 20;
        this.name = nameInput;
    }

    public int getHP() {
        return this.hitPoints;
    }

    public String toString() {
        return this.name;
    }

    public void heal() {                // heal method increases HP by 3 if HP is 17 or lower - increases by 1 if 18 or 19, and prints statement if at 20
        if (this.hitPoints < 18) {
            this.hitPoints = this.hitPoints + 3;
        } else if (this.hitPoints < 20) {
            this.hitPoints = this.hitPoints + 1;
        } else {
            System.out.println("You are already at max HP!\n");
        }
    }

    public void damage(int damage) {    // damage method takes int and reduces player's HP by that amount
        this.hitPoints = this.hitPoints - damage;
    }
    

}
