package com.gildedrose;

public class BackstagePass implements UpdatableItem {

    public static final int MAX_QUALITY = 50;
    public static final int INCREMENT = 1;
    private static final int MIN_QUALITY = 0;

    @Override
    public Item update(final Item item) {
        final int newQuality;
        if (reachedMaxLimit(item.quality)) {
            newQuality = MAX_QUALITY;
        } else if (reachedMinLimit(item.quality)) {
            newQuality = MIN_QUALITY;
        } else {
            if (item.sellIn <= 0) {
                newQuality = 0;
            } else if (item.sellIn <= 5) {
                newQuality = item.quality + INCREMENT * 3;
            } else if (item.sellIn <= 10) {
                newQuality = item.quality + INCREMENT * 2;
            } else {
                newQuality = item.quality + INCREMENT;
            }
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    private boolean reachedMaxLimit(final int quality) {
        return quality >= MAX_QUALITY;
    }

    private boolean reachedMinLimit(final int quality) {
        return quality <= MIN_QUALITY;
    }
}
