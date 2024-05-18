package com.zdf.internalcommon.constant;

import lombok.Data;

/**
 *@Description RocketMQ Constant
 *@Author mrzhang
 *@Date 2024/5/14 22:02
 */
@Data
public class RabbitMqConstant {
    public static final String EXCHANGE = "ssyx-exchange";
    public static final String ROUTING_KEY_LISTING = "ssyx-routing-listing";
    public static final String ROUTING_KEY_REMOVAL = "ssyx-routing-removal";
    public static final String QUEUE_LISTING = "ssyx-queue-listing";
    public static final String QUEUE_REMOVAL = "ssyx-queue-removal";

    private RabbitMqConstant(){}
}
