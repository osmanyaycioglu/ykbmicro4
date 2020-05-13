package com.ykb.cloud;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @Value("${server.port}")
    private int port;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "dep_it_q", autoDelete = "false", durable = "true"),
                                             exchange = @Exchange(name = "dep_exchange",
                                                                  type = ExchangeTypes.DIRECT,
                                                                  durable = "true"),
                                             key = "dep.it"))
    @SendTo("org_exchange/dep.result")
    public String xyz(final Department dep) {
        System.out.println("xyz : " + dep);
        return "xyz : processed " + this.port;
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "dep_fin_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "dep_exchange",
                                                                  type = ExchangeTypes.DIRECT,
                                                                  durable = "true"),
                                             key = "dep.fin"))
    @SendTo("org_exchange/dep.result")
    public String bnm(final Department dep) {
        System.out.println("bnm : " + dep);
        return "bnm : processed " + this.port;
    }

}
