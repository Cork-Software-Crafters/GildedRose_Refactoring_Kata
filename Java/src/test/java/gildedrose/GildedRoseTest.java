package gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

@UseReporter(MeldReporter.class)
public class GildedRoseTest {

    @Test
    public void should_update_quality_of_an_item() {
        CombinationApprovals.verifyAllCombinations(
                this::updateQuality,
                new String[]{"an item", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
                new Integer[]{0},
                new Integer[]{0, 1});
    }

    private String updateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        return gildedRose.items[0].toString();
    }

}
