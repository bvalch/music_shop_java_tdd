package shopTest;

import instruments.Guitar;
import instruments.Instrument;
import instruments.InstrumentType;
import items.GuitarPick;
import items.Item;
import items.ItemType;
import org.junit.Before;
import org.junit.Test;
import shop.Shop;


import static org.junit.Assert.assertEquals;

public class ShopTest {

    Shop shop;

    @Before
    public void before() {
        shop = new Shop("Music Shoppe");
    }

    @Test
    public void hasName() {
        assertEquals("Music Shoppe", shop.getName());
    }

    @Test
    public void hasEmptyListOfItems() {
        assertEquals(0, shop.getItemsArray().size());
    }

    @Test
    public void canAddInstrunentToItemsArray() {
        Instrument guitar = new Guitar(InstrumentType.GUITAR, 100, 6);
        shop.addItem(guitar);
        assertEquals(guitar, shop.getItemsArray().get(0));
    }

    @Test
    public void shopAssignsSellPriceOfItem() {
        Instrument guitar = new Guitar(InstrumentType.GUITAR, 100, 6);
        shop.assignSellPrice(guitar, 150);
        assertEquals(150, guitar.getSellPrice(), 0.0);
        assertEquals(150, ((Instrument) shop.getItemsArray().get(0)).getSellPrice(), 0.0);
    }

    @Test
    public void canCalculateMarkUp() {
        Instrument guitar = new Guitar(InstrumentType.GUITAR, 100, 6);
        shop.assignSellPrice(guitar, 150);
        assertEquals(1.5, guitar.getMarkup(), 0.0);
        assertEquals(1.5, shop.getItemsArray().get(0).getMarkup(), 0.0);
    }

    @Test
    public void canRemoveItemsFromStock() {
        Instrument guitar = new Guitar(InstrumentType.GUITAR, 100, 6);
        Instrument guitar2 = new Guitar(InstrumentType.GUITAR, 200, 26);
        shop.assignSellPrice(guitar, 150);
        shop.assignSellPrice(guitar2, 250);
        shop.removeItemsFromStock(guitar);
        assertEquals(1, shop.getItemsArray().size());
        assertEquals(guitar2, shop.getItemsArray().get(0));

    }

    @Test
    public void itemsRemovedFromShopResetSellPriceToZero() {
        Instrument guitar = new Guitar(InstrumentType.GUITAR, 100, 6);
        shop.assignSellPrice(guitar, 150);
        shop.removeItemsFromStock(guitar);
        assertEquals(0, guitar.getSellPrice(), 0.0);
    }

    @Test
    public void canUpdateSellPriceIfItemAlreadyAddedToStockWithoutSellPrice() {
        Instrument guitar = new Guitar(InstrumentType.GUITAR, 100, 6);
        shop.addItem(guitar);
        assertEquals(0, shop.getItemsArray().get(0).getMarkup(), 0.0);
        shop.assignSellPrice(guitar, 150);
        assertEquals(1, shop.getItemsArray().size());
        assertEquals(1.5, guitar.getMarkup(), 0.0);
        assertEquals(1.5, shop.getItemsArray().get(0).getMarkup(), 0.0);

    }

    @Test
    public void canAddItemToStock() {
        Item guitarpick = new GuitarPick(ItemType.GUITAR_PICK);
        shop.addItem(guitarpick);
        assertEquals(1, shop.getItemsArray().size());
    }

    @Test
    public void canAddMarkUpToItem() {
        Item guitarpick = new GuitarPick(ItemType.GUITAR_PICK);
        shop.assignSellPrice(guitarpick, 30);
        assertEquals(3, guitarpick.getMarkup(), 0.0);
    }

    @Test
    public void canUpdatePriceOfItemIfAlreadyInStockWithNoSellPrice() {
        Item guitarpick = new GuitarPick(ItemType.GUITAR_PICK);
        shop.addItem(guitarpick);
        shop.assignSellPrice(guitarpick, 100);
        assertEquals(10, guitarpick.getMarkup(), 0.0);
        assertEquals(10, shop.getItemsArray().get(0).getMarkup(), 0.0);
    }

    @Test
    public void canCalculateTotalProfitInDolerinoos(){
        Instrument guitar = new Guitar(InstrumentType.GUITAR, 100, 6);
        Item guitarpick = new GuitarPick(ItemType.GUITAR_PICK);
        shop.assignSellPrice(guitar,150);
        shop.assignSellPrice(guitarpick,20);
        assertEquals(60,shop.getPotProfit(),0.0);
        assertEquals(60,shop.getMarkup(),0.0);
    }
}
