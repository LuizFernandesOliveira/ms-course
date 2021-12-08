package com.hrpayroll.services;

import com.hrpayroll.entities.Payment;
import com.hrpayroll.entities.Worker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${hr-worker.host}")
  private String workerHost;

  public Payment getPayment(Long workerId, Integer days) {
    Map<String, String> params = new HashMap<>();
    params.put("id", String.valueOf(workerId));
    var url = workerHost + "/workers/{id}";
    Worker worker = restTemplate.getForObject(url, Worker.class, params);
    return Payment.builder()
      .name(worker.getName())
      .dailyIncome(worker.getDailyIncome())
      .days(days)
      .build();
  }
}
