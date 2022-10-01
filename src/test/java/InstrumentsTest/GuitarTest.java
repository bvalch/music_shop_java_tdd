package InstrumentsTest;

import instruments.Guitar;
import instruments.InstrumentType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuitarTest {
    Guitar guitar;

    @Before
    public void before(){
        guitar = new Guitar(InstrumentType.GUITAR,100,6);
    }
    @Test
    public void hasName(){
        assertEquals("Guitar",guitar.getName());
    }
    @Test
    public void hasIPlayInterfaceReturnsSound(){
        assertEquals("WahWah",guitar.play());
    }
    @Test
    public void hasPrice(){
        assertEquals(100,guitar.getPrice(),0.0);
    }
    @Test
    public void hasMaterial(){
        assertEquals("Guitarium",guitar.getMaterial());
    }
    @Test
    public void hasStrings(){
        assertEquals(6,guitar.getNumStrings());
    }

    @Test
    public void sellPriceStartsAtZero(){

        assertEquals(0,guitar.getSellPrice(),0.0);
    }
}
