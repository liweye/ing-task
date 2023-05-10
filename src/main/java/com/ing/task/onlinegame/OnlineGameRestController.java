package com.ing.task.onlinegame;

import static com.ing.task.onlinegame.OnlineGameRestController.ONLINE_GAME_CONTROLLER_URL;
import static io.micronaut.http.MediaType.APPLICATION_JSON;

import com.ing.task.onlinegame.dto.input.OnlineGameInputDTO;
import com.ing.task.onlinegame.dto.output.OnlineGameOutputDTO;
import com.ing.task.onlinegame.service.OnlineGameService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import java.util.List;

@Controller(ONLINE_GAME_CONTROLLER_URL)
public class OnlineGameRestController {

  final static String ONLINE_GAME_CONTROLLER_URL = "/onlinegame/calculate";

  @Post(consumes = {APPLICATION_JSON}, processes = {APPLICATION_JSON})
  public List<List<OnlineGameOutputDTO>> calculateOrder(@Body OnlineGameInputDTO players) {
    return OnlineGameService.calculateGroupsOrder(players);
  }

}