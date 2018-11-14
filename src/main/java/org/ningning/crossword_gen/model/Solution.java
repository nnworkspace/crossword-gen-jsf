package org.ningning.crossword_gen.model;

import java.util.Arrays;

public class Solution {

  private String word;
  private int[] startPosition;
  private WordOrientation orientation;

  public Solution(String word, int[] startPosition,
      WordOrientation orientation) {
    this.word = word;
    this.startPosition = startPosition;
    this.orientation = orientation;
  }

  public String getWord() {
    return word;
  }

  public int[] getStartPosition() {
    return startPosition;
  }

  public WordOrientation getOrientation() {
    return orientation;
  }

  @Override
  public String toString() {
    return "Solution{" +
        "word='" + word + '\'' +
        ", startPosition=" + Arrays.toString(startPosition) +
        ", orientation=" + orientation +
        '}';
  }
}
