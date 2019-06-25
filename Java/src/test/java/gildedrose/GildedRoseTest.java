package gildedrose;

import org.approvaltests.Approvals;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void should_update_quality_of_an_item() {
        Item[] items = new Item[]{new Item("an item", 0, 0)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Approvals.verify(gildedRose.items[0].name);
    }

}
