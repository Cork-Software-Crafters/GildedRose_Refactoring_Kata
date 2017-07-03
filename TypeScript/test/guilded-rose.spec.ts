import { expect } from 'chai';
import { GildedRose } from '../app/gilded-rose';
import { Item } from '../app/item';

describe('Gilded Rose', function () {

    it('quality and sellIn decreases by 1', function () {
        const gilgedRose = new GildedRose([new Item('An Item', 1, 10)]);

        const items = gilgedRose.updateQuality();

        expect(items[0].sellIn).to.equal(0);
        expect(items[0].quality).to.equal(9);
    });

    it('once the sell by date has passed quality decreases twice as fast', function () {
        const gilgedRose = new GildedRose([new Item('An Item', 0, 10)]);

        const items = gilgedRose.updateQuality();

        expect(items[0].quality).to.equal(8);
    });

    it('the quality of an item is never negative', function () {
        const gilgedRose = new GildedRose([new Item('An Item', 0, 0)]);

        const items = gilgedRose.updateQuality();

        expect(items[0].quality).to.equal(0);
    });

    it('Aged Brie increases in quality the older it gets', function () {
        const gilgedRose = new GildedRose([new Item('Aged Brie', 1, 10)]);

        const items = gilgedRose.updateQuality();

        expect(items[0].quality).to.equal(11);
    });

    it('the quality of an item is never more than 50', function () {
        const gilgedRose = new GildedRose([new Item('Aged Brie', 1, 50)]);

        const items = gilgedRose.updateQuality();

        expect(items[0].quality).to.equal(50);
    });

    it('Sulfuras never has to be sold or decreases in quality ', function () {
        const gilgedRose = new GildedRose([new Item('Sulfuras, Hand of Ragnaros', 1, 10)]);

        const items = gilgedRose.updateQuality();

        expect(items[0].quality).to.equal(10);
    });

    it('Backstage passes increases in quality by 2 when there are 10 days or less', function () {
        const gilgedRose = new GildedRose([new Item('Backstage passes to a TAFKAL80ETC concert', 10, 10)]);

        let items = gilgedRose.updateQuality();
        expect(items[0].quality).to.equal(12);
    });

    it('Backstage passes increases in quality by 3 when there are 5 days or less', function () {
        const gilgedRose = new GildedRose([new Item('Backstage passes to a TAFKAL80ETC concert', 5, 10)]);

        let items = gilgedRose.updateQuality();
        expect(items[0].quality).to.equal(13);
    });

    it('Backstage passes drops quality to 0 after concert', function () {
        const gilgedRose = new GildedRose([new Item('Backstage passes to a TAFKAL80ETC concert', 0, 10)]);

        let items = gilgedRose.updateQuality();
        expect(items[0].quality).to.equal(0);
    });

});