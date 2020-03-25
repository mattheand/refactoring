package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void when_SulfurasItem_expect_QualityAndSellInToStayTheSame() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 11, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 80);
        assertEquals(app.items[0].sellIn, 11);
    }

    @Test
    void when_BackstagePasses_expect_QualityDecreaseBy1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 11);
        assertEquals(app.items[0].sellIn, 10);
    }

    @Test
    void when_BackstagePassesItemIsUsedAndSellInNotExpired_expect_QualityDecreaseBy1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 12);
        assertEquals(app.items[0].sellIn, 9);
    }

    @Test
    void asas() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 13);
        assertEquals(app.items[0].sellIn, 4);
    }

    @Test
    void when_BackstagePassesAreExpired_expect_QualityToDropTo0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 43) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 0);
        assertEquals(app.items[0].sellIn, -1);
    }

    @Test
    void when_RegularItemIsUsedAndSellInNotExpired_expect_QualityDecreaseBy1() {
        Item[] items = new Item[] { new Item("normalItem", 2, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 9);
        assertEquals(app.items[0].sellIn, 1);
    }

    @Test
    void when_RegularItemIsUsedAndSellExpired_expect_QualityDecreaseBy2() {
        Item[] items = new Item[] { new Item("normalItem", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 8);
        assertEquals(app.items[0].sellIn, -1);
    }

    @Test
    void when_ItemQualityIs0_expect_QualityDoNotDecrease() {
        Item[] items = new Item[] { new Item("normalItem", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 0);
        assertEquals(app.items[0].sellIn, -1);
    }

    @Test
    void when_AgedBrieGetsOld_expect_QualityToIncrease() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 11);
        assertEquals(app.items[0].sellIn, 9);
    }

    @Test
    void when_AgedBrieQualityIs50_expect_QualityToNotIncrease() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 50);
        assertEquals(app.items[0].sellIn, 9);
    }

}
