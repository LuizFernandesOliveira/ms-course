package com.hrpayroll.resources;

import com.hrpayroll.entities.Payment;
import com.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
@AllArgsConstructor
public class PaymentResource {
  private PaymentService service;

  @HystrixCommand(fallbackMethod = "getPaymentAlternative")
  @GetMapping(value = "/{workerId}/days/{days}")
  public ResponseEntity<Payment> getPayment(
    @PathVariable Long workerId,
    @PathVariable Integer days) {
    Payment payment = service.getPayment(workerId, days);
    return ResponseEntity.ok(payment);
  }

  public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
    Payment payment = Payment.builder()
      .name("Test")
      .days(days)
      .dailyIncome(300.0)
      .build();
    return ResponseEntity.ok(payment);
  }
}
