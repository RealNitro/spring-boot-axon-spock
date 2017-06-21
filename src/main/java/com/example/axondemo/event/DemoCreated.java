package com.example.axondemo.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jens
 * @since 21/06/17, 10:50
 */
public class DemoCreated {
    private final String name;

    @JsonCreator
    public DemoCreated(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
