package domain;

import com.gildedrose.Item;

public class LegendaryStrategy implements UpdateStrategy {

    @Override
    public Item update(final Item item, final int qualityChangeRate) {
        return item;
    }
}
