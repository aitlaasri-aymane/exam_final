package com.example.customerservice.commands.controllers;

import ma.enset.commonapi.commands.CreateCustomerCommand;
import ma.enset.commonapi.dtos.CreateCustomerRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/command/customers")
public class CustomerCommandController {
    private CommandGateway commandGateway;

    public CustomerCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(path = "/create")
    public CompletableFuture<String> createCustomer(@RequestBody CreateCustomerRequestDTO createCustomerRequestDTO) {
        CompletableFuture<String> response = commandGateway.send(new CreateCustomerCommand(
                UUID.randomUUID().toString(),
                createCustomerRequestDTO.getName(),
                createCustomerRequestDTO.getEmail(),
                createCustomerRequestDTO.getPhone(),
                createCustomerRequestDTO.getAddress()
        ));
        return response;
    }
}
