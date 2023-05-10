package com.ing.task.transactions.service;

import static com.ing.task.transactions.service.TransactionsValidationService.validateTransactions;
import static io.micronaut.core.util.CollectionUtils.isNotEmpty;
import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import com.ing.task.transactions.dto.TransactionInputDTO;
import com.ing.task.transactions.dto.TransactionOutputDTO;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TransactionsService {

  private static final Comparator<TransactionOutputDTO> TRANSACTION_COMPARATOR = comparing(TransactionOutputDTO::getAccount);

  public static List<TransactionOutputDTO> createReport(final List<TransactionInputDTO> transactions) {
    if (isNotEmpty(transactions)) {
      validateTransactions(transactions);
      return groupAndCollectTransactions(transactions);
    }
    return emptyList();
  }

  private static List<TransactionOutputDTO> groupAndCollectTransactions(final List<TransactionInputDTO> transactions) {
    final Map<String, TransactionOutputDTO> result = new HashMap<>();
    transactions.forEach(transaction -> {
      calculateDebitTransaction(computeIfAbsent(result, transaction.getDebitAccount()), transaction.getAmount());
      calculateCreditTransaction(computeIfAbsent(result, transaction.getCreditAccount()), transaction.getAmount());
    });
    return result.values().stream().sorted(TRANSACTION_COMPARATOR).collect(toList());
  }

  private static void calculateDebitTransaction(final TransactionOutputDTO transactionOutput, final double amount) {
    transactionOutput.subtractFromBalance(amount);
    transactionOutput.incrementDebitCount();
  }

  private static void calculateCreditTransaction(final TransactionOutputDTO transactionOutput, final double amount) {
    transactionOutput.addToBalance(amount);
    transactionOutput.incrementCreditCount();
  }

  private static TransactionOutputDTO computeIfAbsent(final Map<String, TransactionOutputDTO> result, final String account) {
    return result.computeIfAbsent(account, (__) -> new TransactionOutputDTO(account));
  }

}
