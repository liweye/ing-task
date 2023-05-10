package com.ing.task.atm;

import static com.ing.task.atm.AtmRestController.ATM_CONTROLLER_URL;
import static io.micronaut.http.MediaType.APPLICATION_JSON;

import com.ing.task.atm.dto.input.ServiceTaskInputDTO;
import com.ing.task.atm.dto.output.ServiceTaskOutputDTO;
import com.ing.task.atm.service.AtmService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import java.util.List;

@Controller(ATM_CONTROLLER_URL)
public class AtmRestController {

  final static String ATM_CONTROLLER_URL = "atms/calculateOrder";

  @Post(consumes = {APPLICATION_JSON}, processes = {APPLICATION_JSON})
  public List<ServiceTaskOutputDTO> calculateOrder(@Body List<ServiceTaskInputDTO> serviceTasks) {
    return AtmService.calculateOrder(serviceTasks);
  }

}
