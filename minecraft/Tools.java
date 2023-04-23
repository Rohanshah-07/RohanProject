package minecraft;

import java.util.Iterator;

public class Tools {
    private String name;
    protected Inventory i;
    private int amount;
    private String index;
    private int durabilty;

    public Tools(String initName, Inventory initInventory, int initDurabiltiy, String initIndex) {
        this.name = initName;
        this.i = initInventory;
        this.index = initIndex;
    }
    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }
    public String getIndex() {
        return index;
    }
}
class Furnace extends Tools {
    Furnace(String initName, Inventory initInventory, int initDurabiltiy, String initIndex) {
        super(initName, initInventory, initDurabiltiy, initIndex);
    }
    public boolean recipie() {
        int count = 0;

        /* I HAVE A QUESTION IN THIS METHOD. LOOK AT THE COMMENT ON LINE 60
         * to craft a furnace, it takes 8 cobblestone
         * this method checks the inventory for the 8 cobblestone and if there are 8 cobblestone, a furnace is added to the inventory and the 8 cobblestone are removed
         */
        for (Block b : i.getBlocks()) {
            if (b.getDrops().equals("Cobblestone")) {
                count++;
                System.out.println(count);
            }
        }
        if (count >= 8) {
            int num = 0;
            Iterator<Block> itr = i.getBlocks().iterator();
            for (int number = 0; number <= i.getBlocks().size() * 2; number++) {
                if (num == 8) {
                    break;
                }
                if (itr.next().getDrops().equals("Cobblestone")) {
                    System.out.println(itr.toString());
                    itr.remove();
                    num++;
                }

                
                
                 /*
                  
                  this solution that is currently implemented works but I dont know why
                  Could you please let me know why it works
                  
                  this is a diagram of what each iteration of the loop should do but it does not
                  as you can see, the count should end at 7 but it ends at 8 (I want the count to be 8 and this loop works as I need but it should not according to the diagram ) 

                  size = 10 9 cobl 1 dirt
                  num <= size * 2

                  num = 1 rem cobl size = 9 * 2 = 18 count 1
                  num = 2 rem cobl size = 8 * 2 = 16 count 2
                  num = 3 rem cobl size = 7 * 2 = 14 count 3
                  num = 4 no cobl  size = 7 * 2 = 14 count 3
                  num = 5 rem cobl size = 6 * 2 = 12 count 4
                  num = 6 rem cobl size = 5 * 2 = 10 count 5
                  num = 7 rem cobl size = 4 * 2 = 8 count 6 
                  num = 8 rem cobl size = 3 * 2 = 6 count 7 <- this iteration should not go through since num > size * 2
                  
                  */

            }
            return true;
        }
        else {
            return false;
        }
    }
}
class StonePickaxe extends Tools {
    StonePickaxe(String initName, Inventory initInventory, int initDurability, int initDurabiltiy, String initIndex) {
        super(initName, initInventory, initDurability, initIndex);
    }
    public boolean recipie() {
    /*
     * checks if the inventory contain the items to craft a stone pickaxe 
     * if it does, the pickaxe is added to the inventory and the items used to craft it are deleted
     * this process is the same for the iron pickaxe and the diamond pickaxe
     */
        
        int count1 = 0;
        int count2 = 0;
        
        boolean key1 = false;
        boolean key2 = false;

        for (Block b : i.getBlocks()) {
            if (b.getDrops().equals("Cobblestone")) {
                count1++;
            }
        }
        if (count1 >= 3) {
            int num1 = 0;
            Iterator<Block> itr = i.getBlocks().iterator();

            for (int number = 0; number <= i.getBlocks().size() * 2; number++) {
                if (num1 == 3) {
                    break;
                }
                if (itr.next().getDrops().equals("Cobblestone")) {
                    itr.remove();
                    num1++;
                }
            }
            key1 = true;
        }
        for (Item it : i.getItems()) {
            if (it.getName().equals("Stick")) {
                count2++;
            }
        }
        if (count2 >= 2) {
            int num2 = 0;
            Iterator<Item> itr = i.getItems().iterator();

            for (int number = 0; number <= i.getItems().size() * 2; number++) {
                if (num2 == 2) {
                    break;
                }
                if (itr.next().getName().equals("Stick")) {
                    itr.remove();
                    num2++;
                }
            }
            key2 = true;
        }
        if (key1 == true && key2 == true) {
            return true;
        }     
        else {
            return false;
        }
    }
}
class IronPickaxe extends Tools {
    IronPickaxe(String initName, Inventory initInventory, int initDurabiltiy, String initIndex) {
        super(initName, initInventory, initDurabiltiy, initIndex);
    }
    public boolean recipie() {
        
        int count1 = 0;
        int count2 = 0;
        
        boolean key1 = false;
        boolean key2 = false;

        for (Item b : i.getItems()) {
            if (b.getName().equals("Iron Ore")) {
                count1++;
            }
        }
        if (count1 >= 3) {
            int num1 = 0;
            Iterator<Item> itr = i.getItems().iterator();

            for (int number = 0; number <= i.getItems().size() * 2; number++) {
                if (num1 == 3) {
                    break;
                }
                if (itr.next().getName().equals("Iron Ore")) {
                    itr.remove();
                    num1++;
                }
            }
            key1 = true;
        }
        for (Item it : i.getItems()) {
            if (it.getName().equals("Stick")) {
                count2++;
            }
        }
        if (count2 >= 2) {
            int num2 = 0;
            Iterator<Item> itr = i.getItems().iterator();

            for (int number = 0; number <= i.getItems().size() * 2; number++) {
                if (num2 == 2) {
                    break;
                }
                if (itr.next().getName().equals("Stick")) {
                    itr.remove();
                    num2++;
                }
            }
            key2 = true;
        }
        if (key1 == true && key2 == true) {
            return true;
        }     
        else {
            return false;
        }
    }
}
class DiamondPickaxe extends Tools {
    DiamondPickaxe(String initName, Inventory initInventory, int initDurabiltiy, String initIndex) {
        super(initName, initInventory, initDurabiltiy, initIndex);
    }
    public boolean recipie() {
        
        int count1 = 0;
        int count2 = 0;
        
        boolean key1 = false;
        boolean key2 = false;

        for (Item b : i.getItems()) {
            if (b.getName().equals("Diamond Gem")) {
                count1++;
            }
        }
        if (count1 >= 3) {
            int num1 = 0;
            Iterator<Item> itr = i.getItems().iterator();

            for (int number = 0; number <= i.getItems().size() * 2; number++) {
                if (num1 == 3) {
                    break;
                }
                if (itr.next().getName().equals("Diamond Gem")) {
                    itr.remove();
                    num1++;
                }
            }
            key1 = true;
        }
        for (Item it : i.getItems()) {
            if (it.getName().equals("Stick")) {
                count2++;
            }
        }
        if (count2 >= 2) {
            int num2 = 0;
            Iterator<Item> itr = i.getItems().iterator();

            for (int number = 0; number <= i.getItems().size() * 2; number++) {
                if (num2 == 2) {
                    break;
                }
                if (itr.next().getName().equals("Stick")) {
                    itr.remove();
                    num2++;
                }
            }
            key2 = true;
        }
        if (key1 == true && key2 == true) {
            return true;
        }     
        else {
            return false;
        }
    }
}



