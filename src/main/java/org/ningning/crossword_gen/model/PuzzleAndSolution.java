package org.ningning.crossword_gen.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PuzzleAndSolution {

  private char[][] puzzle;
  private List<Solution> solutions;

  public PuzzleAndSolution(char[][] puzzle,
      List<Solution> solutions) {
    this.puzzle = puzzle;
    this.solutions = solutions;
  }

  public char[][] getPuzzle() {
    return puzzle;
  }

  public List<Solution> getSolutions() {
    return solutions;
  }

  @Override
  public String toString() {
    return "PuzzleAndSolution{" +
        "puzzle=" + Arrays.toString(puzzle) +
        ", solutions=" + solutions +
        '}';
  }
}
