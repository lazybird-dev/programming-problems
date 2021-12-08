package io.lazybird.programmingproblems.gfg.array;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class RearrangementProblemsTestCases {

  static Stream<Arguments> rearrangeArrayElementsToIndex() {
    return Stream.of(
        Arguments.arguments(new int[]{0, 2, 1, 3, 4}, new int[]{0, 1, 2, 3, 4}),
        Arguments.arguments(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 3, 4}),
        Arguments.arguments(new int[]{-1, -1, 2, -1, 3},
            new int[]{-1, -1, 2, 3, -1}));
  }

}
