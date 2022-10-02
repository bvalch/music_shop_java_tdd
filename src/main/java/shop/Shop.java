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
//same as below
//    public double getPotentialProfit() {
//        if (this.itemsArray.size() != 0) {
//            double profit = 0;
//            for (int i = 0; i < itemsArray.size(); i++) {
//                if (itemsArray.get(i) instanceof Instrument) {
//                    profit += (((Instrument) itemsArray.get(i)).getSellPrice()) - ((Instrument) itemsArray.get(i)).getPrice();
//                } else if (itemsArray.get(i) instanceof Item) {
//                    profit += ((((Item) itemsArray.get(i)).getSellPrice())) - (((Item) itemsArray.get(i)).getPrice());
//                }
//
//            }
//            return profit;
//
//
//        }
//        return 0;
//    }

    public double getPotProfit() {
        if (itemsArray.size() != 0) {
            double profit = 0;
            for (ISell item : itemsArray) {
                if (item instanceof Instrument) {
                    profit += (((Instrument) item).getSellPrice()) - ((Instrument) item).getPrice();
                }
                else if
                (item instanceof Item) {
                    profit += (((Item) item).getSellPrice()) - ((Item) item).getPrice();
                }
            }
            return profit;
        }
        return 0;
    }
// same as above
//    public double getMarkup(){
//        double margin=0;
//        for(ISell item:itemsArray){
//            margin +=item.getProfitMargin();
//        }
//        return margin;
//    }




}
