package com.ykb.cloud;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ykb.cloud.event.MyRemoteEvent;

@Component
public class MyEventList {

    @EventListener(MyRemoteEvent.class)
    public void name(final MyRemoteEvent eventParam) {
        System.out.println(eventParam.getEventMessage());
    }

}
