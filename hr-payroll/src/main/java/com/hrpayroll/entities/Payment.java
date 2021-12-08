package com.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment implements Serializable {
  private static final long serialVersionUID = 1L;

  private String name;
  private Double dailyIncome;
  private Integer days;

  public Double getTotal() {
    return this.days * this.dailyIncome;
  }
}
