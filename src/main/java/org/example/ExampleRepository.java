package org.example;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExampleRepository extends MongoRepository<Example, String> {
    // Custom database queries can be defined here
}