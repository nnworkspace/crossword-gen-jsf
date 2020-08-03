package org.ningning.crossword_gen.model;

import java.util.Arrays;

public class Solution {

  private String word;
  private Integer[] startPosition = new Integer[2];
  private WordOrientation orientation;

  public Solution(String word, int[] startPosition, WordOrientation orientation) {
    this.word = word;
    this.startPosition[0] = startPosition[0];
    this.startPosition[1] = startPosition[1];
    this.orientation = orientation;
  }

  public String getWord() {
    return word;
  }

  public Integer[] getStartPosition() {
    return startPosition;
  }

  public WordOrientation getOrientation() {
    return orientation;
  }

  @Override
  public String toString() {
    return "Solution{"
        + "word='"
        + word
        + '\''
        + ", startPosition="
        + Arrays.toString(startPosition)
        + ", orientation="
        + orientation
        + '}';
  }
}
