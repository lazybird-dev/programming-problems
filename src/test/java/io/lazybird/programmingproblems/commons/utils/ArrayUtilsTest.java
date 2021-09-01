package io.lazybird.programmingproblems.commons.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ArrayUtilsTest {

  static Stream<Arguments> testCases_reverseArray() {

    return Stream.of(
        arguments(new int[]{1, 2, 3}, 0, 2, new int[]{3, 2, 1}),
        arguments(new int[]{1, 2}, 0, 0, new int[]{1, 2}),
        arguments(new int[]{1, 2, 3, 4, 5}, 1, 2, new int[]{1, 3, 2, 4, 5}),
        arguments(new int[]{1}, 0, 0, new int[]{1}),
        arguments(new int[]{}, 1, 2, new int[]{})
    );

  }

  static Stream<Arguments> failedTestCases_reverseArray() {

    return Stream.of(
        arguments(new int[]{1, 2, 3}, -1, 2, IllegalArgumentException.class),
        arguments(new int[]{1, 2}, 1, 0, IllegalArgumentException.class),
        arguments(new int[]{1, 2, 3, 4, 5}, 1, 6,
            IllegalArgumentException.class)
    );

  }

  @ParameterizedTest
  @MethodSource("testCases_reverseArray")
  void reverseArray(int[] array, int startIndex, int endIndex,
      int[] expectedArray) {
    ArrayUtils.reverseArray(array, startIndex, endIndex);
    assertThat(array).containsExactly(expectedArray);
  }

  @ParameterizedTest
  @MethodSource("failedTestCases_reverseArray")
  void failedCases_reverseArray(int[] array, int startIndex, int endIndex,
      Class<RuntimeException> exceptionClass) {
    Exception e = catchThrowableOfType(
        () -> ArrayUtils.reverseArray(array, startIndex, endIndex),
        exceptionClass);

    assertThat(e).hasMessageContaining(
        String.format("Invalid start & end index %d, %d", startIndex,
            endIndex));
  }

}