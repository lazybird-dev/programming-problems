package io.lazybird.programmingproblems.commons.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MathUtilsTest {

  @ParameterizedTest
  @MethodSource("gcdTestCases")
  void gcd(int x, int y, int gcd) {
    assertEquals(MathUtils.gcd(x, y), gcd);
  }

  static Stream<Arguments> gcdTestCases() {
    return Stream.of(arguments(2, 4, 2),
        arguments(1, 3, 1),
        arguments(10, 5, 5),
        arguments(10, 4, 2)
    );
  }
}