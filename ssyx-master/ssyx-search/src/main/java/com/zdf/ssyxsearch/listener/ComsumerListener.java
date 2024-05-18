package com.zdf.ssyxsearch.listener;

import com.rabbitmq.client.Channel;
import com.zdf.internalcommon.constant.RabbitMqConstant;
import com.zdf.ssyxsearch.service.SearchService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Objects;

/**
 *@Description ComsumerListener
 *@Author mrzhang
 *@Date 2024/5/16 12:08
 */
@Component
public class ComsumerListener {

    @Resource
    private SearchService searchService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitMqConstant.QUEUE_LISTING, durable = "true"),
            exchange = @Exchange(value = RabbitMqConstant.EXCHANGE),
            key = {RabbitMqConstant.ROUTING_KEY_LISTING}
    ))
    public void listSku(Long id, Message message, Channel channel) throws IOException {
        if (!Objects.isNull(id)) {
            searchService.listProduct(id);
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitMqConstant.QUEUE_REMOVAL, durable = "true"),
            exchange = @Exchange(value = RabbitMqConstant.EXCHANGE),
            key = {RabbitMqConstant.ROUTING_KEY_REMOVAL}
    ))
    public void removalSku(Long id, Message message, Channel channel) throws IOException {
        if (!Objects.isNull(id)){
            searchService.removalProduct(id);
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
