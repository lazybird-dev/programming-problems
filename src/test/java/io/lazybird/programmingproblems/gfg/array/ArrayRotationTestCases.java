package io.lazybird.programmingproblems.gfg.array;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class ArrayRotationTestCases {

  static Stream<Arguments> testCasesForArrayRotation() {
    return Stream.of(arguments(new int[]{}, 1, new int[]{}),
        arguments(new int[]{1, 2}, 0, new int[]{1, 2}),
        arguments(new int[]{1, 2}, 1, new int[]{2, 1}),
        arguments(new int[]{1, 2}, 2, new int[]{1, 2}),
        arguments(new int[]{1, 2}, 3, new int[]{2, 1}),
        arguments(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 13,
            new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3})
    );
  }

  static Stream<Arguments> searchElementInRotatedSortedArray() {
    return Stream.of(arguments(new int[]{1, 2, 3, 4, 5}, 1, 0),
        arguments(new int[]{1, 2, 3, 4, 5}, 3, 2),
        arguments(new int[]{1, 2, 3, 4, 5}, 0, -1),
        arguments(new int[]{3, 4, 5, 1, 2}, 1, 3),
        arguments(new int[]{3, 4, 5, 1, 2}, 4, 1),
        arguments(new int[]{3, 4, 5, 1, 2}, 5, 2),
        arguments(new int[]{3, 4, 5, 1, 2}, 6, -1)
    );
  }

  static Stream<Arguments> maxOfPositionalSum() {
    return Stream.of(of(new int[]{1, 2, 3, 4, 5}),
        of(new int[]{1, 2, -3, -4, -5}),
        of(new int[]{-1, 2, -3, 4, 10}),
        of(new int[]{-3, 4, 15, 1, -2}),
        of(new int[]{3, -4, 5, -1, 2}),
        of(new int[]{3, 14, 5, 21, 2}),
        of(new int[]{3, -4, 25, 1, 2})
    );
  }

  static Stream<Arguments> rotationCountInRotatedSortedArray() {
    return Stream.of(arguments(new int[]{1, 2, 3, 4, 5}, 0),
        arguments(new int[]{2, 3, 4, 5, 1}, 4),
        arguments(new int[]{3, 4, 5, 1, 2}, 3),
        arguments(new int[]{4, 5, 1, 2, 3}, 2),
        arguments(new int[]{1, 2}, 0),
        arguments(new int[]{2, 1}, 1),
        arguments(new int[]{1}, 0)
    );
  }

  static Stream<Arguments> rotationWithMaximumHammingDistance() {
    return Stream.of(arguments(new int[]{1, 2, 3, 4, 5}, 5),
        arguments(new int[]{1, 2, 3, 5, 1}, 5),
        arguments(new int[]{1, 1, 1, 1, 1, 1}, 0),
        arguments(new int[]{1, 2, 1}, 2),
        arguments(new int[]{1, 2, 1, 2}, 4),
        arguments(new int[]{3, 0, 6, 4, 3}, 5)
    );
  }

  static Stream<Arguments> queriesOnArray() {
    return Stream.of(
        arguments(new int[]{1, 2, 3, 4, 5},
            new int[][]{{1, 3}, {2, 3}, {3, 0, 4}}, 15),
        arguments(new int[]{1, 2, 3, 4, 5},
            new int[][]{{1, 3}, {1, 1}, {3, 0, 1}}, 5),
        arguments(new int[]{1, 2, 3, 4, 5},
            new int[][]{{2, 3}, {1, 1}, {3, 0, 3}}, 13)
    );
  }

  static Stream<Arguments> splitFirstPartAndAddItToBack() {
    return Stream.of(
        arguments(new int[]{1, 2}, 0, new int[]{1, 2}),
        arguments(new int[]{1, 2}, 1, new int[]{2, 1}),
        arguments(new int[]{1, 2}, 2, new int[]{1, 2}),
        arguments(new int[]{1, 2, 3, 4, 5}, 3, new int[]{4, 5, 1, 2, 3}),
        arguments(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3,
            new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3})
    );
  }

  static Stream<Arguments> reArrangeArray() {
    return Stream.of(
        arguments(new int[]{0, 1}, new int[]{0, 1}),
        arguments(new int[]{0, 1, 4, 3, 2}, new int[]{0, 1, 2, 3, 4}),
        arguments(new int[]{-1, -1, 4, 3, 2}, new int[]{-1, -1, 2, 3, 4}),
        arguments(new int[]{-1, 0}, new int[]{0, -1}),
        arguments(new int[]{0}, new int[]{0}),
        arguments(new int[]{-1}, new int[]{-1}),
        arguments(new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1},
            new int[]{-1, 1, 2, 3, 4, -1, 6, -1, -1, 9}),
        arguments(
            new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2,
                14, 17, 4},
            new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19})
    );
  }

  static Stream<Arguments> rotationRequiredToSortArray() {
    return Stream.of(
        arguments(new int[]{1, 2, 3, 4, 5}, 4),
        arguments(new int[]{1}, 0),
        arguments(new int[]{2, 1}, 0),
        arguments(new int[]{2, 1, 3}, 2),
        arguments(new int[]{1, 2, 2}, 2),
        arguments(new int[]{3, 1, 2, 4, 5}, -1),
        arguments(new int[]{2, 1, 5, 4, 3}, 2)
    );
  }

  static Stream<Arguments> isMatrixRotationOfAnother() {
    return Stream.of(
        Arguments.arguments(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, true),
        Arguments.arguments(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{1, 4, 7}, {8, 5, 2}, {9, 6, 3}}, false));
  }

  static Stream<Arguments> rotateMatrixClockwiseBy90() {
    return Stream.of(
        Arguments.arguments(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}),
        Arguments.arguments(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{1, 4, 7}, {8, 5, 2}, {9, 6, 3}}));
  }

  static Stream<Arguments> testRotateMatrixClockwiseBy90() {
    return Stream.of(
        Arguments.arguments(
            new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}},
            new int[][]{{10, 7, 4, 1}, {11, 8, 5, 2}, {12, 9, 6, 3}}),
        Arguments.arguments(
            new int[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}},
            new int[][]{{7, 1}, {8, 2}, {9, 3}, {10, 4}, {11, 5}, {12, 6}}));
  }

  static Stream<Arguments> maximumConsecutiveZerosAtStartOrEnd() {
    return Stream.of(
        Arguments.arguments("1001", 2),
        Arguments.arguments("0100", 3),
        Arguments.arguments("1111", 0),
        Arguments.arguments("0000", 4)
    );
  }

  static Stream<Arguments> rotateMatrixRows() {
    return Stream.of(
        Arguments.arguments(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{1, 2, 3}, {6, 4, 5}, {8, 9, 7}}),
        Arguments.arguments(new int[][]{{1, 2, 3}, {4, 5, 6}},
            new int[][]{{1, 2, 3}, {6, 4, 5}}));
  }

  static Stream<Arguments> stringShift() {
    return Stream.of(
        Arguments.arguments("abc", new int[][]{{0, 1}, {1, 2}}, "cab"),
        Arguments.arguments("abcdefg",
            new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}}, "efgabcd"),
        Arguments.arguments("abcdefg",
            new int[][]{{0, 1}, {0, 1}}, "cdefgab"),
        Arguments.arguments("abcdefg",
            new int[][]{{0, 1}, {1, 1}}, "abcdefg"));
  }

  static Stream<Arguments> lexicographicMinimumOfStringRotation() {
    return Stream.of(Arguments.arguments("GEEKSQUIZ", "EEKSQUIZG"),
        Arguments.arguments("GFG", "FGG"),
        Arguments.arguments("GEEKSFORGEEKS", "EEKSFORGEEKSG"),
        Arguments.arguments("aaacaaa", "aaaaaac"),
        Arguments.arguments("aaaaaaa", "aaaaaaa"),
        Arguments.arguments("a", "a"),
        Arguments.arguments("bbab", "abbb"));
  }

  static Stream<Arguments> leftRotateBitOfNumber() {
    return Stream.of(Arguments.arguments(16, 2, 64));
  }

  static Stream<Arguments> rightRotateBitOfNumber() {
    return Stream.of(Arguments.arguments(16, 2, 4));
  }

  static Stream<Arguments> isStringRotationOfAnother() {
    return Stream.of(Arguments.arguments("ABCD", "CDAB", true),
        Arguments.arguments("ABCD", "ACBD", false));
  }

  static Stream<Arguments> rotateAnImageBy90Degree() {
    return Stream.of(Arguments.arguments(
        new String[][]{{"*", "*", "*", "^", "*", "*", "*"},
            {"*", "*", "*", "|", "*", "*", "*"},
            {"*", "*", "*", "|", "*", "*", "*"},
            {"*", "*", "*", "|", "*", "*", "*"}},
        new String[][]{{"*", "*", "*", "*"}, {"*", "*", "*", "*"},
            {"*", "*", "*", "*"}, {"|", "|", "|", "^"}, {"*", "*", "*", "*"},
            {"*", "*", "*", "*"}, {"*", "*", "*", "*"}}));
  }

  static Stream<Arguments> isBitRotationOfOther() {
    return Stream.of(Arguments.arguments(8, 1, true),
        Arguments.arguments(122, 2147483678L, true));
  }

  static Stream<Arguments> leftRotateRightRotateString() {
    return Stream.of(Arguments.arguments("GeeksforGeeks", 1,
            new String[]{"eksforGeeksGe", "ksGeeksforGee"}),
        Arguments.arguments("qwertyu", 2, new String[]{"ertyuqw", "yuqwert"}));
  }

  static Stream<Arguments> numberOfRotationDivisibleBy4() {
    return Stream.of(Arguments.arguments("8", 1),
        Arguments.arguments("20", 1), Arguments.arguments("13502", 0),
        Arguments.arguments("928160", 4),
        Arguments.arguments("4834", 2),
        Arguments.arguments("44", 2));
  }

  static Stream<Arguments> rotateMatrixInPlace() {
    return Stream.of(
        Arguments.arguments(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{3, 6, 9}, {2, 5, 8}, {1, 4, 7}}),
        Arguments.arguments(new int[][]{{1, 2}, {3, 4}},
            new int[][]{{2, 4}, {1, 3}}),
        Arguments.arguments(
            new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}},
            new int[][]{{5, 10, 15, 20, 25}, {4, 9, 14, 19, 24},
                {3, 8, 13, 18, 23}, {2, 7, 12, 17, 22}, {1, 6, 11, 16, 21}}),
        Arguments.arguments(
            new int[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}},
            new int[][]{{6, 12, 18, 24, 30, 36}, {5, 11, 17, 23, 29, 35},
                {4, 10, 16, 22, 28, 34}, {3, 9, 15, 21, 27, 33},
                {2, 8, 14, 20, 26, 32}, {1, 7, 13, 19, 25, 31}}));
  }

  static Stream<Arguments> numberOfRotationDivisibleBy8() {
    return Stream.of(Arguments.arguments("8", 1),
        Arguments.arguments("40", 1), Arguments.arguments("13502", 0),
        Arguments.arguments("43262488612", 4),
        Arguments.arguments("88", 2),
        Arguments.arguments("800", 3));
  }

  static Stream<Arguments> rotateMatrixBy180() {
    return Stream.of(
        Arguments.arguments(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}}),
        Arguments.arguments(
            new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, 1, 2}, {3, 4, 5, 6}},
            new int[][]{{6, 5, 4, 3}, {2, 1, 0, 9}, {8, 7, 6, 5},
                {4, 3, 2, 1}}));
  }

  static Stream<Arguments> numberOfMinimumRotationsToMakeEqualStrings() {
    return Stream.of(
        Arguments.arguments(new String[]{"xzzwo", "zwoxz", "zzwox", "xzzwo"},
            5),
        Arguments.arguments(new String[]{"kc", "kc", "kc"}, 0),
        Arguments.arguments(new String[]{"molzv", "lzvmo"}, 2));
  }

  static Stream<Arguments> elementAtIndexAfterNumberOfRotations() {
    return Stream.of(
        Arguments.arguments(new int[]{}, new int[][]{new int[]{}}, 1, 1));
  }

  static Stream<Arguments> sortRotatedSortedArray() {
    return Stream.of(
        Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
        Arguments.arguments(new int[]{3, 4, 5, 1, 2}, new int[]{1, 2, 3, 4, 5}),
        Arguments.arguments(new int[]{1, 2}, new int[]{1, 2}));
  }
}
