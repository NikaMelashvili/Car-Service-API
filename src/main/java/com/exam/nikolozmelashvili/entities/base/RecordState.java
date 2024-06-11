package com.exam.nikolozmelashvili.entities.base;

import lombok.Getter;

@Getter
public enum RecordState {
    ACTIVE(1),
    INACTIVE(2),
    DELETED(3);

    private final int value;

    RecordState(int value) {
        this.value = value;
    }

    public static RecordState fromValue(int value) {
        for (RecordState state : values()) {
            if (state.getValue() == value) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
