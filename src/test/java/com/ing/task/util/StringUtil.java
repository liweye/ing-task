package com.ing.task.util;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class StringUtil {

  public static String withoutWhitespaces(String text) {
    return isNotBlank(text) ? text.replaceAll("\\s", "") : text;
  }

}
