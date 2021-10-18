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
 *
 * <h3>Sources:</h3>
 * <ol>
 *   <li>https://www.geeksforgeeks.org/array-data-structure/#rotation</li>
 *   <li>https://www.geeksforgeeks.org/tag/rotation/</li>
 * </ol>
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
  @SuppressWarnings("ManualArrayCopy")
  public static int[] usingTempArray(@NotNull int[] array, int rotateBy) {

    _LOGGER.atDebug().log("Input: array={}, rotateBy={}",
        Arrays.toString(array), rotateBy);

    if (array.length <= 1 || (rotateBy = rotateBy % array.length) == 0) {
      return array;
    }

    int[] tempArray = Arrays.copyOf(array, rotateBy);

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
   * <p>https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/</p>
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
   * @see <a href="https://www.geeksforgeeks.org/block-swap-algorithm-for-array-rotation/"
   *     target="_blank">block-swap-algorithm-for-array-rotation</a>
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
   * Search an element in a sorted and rotated array.
   *
   * @param array   to be searched.
   * @param element to be searched.
   * @return index of the element or -1 if not found.
   * @see <a href="https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/">Problem
   *     Statement @geeksforgeeks.org</a>
   */
  @ProgrammingProblem(title = "",
      sources = "",
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
   * @see <a href="https://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/"
   *     target="_blank">maximum-sum-iarri-among-rotations-given-array</a>
   * @see <a href="https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/"
   *     target="_blank">Problem Statement @geeksforgeeks.org</a>
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
   * @see <a href="https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/"
   *     target="_blank">find-rotation-count-rotated-sorted-array</a>
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
   * @see <a href="https://www.geeksforgeeks.org/quickly-find-multiple-left-rotations-of-an-array/"
   *     target="_blank">quickly-find-multiple-left-rotations-of-an-array</a>
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
  public static int rotationWithMaximumHammingDistance1(@NotEmpty int[] array) {

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

  /**
   * <p>Find a rotation with maximum hamming distance</p>
   * <p>https://www.geeksforgeeks.org/find-a-rotation-with-maximum-hamming-distance-set-2/</p>
   * A rotation with maximum hamming distance.
   *
   * @param array of integers
   * @return maximum hamming distance of all possible array rotation.
   */
  public static int rotationWithMaximumHammingDistance2(@NotEmpty int[] array) {
    return -1;
  }

  /**
   * https://www.geeksforgeeks.org/queries-left-right-circular-shift-array/
   *
   * @param array   of integer
   * @param queries queries to be performed on array
   * @return sum of the elements over a range.
   */
  public static int queriesOnArray(@NotEmpty int[] array,
      @NotEmpty int[][] queries) {

    int totalSum = 0;
    int s = 0;

    for (int[] query : queries) {
      switch (query[0]) {
        case 1:
          s = Math.floorMod(s - query[1], array.length);
          break;

        case 2:
          s = Math.floorMod(s + query[1], array.length);
          break;

        case 3:
          int range = query[2] - query[1];
          int startIndex = (s % array.length) + query[1];

          for (int i = startIndex; i <= range + startIndex; i++) {
            totalSum += array[i % array.length];
          }
          break;
        default:
          throw new AssertionError(
              String.format("Invalid query %s", Arrays.toString(query)));
      }
    }
    return totalSum;
  }

  /**
   * Split the array in two parts and attach first part to the end of second
   * part.
   *
   * @param array   of integers to be split.
   * @param splitBy first-half length
   * @return resulting array
   */
  public static int[] splitFirstPartAndAddItToBack(@NotEmpty int[] array,
      int splitBy) {

    if (splitBy == 0 || array.length == splitBy) {
      return array;
    }
    ArrayUtils.reverseArray(array, 0, splitBy - 1);
    ArrayUtils.reverseArray(array, splitBy, array.length - 1);
    ArrayUtils.reverseArray(array, 0, array.length - 1);

    return array;
  }

  /**
   * URL: https://www.geeksforgeeks.org/rearrange-array-arri/
   *
   * @param array to be rearranged
   */
  public static void reArrangeArray(@NotEmpty int[] array) {
    for (int i = 0; i < array.length; i++) {
      int temp;
      while (array[i] != -1 && array[i] != i) {
        temp = array[i];
        array[i] = array[temp];
        array[temp] = temp;
      }
    }
  }

  /**
   * <p>Count rotations required to sort given array in non-increasing
   * order</p> URL: https://www.geeksforgeeks.org/count-rotations-required-to-sort-given-array-in-non-increasing-order/
   *
   * @param array of integers
   * @return number of anti-clockwise rotation required to sort the array in
   *     non-increasing order or -1 if array is not sortable.
   */
  public static int rotationRequiredToSortArray(@NotEmpty int[] array) {

    if (array.length == 1) {
      return 0;
    }

    int pivotIndex = -1;
    int index = array.length - 1;

    while (index > 0) {
      if (array[index - 1] < array[index]) {
        if (pivotIndex == -1) {
          pivotIndex = index;
        }
      } else {
        if (pivotIndex == -1) {
          pivotIndex = index - 1;
        } else {
          return -1;
        }
      }
      index--;
    }

    return pivotIndex;
  }

  /**
   * https://www.geeksforgeeks.org/check-whether-matrix-t-is-a-result-of-one-or-more-90-rotations-of-matrix-mat/
   *
   * @param originalMatrix matrix 1
   * @param rotatedMatrix  matrix 2
   * @return true if one matrix is rotation of another else false.
   */
  public static boolean isMatrixRotationOfAnother(
      @NotEmpty int[][] originalMatrix, @NotEmpty int[][] rotatedMatrix) {

    if (originalMatrix.length != rotatedMatrix.length
        || originalMatrix[0].length != rotatedMatrix[0].length) {
      return false;
    }

    boolean[] result = new boolean[4];
    Arrays.fill(result, true);

    int r = originalMatrix.length - 1;
    int c = originalMatrix[0].length - 1;

    for (int i = 0; i < originalMatrix.length; i++) {
      for (int j = 0; j < originalMatrix[i].length; j++) {

        if (result[0] && originalMatrix[i][j] != rotatedMatrix[i][j]) {
          result[0] = false;
        }

        if (result[1] && originalMatrix[i][j] != rotatedMatrix[j][i]) {
          result[1] = false;
        }

        if (result[2] && originalMatrix[i][j] != rotatedMatrix[i][c - j]) {
          result[2] = false;
        }

        if (result[3] && originalMatrix[i][j] != rotatedMatrix[j][r - i]) {
          result[3] = false;
        }
      }
    }

    return result[0] || result[1] || result[2] || result[3];
  }

  /**
   * https://www.geeksforgeeks.org/rotate-a-matrix-clockwise-by-90-degree-without-using-any-extra-space-set-3/
   *
   * @param matrix to be rotated
   * @return rotated matrix
   */
  public static int[][] rotateMatrixClockwiseBy90(@NotEmpty int[][] matrix) {

    int r = matrix.length - 1;
    int c = matrix[0].length - 1;

    int[][] rotatedMatrix = new int[c + 1][];

    for (int i = 0; i <= c; i++) {
      rotatedMatrix[i] = new int[r + 1];
      for (int j = 0; j <= r; j++) {
        rotatedMatrix[i][r - j] = matrix[j][i];
      }

    }

    return rotatedMatrix;
  }


  /**
   * Reduce the given Array of [1, N] by rotating left or right based on given *
   * conditions.
   *
   * @param array               to be rotated
   * @param rotationInstruction instruction array
   * @return remaining element
   * @see <a href="https://www.geeksforgeeks.org/reduce-the-given-array-of-1-n-by-rotating-left-or-right-based-on-given-conditions/"
   *     target="_blank">Problem Statement @geeksforgeeks.org</a>
   */
  public static int reduceArrayByRotation(@NotEmpty int[] array,
      @NotEmpty int[] rotationInstruction) {
    int s = 0;
    int e = array.length - 1;
    return -1;
  }

  /**
   * Maximum number of 0s placed consecutively at the start and end in any
   * rotation of a Binary String.
   *
   * @param binaryString binary string
   * @return number of consecutive zeroes
   * @see <a href="https://www.geeksforgeeks.org/maximum-number-of-0s-placed-consecutively-at-the-start-and-end-in-any-rotation-of-a-binary-string/"
   *     target="_blank">Problem Link</a>
   */
  public static int maximumConsecutiveZerosAtStartOrEnd(
      @NotEmpty String binaryString) {
    int maxZeroSubstringLength = 0;
    int zeroCount = 0;
    int index = 0;
    while (index < binaryString.length() * 2 - 1) {

      if (binaryString.charAt(index % binaryString.length()) == '0') {
        zeroCount++;
        maxZeroSubstringLength = Math.max(maxZeroSubstringLength, zeroCount);
      } else {
        zeroCount = 0;
      }
      index++;
    }
    //In case string is all zeroes
    return Math.min(maxZeroSubstringLength, binaryString.length());
  }

  /**
   * Rotate matrix rows.
   *
   * @param matrix rows of this given matrix need to be rotated.
   */
  public static void rotateMatrixRows(@NotEmpty int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      //clockwise  = length - anticlockwise rotation
      ArrayRotation.byJugglingMethod(matrix[i], matrix[0].length - i);
    }
  }

  /**
   * Modify a string by performing given shift operations.
   *
   * @param string     of chars
   * @param operations operation matrix
   * @return modified string
   * @see <a href="https://www.geeksforgeeks.org/modify-a-string-by-performing-given-shift-operations/"
   *     target="_blank">Problem Statement @geeksforgeeks.org</a>
   */
  public static String stringShift(String string, int[][] operations) {
    int effectiveShift = 0;

    for (int[] operation : operations) {
      if (operation[0] == 0) {
        effectiveShift -= operation[1];
      } else {
        effectiveShift += operation[1];
      }
    }

    String tempString = string.concat(string);

    if (effectiveShift < 0) {
      tempString = tempString.substring(-effectiveShift,
          -effectiveShift + string.length());
    } else if (effectiveShift < 0) {
      tempString = tempString.substring(string.length() - effectiveShift,
          effectiveShift + string.length() + 1);
    }

    return tempString;
  }

  /**
   * Lexicographically minimum string rotation.
   *
   * @param str given string
   * @return minimum lexicographic rotation of the string
   * @see <a href="https://www.geeksforgeeks.org/lexicographically-minimum-string-rotation/"
   *     target="_blank">Problem Statement @geeksforgeeks.org</a>
   * @see <a href="https://www.geeksforgeeks.org/lexicographically-smallest-rotated-sequence-set-2/">Problem
   *     Statement @geeksforgeeks.org</a>
   * @see <a href="https://en.wikipedia.org/wiki/Lexicographically_minimal_string_rotation"
   *     target="_blank">Wikipedia
   *     </a>
   */
  public static String lexicographicMinimumOfStringRotation(String str) {
    String s = str + str;
    int s1 = 0;
    int s2 = 0;
    int wl;
    int step = 0;
    while (s2 < str.length()) {
      wl = 0;
      step++;
      s2 = s1 + step;
      while (s2 + wl < s.length()) {
        if (s.charAt(s1 + wl) == s.charAt(s2 + wl)) {
          wl++;
        } else {
          if (s.charAt(s1 + wl) < s.charAt(s2 + wl)) {
            step = s2 - s1 + wl;
          } else {
            s1 = s2;
            step = 0;
          }
          break;
        }
      }
    }
    return s.substring(s1, s1 + str.length());
  }

  /**
   * Rotate bits of a number.
   *
   * @param n        integer to be rotated.
   * @param rotateBy number of times integer is to be rotated.
   * @return integer after performing rotation
   * @see <a href="https://www.geeksforgeeks.org/rotate-bits-of-an-integer/"
   *     target="_blank">Problem Statement @geeksforgeeks.org</a>
   */
  public static int leftRotateBitOfNumber(int n, int rotateBy) {
    return (n << rotateBy) | (n >> 32 - rotateBy);
  }

  /**
   * Rotate bits of a number.
   *
   * @param n        integer to be rotated.
   * @param rotateBy number of times to be rotated.
   * @return integer after performing rotation.
   * @see <a href="https://www.geeksforgeeks.org/rotate-bits-of-an-integer/">Problem
   *     Statement @geeksforgeeks.org</a>
   */
  public static int rightRotateBitOfNumber(int n, int rotateBy) {
    return (n >> rotateBy) | (n << 32 - rotateBy);
  }


  /**
   * A Program to check if strings are rotations of each other or not.
   *
   * @param originalString a non-null string
   * @param rotatedString  a non-null string
   * @return true when rotatedString is a rotation of original string else
   *     false.
   * @see <a href="https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/"
   *     target="_blank">Problem Statement @geeksforgeeks.org</a>
   * @see <a href="https://www.geeksforgeeks.org/check-string-can-obtained-rotating-another-string-2-places/"
   *     target="_blank">Similar Problem</a>
   * @see <a href="https://www.geeksforgeeks.org/check-rows-matrix-circular-rotations/"
   *     target="_blank">Similar Problem</a>
   */
  public static boolean isStringRotationOfAnother(String originalString,
      String rotatedString) {
    return rotatedString.length() == originalString.length()
        && (rotatedString + rotatedString).contains(originalString);
  }

  /**
   * Rotate an image by 90 degree.
   *
   * @param imageBuffer to be rotated.
   * @return array representing 90 degree rotated imageBuffer
   * @see <a href="https://www.geeksforgeeks.org/turn-an-image-by-90-degree/"
   *     target="_blank">Problem Statement @geeksforgeeks.org</a>
   */
  public static String[][] rotateAnImageBy90Degree(String[][] imageBuffer) {
    int r = imageBuffer.length;
    int c = imageBuffer[0].length;
    String[][] result = new String[c][];
    for (int i = 0; i < c; i++) {
      result[i] = new String[r];
      for (int j = 0; j < r; j++) {
        result[i][r - j - 1] = imageBuffer[j][i];
      }
    }
    return result;
  }

  /**
   * Check if two numbers are bit rotations of each other or not.
   *
   * @param actualNumber  number
   * @param rotatedNumber number's bit rotation
   * @return true if actualNumber and rotatedNumber are bit rotation of each
   *     other else false.
   * @see <a href="https://www.geeksforgeeks.org/check-two-numbers-bit-rotations-not/">Problem
   *     Statement @geeksforgeeks.org</a>
   */
  public static boolean isBitRotationOfOther(long actualNumber,
      long rotatedNumber) {
    for (int i = 0; i < 64; i++) {
      if (((actualNumber << 64 - i) | (actualNumber >> i)) == rotatedNumber) {
        return true;
      }
    }
    return false;
  }

  /**
   * Left Rotation and Right Rotation of a String.
   *
   * @param str      non-null string to be rotated
   * @param rotateBy number of places to be rotated by.
   * @see <a href="https://www.geeksforgeeks.org/left-rotation-right-rotation-string-2/"
   *     target="_blank">Problem Statement @geeksforgeeks.org</a>
   */
  public static String[] leftRotateRightRotateString(String str, int rotateBy) {
    rotateBy = rotateBy % str.length();
    String[] result = new String[2];
    result[0] = (str.substring(rotateBy) + str.substring(0, rotateBy));
    result[1] = str.substring(str.length() - rotateBy) + str.substring(0,
        str.length() - rotateBy);
    return result;
  }

  /**
   * Count rotations divisible by 4.
   *
   * @param str non-empty string representing a large positive integer
   * @return number of rotation divisible by 4.
   * @see <a href="https://www.geeksforgeeks.org/count-rotations-divisible-4/"
   *     target="_blank">Problem Statement @geeksforgeeks.org</a>
   */
  public static int numberOfRotationDivisibleBy4(String str) {
    int count = 0;

    if (str.length() == 1) {
      count += Integer.parseInt(str) % 4 == 0 ? 1 : 0;
    } else {
      String temp = str + str;
      for (int i = 0; i < str.length(); i++) {
        count +=
            Integer.parseInt(temp.substring(i, i + 2)) % 4 == 0
                ? 1 : 0;
      }
    }
    return count;
  }

  /**
   * Given a square matrix, turn it by 90 degrees in anti-clockwise direction
   * without using any extra space.
   *
   * @param matrix to be rotated
   * @see <a href="https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/"
   *     target="_blank">Problem Statement @geeksforgeeks.org</a>
   */
  public static void rotateMatrixInPlace1(int[][] matrix) {
    for (int i = 0; i < matrix.length / 2; i++) {
      int d = matrix.length - 2 * i;
      int temp;
      for (int j = 0; j < d - 1; j++) {
        temp = matrix[i][i + j];
        matrix[i][i + j] = matrix[i + j][i + d - 1];
        matrix[i + j][i + d - 1] = matrix[i + d - 1][i + d - 1 - j];
        matrix[i + d - 1][i + d - 1 - j] = matrix[i + d - 1 - j][i];
        matrix[i + d - 1 - j][i] = temp;
      }
    }
  }


  /**
   * Count rotations divisible by 8.
   *
   * @param str given string.
   * @return number of rotations divisible by 8.
   * @see <a href="https://www.geeksforgeeks.org/count-rotations-divisible-8/">Problem
   *     Statement @geeksforgeeks.org</a>
   */
  public static int numberOfRotationDivisibleBy8(String str) {

    int count = 0;

    count += str.length() == 1 && Integer.parseInt(str) % 8 == 0 ? 1 : 0;

    if (str.length() == 2) {
      count += Integer.parseInt(str) % 8 == 0 ? 1 : 0;
      count +=
          ((str.charAt(1) - '0') * 10 + str.charAt(0) - '0') % 8 == 0 ? 1 : 0;
    }

    if (str.length() > 2) {
      String temp = str + str;
      for (int i = 0; i < str.length(); i++) {
        count += Integer.parseInt(temp.substring(i, i + 3)) % 8 == 0 ? 1 : 0;
      }
    }
    return count;
  }


}
