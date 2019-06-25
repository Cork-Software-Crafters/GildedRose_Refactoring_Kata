package gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    @Test
    public void quality_and_sellIn_decreases_by_1() {
        Item[] items = new Item[]{new Item("An Item", 1, 10)};
        GildedRose gilgedRose = new GildedRose(items);

        gilgedRose.updateQuality();

        assertThat(items[0].sellIn).isEqualTo(0);
        assertThat(items[0].quality).isEqualTo(9);
    }

    @Test
    public void once_the_sell_by_date_has_passed_quality_decreases_twice_as_fast() {
        Item[] items = new Item[]{new Item("An Item", 0, 10)};
        GildedRose gilgedRose = new GildedRose(items);

        gilgedRose.updateQuality();

        assertThat(items[0].quality).isEqualTo(8);
    }

    @Test
    public void the_quality_of_an_item_is_never_negative() {
        Item[] items = new Item[]{new Item("An Item", 0, 0)};
        GildedRose gilgedRose = new GildedRose(items);

        gilgedRose.updateQuality();

        assertThat(items[0].quality).isEqualTo(0);
    }

    @Test
    public void Aged_brie_increases_in_quality_the_older_it_gets() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 10)};
        GildedRose gilgedRose = new GildedRose(items);

        gilgedRose.updateQuality();

        assertThat(items[0].quality).isEqualTo(11);
    }

    @Test
    public void Aged_brie_when_sellIn_expires() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 10)};
        GildedRose gilgedRose = new GildedRose(items);

        gilgedRose.updateQuality();

        assertThat(items[0].sellIn).isEqualTo(-1);
        assertThat(items[0].quality).isEqualTo(12);
    }

    @Test
    public void the_quality_of_an_item_is_never_more_than_50() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
        GildedRose gilgedRose = new GildedRose(items);

        gilgedRose.updateQuality();

        assertThat(items[0].quality).isEqualTo(50);
    }

    @Test
    public void Sulfuras_never_has_to_be_sold_or_decreases_in_quality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
        GildedRose gilgedRose = new GildedRose(items);

        gilgedRose.updateQuality();

        assertThat(items[0].quality).isEqualTo(80);
    }

    @Test
    public void Backstage_passes_increases_in_quality_by_2_when_there_are_10_days_or_less() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose gilgedRose = new GildedRose(items);

        gilgedRose.updateQuality();

        assertThat(items[0].quality).isEqualTo(12);
    }

    @Test
    public void Backstage_passes_increases_in_quality_by_3_when_there_are_5_days_or_less() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose gilgedRose = new GildedRose(items);

        gilgedRose.updateQuality();

        assertThat(items[0].quality).isEqualTo(13);
    }

    @Test
    public void Backstage_passes_drops_quality_to_0_after_concert() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose gilgedRose = new GildedRose(items);

        gilgedRose.updateQuality();

        assertThat(items[0].quality).isEqualTo(0);
    }

}
