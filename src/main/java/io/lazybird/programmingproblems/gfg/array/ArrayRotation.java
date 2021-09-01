package io.lazybird.programmingproblems.gfg.array;

import io.lazybird.programmingproblems.commons.annotations.DifficultyLevel;
import io.lazybird.programmingproblems.commons.annotations.ProgrammingProblem;
import io.lazybird.programmingproblems.commons.utils.ArrayUtils;
import io.lazybird.programmingproblems.commons.utils.MathUtils;
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

}
