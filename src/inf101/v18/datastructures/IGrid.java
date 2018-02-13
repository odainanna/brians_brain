package inf101.v18.datastructures;

import inf101.v18.cell.CellState;


public interface IGrid {

  /**
   * @return The height of the grid.
   */
  int getHeight();

  /**
   * @return The width of the grid.
   */
  int getWidth();

  /**
   * Set the contents of the cell in the given x,y location.
   *
   * y must be greater than or equal to 0 and less than getHeight(). x must be greater than or equal
   * to 0 and less than getWidth().
   *
   * @param x The column of the cell to change the contents of.
   * @param y The row of the cell to change the contents of.
   * @param element The contents the cell is to have.
   */
  void set(int x, int y, CellState element);

  /**
   * Get the contents of the cell in the given x,y location. If the coordinate is outside
   * of the array, the contents of the cell in the opposite part of the grid is returned.
   *
   * The grid works as if it was round.
   *
   * @param x The column of the cell to get the contents of.
   * @param y The row of the cell to get contents of.
   */
  CellState get(int x, int y);

  /**
   * Make a copy
   *
   * @return A fresh copy of the grid, with the same elements
   */
  IGrid copy();

}