package com.ing.task.transactions;

import static com.ing.task.transactions.TransactionsRestController.TRANSACTIONS_CONTROLLER_URL;
import static io.micronaut.http.MediaType.APPLICATION_JSON;

import com.google.common.collect.ImmutableList;
import com.ing.task.transactions.dto.TransactionInputDTO;
import com.ing.task.transactions.dto.TransactionOutputDTO;
import com.ing.task.transactions.service.TransactionsService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import java.util.List;

@Controller(TRANSACTIONS_CONTROLLER_URL)
public class TransactionsRestController {

  final static String TRANSACTIONS_CONTROLLER_URL = "/transactions/report";

  @Post(consumes = {APPLICATION_JSON}, processes = {APPLICATION_JSON})
  public List<TransactionOutputDTO> createReport(@Body List<TransactionInputDTO> transactions) {
    return TransactionsService.createReport(transactions);
  }

}
