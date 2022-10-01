package instruments;

public class Piano extends Instrument{
    private int numKeys;
    public Piano(InstrumentType instrumentType, double price,int numKeys) {
        super(instrumentType, price);
        this.numKeys=numKeys;
    }

    public int getNumKeys() {
        return numKeys;
    }
}
