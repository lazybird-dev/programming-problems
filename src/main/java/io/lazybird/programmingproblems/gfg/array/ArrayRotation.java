package io.lazybird.programmingproblems.gfg.array;

import io.lazybird.programmingproblems.commons.annotations.DifficultyLevel;
import io.lazybird.programmingproblems.commons.annotations.ProgrammingProblem;
import io.lazybird.programmingproblems.commons.utils.ArrayUtils;
import io.lazybird.programmingproblems.commons.utils.MathUtils;
import java.util.Arrays;
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
  @ProgrammingProblem(title = "Array Rotation", sources = "https://www.geeksforgeeks.org/array-rotation/",
      tags = {"array", "rotation"}, difficultyLevel = DifficultyLevel.BEGINNER)
  public static int[] oneByOne(@NotNull int[] array, int rotateBy) {

    if (_LOGGER.isDebugEnabled()) {
      _LOGGER.debug("Input: array={}, rotateBy={}",
          Arrays.toString(array), rotateBy);
    }

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

    if (_LOGGER.isDebugEnabled()) {
      _LOGGER.debug("Input: array={}, rotateBy={}",
          Arrays.toString(array), rotateBy);
    }

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

    if (_LOGGER.isDebugEnabled()) {
      _LOGGER.debug("Input: array={}, rotateBy={}",
          Arrays.toString(array), rotateBy);
    }

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

    if (_LOGGER.isDebugEnabled()) {
      _LOGGER.debug("Input: array={}, rotateBy={}",
          Arrays.toString(array), rotateBy);
    }

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


}
