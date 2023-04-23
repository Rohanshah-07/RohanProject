package minecraft;

public class Driver {
    public static void main(String[] args) {
        //instances of map and game to call methods
        Map map = new Map();
        Game g = new Game();

        //initial instructions for the user
        g.initialTextSequence();
        g.instructions();
        g.symbols();
        g.recipies();
        
        //game loops until the win condition is met
        while (g.checkWinCondition() == false) {
            g.mainMenu();
        }
    }
}
