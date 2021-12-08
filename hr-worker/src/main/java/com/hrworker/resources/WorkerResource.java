package com.hrworker.resources;

import com.hrworker.entities.Worker;
import com.hrworker.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
@AllArgsConstructor
public class WorkerResource {
  private final WorkerRepository repository;

  @GetMapping
  public ResponseEntity<List<Worker>> findAll() {
    List<Worker> workers = repository.findAll();
    return ResponseEntity.ok(workers);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id) {
    Optional<Worker> worker = repository.findById(id);
    return ResponseEntity.ok(worker.get());
  }

}
