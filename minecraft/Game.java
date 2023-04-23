package minecraft;

import java.util.*;


public class Game {
    //static instances of the map and inventory + all arraylists in inventory
    private static Map m = new Map();
    private static ArrayList <Block> blocks = new ArrayList<Block>();
    private static ArrayList <Item> items = new ArrayList<Item>();
    private static ArrayList <Tools> tools = new ArrayList<Tools>();
    private static Inventory inventory = new Inventory(blocks, items, tools);

    public Game() {

    }
    //welcome message for the user
    public void initialTextSequence() {
        System.out.println("Welcome to Minecraft!");
        System.out.println("---------------------------------------");
        System.out.println("In this game, the goal is to attain a gold block.");
        System.out.println("Break blocks to attain resources and use the resoucres to break more blocks.");
        System.out.println("---------------------------------------");
        System.out.println("");
        //creates the map on which the game is played
        m.CreateMap();

    }
    public void mainMenu() {

        Scanner scanner = new Scanner(System.in);

        String uInput = "";
        Boolean key = false;

        while (key == false) {
            //displays the map for the user to see
            m.displayMap();
            
            //prints out the actions the user can make
            System.out.println("-----------------------------");
            System.out.println("1: Break Block");
            System.out.println("2: Craft Item");
            System.out.println("3: Smelt Ore");
            System.out.println("4: Dig to Next Layer");
            System.out.println("5: Help");
            System.out.println("-----------------------------");
            System.out.print("Input: ");

            uInput = scanner.nextLine();

            //if statements to see if the user input is vaild
            if (uInput.equals("1") || uInput.equals("2") || uInput.equals("3") || uInput.equals("4") || uInput.equals("5")) {
                key = true;
            }
            else {
                System.out.println("Enter a vaild input");
                
            }
        }
        if (uInput.equals("1")) {
            //the user wants to break a block so the block will be broken and returned from the method breakAndReturn block in the map class
            //this section of the code will take the block that is returned and adds it to the block array in inventory
            Block block = m.breakAndReturnBlock();
            
            inventory.insertionSort(tools);

            //if the user breaks the leaves block, there is a 5 percent chance that it drops a stick
            //the drop stick method calculates this chance
            //if the method is true, a stick is added it to the item array in the inventory
            //if it is false, the block is changed to air which does not add anything to the inventory
            if (block.getName().equals("Leaves")) {
                if (dropStick() == true) {
                    Stick stick = new Stick("Stick", 0, inventory);
                    inventory.addItem(stick);
                    Air air = new Air("Air", "AI", null, null, 0);
                    block = air;
                }
                else {
                    Air air = new Air("Air", "AI", null, null, 0);
                    block = air;
                }
            }

            //makes sure the given block is not air before adding it to the inventory
            if (!(block.getName().equals("Air"))) {
                inventory.addBlock(block);
            }
        }
        else if (uInput.equals("2")) {
            //brings the user to the crafting menu to craft items or tools
            craftingMenu();
        }
        else if (uInput.equals("3")) {
            // code not implemented yet
        }
        else if (uInput.equals("4")) {
            // creates a new map
            m.CreateMap();
        }
        else if (uInput.equals("5")) {
            //displays the instructions again
            instructions();
            symbols();
            recipies();
        }
        else {
            System.out.println("Enter a vaild input");
        }
        
    }
    //calculates the 5 percent chance for leaves to drop a stick
    public boolean dropStick() {
        int num = (int)(Math.random() * 100);
        System.out.println(num);
        if (num <= 5) {
            return true;
        }
        else {
            return false;
        }
    }
    public Inventory getInventory() {
        return inventory;
    }
    //the next 3 methods are the instructions for the game
    public void instructions() {
        System.out.println("************************************************************");
        System.out.println("INSTRUCTIONS:");
        System.out.println("You will recive items after breaking blocks.");
        System.out.println("You can use these blocks to craft pickaxes and furnaces.");
        System.out.println("Use the pickaxes to mine more blocks until you get enough gold to craft a gold block.");
        System.out.println("Some items must be smelted before they are usable.");
        System.out.println("For these items, use the furnace along with coal to smelt them.");
        System.out.println("The game is played on a 5 by 5 grid of blocks. The block's symbol is displayed to represent the block.");
        System.out.println("Enter symbol to see what block a symbol corresponds to.");
        System.out.println("Once you are done mining on the current layer, enter dig to go the next layer.");
        System.out.println("In order to break enter letter of the row and the number of the column similar to a vending machine. Ex: a3");
        System.out.println("Also, beware of durabilty, your weapons can break");
        System.out.println("To craft, select crafting in the main menu. Then enter the item you would like to craft.");
        System.out.println("Have Fun!");
        System.out.println("************************************************************");
        System.out.println("");
    }
    public void symbols() {
        System.out.println("--------------------------------------------------");
        System.out.println("Block name        Elemental symbol");
        System.out.println("Air                      AI");
        System.out.println("Coal Ore                 CO");
        System.out.println("Cobblestone              CB");
        System.out.println("Diamond Ore              DO");
        System.out.println("Dirt                     DI");
        System.out.println("Gold Ore                 GO");
        System.out.println("Iron Ore                 IO");
        System.out.println("Leaves                   LE");
        System.out.println("Stone                    ST");
        System.out.println("Wooden Plank             WP");
        System.out.println("--------------------------------------------------");

    }
    public void recipies() {
        System.out.println("Tools:");
        System.out.println("Name                Recepie");
        System.out.println("Furnace             8 cobblestone");
        System.out.println("Stone pickaxe       3 cobblestone + 2 sticks");
        System.out.println("Iron Pickaxe        3 Iron Ingot + 2 sticks");
        System.out.println("Diamond Pickaxe     3 Diamond gems + 2 sticks");
        System.out.println("--------------------------------------------------");
        System.out.println("Items");
        System.out.println("Name                 How to get");
        System.out.println("Dimond Gems          Mine diamond ore with pickaxe");
        System.out.println("Gold Ingot           Smelt gold Ore in furnace consumes 1 coal per ingot created");
        System.out.println("Stick                Drop from leaves or craft from wooden plank");
        System.out.println("Coal                 Mine Coal Ore with a pickaxe");
        System.out.println("Iron Ingot           Smelt from Iron Ore consumes 1 coal per ingot created");
        System.out.println("Block of gold        Have 9 Gold Ingots ");
        System.out.println("--------------------------------------------------");
    }

    //this method asks the user to enter the coordinate of the block they want to break. This is then sent to the the map class where the block is broke and sent back to the game class where it is added to the inventory
    public String breakBlock() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        String uInput = "";
        
        //the first character of the input is a letter which represents the row and the second is a number which represents the column
        //substring of the input is taken to check the fist and second characters
        while (flag == false) {
            System.out.println("Enter the coordinate of the block you would like to break.");
            uInput = scanner.nextLine();

            if (uInput.length() != 2) {
                System.out.println("Make sure your input is two characters long");
            }
            if (uInput.substring(0, 1).equals("a") || uInput.substring(0, 1).equals("b") || uInput.substring(0, 1).equals("c") || uInput.substring(0, 1).equals("d") || uInput.substring(0, 1).equals("e")) {
                if (uInput.substring(1).equals("0") || uInput.substring(1).equals("1") || uInput.substring(1).equals("2") || uInput.substring(1).equals("3") || uInput.substring(1).equals("4")) {
                    flag = true;
                }
            }
            else {
                System.out.println("Enter an input that corresponds with the directions given in the input section.");
            }
        }
        return uInput;
    }
    public void craftingMenu () {
        //this is the menu in which the user can craft items
        
        /*
         * the user will select and item or tool to craft
         * this item or tool will have a recipie method in its class which is a boolean
         * this method will check the inventory to see if it has the items or blocks needed to craft it
         * if the method returns true then the item or tool the user wants to craft will be added to the inventory
         * the items or blocks needed to craft what the user wants to craft will then be removed from the inventory
         */
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("***********************");
        System.out.println("Crafting Menu");
        System.out.println("");

        System.out.println("~Your Inventory~");
        System.out.println("-----------------------");
        System.out.print("Blocks: ");
        if (blocks.size() == 0) {
            System.out.println("You have no blocks.");
        }
        else {
            for (Block b : blocks) {
                System.out.print(b.getDrops() + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("-----------------------");
        System.out.print("Items: ");
        if (items.size() == 0) {
            System.out.println("You have no items.");
        }
        else {
            for (Item i : items) {
                System.out.print(i.getName() + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("-----------------------");
        System.out.print("Tools: ");
        if (tools.size() == 0) {
            System.out.println("You have no Tools.");
        }
        else {
            inventory.insertionSort(tools);
            for (Tools t : tools) {
                System.out.print(t.getName() + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("-----------------------");
        
        boolean key = false;
        String uInput = "";


        while (key == false) {
            //displays the actions the user can make
            System.out.println("***********************");
            System.out.println("0: Craft Block of Gold");
            System.out.println("1: Craft Furnace");
            System.out.println("2: Craft Stone Pickaxe");
            System.out.println("3: Craft Iron Pickaxe");
            System.out.println("4: Craft Diamond Pickaxe");
            System.out.println("5: Craft Sticks");
            System.out.println("6: Exit to Main Menu");
            System.out.println("***********************");
            System.out.print("Input: ");

            uInput = scanner.nextLine();

            if (uInput.equals("1") || uInput.equals("2") || uInput.equals("3") || uInput.equals("4") || uInput.equals("5") || uInput.equals("0") || uInput.equals("6")) {
                key = true;
            }
        }
        if (uInput.equals("0")) {
            BlockOfGold bG = new BlockOfGold("Block of Gold", 0, inventory);
            if (bG.recipie() == true) {
                inventory.addItem(bG);
                System.out.println("Successfully crafted Block of Gold!!!");
            }
            else {
                System.out.println("You do not have enough resources to craft this item.");
            }
        }
        else if (uInput.equals("1")) {
            Furnace f = new Furnace("Furnace", inventory, 1, "d");
            if (f.recipie() == true) {
                inventory.addTool(f);
                System.out.println("Successfully crafted tool!");
            }
            else {
                System.out.println("You do not have enough resources to craft this item.");
            }
        }
        else if (uInput.equals("2")) {
            StonePickaxe sP = new StonePickaxe("Stone Pickaxe", inventory, 20, 0, "c");
            if (sP.recipie() == true) {
                inventory.addTool(sP);
                System.out.println("Successfully crafted tool!");
            }
            else {
                System.out.println("You do not have enough resources to craft this item.");
            }

        }   
        else if (uInput.equals("3")) {
            IronPickaxe iP = new IronPickaxe("Iron Pickaxe", inventory, 0, "b");
            if (iP.recipie() == true) {
                inventory.addTool(iP);
                System.out.println("Successfully crafted tool!");
            }
            else {
                System.out.println("You do not have enough resources to craft this item.");
            }
        }
        else if (uInput.equals("4")) {
            DiamondPickaxe dP = new DiamondPickaxe("Diamond Pickaxe", inventory, 0, "a");
            if (dP.recipie() == true) {
                inventory.addTool(dP);
                System.out.println("Successfully crafted tool!");
            }
            else {
                System.out.println("You do not have enough resources to craft this item.");
            }
        }
        else if (uInput.equals("5")) {
            Stick s = new Stick("Stick", 0, inventory);
            if (s.recipie() == true) {
                inventory.addItem(s);
                System.out.println("Successfully crafted item!");
            }
            else {
                System.out.println("You do not have enough resources to craft this item.");
            }
        }
    }

    //this method is a work in progress and isnt implemented
    public void smeltingMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************");
        System.out.println("Smelting Menu");
        System.out.println("");
        System.out.println("~Your Inventory~");
        System.out.println("-----------------------");
        System.out.print("Blocks: ");
        if (blocks.size() == 0) {
            System.out.println("You have no blocks.");
        }
        else {
            for (Block b : blocks) {
                System.out.print(b.getDrops() + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("-----------------------");
        System.out.print("Items: ");
        if (items.size() == 0) {
            System.out.println("You have no items.");
        }
        else {
            for (Item i : items) {
                System.out.print(i.getName() + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("-----------------------");
        System.out.print("Tools: ");
        if (tools.size() == 0) {
            System.out.println("You have no Tools.");
        }
        else {
            inventory.insertionSort(tools);
            for (Tools t : tools) {
                System.out.print(t.getName() + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("-----------------------");
        
        boolean key = false;
        String uInput = "";


        while (key == false) {
            System.out.println("***********************");
            System.out.println("1: Smelt Iron Ore");
            System.out.println("2: Smelt Gold Ore");
            System.out.println("3: Return to Main Menu");
            System.out.println("***********************");
            System.out.print("Input: ");
            
            uInput = scanner.nextLine();

            if (uInput.equals("1") || uInput.equals("2") || uInput.equals("3")) {
                key = true;
            }
        }

    }

    /*
     * if the user obtains one block of gold then the game is over
     * this method checks to see if the user has the block of gold
     */
    public boolean checkWinCondition() {
        boolean winCon = false;

        if (inventory.getItems().size() == 0) {
            return winCon;       
        }
        else {    
            for (int i = 0; i <= inventory.getItems().size() - 1; i++) {
                if (inventory.getItems().get(i).getName().equals("Block of Gold")) {
                    System.out.println("Congratulations, you beat the game.");
                    winCon = true;
                }
            }
        }
        return winCon;
    }
    
}
