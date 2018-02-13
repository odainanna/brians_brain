package inf101.v18.datastructures;

import static org.junit.Assert.*;

import java.util.Random;

import javafx.scene.control.Cell;
import org.junit.Test;

import inf101.v18.cell.CellState;

public class RoundGridTest {

  Random random = new Random();

  @Test
  public void constructTest1() {
    IGrid grid = new MyGrid(10, 11, CellState.DEAD);
    assertEquals(grid.getWidth(), 10);
    assertEquals(grid.getHeight(), 11);
  }

  /**
   * Tests that trying to access outside of the dimensions of the grid throws an
   * IndexOutOfBoundsException.
   */

  @Test
  public void leftTest() {
    int width = 10;
    int height = 10;
    int x;
    int y;

    x = -1;
    y = 1;
    IGrid grid = new MyGrid(width, height, CellState.DEAD);
    grid.set(x, y, CellState.DYING);
    assertEquals(grid.get(x, y), CellState.DYING);
  }

  @Test
  public void rightTest() {
    int width = 10;
    int height = 10;
    int x;
    int y;

    x = width;
    y = 1;
    IGrid grid = new MyGrid(width, height, CellState.DEAD);
    grid.set(x, y, CellState.DYING);
    assertEquals(grid.get(x, y), CellState.DYING);
  }

  @Test
  public void aboveTest() {
    int width = 10;
    int height = 10;
    int x;
    int y;
    IGrid grid = new MyGrid(width, height, CellState.DEAD);
    x = 1;
    y = -1;
    grid.set(x, y, CellState.DYING);
    assertEquals(grid.get(x, y), CellState.DYING);
  }

  @Test
  public void belowTest() {
    int width = 10;
    int height = 10;
    int x;
    int y;
    IGrid grid = new MyGrid(width, height, CellState.DEAD);
    x = 1;
    y = -1;
    grid.set(x, y, CellState.DYING);
    assertEquals(grid.get(x, y), CellState.DYING);
  }


  @Test
  public void setGetTest1() {
    IGrid grid = new MyGrid(100, 100, CellState.DEAD);

    for (int x = 0; x < 100; x++) {
      for (int y = 0; y < 100; y++) {
        CellState cs = CellState.random(random);
        grid.set(x, y, cs);
        assertEquals(cs, grid.get(x, y));
      }
    }
  }

  @Test
  public void setGetTest2() {
    IGrid grid = new MyGrid(100, 100, CellState.DEAD);

    for (int x = 0; x < 100; x++) {
      for (int y = 0; y < 100; y++) {
        grid.set(x, y, CellState.random(random));
      }
    }

    for (int x = 0; x < 100; x++) {
      for (int y = 0; y < 100; y++) {
        CellState cs = CellState.random(random);
        grid.set(x, y, cs);
        assertEquals(cs, grid.get(x, y));
      }
    }
  }

  @Test
  public void copyTest() {
    IGrid grid = new MyGrid(100, 100, CellState.DEAD);

    for (int x = 0; x < 100; x++) {
      for (int y = 0; y < 100; y++) {
        CellState cs = CellState.random(random);
        grid.set(x, y, cs);
      }
    }

    IGrid newGrid = grid.copy();
    for (int x = 0; x < 100; x++) {
      for (int y = 0; y < 100; y++) {
        assertEquals(grid.get(x, y), newGrid.get(x, y));
      }
    }
  }
}

