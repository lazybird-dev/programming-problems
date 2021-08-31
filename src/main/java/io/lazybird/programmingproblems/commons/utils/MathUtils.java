package io.lazybird.programmingproblems.commons.utils;

public class MathUtils {

  private MathUtils() {
  }

  /**
   * Finds the greatest common divisor of two non-zero numbers.
   *
   * @param x first number
   * @param y second number
   * @return greatest common divisor of x &amp; y.
   * @throws IllegalArgumentException if any of the passed number is 0.
   */
  public static int gcd(int x, int y) {

    if (x == 0 || y == 0) {
      throw new IllegalArgumentException(
          String.format("x=%d, y=%d should be non-zero integers", x, y));
    }
    int max = Math.max(Math.abs(x), Math.abs(y));
    int min = Math.min(Math.abs(x), Math.abs(y));

    if (max == min) {
      return max;
    }

    return max % min == 0 ? min : gcd(max % min, min);
  }

}
