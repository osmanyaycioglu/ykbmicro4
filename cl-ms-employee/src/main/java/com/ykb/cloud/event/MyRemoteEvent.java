package com.ykb.cloud.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class MyRemoteEvent extends RemoteApplicationEvent {

    private static final long serialVersionUID = -2617781967436233666L;
    private String            eventMessage;

    public MyRemoteEvent() {
    }

    public MyRemoteEvent(final Object source,
                         final String id,
                         final String eventMsg) {
        super(source,
              id);
        this.eventMessage = eventMsg;
    }


    public String getEventMessage() {
        return this.eventMessage;
    }


    public void setEventMessage(final String eventMessageParam) {
        this.eventMessage = eventMessageParam;
    }


}
