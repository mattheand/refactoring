package com.gildedrose.domain;

import com.gildedrose.Item;

public class IncreaseStrategy implements UpdateStrategy {

    @Override
    public Item update(final Item item, final int qualityChangeRate) {
        final int newQuality;

        if (ItemValidator.reachedMaxQualityValue(item.quality)) {
            newQuality = ItemValidator.getMaxQualityValue();
        } else {
            newQuality = item.quality + qualityChangeRate;
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }
}
