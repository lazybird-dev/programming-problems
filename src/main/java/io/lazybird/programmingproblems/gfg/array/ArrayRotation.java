package io.lazybird.programmingproblems.gfg.array;

import io.lazybird.programmingproblems.commons.annotations.DifficultyLevel;
import io.lazybird.programmingproblems.commons.annotations.ProgrammingProblem;
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
   *
   * @param array    to be rotated.
   * @param rotateBy no of elements to be rotated
   * @return rotated array
   */
  @SuppressWarnings("ManualArrayCopy")
  @ProgrammingProblem(title = "Array Rotation", sources = "https://www.geeksforgeeks.org/array-rotation/",
      tags = {"array", "rotation"}, difficultyLevel = DifficultyLevel.BEGINNER)
  public static int[] rotateArrayOneByOne(int[] array, int rotateBy) {

    if (array == null || array.length <= 1 || rotateBy == 0) {
      return array;
    }

    rotateBy = rotateBy % array.length;
    _LOGGER.debug("Rotating array by {}", rotateBy);

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

}
