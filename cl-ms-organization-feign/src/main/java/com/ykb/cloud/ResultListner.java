package com.ykb.cloud;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ResultListner {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "org_result_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "org_exchange",
                                                                  type = ExchangeTypes.DIRECT,
                                                                  durable = "true"),
                                             key = "dep.result"))
    public void result(final String str) {
        System.out.println("result : " + str);
    }

}
