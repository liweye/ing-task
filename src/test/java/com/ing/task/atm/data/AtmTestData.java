package com.ing.task.atm.data;

import static com.ing.task.util.StringUtil.withoutWhitespaces;

public final class AtmTestData {

  public final static String ATM_EXAMPLE_1_REQUEST_DATA = withoutWhitespaces("""
      [
        {
          "region": 4,
          "requestType": "STANDARD",
          "atmId": 1
        },
        {
          "region": 1,
          "requestType": "STANDARD",
          "atmId": 1
        },
        {
          "region": 2,
          "requestType": "STANDARD",
          "atmId": 1
        },
        {
          "region": 3,
          "requestType": "PRIORITY",
          "atmId": 2
        },
        {
          "region": 3,
          "requestType": "STANDARD",
          "atmId": 1
        },
        {
          "region": 2,
          "requestType": "SIGNAL_LOW",
          "atmId": 1
        },
        {
          "region": 5,
          "requestType": "STANDARD",
          "atmId": 2
        },
        {
          "region": 5,
          "requestType": "FAILURE_RESTART",
          "atmId": 1
        }
      ]
      """);

  public final static String ATM_EXAMPLE_1_RESPONSE_DATA = withoutWhitespaces("""
      [
        {
          "region": 1,
          "atmId": 1
        },
        {
          "region": 2,
          "atmId": 1
        },
        {
          "region": 3,
          "atmId": 2
        },
        {
          "region": 3,
          "atmId": 1
        },
        {
          "region": 4,
          "atmId": 1
        },
        {
          "region": 5,
          "atmId": 1
        },
        {
          "region": 5,
          "atmId": 2
        }
      ]
      """);

  public final static String ATM_EXAMPLE_2_REQUEST_DATA = withoutWhitespaces("""
      [
        {
          "region": 1,
          "requestType": "STANDARD",
          "atmId": 2
        },
        {
          "region": 1,
          "requestType": "STANDARD",
          "atmId": 1
        },
        {
          "region": 2,
          "requestType": "PRIORITY",
          "atmId": 3
        },
        {
          "region": 3,
          "requestType": "STANDARD",
          "atmId": 4
        },
        {
          "region": 4,
          "requestType": "STANDARD",
          "atmId": 5
        },
        {
          "region": 5,
          "requestType": "PRIORITY",
          "atmId": 2
        },
        {
          "region": 5,
          "requestType": "STANDARD",
          "atmId": 1
        },
        {
          "region": 3,
          "requestType": "SIGNAL_LOW",
          "atmId": 2
        },
        {
          "region": 2,
          "requestType": "SIGNAL_LOW",
          "atmId": 1
        },
        {
          "region": 3,
          "requestType": "FAILURE_RESTART",
          "atmId": 1
        }
      ]
      """);

  public final static String ATM_EXAMPLE_2_RESPONSE_DATA = withoutWhitespaces("""
      [
        {
          "region": 1,
          "atmId": 2
        },
        {
          "region": 1,
          "atmId": 1
        },
        {
          "region": 2,
          "atmId": 3
        },
        {
          "region": 2,
          "atmId": 1
        },
        {
          "region": 3,
          "atmId": 1
        },
        {
          "region": 3,
          "atmId": 2
        },
        {
          "region": 3,
          "atmId": 4
        },
        {
          "region": 4,
          "atmId": 5
        },
        {
          "region": 5,
          "atmId": 2
        },
        {
          "region": 5,
          "atmId": 1
        }
      ]
      """);
}
