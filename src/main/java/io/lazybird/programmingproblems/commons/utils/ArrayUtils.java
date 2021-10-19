package io.lazybird.programmingproblems.commons.utils;


import javax.validation.constraints.NotNull;

public class ArrayUtils {

  private ArrayUtils() {
    throw new IllegalStateException("Utility Class");
  }

  /**
   * Reverse the array elements.
   *
   * @param array to be reversed
   */
  public static void reverseArray(@NotNull int[] array) {

    if (array.length <= 1) {
      return;
    }
    reverseArray(array, 0, array.length - 1);
  }

  /**
   * Reverse the elements sequence [s,e] of the array.
   *
   * @param array whose elements sequence needs to be reversed.
   * @param s     start index of the sequence which is always
   *              <code>&gt;=0</code> &amp; <code>&lt;=e</code>
   * @param e     end index of the sequence which is always <code>=&gt;s</code>
   *              &amp; <code> &lt;array.length</code>
   */
  public static void reverseArray(@NotNull int[] array, int s, int e) {

    if (array.length <= 1) {
      return;
    }

    if (e >= array.length || s < 0 || s > e) {
      throw new IllegalArgumentException(
          String.format("Invalid start & end index %d, %d", s, e));
    }
    int temp;
    while (s < e) {
      temp = array[s];
      array[s] = array[e];
      array[e] = temp;
      s++;
      e--;
    }
  }

}
