package io.lazybird.programmingproblems.gfg.array;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class RearrangementProblemsTest {

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.array.RearrangementProblemsTestCases#rearrangeArrayElementsToIndex")
  void rearrangeArrayElementsToIndex(int[] actualArray, int[] expectedArray) {
    RearrangementProblems.rearrangeArrayElementsToIndex(actualArray);
    assertThat(actualArray).containsExactly(expectedArray);
  }
}