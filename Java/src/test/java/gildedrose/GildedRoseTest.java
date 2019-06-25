package gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

@UseReporter(MeldReporter.class)
public class GildedRoseTest {

    @Test
    public void should_update_quality_of_an_item() {
        String[] names = {"an item", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};
        Integer[] sellIns = {-1, 0, 11};
        Integer[] qualities = {0, 1, 50, 49};

        CombinationApprovals.verifyAllCombinations(
                this::updateQuality,
                names,
                sellIns,
                qualities);
    }

    private String updateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        return gildedRose.items[0].toString();
    }

}
