package com.goodsforpets;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Calculations {

  public String[] availablePeriods(LocalTime[] startTimes, int[] durations, LocalTime beginWorkingTime,
      LocalTime endWorkingTime, int consultationTime) {
    if (startTimes == null || startTimes.length == 0) {
      throw new IllegalArgumentException("startTimes is null or empty");
    }
    if (durations == null || durations.length == 0) {
      throw new IllegalArgumentException("durations is null or empty");
    }
    if (beginWorkingTime == null) {
      throw new IllegalArgumentException("beginWorkingTime");
    }
    if (endWorkingTime == null) {
      throw new IllegalArgumentException("endWorkingTime is null");
    }
    if (consultationTime <= 0) {
      throw new IllegalArgumentException(
          String.format("consultationTime must be > 0, but: %d", consultationTime));
    }
    if (Arrays.stream(startTimes).anyMatch(Objects::isNull)) {
      throw new IllegalArgumentException("startTimes can't contain the null value");
    }
    int iterationCount =
        ((int) (beginWorkingTime.until(endWorkingTime, ChronoUnit.MINUTES) / consultationTime)) * 2;
    String[] tempIntervals = new String[iterationCount];
    ArrayList<String> result = new ArrayList<>();
    LocalTime currentInterval = beginWorkingTime;
    for (int i = 0, j = 0; i < iterationCount && currentInterval.isBefore(endWorkingTime); i++) {
      var stringBuilder = new StringBuilder(currentInterval.toString());
      if (currentInterval == startTimes[j]) {
        currentInterval = currentInterval.plusMinutes(durations[j]);
        if (j != startTimes.length - 1) {
          j++;
        }
        continue;
      } else if (currentInterval.plusMinutes(consultationTime).isAfter(startTimes[j])
          && currentInterval.until(endWorkingTime, ChronoUnit.MINUTES) > consultationTime) {
        currentInterval = startTimes[j];
        continue;
      }
      currentInterval = currentInterval.plusMinutes(consultationTime);
      stringBuilder.append('-');
      stringBuilder.append(currentInterval.toString());
      tempIntervals[i] = stringBuilder.toString();
    }

    for (var timeInterval : tempIntervals) {
      if (timeInterval != null) {
        result.add(timeInterval);
      }
    }

    String[] finalResult = new String[result.size()];
    finalResult = result.toArray(finalResult);

    return finalResult;
  }
}
