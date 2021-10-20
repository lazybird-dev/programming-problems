package io.lazybird.programmingproblems.gfg.matrix;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class RotationProblemsTest {

  @ParameterizedTest
  @MethodSource("io.lazybird.programmingproblems.gfg.matrix.RotationProblemsTestCases#rotateMatrix90ClockwiseWithoutUsingSpace")
  void rotateMatrix90ClockwiseWithoutUsingSpace(int[][] actualMatrix,
      int[][] rotatedMatrix) {
    RotationProblems.rotateMatrix90ClockwiseWithoutUsingSpace(actualMatrix);
    assertThat(actualMatrix).isDeepEqualTo(rotatedMatrix);
  }
}