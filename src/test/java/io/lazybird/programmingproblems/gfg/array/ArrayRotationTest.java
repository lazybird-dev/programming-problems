package io.lazybird.programmingproblems.gfg.array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ArrayRotationTest {

  @ParameterizedTest
  @MethodSource("testCasesForArrayRotation")
  void oneByOne(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(ArrayRotation.oneByOne(actualArray, rotateBy)).containsExactly(
        expectedArray);
  }

  @ParameterizedTest
  @MethodSource("testCasesForArrayRotation")
  void usingTempArray(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(
        ArrayRotation.usingTempArray(actualArray, rotateBy)).containsExactly(
        expectedArray);
  }

  static Stream<Arguments> testCasesForArrayRotation() {

    return Stream.of(arguments(new int[]{}, 1, new int[]{}),
        arguments(new int[]{1, 2}, 0, new int[]{1, 2}),
        arguments(new int[]{1, 2}, 1, new int[]{2, 1}),
        arguments(new int[]{1, 2}, 2, new int[]{1, 2}),
        arguments(new int[]{1, 2}, 3, new int[]{2, 1}),
        arguments(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 13,
            new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3})
    );

  }


  @ParameterizedTest
  @MethodSource("testCasesForArrayRotation")
  void byJugglingMethod(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(
        ArrayRotation.byJugglingMethod(actualArray, rotateBy)).containsExactly(
        expectedArray);
  }

  @ParameterizedTest
  @MethodSource("testCasesForArrayRotation")
  void usingReversalAlgorithm(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(
        ArrayRotation.usingReversalAlgorithm(actualArray,
            rotateBy)).containsExactly(
        expectedArray);
  }

  @ParameterizedTest
  @MethodSource("testCasesForArrayRotation")
  void blockSwapAlgorithm(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(
        ArrayRotation.blockSwapAlgorithm(actualArray,
            rotateBy)).containsExactly(
        expectedArray);
  }

  @ParameterizedTest
  @MethodSource("searchElementInRotatedSortedArray")
  void testSearchElementInRotatedSortedArray(int[] array, int element,
      int elementIndex) {
    assertThat(ArrayRotation.searchElementInRotatedSortedArray(array,
        element)).isEqualTo(elementIndex);
  }

  static Stream<Arguments> searchElementInRotatedSortedArray() {

    return Stream.of(arguments(new int[]{1, 2, 3, 4, 5}, 1, 0),
        arguments(new int[]{1, 2, 3, 4, 5}, 3, 2),
        arguments(new int[]{1, 2, 3, 4, 5}, 0, -1),
        arguments(new int[]{3, 4, 5, 1, 2}, 1, 3),
        arguments(new int[]{3, 4, 5, 1, 2}, 4, 1),
        arguments(new int[]{3, 4, 5, 1, 2}, 5, 2),
        arguments(new int[]{3, 4, 5, 1, 2}, 6, -1)
    );

  }
}