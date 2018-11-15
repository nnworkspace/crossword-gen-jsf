package org.ningning.crossword_gen.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PuzzleAndSolutions {

  private Character[][] puzzle;
  private List<Solution> solutions;

  public PuzzleAndSolutions(char[][] puzzle,
      List<Solution> solutions) {
    int rows = puzzle.length;
    int cols = puzzle[0].length;

    this.puzzle = new Character[rows][cols];

    for (int row = 0; row < rows; row ++) {
      for (int col = 0; col < cols; col++) {
        this.puzzle[row][col] = puzzle[row][col];
      }
    }

    this.solutions = solutions;
  }

  public Character[][] getPuzzle() {
    return puzzle;
  }

  public List<Solution> getSolutions() {
    return solutions;
  }

  @Override
  public String toString() {
    return "PuzzleAndSolutions{" +
        "puzzle=" + Arrays.toString(puzzle) +
        ", solutions=" + solutions +
        '}';
  }
}
