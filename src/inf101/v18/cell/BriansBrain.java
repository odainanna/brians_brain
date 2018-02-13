package inf101.v18.cell;

import java.awt.Color;
import java.util.Random;

import inf101.v18.datastructures.IGrid;
import inf101.v18.datastructures.MyGrid;
import javafx.scene.control.Cell;

/**
 * An ICellAutomata that implements Conways game of life.
 *
 * @author eivind
 * @see ICellAutomaton
 *
 * Every cell has two states: Alive or Dead. Each step the state of each cell is decided from its
 * neighbors (diagonal, horizontal and lateral). If the cell has less than two alive Neighbors or
 * more than three neighbors the cell dies. If a dead cell has exactly three neighbors it will
 * become alive.
 */
public class BriansBrain implements ICellAutomaton {

  /**
   * The grid the game is played in.
   */
  IGrid currentGeneration;

  /**
   * Construct a GameOfLife ICellAutomaton using a grid with the given height and width.
   */
  public BriansBrain(int width, int height) {
    currentGeneration = new MyGrid(width, height,
        CellState.DEAD);
  }

  @Override
  public void initializeGeneration() {
    Random random = new Random();
    for (int x = 0; x < currentGeneration.getWidth(); x++) {
      for (int y = 0; y < currentGeneration.getHeight(); y++) {
        if (random.nextBoolean()) {
          currentGeneration.set(x, y, CellState.ALIVE);
        } else {
          currentGeneration.set(x, y, CellState.DEAD);
        }
      }
    }
  }

  @Override
  public int getHeight() {
    return currentGeneration.getHeight();
  }

  @Override
  public int getWidth() {
    return currentGeneration.getWidth();
  }

  @Override
  public Color getColorInCurrentGeneration(int x, int y) {
    CellState state = currentGeneration.get(x, y);
    if (state == CellState.ALIVE) {
      return new Color(0, 120, 50, 180);
    } else if (state == CellState.DYING) {
      return new Color(0, 120, 50, 80);
    } else {
      return Color.WHITE;
    }
  }

  @Override
  public void stepAutomaton() {

    IGrid nextGeneration = new MyGrid(
        currentGeneration.getWidth(), currentGeneration.getHeight(),
        CellState.ALIVE);

    for (int x = 0; x < currentGeneration.getWidth(); x++) {
      for (int y = 0; y < currentGeneration.getHeight(); y++) {
        int numNeighbours = 0;
        for (int dx = -1; dx <= 1; dx++) {
          for (int dy = -1; dy <= 1; dy++) {
            if (dx == 0 && dy == 0) {
              continue; // samme celle, hopp over
            }
            if (currentGeneration.get(x + dx, y + dy) == CellState.ALIVE) {
              numNeighbours++;
            }
          }
        }
        CellState state = currentGeneration.get(x, y);
        if (state == CellState.ALIVE) {
          nextGeneration.set(x, y, CellState.DYING);
        } else if (state == CellState.DYING) {
          nextGeneration.set(x, y, CellState.DEAD);
        } else if (state == CellState.DEAD && numNeighbours == 2) {
          nextGeneration.set(x, y, CellState.ALIVE);
        } else {
          nextGeneration.set(x, y, state);
        }
      }
    }
    currentGeneration = nextGeneration;
  }
}
