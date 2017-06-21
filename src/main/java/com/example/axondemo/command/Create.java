package com.example.axondemo.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * @author jens
 * @since 21/06/17, 10:45
 */
public class Create {
    @TargetAggregateIdentifier
    private final String name;

    public Create(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
