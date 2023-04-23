package minecraft;

import java.util.Iterator;

//parent class
public class Item {
    private String name;
    private int amount;
    protected Inventory i;

    public Item(String initName, int initAmount, Inventory initInventory) {
        this.name = initName;
        this.amount = initAmount;
        this.i = initInventory;
    }
    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }
}
//child classes
class DiamondGems extends Item {
    public DiamondGems(String initName, int initAmount, Inventory initInventory) {
        super(initName, initAmount, initInventory);
    }
}
class GoldIngot extends Item {
    public GoldIngot(String initName, int initAmount, Inventory initInventory) {
        super(initName, initAmount, initInventory);
    }
    //work in progress method, not implemented
    public boolean smelt() {
        
        /*
         * need to fix drops like coal and diamond gems which should go in item array but are listed as blocks
         */
        int count1 = 0;
        int count2 = 0;
        
        boolean key1 = false;
        boolean key2 = false;

        for (Block b : i.getBlocks()) {
            if (b.getDrops().equals("Coal")) {
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
class Stick extends Item {
    public Stick(String initName, int initAmount, Inventory initInventory) {
        super(initName, initAmount, initInventory);
    }
    //checks inventory if it as one wooden plank to craft a stick
    //if it does, one stick is added to the inventory and deletes the wooden plank
    public boolean recipie() {
        int count = 0;
        for (Block b : i.getBlocks()) {
            if (b.getDrops().equals("Wooden Plank")) {
                count++;
            }
        }
        if (count >= 1) {
            int num = 0;
            Iterator<Block> itr = i.getBlocks().iterator();
            for (int number = 0; number <= i.getBlocks().size() * 2; number++) {
                if (num == 1) {
                    break;
                }
                if (itr.next().getDrops().equals("Wooden Plank")) {
                    itr.remove();
                    num++;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
}
class Coal extends Item {
    public Coal(String initName, int initAmount, Inventory initInventory) {
        super(initName, initAmount, initInventory);
    }
}
class IronIngot extends Item {
    public IronIngot(String initName, int initAmount, Inventory initInventory) {
        super(initName, initAmount, initInventory);
    }
}
class BlockOfGold extends Item {
    public BlockOfGold(String initName, int initAmount, Inventory initInventory) {
        super(initName, initAmount, initInventory);
    }

    public boolean recipie() {
        int count = 0;

        //checks if the inventory has the items to craft a block of gold
        //if it does the block of gold is added to the inventory and the items used to craft the block are deleted
        for (Item item : i.getItems()) {
            if (item.getName().equals("Gold Ingot")) {
                count++;
                System.out.println(count);
            }
        }
        if (count >= 9) {
            int num = 0;
            Iterator<Item> itr = i.getItems().iterator();
            for (int number = 0; number <= i.getItems().size() * 2; number++) {
                if (num == 9) {
                    break;
                }
                if (itr.next().getName().equals("Gold Ingot")) {
                    System.out.println(itr.toString());
                    itr.remove();
                    num++;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
}

