package org.testautomation.app.api.models;

import lombok.Data;
import org.testautomation.app.api.models.enums.OrderStatusEnum;


@Data
public class Order {
    private final Long id;
    private final Long petId;
    private final Integer quantity;
    private final String shipDate;
    private final OrderStatusEnum status;
    private final Boolean complete;
}
