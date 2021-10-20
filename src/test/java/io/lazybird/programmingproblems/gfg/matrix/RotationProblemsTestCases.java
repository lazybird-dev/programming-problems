package io.lazybird.programmingproblems.gfg.matrix;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class RotationProblemsTestCases {

  static Stream<Arguments> rotateMatrix90ClockwiseWithoutUsingSpace() {
    return Stream.of(
        arguments(new int[][]{new int[]{1}}, new int[][]{new int[]{1}}),
        arguments(new int[][]{new int[]{1, 2}, new int[]{3, 4}},
            new int[][]{new int[]{3, 1}, new int[]{4, 2}}),
        arguments(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6},
                new int[]{7, 8, 9}},
            new int[][]{new int[]{7, 4, 1}, new int[]{8, 5, 2},
                new int[]{9, 6, 3}}),
        arguments(new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12}, new int[]{13, 14, 15, 16}},
            new int[][]{new int[]{13, 9, 5, 1}, new int[]{14, 10, 6, 2},
                new int[]{15, 11, 7, 3}, new int[]{16, 12, 8, 4}}),
        arguments(
            new int[][]{new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10},
                new int[]{11, 12, 13, 14, 15}, new int[]{16, 17, 18, 19, 20},
                new int[]{21, 22, 23, 24, 25}},
            new int[][]{new int[]{21, 16, 11, 6, 1},
                new int[]{22, 17, 12, 7, 2}, new int[]{23, 18, 13, 8, 3},
                new int[]{24, 19, 14, 9, 4}, new int[]{25, 20, 15, 10, 5}}));
  }

}
