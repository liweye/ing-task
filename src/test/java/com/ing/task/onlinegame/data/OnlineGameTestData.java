package com.ing.task.onlinegame.data;

import static com.ing.task.util.StringUtil.withoutWhitespaces;

public final class OnlineGameTestData {

  public final static String ONLINE_GAME_EXAMPLE_REQUEST_DATA = withoutWhitespaces("""
       {
         "groupCount": 6,
         "clans": [
           {
             "numberOfPlayers": 4,
             "points": 50
           },
           {
             "numberOfPlayers": 2,
             "points": 70
           },
           {
             "numberOfPlayers": 6,
             "points": 60
           },
           {
             "numberOfPlayers": 1,
             "points": 15
           },
           {
             "numberOfPlayers": 5,
             "points": 40
           },
           {
             "numberOfPlayers": 3,
             "points": 45
           },
           {
             "numberOfPlayers": 1,
             "points": 12
           },
           {
             "numberOfPlayers": 4,
             "points": 40
           }
         ]
       }
      """);

  public final static String ONLINE_GAME_EXAMPLE_RESPONSE_DATA = withoutWhitespaces("""
       [
         [
           {
             "numberOfPlayers": 2,
             "points": 70
           },
           {
             "numberOfPlayers": 4,
             "points": 50
           }
         ],
         [
           {
             "numberOfPlayers": 6,
             "points": 60
           }
         ],
         [
           {
             "numberOfPlayers": 3,
             "points": 45
           },
           {
             "numberOfPlayers": 1,
             "points": 15
           },
           {
             "numberOfPlayers": 1,
             "points": 12
           }
         ],
         [
           {
             "numberOfPlayers": 4,
             "points": 40
           }
         ],
         [
           {
             "numberOfPlayers": 5,
             "points": 40
           }
         ]
       ]
      """);
}
