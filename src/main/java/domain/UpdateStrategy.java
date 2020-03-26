package domain;

import com.gildedrose.Item;

public interface UpdateStrategy {
     Item update(Item item, int qualityChangeRate);
}
