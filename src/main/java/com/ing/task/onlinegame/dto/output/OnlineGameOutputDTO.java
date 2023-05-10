package com.ing.task.onlinegame.dto.output;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class OnlineGameOutputDTO {

  private final long numberOfPlayers;
  private final long points;

  public OnlineGameOutputDTO(long numberOfPlayers, long points) {
    this.numberOfPlayers = numberOfPlayers;
    this.points = points;
  }

  public long getNumberOfPlayers() {
    return numberOfPlayers;
  }

  public long getPoints() {
    return points;
  }

}
