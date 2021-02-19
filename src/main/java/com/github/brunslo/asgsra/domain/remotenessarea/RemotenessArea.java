package com.github.brunslo.asgsra.domain.remotenessarea;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.util.Assert;

public record RemotenessArea(State state, Category category) {
    public RemotenessArea {
        Assert.notNull(state, "system must not be null");
        Assert.notNull(category, "category must not be null");
    }

    public static RemotenessArea valueOf(int code) {
        Assert.isTrue(code >= 10, "code must be >= 10");
        Assert.isTrue(code < 100, "code must be < 100");

        val state = State.valueOf(code / 10);
        val category = Category.valueOf(code % 10);

        return new RemotenessArea(state, category);
    }

    public int code() {
        return state.getCode() * 10 + category.getCode();
    }

    @RequiredArgsConstructor
    public enum State {
        NEW_SOUTH_WALES(1),
        VICTORIA(2),
        QUEENSLAND(3),
        SOUTH_AUSTRALIA(4),
        WESTERN_AUSTRALIA(5),
        TASMANIA(6),
        NORTHERN_TERRITORY(7),
        AUSTRALIAN_CAPITAL_TERRITORY(8),
        OTHER_TERRITORIES(9);

        @Getter
        private final int code;

        public static State valueOf(int code) {
            for (val state : values()) {
                if (code == state.getCode()) {
                    return state;
                }
            }

            throw new IllegalArgumentException("No State with code " + code);
        }
    }

    @RequiredArgsConstructor
    public enum Category {
        MAJOR_CITIES_OF_AUSTRALIA(0),
        INNER_REGIONAL_AUSTRALIA(1),
        OUTER_REGIONAL_AUSTRALIA(2),
        REMOTE_AUSTRALIA(3),
        VERY_REMOTE_AUSTRALIA(4),
        MIGRATORY_OFFSHORE_SHIPPING(5),
        NO_USUAL_ADDRESS(9);

        @Getter
        private final int code;

        public static Category valueOf(int code) {
            for (val category : values()) {
                if (code == category.getCode()) {
                    return category;
                }
            }

            throw new IllegalArgumentException("No Category with code " + code);
        }
    }
}
