package io.lazybird.programmingproblems.commons.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * To annotate a method providing solution for a programming problem.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface ProgrammingProblem {

  /**
   * Title of the problem.
   *
   * @return title of the problem
   */
  String title();

  /**
   * Problem statement describing the problem.
   *
   * @return problem statement
   */
  String problemStatement() default "";

  /**
   * urls of the page where problem is picked from.
   *
   * @return urls of the page the same problem.
   */
  String[] sources() default {};

  /**
   * Tags to identify the problem type.
   *
   * @return tags
   */
  String[] tags() default {};

  /**
   * Describes how difficult the problem is.
   *
   * @return level of the problem.
   */
  DifficultyLevel difficultyLevel();

  /**
   * Custom notes if any to describe the solution given by the annotated method.
   *
   * @return notes
   */
  String notes() default "";

}
