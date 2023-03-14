public class Player {
    private int hitPoints;
    private String name;
    private int numberHeals;    // implemented to limit heals available to player



    public Player() {           // base Player stats w/ default name
        this.hitPoints = 20;
        this.name = "Player";
        this.numberHeals = 4;
        
    }
    public Player(String nameInput) {   // still sets HP to 20, inputs new name String
        this.hitPoints = 20;
        this.name = nameInput;
        this.numberHeals = 4;
    }

    public int getHP() {
        return this.hitPoints;
    }

    public String toString() {
        return this.name;
    }

    public void heal() {                // heal method increases HP by 3 if HP is 17 or lower - increases by 1 if 18 or 19, and prints statement if at 20
        if (this.numberHeals > 0) {
            if (this.hitPoints < 18) {
                this.hitPoints = this.hitPoints + 3;
                System.out.println("You heal yourself!");
            } else if (this.hitPoints < 20) {
                this.hitPoints = this.hitPoints + 1;
                System.out.println("You heal yourself!");
            } else {
                System.out.println("You heal, but you are already at max HP!\n");
            }
            this.numberHeals--;     // using heal method reduces player's numberHeals by 1
        } else {
            System.out.println("You are out of heals!");    // method does not increase HP and instead prints this if numberHeals is 0
        }
    }

    public void damage(int damage) {    // damage method takes int and reduces player's HP by that amount
        this.hitPoints = this.hitPoints - damage;
    }

    public int getNumberHeals() {
        return this.numberHeals;
    }
    

}
