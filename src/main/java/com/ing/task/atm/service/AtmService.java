package com.ing.task.atm.service;

import static com.google.common.collect.Streams.mapWithIndex;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

import com.ing.task.atm.dto.input.ServiceTaskInputDTO;
import com.ing.task.atm.dto.output.ServiceTaskOutputDTO;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public final class AtmService {

  private static final Comparator<ServiceTaskInputDTO> ATM_ORDER_COMPARATOR = comparing(
      ServiceTaskInputDTO::getRegion // jako pierwsze sortujemy po regionie
  ).thenComparing(
      ServiceTaskInputDTO::getRequestPrio, reverseOrder() // następnie po rodzaju zlecenia
  ).thenComparing(
      nullsLast(
          comparing(ServiceTaskInputDTO::getOrderNumber) // na koncu po kolejności zgłoszeń
      )
  );

  public static List<ServiceTaskOutputDTO> calculateOrder(List<ServiceTaskInputDTO> serviceTasks) {
    return orderByRegionAndRequestPrio(
        findAtmsWithHighestRequestPrioGroupedByRegionAndId(serviceTasks)
    );
  }

  private static List<ServiceTaskOutputDTO> orderByRegionAndRequestPrio(Stream<ServiceTaskInputDTO> serviceTasks) {
    return serviceTasks.sorted(ATM_ORDER_COMPARATOR)
        .map(AtmService::mapToOutput)
        .collect(toList());
  }

  private static Stream<ServiceTaskInputDTO> findAtmsWithHighestRequestPrioGroupedByRegionAndId(List<ServiceTaskInputDTO> serviceTasks) {
    return mapWithIndex(serviceTasks.stream(), ServiceTaskInputDTO::withOrderNumber)
        .collect(
            groupingBy(
                ServiceTaskInputDTO::getAtmKey,
                maxBy(
                    comparingInt(
                        ServiceTaskInputDTO::getRequestPrio
                    )
                )
            )
        )
        .values()
        .stream()
        .filter(Optional::isPresent)
        .map(Optional::get);
  }

  private static ServiceTaskOutputDTO mapToOutput(final ServiceTaskInputDTO serviceTask) {
    return new ServiceTaskOutputDTO(serviceTask.getRegion(), serviceTask.getAtmId());
  }

}
