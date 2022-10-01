package instruments;

public class Guitar extends Instrument{
    private final int numStrings;

    public Guitar(InstrumentType instrumentType, double price,int numStrings) {
        super(instrumentType, price);
        this.numStrings=numStrings;
    }

    public int getNumStrings() {
        return numStrings;
    }
}
