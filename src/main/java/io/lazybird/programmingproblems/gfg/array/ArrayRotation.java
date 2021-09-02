package io.lazybird.programmingproblems.gfg.array;

import static io.lazybird.programmingproblems.commons.annotations.DifficultyLevel.BEGINNER;

import io.lazybird.programmingproblems.commons.annotations.ProgrammingProblem;
import io.lazybird.programmingproblems.commons.utils.ArrayUtils;
import io.lazybird.programmingproblems.commons.utils.MathUtils;
import java.util.Arrays;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Problems on array rotation.
 */
public class ArrayRotation {

  private ArrayRotation() {
  }

  private static final Logger _LOGGER = LoggerFactory.getLogger(
      ArrayRotation.class);

  /**
   * Rotates an array counter-clockwise by rotateBy number of positions.
   * <p>
   * Algorithm Analysis:
   * <span>Space: O(1) </span>
   * <span>Time: O(n<sup>2</sup>) </span>
   * </p>
   *
   * @param array    to be rotated.
   * @param rotateBy no of elements to be rotated
   * @return rotated array
   */
  @SuppressWarnings("ManualArrayCopy")
  @ProgrammingProblem(title = "Array Rotation", sources = {
      "https://www.geeksforgeeks.org/array-rotation/",
      "https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/"},
      tags = {"array", "rotation"}, difficultyLevel = BEGINNER)
  public static int[] oneByOne(@NotNull int[] array, int rotateBy) {

    _LOGGER.atDebug().log("Input: array={}, rotateBy={}",
        Arrays.toString(array), rotateBy);

    if (array.length <= 1 || (rotateBy = rotateBy % array.length) == 0) {
      return array;
    }

    int temp;
    while (rotateBy > 0) {
      temp = array[0];
      for (int i = 0; i < array.length - 1; i++) {
        array[i] = array[i + 1];
      }
      array[array.length - 1] = temp;

      rotateBy--;
    }
    return array;
  }

  /**
   * Rotates an array counter-clockwise using a temporary array by given number
   * of positions.
   * <p>
   * Algorithm Analysis:
   * <span>Space: O(n) </span>
   * <span>Time: O(n) </span>
   * </p>
   *
   * @param array    to be rotated.
   * @param rotateBy no of elements to be rotated
   * @return rotated array
   */
  public static int[] usingTempArray(@NotNull int[] array, int rotateBy) {

    _LOGGER.atDebug().log("Input: array={}, rotateBy={}",
        Arrays.toString(array), rotateBy);

    if (array.length <= 1 || (rotateBy = rotateBy % array.length) == 0) {
      return array;
    }

    int[] tempArray = new int[rotateBy];

    //Copy the n=rotateBy elements in a temp array
    System.arraycopy(array, 0, tempArray, 0, rotateBy);

    //rotate remaining elements to their final position
    for (int i = 0; i < array.length - rotateBy; i++) {
      array[i] = array[i + rotateBy];
    }

    //Copy back the n=rotateBy elements from temp to original array
    System.arraycopy(tempArray, 0, array, array.length - rotateBy, rotateBy);

    return array;
  }

  /**
   * Rotates an array counter-clockwise using juggling method of positions.
   * <p>
   * Algorithm Analysis:
   * <span>Space: O(1) </span>
   * <span>Time: O(n) </span>
   * </p>
   *
   * @param array    to be rotated.
   * @param rotateBy no of elements to be rotated
   * @return rotated array
   */
  public static int[] byJugglingMethod(@NotNull int[] array, int rotateBy) {

    _LOGGER.atDebug().log("Input: array={}, rotateBy={}",
        Arrays.toString(array), rotateBy);

    if (array.length <= 1 || (rotateBy = rotateBy % array.length) == 0) {
      return array;
    }

    int gcd = MathUtils.gcd(array.length, rotateBy);

    for (int i = 0; i < gcd; i++) {

      int temp = array[i];
      int j = i;
      for (; (j + rotateBy) % array.length != i;
          j = (j + rotateBy) % array.length) {
        array[j] = array[(j + rotateBy) % array.length];
      }
      array[j] = temp;
    }

    return array;
  }

  /**
   * Rotate array using array reversal algorithm.
   *
   * @param array    to be rotated
   * @param rotateBy number of places to be rotated.
   * @return rotated array
   */
  public static int[] usingReversalAlgorithm(@NotNull int[] array,
      int rotateBy) {

    _LOGGER.atDebug().log("Input: array={}, rotateBy={}",
        Arrays.toString(array), rotateBy);

    if (array.length <= 1 || (rotateBy = rotateBy % array.length) == 0) {
      return array;
    }

    ArrayUtils.reverseArray(array, 0, rotateBy - 1);
    ArrayUtils.reverseArray(array, rotateBy, array.length - 1);
    ArrayUtils.reverseArray(array, 0, array.length - 1);

    return array;
  }

  /**
   * Block swap algorithm to rotate array elements.
   *
   * @param array    to be rotated.
   * @param rotateBy number of elements to be rotated.
   * @return rotated array
   */
  public static int[] blockSwapAlgorithm(@NotNull int[] array, int rotateBy) {

    //https://rules.sonarsource.com/java/RSPEC-2629
    if (_LOGGER.isDebugEnabled()) {
      _LOGGER.debug(
          "Inputs: array={}, rotateBy={}", Arrays.toString(array), rotateBy);
    }

    if (array.length <= 1) {
      return array;
    }
    if ((rotateBy = rotateBy % array.length) == 0) {
      return array;
    }

    helperBlockSwapAlgorithm(array, 0, rotateBy - 1, rotateBy,
        array.length - 1);

    return array;
  }

  /**
   * Returns index of the passed element or -1 if element doesn't exist in
   * rotated sorted array.
   *
   * @param array   to be searched.
   * @param element to be searched.
   * @return index of the element or -1 if not found.
   */
  @ProgrammingProblem(title = "Search an element in a sorted and rotated array",
      sources = "https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/",
      difficultyLevel = BEGINNER)
  public static int searchElementInRotatedSortedArray(@NotNull int[] array,
      int element) {

    _LOGGER.atDebug()
        .log("Inputs: array={}, element={}", Arrays.toString(array), element);

    //TODO - Analyze scenarios for duplicate elements
    int s = 0;
    int e = array.length - 1;
    int m;

    while (s < e) {

      m = s + (e - s) / 2;
      _LOGGER.atDebug()
          .log("s={}, e={}, m={}", s, e, m);
      if (array[m] == element) {
        return m;
      }
      if ((array[s] < array[e] || (array[s] <= array[m]))
          && (array[s] <= element && element < array[m])) {
        e = m;
      } else {
        s = m + 1;
      }
    }

    //element not found in the array.
    return -1;
  }

  /**
   * Recursive Helper method implementing block swap algorithm. All indices to
   * the method are inclusive.
   *
   * @param array to be rotated
   * @param s1    starting index of left array
   * @param e1    end index of left array
   * @param s2    starting index of right array
   * @param e2    end index of right array
   */
  private static void helperBlockSwapAlgorithm(@NotNull int[] array, int s1,
      int e1, int s2, int e2) {

    _LOGGER.debug(
        "Calling helperBlockSwapAlgorithm with s1={}, e1={}, s2={}, e2={}", s1,
        e1, s2, e2);

    int leftArrayLength = e1 - s1 + 1;
    int rightArrayLength = e2 - s2 + 1;

    if (leftArrayLength < rightArrayLength) {

      swap(array, s1, e2 - leftArrayLength + 1, leftArrayLength);
      helperBlockSwapAlgorithm(array, s1, s1 + leftArrayLength - 1,
          s1 + leftArrayLength, e2 - leftArrayLength);

    } else if (leftArrayLength > rightArrayLength) {

      swap(array, s1, e2 - rightArrayLength + 1, rightArrayLength);
      helperBlockSwapAlgorithm(array, s1 + rightArrayLength,
          s1 + 2 * rightArrayLength,
          s1 + 2 * rightArrayLength + 1, e2);

    } else {
      swap(array, s1, s2, leftArrayLength);
    }
  }

  /**
   * Swap two array sequence of length l.
   *
   * @param array which element sequences need to be swapped.
   * @param i1    starting index of first sequence.
   * @param i2    starting index of second sequence.
   * @param l     length of the sequence.
   */
  private static void swap(@NotNull int[] array, int i1, int i2, int l) {

    if (_LOGGER.isDebugEnabled()) {
      _LOGGER.debug("Inputs: array={}, i1={}, i2={}, l={}",
          Arrays.toString(array),
          i1, i2, l);
    }

    assert l >= 0 : String.format("Invalid sequence length, l=%d", l);
    assert
        i1 >= 0 && i2 > i1 + l - 1 : String.format(
        "Overlapping sequence i1=%d, i2=%d, l=%d", i1,
        i2, l);
    assert
        i2 + l - 1 < array.length : String.format("invalid sequence, l=%d",
        l);

    int temp;
    int i = 0;

    while (i < l) {
      temp = array[i2 + i];
      array[i2 + i] = array[i1 + i];
      array[i1 + i] = temp;
      i++;
    }

    if (_LOGGER.isDebugEnabled()) {
      _LOGGER.debug("Output array={}", Arrays.toString(array));
    }
  }

  /**
   * Find maximum value of Sum( i*arr[i]) with only rotations on given array
   * allowed.
   *
   * @param array of integers
   * @return maximum value of Sum( i*arr[i]) with only rotations on given array
   *     allowed.
   */
  public static int maxOfPositionalSum(@NotEmpty int[] array) {

    int maxSum = 0;
    int elementSum = 0;

    for (int i = 0; i < array.length; i++) {
      maxSum += i * array[i];
      elementSum += array[i];
    }

    int positionalSum = maxSum;
    for (int j : array) {

      positionalSum =
          positionalSum - elementSum + j + j * (array.length - 1);

      if (positionalSum > maxSum) {
        maxSum = positionalSum;
      }
    }
    return maxSum;
  }

  /**
   * Finds the Rotation Count in clockwise Rotated Sorted array.
   *
   * @param array of integers.
   * @return number of clockwise rotation.
   */
  public static int rotationCountInRotatedSortedArray(@NotEmpty int[] array) {
    if (array.length == 1) {
      return 0;
    }
    int s = 0;
    int e = array.length - 1;
    int m = 0;
    while (s < e) {

      if (array[s] < array[e]) {
        return 0;
      }

      m = s + (e - s) / 2;

      if (array[m] > array[m + 1]) {
        return m + 1;
      }

      if (array[s] < array[m]) {
        s = m;
      } else {
        e = m;
      }
    }
    return m;
  }

  /**
   * Rotate array without creating a new array.
   *
   * @param array    of integers
   * @param rotateBy places by which array to be left rotated.
   * @return rotated array
   */
  public static int[] findMultipleLeftRotationOfArray(@NotNull int[] array,
      int rotateBy) {

    if (array.length <= 1) {
      return array;
    }

    rotateBy = rotateBy % array.length;
    if (rotateBy == 0) {
      return array;
    }

    int[] rotatedArray = new int[array.length];

    for (int i = rotateBy; i < rotateBy + array.length; i++) {
      rotatedArray[i - rotateBy] = array[i % array.length];
    }
    return rotatedArray;
  }

  /**
   * https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/
   * Returns the minimum element of a rotated sorted array. Array must not have
   * duplicate elements.
   *
   * @param array rotated and sorted array without any duplicates
   * @return minimum element of the array
   */
  public static int minimumInRotatedSortedArray(@NotEmpty int[] array) {

    if (array.length == 1) {
      return array[0];
    }

    int s = 0;
    int e = array.length - 1;
    int m = Integer.MIN_VALUE;
    while (s < e) {

      if (array[s] < array[e]) {
        return array[s];
      }

      m = s + (e - s) / 2;

      if (array[m] > array[m + 1]) {
        return array[m + 1];
      }

      if (array[s] < array[m]) {
        s = m;
      } else {
        e = m;
      }
    }
    return m;
  }

  /**
   * A rotation with maximum hamming distance.
   *
   * @param array of integers
   * @return maximum hamming distance of all possible array rotation.
   */
  public static int rotationWithMaximumHammingDistance(@NotEmpty int[] array) {

    int hammingDistance = Integer.MIN_VALUE;

    for (int i = 1; i < array.length - 1; i++) {
      int currentDistant = 0;

      for (int j = 0; j < array.length; j++) {
        if (array[j] != array[(j + i) % array.length]) {
          currentDistant += 1;
        }
      }

      if (currentDistant > hammingDistance) {
        hammingDistance = currentDistant;
      }
    }
    return hammingDistance;
  }


}
