package com.example.inventoryservice.commands.controllers;

import ma.enset.commonapi.commands.CreateCategoryCommand;
import ma.enset.commonapi.dtos.CreateCategoryRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/command/category")
public class CategoryCommandController {
    private CommandGateway commandGateway;

    public CategoryCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(path = "/create")
    public CompletableFuture<String> createCategory(@RequestBody CreateCategoryRequestDTO createCategoryDTO) {
        return commandGateway.send(new CreateCategoryCommand(
                UUID.randomUUID().toString(),
                createCategoryDTO.getName(),
                createCategoryDTO.getDescription()
        ));
    }
}
