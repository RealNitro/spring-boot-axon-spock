package com.example.axondemo.domain;

import com.example.axondemo.command.Message;
import com.example.axondemo.command.Create;
import com.example.axondemo.event.DemoCreated;
import com.example.axondemo.event.MessageReceived;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * @author jens
 * @since 21/06/17, 10:46
 */
@Aggregate
@AggregateRoot
public class DemoAggregate {
    @AggregateIdentifier
    private String name;

    public DemoAggregate() {
    }

    @CommandHandler
    public DemoAggregate(Create cmd) {
        apply(new DemoCreated(cmd.getName()));
    }

    @CommandHandler
    public void handle(Message cmd) {
        apply(new MessageReceived(cmd.getContent()));
    }

    @EventSourcingHandler
    public void handle(DemoCreated evt) {
        name = evt.getName();
    }

    @EventSourcingHandler
    public void handle(MessageReceived evt) {
        // not doing anything for now
    }
}
