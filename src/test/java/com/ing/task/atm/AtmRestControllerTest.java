package com.ing.task.atm;

import static com.ing.task.atm.AtmRestController.ATM_CONTROLLER_URL;
import static com.ing.task.atm.data.AtmTestData.ATM_EXAMPLE_1_REQUEST_DATA;
import static com.ing.task.atm.data.AtmTestData.ATM_EXAMPLE_1_RESPONSE_DATA;
import static com.ing.task.atm.data.AtmTestData.ATM_EXAMPLE_2_REQUEST_DATA;
import static com.ing.task.atm.data.AtmTestData.ATM_EXAMPLE_2_RESPONSE_DATA;
import static io.micronaut.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.is;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

@MicronautTest
public class AtmRestControllerTest {

  @Test
  void shouldCalculateAtmsOrderWithExample_1_Data(RequestSpecification spec) {
    spec
        .when()
        .body(ATM_EXAMPLE_1_REQUEST_DATA)
        .contentType(APPLICATION_JSON)
        .post(ATM_CONTROLLER_URL)
        .then()
        .statusCode(200)
        .body(is(ATM_EXAMPLE_1_RESPONSE_DATA));
  }

  @Test
  void shouldCalculateAtmsOrderWithExample_2_Data(RequestSpecification spec) {
    spec
        .when()
        .body(ATM_EXAMPLE_2_REQUEST_DATA)
        .contentType(APPLICATION_JSON)
        .post(ATM_CONTROLLER_URL)
        .then()
        .statusCode(200)
        .body(is(ATM_EXAMPLE_2_RESPONSE_DATA));
  }

}
