package gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    @Test
    public void should_update_quality_of_an_item() {
        Item[] items = new Item[]{new Item("an item", 0, 0)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(gildedRose.items[0].name).isEqualTo("an item");
    }

}
