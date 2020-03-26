package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void when_ItemIsUpdated_expect_NameToNotChange() {
        final Item[] items = new Item[]{new Item("foo", 0, 0)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void when_SulfurasItem_expect_QualityAndSellInToStayTheSame() {
        final Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 11, 80)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 11);
        assertEquals(app.items[0].quality, 80);
    }

    @Test
    void when_BackstageWithSellInBiggerThan10_expect_SellInToDecreaseAndQualityToIncreaseByOne() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 10);
        assertEquals(app.items[0].quality, 11);
    }

    @Test
    void when_BackstageWithSellInSmallerThan10AndBiggerThan5_expect_SellInToDecreaseAndQualityToIncreaseBy2() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 9);
        assertEquals(app.items[0].quality, 12);
    }

    @Test
    void when_BackstageWithSellInSmallerThan5_expect_SellInToDecreaseAndQualityToIncreaseBy3() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 0)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 0);
        assertEquals(app.items[0].quality, 3);
    }

    @Test
    void when_BackstagePassesSellIn6andQuality0_expect_SellInToDecreaseQualityDecreaseIncreaseBy2() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 0)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 5);
        assertEquals(app.items[0].quality, 2);
    }


    @Test
    void when_BackstagePassesSellIn5andQuality10_expect_SellInToDecreaseAndQualityDecreaseIncreaseBy3() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 4);
        assertEquals(app.items[0].quality, 13);
    }

    @Test
    void when_BackstagePassesAreExpired_expect_SellInToDecreaseAndQualityToDropTo0() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 43)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, -1);
        assertEquals(app.items[0].quality, 0);
    }

    @Test
    void when_BackstagePassesSellIn5andQuality50_expect_SellInToDecreaseAndQualityToStay50() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 4);
        assertEquals(app.items[0].quality, 50);
    }

    @Test
    void when_BackstagePassesAreExpiredandQuality0_expect_SellInToDecreaseAndQualityToStay0() {
        final Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, -1);
        assertEquals(app.items[0].quality, 0);
    }

    @Test
    void when_AgedBrieGetsOld_expect_SellInToDecreaseAndQualityToIncrease() {
        final Item[] items = new Item[]{new Item("Aged Brie", 10, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 9);
        assertEquals(app.items[0].quality, 11);
    }

    @Test
    void when_AgedBrieQualityIs50_expect_SellInToDecreaseAndQualityToNotIncrease() {
        final Item[] items = new Item[]{new Item("Aged Brie", 10, 50)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 9);
        assertEquals(app.items[0].quality, 50);
    }

    @Test
    void when_RegularItemIsUsedAndSellInNotExpired_expect_SellInToDecreaseAndQualityDecreaseBy1() {
        final Item[] items = new Item[]{new Item("normalItem", 2, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 1);
        assertEquals(app.items[0].quality, 9);
    }

    @Test
    void when_RegularItemIsUsedAndSellExpired_expect_SellInToDecreaseAndQualityDecreaseBy2() {
        final Item[] items = new Item[]{new Item("normalItem", 0, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, -1);
        assertEquals(app.items[0].quality, 8);
    }

    @Test
    void when_RegularItemQualityIs0_expect_SellInToDecreaseAndQualityDoNotDecrease() {
        final Item[] items = new Item[]{new Item("normalItem", 0, 0)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, -1);
        assertEquals(app.items[0].quality, 0);
    }

    @Test
    void when_ConjuredIsUsedAndSellInNotExpired_expect_SellInToDecreaseAndQualityDecreaseBy2() {
        final Item[] items = new Item[]{new Item("Conjured Mana Cake", 2, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 1);
        assertEquals(app.items[0].quality, 8);
    }

    @Test
    void when_ConjuredItemIsExpired_expect_SellInToDecreaseAndQualityDecreaseBy4() {
        final Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 10)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, -1);
        assertEquals(app.items[0].quality, 6);
    }

    @Test
    void when_ConjuredItemQualityIs0_expect_SellInToDecreaseAndQualityDoNotDecrease() {
        final Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 0)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, -1);
        assertEquals(app.items[0].quality, 0);
    }
}
