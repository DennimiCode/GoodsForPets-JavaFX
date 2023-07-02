package com.goodsforpets;

import java.time.LocalTime;
import org.junit.jupiter.api.Assertions;

class CalculationsTests {

  @org.junit.jupiter.api.Test
  void testAvailablePeriodsMethod1() {
    // Arrange
    var calculations = new Calculations();
    LocalTime[] startTimes = {
        LocalTime.of(10, 0, 0),
        LocalTime.of(11, 0, 0),
        LocalTime.of(15, 0, 0),
        LocalTime.of(15, 30, 0),
        LocalTime.of(16, 50, 0),
    };
    LocalTime beginWorkingTime = LocalTime.of(8, 0, 0);
    LocalTime endWorkingTime = LocalTime.of(18, 0, 0);
    int[] durations = {60, 30, 10, 10, 40,};
    int consultationTime = 30;
    String[] expected = {
        "08:00-08:30", "08:30-09:00",
        "09:00-09:30", "09:30-10:00",
        "11:30-12:00", "12:00-12:30",
        "12:30-13:00", "13:00-13:30",
        "13:30-14:00", "14:00-14:30",
        "14:30-15:00", "15:40-16:10",
        "16:10-16:40", "17:30-18:00",
    };
    // Act
    String[] result = calculations.availablePeriods(startTimes, durations, beginWorkingTime, endWorkingTime,
        consultationTime);
    // Assert
    Assertions.assertArrayEquals(expected, result);
  }

  @org.junit.jupiter.api.Test
  void testAvailablePeriodsMethod2() {
    // Arrange
    var calculations = new Calculations();
    LocalTime[] startTimes = {
        LocalTime.of(10, 0, 0),
        LocalTime.of(11, 0, 0),
        LocalTime.of(15, 0, 0),
        LocalTime.of(15, 30, 0),
        LocalTime.of(16, 50, 0),
    };
    LocalTime beginWorkingTime = LocalTime.of(8, 0, 0);
    LocalTime endWorkingTime = LocalTime.of(18, 0, 0);
    int[] durations = {60,};
    int consultationTime = 30;
    // Act
    // Assert
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
        () -> calculations.availablePeriods(startTimes, durations, beginWorkingTime, endWorkingTime,
            consultationTime));
  }

  @org.junit.jupiter.api.Test
  void testAvailablePeriodsMethod3() {
    // Arrange
    var calculations = new Calculations();
    LocalTime[] startTimes = {
        LocalTime.of(10, 0, 0),
        LocalTime.of(11, 0, 0),
        LocalTime.of(15, 0, 0),
        LocalTime.of(15, 30, 0),
        LocalTime.of(16, 50, 0),
    };
    LocalTime beginWorkingTime = LocalTime.of(8, 0, 0);
    LocalTime endWorkingTime = LocalTime.of(18, 0, 0);
    int[] durations = {60, 50,};
    int consultationTime = -30;
    // Act
    // Assert
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> calculations.availablePeriods(startTimes, durations, beginWorkingTime, endWorkingTime,
            consultationTime));
  }

  @org.junit.jupiter.api.Test
  void testAvailablePeriodsMethod4() {
    // Arrange
    var calculations = new Calculations();
    LocalTime[] startTimes = {};
    LocalTime beginWorkingTime = LocalTime.of(8, 0, 0);
    LocalTime endWorkingTime = LocalTime.of(18, 0, 0);
    int[] durations = {60, 30, 10, 10, 40,};
    int consultationTime = 30;
    // Act
    // Assert
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> calculations.availablePeriods(startTimes, durations, beginWorkingTime, endWorkingTime,
            consultationTime));
  }

  @org.junit.jupiter.api.Test
  void testAvailablePeriodsMethod5() {
    // Arrange
    var calculations = new Calculations();
    LocalTime[] startTimes = {
        LocalTime.of(10, 0, 0),
        LocalTime.of(11, 0, 0),
        LocalTime.of(15, 0, 0),
        LocalTime.of(15, 30, 0),
        LocalTime.of(16, 50, 0),
    };
    LocalTime beginWorkingTime = LocalTime.of(8, 0, 0);
    LocalTime endWorkingTime = LocalTime.of(18, 0, 0);
    int[] durations = {};
    int consultationTime = 30;
    // Act
    // Assert
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> calculations.availablePeriods(startTimes, durations, beginWorkingTime, endWorkingTime,
            consultationTime));
  }

  @org.junit.jupiter.api.Test
  void testAvailablePeriodsMethod6() {
    // Arrange
    var calculations = new Calculations();
    LocalTime[] startTimes = {
        LocalTime.of(10, 0, 0),
        LocalTime.of(11, 0, 0),
        LocalTime.of(15, 0, 0),
        LocalTime.of(15, 30, 0),
        LocalTime.of(16, 50, 0),
    };
    LocalTime beginWorkingTime = LocalTime.of(8, 0, 0);
    LocalTime endWorkingTime = LocalTime.of(18, 0, 0);
    int[] durations = {-60,};
    int consultationTime = 30;
    // Act
    // Assert
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
        () -> calculations.availablePeriods(startTimes, durations, beginWorkingTime, endWorkingTime,
            consultationTime));
  }

  @org.junit.jupiter.api.Test
  void testAvailablePeriodsMethod7() {
    // Arrange
    var calculations = new Calculations();
    LocalTime[] startTimes = {
        LocalTime.of(10, 0, 0),
        LocalTime.of(11, 0, 0),
        LocalTime.of(15, 0, 0),
        LocalTime.of(15, 30, 0),
        LocalTime.of(16, 50, 0),
    };
    LocalTime beginWorkingTime = LocalTime.of(8, 0, 0);
    LocalTime endWorkingTime = null;
    int[] durations = {60, 30, 10, 10, 40,};
    int consultationTime = 30;
    // Act
    // Assert
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> calculations.availablePeriods(startTimes, durations, beginWorkingTime, endWorkingTime,
            consultationTime));
  }

  @org.junit.jupiter.api.Test
  void testAvailablePeriodsMethod8() {
    // Arrange
    var calculations = new Calculations();
    LocalTime[] startTimes = {
        LocalTime.of(10, 0, 0),
        LocalTime.of(11, 0, 0),
        LocalTime.of(15, 0, 0),
        LocalTime.of(15, 30, 0),
        LocalTime.of(16, 50, 0),
    };
    LocalTime beginWorkingTime = null;
    LocalTime endWorkingTime = LocalTime.of(18, 0, 0);
    int[] durations = {60, 30, 10, 10, 40,};
    int consultationTime = 30;
    // Act
    // Assert
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> calculations.availablePeriods(startTimes, durations, beginWorkingTime, endWorkingTime,
            consultationTime));
  }

  @org.junit.jupiter.api.Test
  void testAvailablePeriodsMethod9() {
    // Arrange
    var calculations = new Calculations();
    LocalTime[] startTimes = {
        LocalTime.of(10, 0, 0),
        LocalTime.of(11, 0, 0),
        null,
        LocalTime.of(15, 30, 0),
        LocalTime.of(16, 50, 0),
    };
    LocalTime beginWorkingTime = LocalTime.of(8, 0, 0);
    LocalTime endWorkingTime = LocalTime.of(18, 0, 0);
    int[] durations = {60, 30, 10, 10, 40,};
    int consultationTime = 30;
    // Act
    // Assert
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> calculations.availablePeriods(startTimes, durations, beginWorkingTime, endWorkingTime,
            consultationTime));
  }

  @org.junit.jupiter.api.Test
  void testAvailablePeriodsMethod10() {
    // Arrange
    Calculations calculations = null;
    LocalTime[] startTimes = {
        LocalTime.of(10, 0, 0),
        LocalTime.of(11, 0, 0),
        LocalTime.of(15, 0, 0),
        LocalTime.of(15, 30, 0),
        LocalTime.of(16, 50, 0),
    };
    LocalTime beginWorkingTime = LocalTime.of(8, 0, 0);
    LocalTime endWorkingTime = LocalTime.of(18, 0, 0);
    int[] durations = {60, 30, 10, 10, 40,};
    int consultationTime = 30;
    // Act
    // Assert
    Assertions.assertThrows(NullPointerException.class,
        () -> calculations.availablePeriods(startTimes, durations, beginWorkingTime, endWorkingTime,
            consultationTime));
  }
}