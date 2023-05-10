package com.ing.task.onlinegame;


import static com.ing.task.onlinegame.OnlineGameRestController.ONLINE_GAME_CONTROLLER_URL;
import static com.ing.task.onlinegame.data.OnlineGameTestData.ONLINE_GAME_EXAMPLE_REQUEST_DATA;
import static com.ing.task.onlinegame.data.OnlineGameTestData.ONLINE_GAME_EXAMPLE_RESPONSE_DATA;
import static io.micronaut.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.is;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

@MicronautTest
public class OnlineGameRestControllerTest {

  @Test
  void shouldCalculateOnlineGameWithExampleData(RequestSpecification spec) {
    spec
        .when()
        .body(ONLINE_GAME_EXAMPLE_REQUEST_DATA)
        .contentType(APPLICATION_JSON)
        .post(ONLINE_GAME_CONTROLLER_URL)
        .then()
        .statusCode(200)
        .body(is(ONLINE_GAME_EXAMPLE_RESPONSE_DATA));
  }

}
