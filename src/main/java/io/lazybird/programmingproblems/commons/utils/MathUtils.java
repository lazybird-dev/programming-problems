package io.lazybird.programmingproblems.commons.utils;

public class MathUtils {

  /**
   * Finds the greatest common divisor of two non-zero numbers.
   *
   * @return gcd of x & y
   */
  public static int gcd(int x, int y) {
    //TODO - assert that x & y are not equals to 0;
    int max = Math.max(x, y);
    int min = Math.min(x, y);

    if (max == min) {
      return max;
    }

    return max % min == 0 ? min : gcd(max % min, min);
  }

}
