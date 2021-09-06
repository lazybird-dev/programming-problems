package io.lazybird.programmingproblems.gfg.array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
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

  static Stream<Arguments> maxOfPositionalSum() {

    return Stream.of(arguments(new int[]{1, 2, 3, 4, 5}),
        arguments(new int[]{1, 2, -3, -4, -5}),
        arguments(new int[]{-1, 2, -3, 4, 10}),
        arguments(new int[]{-3, 4, 15, 1, -2}),
        arguments(new int[]{3, -4, 5, -1, 2}),
        arguments(new int[]{3, 14, 5, 21, 2}),
        arguments(new int[]{3, -4, 25, 1, 2})
    );

  }

  @ParameterizedTest
  @MethodSource("maxOfPositionalSum")
  void maxOfPositionalSum(int[] array) {

    int[] tempArray = Arrays.copyOf(array, array.length);
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < tempArray.length; i++) {

      int currentSum = 0;
      for (int j = 0; j < tempArray.length; j++) {
        currentSum += j * tempArray[j];
      }
      if (currentSum > maxSum) {
        maxSum = currentSum;
      }

      tempArray = ArrayRotation.byJugglingMethod(tempArray, 1);
    }

    assertThat(ArrayRotation.maxOfPositionalSum(array)).isEqualTo(maxSum);

  }

  static Stream<Arguments> rotationCountInRotatedSortedArray() {

    return Stream.of(arguments(new int[]{1, 2, 3, 4, 5}, 0),
        arguments(new int[]{2, 3, 4, 5, 1}, 4),
        arguments(new int[]{3, 4, 5, 1, 2}, 3),
        arguments(new int[]{4, 5, 1, 2, 3}, 2),
        arguments(new int[]{1, 2}, 0),
        arguments(new int[]{2, 1}, 1),
        arguments(new int[]{1}, 0)
    );

  }

  @ParameterizedTest
  @MethodSource("rotationCountInRotatedSortedArray")
  void rotationCountInRotatedSortedArray(int[] array, int rotationCount) {
    assertThat(
        ArrayRotation.rotationCountInRotatedSortedArray(array)).isEqualTo(
        rotationCount);
  }

  @ParameterizedTest
  @MethodSource("testCasesForArrayRotation")
  void findMultipleLeftRotationOfArray(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(ArrayRotation.findMultipleLeftRotationOfArray(actualArray,
        rotateBy)).containsExactly(
        expectedArray);
  }

  @ParameterizedTest
  @MethodSource("rotationCountInRotatedSortedArray")
  void minimumInRotatedSortedArray(int[] array, int pivotalIndex) {
    assertThat(ArrayRotation.minimumInRotatedSortedArray(array)).isEqualTo(
        array[pivotalIndex]);
  }

  static Stream<Arguments> rotationWithMaximumHammingDistance() {

    return Stream.of(arguments(new int[]{1, 2, 3, 4, 5}, 5),
        arguments(new int[]{1, 2, 3, 5, 1}, 5),
        arguments(new int[]{1, 1, 1, 1, 1, 1}, 0),
        arguments(new int[]{1, 2, 1}, 2),
        arguments(new int[]{1, 2, 1, 2}, 4),
        arguments(new int[]{3, 0, 6, 4, 3}, 5)
    );

  }

  @ParameterizedTest
  @MethodSource("rotationWithMaximumHammingDistance")
  void rotationWithMaximumHammingDistance(int[] array,
      int actualHammingDistance) {
    assertThat(
        ArrayRotation.rotationWithMaximumHammingDistance1(array)).isEqualTo(
        actualHammingDistance);
  }

  static Stream<Arguments> queriesOnArray() {

    return Stream.of(
        arguments(new int[]{1, 2, 3, 4, 5},
            new int[][]{{1, 3}, {2, 3}, {3, 0, 4}}, 15),
        arguments(new int[]{1, 2, 3, 4, 5},
            new int[][]{{1, 3}, {1, 1}, {3, 0, 1}}, 5),
        arguments(new int[]{1, 2, 3, 4, 5},
            new int[][]{{2, 3}, {1, 1}, {3, 0, 3}}, 13)
    );

  }

  @ParameterizedTest
  @MethodSource("queriesOnArray")
  void queriesOnArray(int[] array, int[][] queries, int expectedSum) {
    assertThat(ArrayRotation.queriesOnArray(array, queries)).isEqualTo(
        expectedSum);
  }

  static Stream<Arguments> splitFirstPartAndAddItToBack() {

    return Stream.of(
        arguments(new int[]{1, 2}, 0, new int[]{1, 2}),
        arguments(new int[]{1, 2}, 1, new int[]{2, 1}),
        arguments(new int[]{1, 2}, 2, new int[]{1, 2}),
        arguments(new int[]{1, 2, 3, 4, 5}, 3, new int[]{4, 5, 1, 2, 3}),
        arguments(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3,
            new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3})
    );

  }

  @ParameterizedTest
  @MethodSource("splitFirstPartAndAddItToBack")
  void splitFirstPartAndAddItToBack(int[] array, int splitBy,
      int[] expectedArray) {
    assertThat(ArrayRotation.splitFirstPartAndAddItToBack(array,
        splitBy)).containsExactly(expectedArray);
  }

  static Stream<Arguments> reArrangeArray() {
    return Stream.of(
        arguments(new int[]{0, 1}, new int[]{0, 1}),
        arguments(new int[]{0, 1, 4, 3, 2}, new int[]{0, 1, 2, 3, 4}),
        arguments(new int[]{-1, -1, 4, 3, 2}, new int[]{-1, -1, 2, 3, 4}),
        arguments(new int[]{-1, 0}, new int[]{0, -1}),
        arguments(new int[]{0}, new int[]{0}),
        arguments(new int[]{-1}, new int[]{-1}),
        arguments(new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1},
            new int[]{-1, 1, 2, 3, 4, -1, 6, -1, -1, 9}),
        arguments(
            new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2,
                14, 17, 4},
            new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19})
    );
  }

  @ParameterizedTest
  @MethodSource("reArrangeArray")
  void reArrangeArray(int[] actualArray, int[] expectedArray) {
    ArrayRotation.reArrangeArray(actualArray);
    assertThat(actualArray).containsExactly(
        expectedArray);
  }

  static Stream<Arguments> rotationRequiredToSortArray() {
    return Stream.of(
        arguments(new int[]{1, 2, 3, 4, 5}, 4),
        arguments(new int[]{1}, 0),
        arguments(new int[]{2, 1}, 0),
        arguments(new int[]{2, 1, 3}, 2),
        arguments(new int[]{1, 2, 2}, 2),
        arguments(new int[]{3, 1, 2, 4, 5}, -1),
        arguments(new int[]{2, 1, 5, 4, 3}, 2)
    );
  }

  @ParameterizedTest
  @MethodSource("rotationRequiredToSortArray")
  void rotationRequiredToSortArray(int[] array, int rotationRequired) {
    assertThat(ArrayRotation.rotationRequiredToSortArray(array)).isEqualTo(
        rotationRequired);
  }


  static Stream<Arguments> isMatrixRotationOfAnother() {

    return Stream.of(
        Arguments.arguments(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, true),
        Arguments.arguments(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{1, 4, 7}, {8, 5, 2}, {9, 6, 3}}, false));
  }


  @ParameterizedTest
  @MethodSource("isMatrixRotationOfAnother")
  void isMatrixRotationOfAnother(int[][] actualMatrix, int[][] rotatedMatrix,
      boolean isRotated) {
    assertThat(ArrayRotation.isMatrixRotationOfAnother(actualMatrix,
        rotatedMatrix)).isEqualTo(isRotated);
  }
}