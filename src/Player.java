public class Player {
    private int hitPoints;
    private String name;



    public Player() {
        this.hitPoints = 20;
        this.name = "Player";
        
    }
    public Player(String nameInput) {
        this.hitPoints = 20;
        this.name = nameInput;
    }

    public int getHP() {
        return this.hitPoints;
    }

    public String toString() {
        return this.name;
    }

    public void heal() {
        if (this.hitPoints < 18) {
            this.hitPoints = this.hitPoints + 3;
        } else if (this.hitPoints < 20) {
            this.hitPoints = this.hitPoints + 1;
        } else {
            System.out.println("You are already at max HP!\n");
        }
    }

    public void damage(int damage) {
        this.hitPoints = this.hitPoints - damage;
    }
    

}
