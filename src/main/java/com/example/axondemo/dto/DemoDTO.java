package com.example.axondemo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author jens
 * @since 21/06/17, 10:47
 */
public class DemoDTO {
    private final List<String> messages;

    @JsonCreator
    public DemoDTO(@JsonProperty("messages") List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
