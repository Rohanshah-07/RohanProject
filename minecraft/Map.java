package minecraft;

public class Map {
    //the game is played on a 5 by 5 grid so I used a 2d array to do this
    private static Block[][] map = new Block[5][5];
    //used to call methods from the game class
    private static Game g = new Game();

    public Map() {

    }

    //the block on each index of the 2d array/map is decided by using a percentage
    //a random number from 0 to 100 is taken and from this, the block is decided
    public Block spawnPercent() {
        int spawn = (int)(Math.random() * 100);

        if (spawn >= 0 && spawn < 10) {
            Air air = new Air("Air","AI", null, null, 0);
            return air;
        }
        if (spawn >= 10 && spawn < 20) {
            CoalOre coalOre = new CoalOre("Coal Ore", "CO", "Coal", true, 0);
            return coalOre;
        }
        if (spawn >= 30 && spawn < 40) {
            Cobblestone cobblestone = new Cobblestone("Cobblestone", "CB", "Cobblestone", null, 0, 0);
            return cobblestone;
        }
        if (spawn >= 95 && spawn < 100) {
            DiamondOre diamondOre = new DiamondOre("Diamond Ore", "DO", "Diamond Gem", true, 0);
            return diamondOre;
        }
        if (spawn >= 40 && spawn < 60) {
            Dirt dirt = new Dirt("Dirt", "DI", "Dirt", false, 0);
            return dirt;
        }
        if (spawn >= 90 && spawn < 95) {
            GoldOre goldOre = new GoldOre("Gold Ore", "GO", "Gold Ore", true, 0);
            return goldOre;
        }
        if (spawn >= 80 && spawn < 90) {
            IronOre ironOre = new IronOre("Iron Ore", "IO", "Iron Ore", true, 0);
            return ironOre;
        }
        if (spawn >= 60 && spawn < 70) {
            Leaves leaves = new Leaves("Leaves", "LE", "Stick", false, 0);
            return leaves;
        }
        if (spawn >= 20 && spawn < 30) {
            Stone stone = new Stone("Stone", "ST", "Cobblestone", null, 0);
            return stone;
        }
        else {
            WoodenPlank woodenPlank = new WoodenPlank("Wooden Plank", "WP", "Wooden Plank", false, 0);
            return woodenPlank;
        }
    }
    public void CreateMap() {
        //a loop to loops through all indexes of the map and adds a block in each of the indexes which is decided from the spawnPercent method
        for (int x = 0; x <= map.length - 1; x++) {
            for (int y = 0; y <= map[0].length - 1; y++) {
                map[x][y] = spawnPercent();
            }
        } 
    }
    public void displayMap() {
        //prints out the map along with letters representing the rows and number representing the columns
        int i = 0;
        int c = 98;
        System.out.println("-----------------------------");
        System.out.println("   0  1  2  3  4");
        
        System.out.print("a |");
        for (int x = 0; x <= map.length - 1; x++) {
            for (int y = 0; y <= map[0].length - 1; y++) {
                if (i != 5) {
                    i++;
                    System.out.print(map[x][y].getSymbol() + " ");
                }
                else {
                    i = 1;
                    System.out.print("\n");
                    System.out.print((char) c + " |");
                    c++;
                    System.out.print(map[x][y].getSymbol() + " ");
                }
            }
        }
        System.out.println("");

    }
    public Block breakAndReturnBlock() {
        
        //converts the coordinate of the block the user wants to break into 2 separate ints, one for the row and the other for the column
        String block = g.breakBlock();

        String row = block.substring(0, 1);
        String column = block.substring(1);
        
        int rowNum = 1;
        int columnNum = Integer.parseInt(column);

        if (row.equals("a")) {
            rowNum = 0;
        }
        if (row.equals("b")) {
            rowNum = 1;
        }
        if (row.equals("c")) {
            rowNum = 2;
        }
        if (row.equals("d")) {
            rowNum = 3;
        }
        if (row.equals("e")) {
            rowNum = 4;
        }

        Air air = new Air("Air", "AI", null, false, 0);

        boolean flag = false;
        boolean flag2 = false;
        Block b = map[rowNum][columnNum];
        
        /* THIS IS WHERE MY PROBELM IS
         * in the instructions, if the user does not have a pickaxe, then it takes two hits to break cobblestone or stone
         * there is an int in the classes of stone and cobblestone named getNumHits which is how many hits the block has recived
         * for some reason, I cannont access this varible and change it since cobblestone and stone are in block arrays 
         * to work around this, I created an int amount in the parent class and i am accessing this to indicate if a cobblestone or stone has been hit
         * this is not good practice as the other child classes do not need this feature of 2 hits to break if there is no pickaxe so this should not be something that is inherited
         * how do I work around this?
         * 
         * note: if a block is broken, it is replaced with air on the map
         */

        Boolean pickaxe = b.getNeedPickaxe();
        if (b instanceof Cobblestone || b instanceof Stone) {
            for (Tools t : g.getInventory().getTools()) {
                if (t.getName().equals("Diamond Pickaxe") || t.getName().equals("Iron Pickaxe") || t.getName().equals("Stone Pickaxe")) {
                    flag2 = true;
                    break;
                }
                
            }
            if (flag2 == true) {
                map[rowNum][columnNum] = air;
                return b;
            }
            if (flag2 == false) {
                 if(((Cobblestone)b).getNumHits() < 1) {
                     //Though this is possible, it is not at all recommended as it kind of destroys
                     // the reason for inheritance. The best way would be to restructure your application
                     // design so that there are NO parent to child dependencies. A parent
                     // should not ever need to know its children or their capabilities.
                 }
                if (b.getAmount() < 1) {
                    System.out.println("Since you don't have a pickaxe, it takes two hits to break this block");
                    b.setAmount(b.getAmount() + 1);
                    return air;
                }
                else if (b.getAmount() == 1) {
                    map[rowNum][columnNum] = air;
                    return b;
                }

            }

        }
        
        if (pickaxe == null) {
            map[rowNum][columnNum] = air;
            return b;
        }
        
        //checks if a block needs a pickaxe to break and if the user has a pickaxe to break the block with
        if (pickaxe == true) {
            for (Tools t : g.getInventory().getTools()) {
                if (t.getName().equals("Diamond Pickaxe") || t.getName().equals("Iron Pickaxe") || t.getName().equals("Stone Pickaxe")) {
                    map[rowNum][columnNum] = air;
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                return b;
            }
            else {
                System.out.println("A pickaxe is needed to break this block.");
                return air;
            }
        }
        else {
            map[rowNum][columnNum] = air;
            return b;
        }

    }
}
