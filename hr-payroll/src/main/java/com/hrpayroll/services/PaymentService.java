package com.hrpayroll.services;

import com.hrpayroll.entities.Payment;
import com.hrpayroll.entities.Worker;
import com.hrpayroll.feignclients.WorkerFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {
  private WorkerFeignClient workerFeignClient;

  public Payment getPayment(Long workerId, Integer days) {
    Worker worker = workerFeignClient.findById(workerId).getBody();
    return Payment.builder()
      .name(worker.getName())
      .dailyIncome(worker.getDailyIncome())
      .days(days)
      .build();
  }
}
