package minecraft;

import java.util.*;

public class Inventory {
    //3 separate arraylist for the 3 types of items the user can collect. for more info, look at instructions.txt
    private ArrayList <Block> blocks;
    private ArrayList <Item> items;
    private ArrayList <Tools> tools;

    public Inventory(ArrayList <Block> initBlocks, ArrayList<Item> initItems, ArrayList<Tools> initTools) {
        this.blocks = initBlocks;
        this.items = initItems;
        this.tools = initTools;
    }
    //getter methods
    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public ArrayList<Tools> getTools() {
        return tools;
    }

    //finds the index of a block in the arraylist
    public int findBlock(Block a) {
        int num = 0;

        for (int i = 0; i <= blocks.size(); i++) {
            if (blocks.get(i).getName().equals(a.getName())) {
                num = blocks.get(i).getAmount();
            }
        }
        return num;
    }
    //finds the index of an item in the arraylist
    public int findItem(Item a) {
        int num = 0;

        for (int i = 0; i <= items.size(); i++) {
            if (items.get(i).getName().equals(a.getName())) {
                num = items.get(i).getAmount();
            }
        }
        return num;
    }
    //finds the index of a tool in the arraylist
    public int findTool(Tools a) {
        int num = 0;

        for (int i = 0; i <= tools.size(); i++) {
            if (tools.get(i).getName().equals(a.getName())) {
                num = tools.get(i).getAmount();
            }
        }
        return num;
    }
    //setter methods
    public void addBlock(Block b) {
        blocks.add(b);
    }
    public void addItem(Item i) {
        items.add(i);
    }
    public void addTool(Tools t) {
        tools.add(t);
    }
    //insertion sorts the tools arraylist to make sure the diamond pickaxe is first followed by the iron pickaxe, then the stone pickaxe, then the other items
    public void insertionSort(ArrayList<Tools> a) {
        for(int i = 1; i < a.size(); i++) {
			Tools temp = a.get(i);
			int j = i - 1;
			
			while(j>=0 && a.get(j).getIndex().compareTo(temp.getIndex()) > 0) {
				a.set(j + 1, a.get(j));
				j--;
			}
			a.set(j + 1, temp);
		}
    }

}