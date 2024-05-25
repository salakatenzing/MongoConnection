package org.example;

import org.example.ExampleRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/examples")
public class ExampleController {

    @Autowired
    private ExampleRepository repository;

    @PostMapping
    public Example addExample(@RequestBody Example example) {
        return repository.save(example);
    }

    @GetMapping("/{id}")
    public Example getExample(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    // Add more endpoints as needed for update and delete
}
