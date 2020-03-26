package com.gildedrose.domain;

public class ItemValidator {
    private static final int MIN_QUALITY_VALUE = 0;
    private static final int MAX_QUALITY_VALUE = 50;

    public static boolean reachedMinQualityValue(final int quality) {
        return quality <= MIN_QUALITY_VALUE;
    }

    public static int getMaxQualityValue() {
        return MAX_QUALITY_VALUE;
    }

    public static int getMinQualityValue() {
        return MIN_QUALITY_VALUE;
    }

    public static boolean isExpired(final int sellIn) {
        return sellIn <= 0;
    }

    public static boolean reachedMaxQualityValue(final int quality) {
        return quality >= MAX_QUALITY_VALUE;
    }
}
