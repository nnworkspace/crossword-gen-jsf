package org.ningning.crossword_gen;

import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.ningning.crossword_gen.model.Board;
import org.ningning.crossword_gen.model.PuzzleAndSolutions;

@Named
@SessionScoped
public class CrosswordGeneratorBean implements Serializable {

  // request parameters
  private int rows = 8, cols = 8, shortestWordLength = 3;
  private float density = 0.75f;
  private boolean renderResult = false, renderSolution = false, showWaitingMsg = false;
  private PuzzleAndSolutions puzzleAndSolutions;
  private List<String> words;
  private List<Integer> columns = new ArrayList<>();

  private static final String relativePath = "/resources/german.dic";

  @PostConstruct
  public void init() {}

  public void generate() {

    FacesContext facesContext = FacesContext.getCurrentInstance();

    showWaitingMsg = true;
    renderResult = false;
    renderSolution = false;

    // update two view fragments
    // standard jsf API is not working
    // facesContext.getPartialViewContext().getRenderIds().add("puzzleFragment");
    // facesContext.getPartialViewContext().getRenderIds().add("solutionFragment");

    this.puzzleAndSolutions = null;
    this.words = null;
    this.columns.clear();

    String absoluteFilePath = facesContext.getExternalContext().getRealPath(relativePath);
    CrosswordGenerator cwGen =
        new CrosswordGenerator(Paths.get(absoluteFilePath), new Board(rows, cols));
    cwGen.generate(density, shortestWordLength);
    this.words = cwGen.getPuzzleAndSolutions().getWords();
    this.puzzleAndSolutions = cwGen.getPuzzleAndSolutions();

    // According to this thread:
    // https://stackoverflow.com/questions/34449826/iteration-over-array-of-primitives-using-uirepeat
    // primitive types does not render correctly on JSF.
    // Must convert the data type first.

    for (int i = 0; i < this.cols; i++) {
      this.columns.add(i);
    }

    // TODO

    renderResult = true;
    showWaitingMsg = false;
  }

  public void showSolution() {
    this.renderSolution = true;
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

  public List<String> getWords() {
    return words;
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

  public List<Integer> getColumns() {
    return columns;
  }

  public boolean isRenderResult() {
    return renderResult;
  }

  public boolean isRenderSolution() {
    return renderSolution;
  }

  public boolean isShowWaitingMsg() {
    return showWaitingMsg;
  }
}
