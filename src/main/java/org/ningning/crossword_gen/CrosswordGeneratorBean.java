package org.ningning.crossword_gen;

import java.nio.file.Paths;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.ningning.crossword_gen.model.Board;
import org.ningning.crossword_gen.model.PuzzleAndSolutions;

@Named
@RequestScoped
public class CrosswordGeneratorBean {

  // request parameters
  private int rows = 8, cols = 8, shortestWordLength = 3;
  private float density = 0.75f;
  private boolean renderResult = false;
  private PuzzleAndSolutions puzzleAndSolutions;

  private static final String relativePath = "/resources/german.dic";

  public void generate() {
    renderResult = false;
    String absoluteFilePath = FacesContext.getCurrentInstance().getExternalContext()
        .getRealPath(relativePath);
    CrosswordGenerator cwGen = new CrosswordGenerator(Paths.get(absoluteFilePath),
        new Board(rows, cols));
    cwGen.generate(density, shortestWordLength);
    this.puzzleAndSolutions = cwGen.getPuzzleAndSolutions();

    // According to this thread:
    // https://stackoverflow.com/questions/34449826/iteration-over-array-of-primitives-using-uirepeat
    // primitive types does not render correctly on JSF.
    // Must convert the data type first.

    // TODO

    renderResult = true;
  }

  public int getRows() {
    return rows;
  }

  public void setRows(int rows) {
    this.rows = rows;
  }

  public int getCols() {
    return cols;
  }

  public void setCols(int cols) {
    this.cols = cols;
  }

  public int getShortestWordLength() {
    return shortestWordLength;
  }

  public void setShortestWordLength(int shortestWordLength) {
    this.shortestWordLength = shortestWordLength;
  }

  public float getDensity() {
    return density;
  }

  public void setDensity(float density) {
    this.density = density;
  }

  public PuzzleAndSolutions getPuzzleAndSolutions() {
    return puzzleAndSolutions;
  }

  public boolean isRenderResult() {
    return renderResult;
  }
}
