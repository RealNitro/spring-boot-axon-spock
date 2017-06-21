package com.example.axondemo.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jens
 * @since 21/06/17, 10:51
 */
public class MessageReceived {
    private final String content;

    @JsonCreator
    public MessageReceived(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
