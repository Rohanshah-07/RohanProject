package minecraft;

//parent class
public class Block {
    
    private String name;
    private String symbol;
    private String drops;
    private Boolean needPickaxe;
    private int amount;

    public Block(String initName, String initSymbol, String initDrops, Boolean initNeedPickaxe, int initAmount) {
        this.name = initName;
        this.symbol = initSymbol;
        this.drops = initDrops;
        this.needPickaxe = initNeedPickaxe;
        this.amount = initAmount;
    }
    //getters
    public String getName() {
        return name;
    }
    public String getSymbol() {
        return symbol;
    }    
    public String getDrops() {
        return drops;
    }
    public Boolean getNeedPickaxe() {
        return needPickaxe;
    }
    public int getAmount() {
        return amount;
    }

    //setter
    public void setDrops(String drop) {
        drops = drop;
    }
    public void setAmount(int num) {
        amount = num;
    }

}
//child classes
class Air extends Block {
    public Air(String initName, String initSymbol, String initDrops, Boolean initNeedPickaxe, int initAmount) {
        super(initName, initSymbol, initDrops, initNeedPickaxe, initAmount);
    }
}
class CoalOre extends Block {
    public CoalOre(String initName, String initSymbol, String initDrops, Boolean initNeedPickaxe, int initAmount) {
        super(initName, initSymbol, initDrops, initNeedPickaxe, initAmount);
    }
}
class Cobblestone extends Block {
    private int numHits;
    public Cobblestone(String initName, String initSymbol, String initDrops, Boolean initNeedPickaxe, int initNumHits, int initAmount) {
        super(initName, initSymbol, initDrops, initNeedPickaxe, initAmount);
        this.numHits = initNumHits;
    }
    public int getNumHits() {
        return numHits;
    }
    public void setNumHits(int hits) {
        numHits = hits;
    }

}
class DiamondOre extends Block {
    public DiamondOre(String initName, String initSymbol, String initDrops, Boolean initNeedPickaxe, int initAmount) {
        super(initName, initSymbol, initDrops, initNeedPickaxe, initAmount);
    }
}
class Dirt extends Block {
    public Dirt(String initName, String initSymbol, String initDrops, Boolean initNeedPickaxe, int initAmount) {
        super(initName, initSymbol, initDrops, initNeedPickaxe, initAmount);
    }
}
class GoldOre extends Block {
    public GoldOre(String initName, String initSymbol, String initDrops, Boolean initNeedPickaxe, int initAmount) {
        super(initName, initSymbol, initDrops, initNeedPickaxe, initAmount);
    }
}
class IronOre extends Block {
    public IronOre(String initName, String initSymbol, String initDrops, Boolean initNeedPickaxe, int initAmount) {
        super(initName, initSymbol, initDrops, initNeedPickaxe, initAmount);
    }
}
class Leaves extends Block {
    public Leaves(String initName, String initSymbol, String initDrops, Boolean initNeedPickaxe, int initAmount) {
        super(initName, initSymbol, initDrops, initNeedPickaxe, initAmount);
    }
}
class Stone extends Block {
    public Stone(String initName, String initSymbol, String initDrops, Boolean initNeedPickaxe, int initAmount) {
        super(initName, initSymbol, initDrops, initNeedPickaxe, initAmount);
    }
}
class WoodenPlank extends Block {
    public WoodenPlank(String initName, String initSymbol, String initDrops, Boolean initNeedPickaxe, int initAmount) {
        super(initName, initSymbol, initDrops, initNeedPickaxe, initAmount);
    }
}


