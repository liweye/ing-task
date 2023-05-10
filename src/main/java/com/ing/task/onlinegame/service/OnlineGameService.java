package com.ing.task.onlinegame.service;

import com.ing.task.onlinegame.dto.helper.OnlineGameClansWithCountDTO;
import com.ing.task.onlinegame.dto.input.OnlineGameInputDTO;
import com.ing.task.onlinegame.dto.output.OnlineGameOutputDTO;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class OnlineGameService {

  public static List<List<OnlineGameOutputDTO>> calculateGroupsOrder(final OnlineGameInputDTO players) {
    List<List<OnlineGameOutputDTO>> output = new LinkedList<>();

    final long maxGroupCount = players.getGroupCount();
    List<OnlineGameClansWithCountDTO> onlineGameClansWithCount = OnlineGameServiceHelper.groupAndCountClans(players.getClans());

    while (!onlineGameClansWithCount.isEmpty()) {
      output.add(createClansGroup(onlineGameClansWithCount.listIterator(), maxGroupCount));
    }

    return output;
  }

  private static List<OnlineGameOutputDTO> createClansGroup(
      final Iterator<OnlineGameClansWithCountDTO> iterator,
      final long maxGroupCount
  ) {
    long currentGroupCount = 0;
    final List<OnlineGameOutputDTO> clansGroup = new LinkedList<>();
    while (iterator.hasNext() && OnlineGameServiceHelper.groupIsNotFull(maxGroupCount, currentGroupCount)) {
      final OnlineGameClansWithCountDTO clansWithCount = iterator.next();
      final long numberOfPlayers = clansWithCount.getNumberOfPlayers();
      if (OnlineGameServiceHelper.canAddClanToGroup(maxGroupCount, numberOfPlayers, currentGroupCount)) {
        for (int i = 1; i <= clansWithCount.getNumberOfClans(); i++) {
          if (OnlineGameServiceHelper.canAddClanToGroup(maxGroupCount, numberOfPlayers, currentGroupCount)) {
            OnlineGameServiceHelper.addClanToGroup(clansGroup, numberOfPlayers, clansWithCount.getPoints());
            currentGroupCount += numberOfPlayers;
            if (clansWithCount.getNumberOfClans() == 1) {
              iterator.remove();
            } else {
              clansWithCount.decrementNumberOfClans();
            }
          } else {
            break;
          }
        }
      }
    }
    return clansGroup;
  }
}
