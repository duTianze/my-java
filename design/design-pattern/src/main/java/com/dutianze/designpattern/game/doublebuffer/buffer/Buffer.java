package com.dutianze.designpattern.game.doublebuffer.buffer;

/**
 * @author dutianze
 * @date 2022/9/14
 */
public interface Buffer {

  /**
   * Clear the pixel in (x, y).
   *
   * @param x X coordinate
   * @param y Y coordinate
   */
  void clear(int x, int y);

  /**
   * Draw the pixel in (x, y).
   *
   * @param x X coordinate
   * @param y Y coordinate
   */
  void draw(int x, int y);

  /**
   * Clear all the pixels.
   */
  void clearAll();

  /**
   * Get all the pixels.
   *
   * @return pixel list
   */
  Pixel[] getPixels();

}
