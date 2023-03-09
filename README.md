## Adventure Game Final

Instructions and Description to be added.




## Peer Review Feedback - ALec Nguyen

1. In the **Game** class, I would modify the main() method to add a loop to allow the player to play again:

```
boolean playAgain = true;
Scanner scanner = new Scanner(System.in);

while (playAgain) {
    Game game = new Game();
    game.play();
    System.out.println("Play again? (y/n)");
    String input = scanner.nextLine();
    playAgain = input.equalsIgnoreCase("y");
}
```

2. In the **Player** class, I would add a getter for the numberHeals field so that it can be accessed outside the class:

```
public int getNumberHeals() {
    return this.numberHeals;
}
```
Overall, the program seems to work well, but I think these changes could improve the game experience and make the code more modular and reusable.