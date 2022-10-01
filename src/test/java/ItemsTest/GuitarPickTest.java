package ItemsTest;

import items.GuitarPick;
import items.Item;
import items.ItemType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuitarPickTest {
    Item guitarPick;

    @Before
    public void before(){
        guitarPick=new GuitarPick(ItemType.GUITAR_PICK);
    }

    @Test
    public void hasName(){
        assertEquals("Guitar Pick",guitarPick.getName());
    }
    @Test
    public void hasPrice(){
        assertEquals(10,guitarPick.getPrice());
    }
}
