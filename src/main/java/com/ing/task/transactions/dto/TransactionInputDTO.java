package com.ing.task.transactions.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@Introspected
public class TransactionInputDTO {

  private final String debitAccount; // konto z któego wysyłamy
  private final String creditAccount; // konto na które wysyłamy
  private final Double amount; // wartość

  public TransactionInputDTO(String debitAccount, String creditAccount, Double amount) {
    this.debitAccount = debitAccount;
    this.creditAccount = creditAccount;
    this.amount = amount;
  }

  public String getDebitAccount() {
    return debitAccount;
  }

  public String getCreditAccount() {
    return creditAccount;
  }

  public Double getAmount() {
    return amount;
  }

}
