package com.example.inventoryservice.commands.aggregates;
;
import ma.enset.commonapi.commands.CreateCategoryCommand;
import ma.enset.commonapi.events.CategoryCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class CategoryAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String description;

    public CategoryAggregate() {
    }

    @CommandHandler
    public CategoryAggregate(CreateCategoryCommand command) {
        if (command.getName() == null || command.getName().isEmpty() || command.getDescription() == null || command.getDescription().isEmpty()) {
            throw new IllegalArgumentException("All fields are required and cannot be empty");
        }
        AggregateLifecycle.apply(new CategoryCreatedEvent(
                UUID.randomUUID().toString(),
                command.getName(),
                command.getDescription()));
    }
    @EventSourcingHandler
    public void on(CategoryCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
    }
}
