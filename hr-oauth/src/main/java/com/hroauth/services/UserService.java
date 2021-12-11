package com.hroauth.services;

import com.hroauth.entities.User;
import com.hroauth.feignclients.UserFeignClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
  private final UserFeignClient userFeignClient;

  public User findByEmail(String email) {
    User user = userFeignClient.findByEmail(email).getBody();

    if (user == null) {
      log.error("Email not found: {}", email);
      throw new IllegalArgumentException("Email not found");
    }

    log.info("Email found: {}", email);
    return user;
  }

}
