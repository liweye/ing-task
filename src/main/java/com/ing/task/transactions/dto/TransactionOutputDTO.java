package com.ing.task.transactions.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@Introspected
public class TransactionOutputDTO {

  private final String account;
  private long debitCount = 0;
  private long creditCount = 0;
  private double balance = 0.0;

  public TransactionOutputDTO(String account) {
    this.account = account;
  }

  public String getAccount() {
    return account;
  }

  public long getDebitCount() {
    return debitCount;
  }

  public long getCreditCount() {
    return creditCount;
  }

  public double getBalance() {
    return balance;
  }

  public void addToBalance(double value) {
    this.balance += value;
  }

  public void subtractFromBalance(double value) {
    this.balance -= value;
  }

  public void incrementDebitCount() {
    this.debitCount++;
  }

  public void incrementCreditCount() {
    this.creditCount++;
  }

}
