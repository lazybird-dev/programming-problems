package io.lazybird.programmingproblems.gfg.matrix;

public class RotationProblems {

  /**
   * Rotate a matrix by 90 degree in clockwise direction without using any extra
   * space.
   *
   * @param matrix
   * @see <a href="https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/">Problem
   *     Statement</a>
   * @see <a href="https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/">Similar
   *     Problem</a>
   */
  public static void rotateMatrix90ClockwiseWithoutUsingSpace(int[][] matrix) {

    int m = matrix.length;

    for (int i = 0; i < m / 2; i++) {
      int d = m - i * 2; //d is dimension
      for (int j = 0; j < d - 1; j++) {
        int temp = matrix[i][i + j];
        matrix[i][i + j] = matrix[i + d - 1 - j][i];
        matrix[i + d - 1 - j][i] = matrix[i + d - 1][i + d - 1 - j];
        matrix[i + d - 1][i + d - 1 - j] = matrix[i + j][i + d - 1];
        matrix[i + j][i + d - 1] = temp;
      }
    }
  }

}
