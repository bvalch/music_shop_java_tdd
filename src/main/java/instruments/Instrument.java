package instruments;

import interfaces.IPlay;
import interfaces.ISell;

public abstract class Instrument implements ISell, IPlay {
    InstrumentType instrumentType;
    private final String name;
    private final String sound;
    private final double price;
    private final String material;
    private double sellPrice;

    public Instrument(InstrumentType instrumentType, double price) {
        this.instrumentType = instrumentType;
        this.name = instrumentType.getName();
        this.sound = instrumentType.getSound();
        this.material = instrumentType.getMaterial();
        this.price = price;
        this.sellPrice = 0;

    }

    public String getName() {
        return name;
    }

    public String play() {
        return sound;
    }

    public double getPrice() {
        return price;
    }

    public String getMaterial() {
        return material;
    }

    public void assignSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getSellPrice() {
        return this.sellPrice;
    }
    public double getMarkup(){
        return this.sellPrice/this.price;
    }
    public double getProfitMargin(){
        return this.sellPrice-this.price;
    }
}
