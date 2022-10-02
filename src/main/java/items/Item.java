package items;

import interfaces.ISell;

public abstract class Item implements ISell {
    private final ItemType itemType;
    private final String name;
    private final int price;
    private double sellPrice;

    public Item(ItemType itemType) {
        this.itemType = itemType;
        this.name = itemType.getName();
        this.price = itemType.getPrice();
        this.sellPrice = 0;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getMarkup() {
        return this.sellPrice / this.price;
    }

    public void assignItemPrice(double itemPrice) {
        this.sellPrice = itemPrice;
    }
    public double getSellPrice(){
        return this.sellPrice;
    }
    public double getProfitMargin(){
        return this.sellPrice-this.price;
    }

}
