package com.hruser.resources;

import com.hruser.entities.User;
import com.hruser.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserResource {
  private final UserRepository repository;

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    Optional<User> worker = repository.findById(id);
    return ResponseEntity.ok(worker.get());
  }

  @GetMapping(value = "/search")
  public ResponseEntity<User> findByEmail(@RequestParam String email) {
    User worker = repository.findByEmail(email);
    return ResponseEntity.ok(worker);
  }
}