package com.ing.task.transactions.service;

import com.ing.task.transactions.dto.TransactionInputDTO;
import java.util.List;
import java.util.regex.Pattern;

public class TransactionsValidationService {

  private static final Pattern BANK_ACCOUNT = Pattern.compile("[0-9]{26}");

  public static void validateTransactions(final List<TransactionInputDTO> transactions) {
    transactions.forEach(transaction -> {
      validateAccountNumber(transaction.getCreditAccount());
      validateAccountNumber(transaction.getDebitAccount());
      validateAmount(transaction.getAmount());
    });
  }

  private static void validateAccountNumber(final String account) {
    if (!BANK_ACCOUNT.matcher(account).matches()) {
      throw new RuntimeException();
    }
  }

  private static void validateAmount(final Double amount) {
    if (amount == null) {
      throw new RuntimeException();
    }
  }

}
