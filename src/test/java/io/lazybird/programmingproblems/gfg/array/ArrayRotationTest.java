package io.lazybird.programmingproblems.gfg.array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.Arrays;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ArrayRotationTest {

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#testCasesForArrayRotation")
  void oneByOne(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(ArrayRotation.oneByOne(actualArray, rotateBy)).containsExactly(
        expectedArray);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#testCasesForArrayRotation")
  void usingTempArray(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(
        ArrayRotation.usingTempArray(actualArray, rotateBy)).containsExactly(
        expectedArray);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#testCasesForArrayRotation")
  void byJugglingMethod(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(
        ArrayRotation.byJugglingMethod(actualArray, rotateBy)).containsExactly(
        expectedArray);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#testCasesForArrayRotation")
  void usingReversalAlgorithm(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(
        ArrayRotation.usingReversalAlgorithm(actualArray,
            rotateBy)).containsExactly(
        expectedArray);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#testCasesForArrayRotation")
  void blockSwapAlgorithm(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(
        ArrayRotation.blockSwapAlgorithm(actualArray,
            rotateBy)).containsExactly(
        expectedArray);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#searchElementInRotatedSortedArray")
  void searchElementInRotatedSortedArray(int[] array, int element,
      int elementIndex) {
    assertThat(ArrayRotation.searchElementInRotatedSortedArray(array,
        element)).isEqualTo(elementIndex);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#maxOfPositionalSum")
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

      ArrayRotation.byJugglingMethod(tempArray, 1);
    }

    assertThat(ArrayRotation.maxOfPositionalSum(array)).isEqualTo(maxSum);

  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#rotationCountInRotatedSortedArray")
  void rotationCountInRotatedSortedArray(int[] array, int rotationCount) {
    assertThat(
        ArrayRotation.rotationCountInRotatedSortedArray(array)).isEqualTo(
        rotationCount);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#testCasesForArrayRotation")
  void findMultipleLeftRotationOfArray(int[] actualArray, int rotateBy,
      int[] expectedArray) {
    assertThat(ArrayRotation.findMultipleLeftRotationOfArray(actualArray,
        rotateBy)).containsExactly(
        expectedArray);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#rotationCountInRotatedSortedArray")
  void minimumInRotatedSortedArray(int[] array, int pivotalIndex) {
    assertThat(ArrayRotation.minimumInRotatedSortedArray(array)).isEqualTo(
        array[pivotalIndex]);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#rotationWithMaximumHammingDistance")
  void rotationWithMaximumHammingDistance1(int[] array,
      int actualHammingDistance) {
    assertThat(
        ArrayRotation.rotationWithMaximumHammingDistance1(array)).isEqualTo(
        actualHammingDistance);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#queriesOnArray")
  void queriesOnArray(int[] array, int[][] queries, int expectedSum) {
    assertThat(ArrayRotation.queriesOnArray(array, queries)).isEqualTo(
        expectedSum);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#splitFirstPartAndAddItToBack")
  void splitFirstPartAndAddItToBack(int[] array, int splitBy,
      int[] expectedArray) {
    assertThat(ArrayRotation.splitFirstPartAndAddItToBack(array,
        splitBy)).containsExactly(expectedArray);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#reArrangeArray")
  void reArrangeArray(int[] actualArray, int[] expectedArray) {
    ArrayRotation.reArrangeArray(actualArray);
    assertThat(actualArray).containsExactly(
        expectedArray);
  }

  @Disabled("Error")
  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#rotationRequiredToSortArray")
  void rotationRequiredToSortArray(int[] array, int rotationRequired) {
    assertThat(ArrayRotation.rotationRequiredToSortArray(array)).isEqualTo(
        rotationRequired);
  }

  @Disabled("Failed Case")
  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#isMatrixRotationOfAnother")
  void isMatrixRotationOfAnother(int[][] actualMatrix, int[][] rotatedMatrix,
      boolean isRotated) {
    assertThat(ArrayRotation.isMatrixRotationOfAnother(actualMatrix,
        rotatedMatrix)).isEqualTo(isRotated);
  }

  @Disabled("Failed Cases")
  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#rotateMatrixClockwiseBy90")
  void rotateMatrixClockwiseBy90(int[][] actualMatrix, int[][] rotatedMatrix) {
    ArrayRotation.rotateMatrixClockwiseBy90(actualMatrix);
    assertThat(actualMatrix).isDeepEqualTo(rotatedMatrix);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#testRotateMatrixClockwiseBy90")
  void testRotateMatrixClockwiseBy90(int[][] actualArray,
      int[][] rotatedArray) {
    assertThat(
        ArrayRotation.rotateMatrixClockwiseBy90(actualArray)).isDeepEqualTo(
        rotatedArray);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#maximumConsecutiveZerosAtStartOrEnd")
  void maximumConsecutiveZerosAtStartOrEnd(String binaryString,
      int noOfConsecutiveZeros) {
    assertThat(ArrayRotation.maximumConsecutiveZerosAtStartOrEnd(
        binaryString)).isEqualTo(noOfConsecutiveZeros);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#rotateMatrixRows")
  void rotateMatrixRows(int[][] actualMatrix, int[][] expectedMatrix) {
    ArrayRotation.rotateMatrixRows(actualMatrix);
    assertThat(actualMatrix).isDeepEqualTo(
        expectedMatrix);
  }

  @Disabled("Failed Cases")
  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#stringShift")
  void stringShift(String actualString, int[][] operationMatrix,
      String expectedString) {
    assertThat(
        ArrayRotation.stringShift(actualString, operationMatrix)).isEqualTo(
        expectedString);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#lexicographicMinimumOfStringRotation")
  void lexicographicMinimumOfStringRotation(String actualString,
      String expectedString) {
    assertThat(ArrayRotation.lexicographicMinimumOfStringRotation(
        actualString)).isEqualTo(expectedString);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#leftRotateBitOfNumber")
  void leftRotateBitOfNumber(int actualNumber, int rotateBy,
      int expectedNumber) {
    assertThat(
        ArrayRotation.leftRotateBitOfNumber(actualNumber, rotateBy)).isEqualTo(
        expectedNumber);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#rightRotateBitOfNumber")
  void rightRotateBitOfNumber(int actualNumber, int rotateBy,
      int expectedNumber) {
    assertThat(
        ArrayRotation.rightRotateBitOfNumber(actualNumber, rotateBy)).isEqualTo(
        expectedNumber);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#isStringRotationOfAnother")
  void isStringRotationOfAnother(String actualString, String rotateString,
      boolean isRotated) {
    assertThat(ArrayRotation.isStringRotationOfAnother(actualString,
        rotateString)).isEqualTo(isRotated);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#rotateAnImageBy90Degree")
  void rotateAnImageBy90Degree(String[][] originalImage,
      String[][] rotatedImage) {
    assertThat(
        ArrayRotation.rotateAnImageBy90Degree(originalImage)).isDeepEqualTo(
        rotatedImage);
  }

  @Disabled("Question not clear.")
  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#isBitRotationOfOther")
  void isBitRotationOfOther(long actualNumber, long rotatedNumber,
      boolean isRotated) {
    assertThat(ArrayRotation.isBitRotationOfOther(actualNumber,
        rotatedNumber)).isEqualTo(isRotated);
  }

  @Disabled("Junit output stream read")
  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#leftRotateRightRotateString")
  void leftRotateRightRotateString(String str, int rotateBy,
      String[] expectedOutput) {
    assertThat(ArrayRotation.leftRotateRightRotateString(str,
        rotateBy)).containsExactly(expectedOutput);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#numberOfRotationDivisibleBy4")
  void numberOfRotationDivisibleBy4(String str, int divisibilityCount) {
    assertThat(ArrayRotation.numberOfRotationDivisibleBy4(str)).isEqualTo(
        divisibilityCount);
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#rotateMatrixInPlace")
  void rotateMatrixInPlace1(int[][] actualMatrix,
      int[][] expectedMatrix) {
    ArrayRotation.rotateMatrixInPlace1(actualMatrix);
    assertThat(actualMatrix).isDeepEqualTo(expectedMatrix);
  }

  @Disabled("Not implemented")
  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#rotationWithMaximumHammingDistance")
  void rotationWithMaximumHammingDistance2(int[] array,
      int actualHammingDistance) {
    fail("Note Implemented");
  }

  @Disabled("Not Implemented")
  @Test
  void reduceArrayByRotation() {
    assertThat(ArrayRotation.reduceArrayByRotation(new int[]{},
        new int[]{})).isEqualTo(-1);
    fail("Not Implemented");
  }

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.ArrayRotationTestCases#numberOfRotationDivisibleBy8")
  void numberOfRotationDivisibleBy8(String str, int divisibilityCount) {
    assertThat(ArrayRotation.numberOfRotationDivisibleBy8(str)).isEqualTo(
        divisibilityCount);
  }
}