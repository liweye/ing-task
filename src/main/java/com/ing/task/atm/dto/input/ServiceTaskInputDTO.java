package com.ing.task.atm.dto.input;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@Introspected
public class ServiceTaskInputDTO {

  private final int region;
  private final int atmId;
  private final RequestType requestType;
  private Long orderNumber; // kolejność zgłoszeń

  public ServiceTaskInputDTO(int region, int atmId, RequestType requestType) {
    this.region = region;
    this.atmId = atmId;
    this.requestType = requestType;
  }

  public int getRegion() {
    return region;
  }

  public int getAtmId() {
    return atmId;
  }

  public int getRequestPrio() {
    return requestType.getPrio();
  }

  public Long getOrderNumber() {
    return orderNumber;
  }

  public ServiceTaskInputDTO withOrderNumber(Long orderNumber) {
    this.orderNumber = orderNumber;
    return this;
  }

  public String getAtmKey() {
    return region + "-" + atmId;
  }

}
