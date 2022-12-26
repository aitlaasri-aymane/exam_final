package com.example.customerservice.commands.aggregates;

import ma.enset.commonapi.commands.CreateCustomerCommand;
import ma.enset.commonapi.events.ClientCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class ClientAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public ClientAggregate() {
    }

    @CommandHandler
    public ClientAggregate(CreateCustomerCommand command) {
        if (command.getName() == null || command.getName().isEmpty() || command.getEmail() == null || command.getEmail().isEmpty() || command.getPhone() == null || command.getPhone().isEmpty() || command.getAddress() == null || command.getAddress().isEmpty()) {
            throw new IllegalArgumentException("All fields are required and cannot be empty");
        }
        AggregateLifecycle.apply(new ClientCreatedEvent(
                UUID.randomUUID().toString(),
                command.getName(),
                command.getEmail(),
                command.getPhone(),
                command.getAddress()));
    }

    @EventSourcingHandler
    public void on(ClientCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.phone = event.getPhone();
        this.address = event.getAddress();
    }
}
