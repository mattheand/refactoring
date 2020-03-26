package com.gildedrose.domain;

import com.gildedrose.Item;

public interface UpdateStrategy {
     Item update(Item item, int qualityChangeRate);
}
