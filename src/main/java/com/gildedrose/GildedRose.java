package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            switch (items[i].name) {
                case "Aged Brie":
                    items[i] = new AgedBrie().update(items[i]);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    items[i] = new Sulfuras().update(items[i]);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    items[i] = new BackstagePass().update(items[i]);
                    break;
                default:
                    items[i] = new RegularItem().update(items[i]);
                    break;
            }
        }
    }


}