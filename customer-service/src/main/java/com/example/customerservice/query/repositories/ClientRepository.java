package com.example.customerservice.query.repositories;

import com.example.customerservice.query.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,String> {
}
