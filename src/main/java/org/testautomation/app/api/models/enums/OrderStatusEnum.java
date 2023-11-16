package org.testautomation.app.api.models.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    PLACED("placed"),

    APPROVED("approved"),

    DELIVERED("delivered");

    private final String value;

    OrderStatusEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
