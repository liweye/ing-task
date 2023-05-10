package com.ing.task.transactions.data;

import static com.ing.task.util.StringUtil.withoutWhitespaces;

public class TransactionTestData {

  public final static String TRANSACTION_EXAMPLE_REQUEST_DATA = withoutWhitespaces("""
      [
        {
          "debitAccount": "32309111922661937852684864",
          "creditAccount": "06105023389842834748547303",
          "amount": 10.90
        },
        {
          "debitAccount": "31074318698137062235845814",
          "creditAccount": "66105036543749403346524547",
          "amount": 200.90
        },
        {
          "debitAccount": "66105036543749403346524547",
          "creditAccount": "32309111922661937852684864",
          "amount": 50.10
        }
      ]
      """);

  public final static String TRANSACTION_EXAMPLE_RESPONSE_DATA = withoutWhitespaces("""
      [
        {
          "account": "06105023389842834748547303",
          "debitCount": 0,
          "creditCount": 1,
          "balance": 10.9
        },
        {
          "account": "31074318698137062235845814",
          "debitCount": 1,
          "creditCount": 0,
          "balance": -200.9
        },
        {
          "account": "32309111922661937852684864",
          "debitCount": 1,
          "creditCount": 1,
          "balance": 39.2
        },
        {
          "account": "66105036543749403346524547",
          "debitCount": 1,
          "creditCount": 1,
          "balance": 150.8
        }
      ]
      """);
}
