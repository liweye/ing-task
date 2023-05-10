package com.ing.task.atm.dto.output;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@Introspected
public class ServiceTaskOutputDTO {

  private final int region;
  private final int atmId;

  public ServiceTaskOutputDTO(int region, int atmId) {
    this.region = region;
    this.atmId = atmId;
  }

  public int getRegion() {
    return region;
  }

  public int getAtmId() {
    return atmId;
  }

}