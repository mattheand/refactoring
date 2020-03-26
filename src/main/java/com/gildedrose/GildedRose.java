package com.gildedrose;

import com.gildedrose.domain.DecreaseStrategy;
import com.gildedrose.domain.IncreaseStrategy;
import com.gildedrose.domain.LegendaryStrategy;
import com.gildedrose.domain.VariableStrategy;
import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        this.items = Arrays.stream(this.items).map(this::applyUpdateStrategy).toArray(Item[]::new);
    }

    private Item applyUpdateStrategy(Item item) {
        switch (item.name) {
            case "Aged Brie":
                item = new IncreaseStrategy().update(item, 1);
                break;
            case "Sulfuras, Hand of Ragnaros":
                item = new LegendaryStrategy().update(item, 0);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item = new VariableStrategy().update(item, 1);
                break;
            case "Conjured Mana Cake":
                item = new DecreaseStrategy().update(item, 2);
                break;
            default:
                item = new DecreaseStrategy().update(item, 1);
                break;
        }
        return item;
    }
}