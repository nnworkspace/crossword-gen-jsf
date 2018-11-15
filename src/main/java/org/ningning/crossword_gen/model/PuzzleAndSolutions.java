package org.ningning.crossword_gen.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PuzzleAndSolutions {

  private Character[][] puzzle;
  private List<Solution> solutions;
  private List<String> words;

  public PuzzleAndSolutions(char[][] puzzle,
      List<Solution> solutions) {
    int rows = puzzle.length;
    int cols = puzzle[0].length;

    this.puzzle = new Character[rows][cols];

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        this.puzzle[row][col] = puzzle[row][col];
      }
    }

    this.solutions = solutions;

    this.words = solutions.stream().map(solution -> solution.getWord())
        .collect(Collectors.toList());
  }

  public Character[][] getPuzzle() {
    return puzzle;
  }

  public List<Solution> getSolutions() {
    return solutions;
  }

  public List<String> getWords() {
    return words;
  }

  @Override
  public String toString() {
    return "PuzzleAndSolutions{" +
        "puzzle=" + Arrays.toString(puzzle) +
        ", solutions=" + solutions +
        '}';
  }
}
