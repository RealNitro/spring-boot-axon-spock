package com.example.axondemo.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * @author jens
 * @since 21/06/17, 10:51
 */
public class Message {
    @TargetAggregateIdentifier
    private final String name;
    private final String content;

    public Message(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
