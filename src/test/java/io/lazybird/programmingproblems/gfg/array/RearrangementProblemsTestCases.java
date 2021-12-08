package io.lazybird.programmingproblems.gfg.array;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class RearrangementProblemsTestCases {

  static Stream<Arguments> rearrangeArrayElementsToIndex() {
    return Stream.of(
        Arguments.arguments(new int[]{0, 2, 1, 3, 4}, new int[]{0, 1, 2, 3, 4}),
        Arguments.arguments(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 3, 4}),
        Arguments.arguments(new int[]{-1, -1, 2, -1, 3},
            new int[]{-1, -1, 2, 3, -1}),
        Arguments.arguments(new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1},
            new int[]{-1, 1, 2, 3, 4, -1, 6, -1, -1, 9}),
        Arguments.arguments(
            new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2,
                14, 17, 4},
            new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19}));
  }

}
