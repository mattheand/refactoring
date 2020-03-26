package com.gildedrose;

public class AgedBrie implements UpdatableItem {
    public static final int MAX_QUALITY = 50;
    public static final int INCREMENT = 1;

    @Override
    public Item update(final Item item) {
        final int newQuality;
        if (reachedLimit(item.quality)) {
            newQuality = MAX_QUALITY;
        } else {
            newQuality = item.quality + INCREMENT;
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    private boolean reachedLimit(final int quality) {
        return quality >= MAX_QUALITY;
    }
}
