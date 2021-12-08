package io.lazybird.programmingproblems.gfg.array;

import java.util.Arrays;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RearrangementProblems {

  private static final Logger _LOGGER = LoggerFactory.getLogger(
      RearrangementProblems.class);

  private RearrangementProblems() {
  }

  /**
   * Rearrange an array such that arr[i] = i.
   *
   * <p>
   * Error Conditions:
   *   <ul>
   *     <li>Infinite loop: When </li>
   *   </ul>
   * </p>
   *
   * @param array a non-null array whose elements need to be rearranged.
   * @see <a href="https://www.geeksforgeeks.org/rearrange-array-arri/">Problem
   *     Statement</a>
   */
  public static void rearrangeArrayElementsToIndex(@NotNull int[] array) {
    _LOGGER.atDebug().log("Input(s): array={}", Arrays.toString(array));
    for (int i = 0; i < array.length; i++) {
      while (array[i] != i && array[i] != -1) {
        int temp = array[array[i]];
        array[array[i]] = array[i];
        array[i] = temp;
      }
    }
    _LOGGER.atDebug().log("Output(s): array={}", Arrays.toString(array));
  }

}
