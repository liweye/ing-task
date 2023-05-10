package com.ing.task.atm.dto.input;

public enum RequestType {
  FAILURE_RESTART(3),
  PRIORITY(2),
  SIGNAL_LOW(1),
  STANDARD(0);

  private final int prio; // wyższa wartość == wyższy priorytet

  RequestType(final int prio) {
    this.prio = prio;
  }

  public int getPrio() {
    return prio;
  }

}
