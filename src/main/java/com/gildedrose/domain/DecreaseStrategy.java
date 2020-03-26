package com.gildedrose.domain;

import com.gildedrose.Item;

public final class DecreaseStrategy implements UpdateStrategy {
    @Override
    public Item update(final Item item, final int qualityChangeRate) {
        final int newQuality;

        if (ItemValidator.reachedMinQualityValue(item.quality)) {
            newQuality = ItemValidator.getMinQualityValue();
        } else {
            if (ItemValidator.isExpired(item.sellIn)) {
                newQuality = item.quality - qualityChangeRate * 2;
            } else {
                newQuality = item.quality - qualityChangeRate;
            }
        }
        return new Item(item.name, item.sellIn - 1, newQuality);
    }
}
