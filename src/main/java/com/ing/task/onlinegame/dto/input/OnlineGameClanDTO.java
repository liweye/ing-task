package com.ing.task.onlinegame.dto.input;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import java.util.Objects;

@Serdeable
@Introspected
public class OnlineGameClanDTO {

  private final long numberOfPlayers;
  private final long points;

  public OnlineGameClanDTO(long numberOfPlayers, long points) {
    this.numberOfPlayers = numberOfPlayers;
    this.points = points;
  }

  public long getNumberOfPlayers() {
    return numberOfPlayers;
  }

  public long getPoints() {
    return points;
  }

  @Override
  public int hashCode() {
    return 31 * Long.hashCode(numberOfPlayers) + Long.hashCode(points);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof OnlineGameClanDTO onlineGameClan) {
      return Objects.equals(this.numberOfPlayers, onlineGameClan.getNumberOfPlayers())
             && Objects.equals(this.points, onlineGameClan.getPoints());
    }
    return false;
  }

}
