package shop;

import instruments.Instrument;
import interfaces.ISell;
import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final String name;
    private List<ISell> itemsArray;

    public Shop(String name) {
        this.name = name;
        this.itemsArray = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<ISell> getItemsArray() {
        return itemsArray;
    }

    public void addItem(ISell item) {
        this.itemsArray.add(item);
    }

    public void assignSellPrice(ISell item, double sellPrice) {
        if (this.itemsArray.contains(item)) {
            this.itemsArray.remove(item);
        }
        if (item instanceof Instrument) {
            ((Instrument) item).assignSellPrice(sellPrice);
            addItem(item);
        } else if (item instanceof Item) {
            ((Item) item).assignItemPrice(sellPrice);
            addItem(item);
        }
    }

    public void removeItemsFromStock(ISell item) {
        if (item instanceof Instrument) {
            ((Instrument) item).assignSellPrice(0);
        } else if
        (item instanceof Item) {
            ((Item) item).assignItemPrice(0);
        }
        this.itemsArray.remove(item);
    }
}
