package com.ing.task.onlinegame.dto.input;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import java.util.List;

@Serdeable
@Introspected
public class OnlineGameInputDTO {

  private final long groupCount;
  private final List<OnlineGameClanDTO> clans;

  public OnlineGameInputDTO(long groupCount, List<OnlineGameClanDTO> clans) {
    this.groupCount = groupCount;
    this.clans = clans;
  }

  public long getGroupCount() {
    return groupCount;
  }

  public List<OnlineGameClanDTO> getClans() {
    return clans;
  }

}
