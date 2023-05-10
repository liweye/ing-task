package com.ing.task.onlinegame.service;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

import com.ing.task.onlinegame.dto.input.OnlineGameClanDTO;
import com.ing.task.onlinegame.dto.helper.OnlineGameClansWithCountDTO;
import com.ing.task.onlinegame.dto.output.OnlineGameOutputDTO;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class OnlineGameServiceHelper {

  private static final Comparator<OnlineGameClanDTO> ONLINE_GAME_CLAN_DTO_COMPARATOR = comparing(
      OnlineGameClanDTO::getPoints, reverseOrder()
  ).thenComparing(
      OnlineGameClanDTO::getNumberOfPlayers
  );

  static List<OnlineGameClansWithCountDTO> groupAndCountClans(final List<OnlineGameClanDTO> inputClans) {
    return inputClans
        .parallelStream()
        .collect(groupingBy(identity(), counting()))
        .entrySet().parallelStream()
        .map(e -> new OnlineGameClansWithCountDTO(e.getKey(), e.getValue()))
        .sorted(ONLINE_GAME_CLAN_DTO_COMPARATOR)
        .collect(toCollection(LinkedList::new));
  }

  static boolean groupIsNotFull(final long maxGroupCount, final long currentGroupCount) {
    return maxGroupCount != currentGroupCount;
  }

  static boolean canAddClanToGroup(final long maxGroupCount, final long numberOfPlayers, final long currentGroupCount) {
    return maxGroupCount >= numberOfPlayers + currentGroupCount;
  }

  static void addClanToGroup(final List<OnlineGameOutputDTO> clansGroup, final long numberOfPlayers, final long points) {
    clansGroup.add(new OnlineGameOutputDTO(numberOfPlayers, points));
  }

}
