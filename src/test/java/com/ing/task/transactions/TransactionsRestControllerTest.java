package com.ing.task.transactions;

import static com.ing.task.transactions.TransactionsRestController.TRANSACTIONS_CONTROLLER_URL;
import static com.ing.task.transactions.data.TransactionTestData.TRANSACTION_EXAMPLE_REQUEST_DATA;
import static com.ing.task.transactions.data.TransactionTestData.TRANSACTION_EXAMPLE_RESPONSE_DATA;
import static io.micronaut.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.is;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

@MicronautTest
public class TransactionsRestControllerTest {

  @Test
  void shouldGenerateTransactionsReportWithExampleData(RequestSpecification spec) {
    spec
        .when()
        .body(TRANSACTION_EXAMPLE_REQUEST_DATA)
        .contentType(APPLICATION_JSON)
        .post(TRANSACTIONS_CONTROLLER_URL)
        .then()
        .statusCode(200)
        .body(is(TRANSACTION_EXAMPLE_RESPONSE_DATA));
  }

}
