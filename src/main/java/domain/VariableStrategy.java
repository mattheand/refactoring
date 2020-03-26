package domain;

import com.gildedrose.Item;

public class VariableStrategy implements UpdateStrategy {


    @Override
    public Item update(final Item item, final int qualityChangeRate) {
        final int newQuality;

        if (ItemValidator.isExpired(item.sellIn)) {
            newQuality = ItemValidator.getMinQualityValue();
        } else if (ItemValidator.reachedMaxQualityValue(item.quality)) {
            newQuality = ItemValidator.getMaxQualityValue();
        } else {
            if (item.sellIn <= 5) {
                newQuality = item.quality + qualityChangeRate * 3;
            } else if (item.sellIn <= 10) {
                newQuality = item.quality + qualityChangeRate * 2;
            } else {
                newQuality = item.quality + qualityChangeRate;
            }
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }
}
