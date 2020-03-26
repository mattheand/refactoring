package com.gildedrose;

public final class RegularItem implements UpdatableItem {
    public static final int MIN_LIMIT = 0;
    public static final int INCREMENT = 1;

    @Override
    public Item update(final Item item) {
        final int newQuality;

        if (reachedLimit(item.quality)) {
            newQuality = MIN_LIMIT;
        } else {
            if (isExpired(item)) {
                newQuality = item.quality - INCREMENT * 2;
            } else {
                newQuality = item.quality - INCREMENT;
            }
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    private boolean reachedLimit(final int quality) {
        return quality <= MIN_LIMIT;
    }

    private boolean isExpired(final Item item) {
        return item.sellIn <= 0;
    }
}
