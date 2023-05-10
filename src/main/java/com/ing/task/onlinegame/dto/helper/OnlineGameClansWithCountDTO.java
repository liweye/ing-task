package com.ing.task.onlinegame.dto.helper;

import com.ing.task.onlinegame.dto.input.OnlineGameClanDTO;

public class OnlineGameClansWithCountDTO extends OnlineGameClanDTO {

  /**
   * Liczba klanów z tą samą ilością graczy i punktów.
   */
  private long numberOfClans;

  public OnlineGameClansWithCountDTO(OnlineGameClanDTO onlineGameClanDTO, long numberOfClans) {
    super(onlineGameClanDTO.getNumberOfPlayers(), onlineGameClanDTO.getPoints());
    this.numberOfClans = numberOfClans;
  }

  public long getNumberOfClans() {
    return numberOfClans;
  }

  public void decrementNumberOfClans() {
    this.numberOfClans -= 1;
  }

}
