package com.dutianze.designpattern.game.doublebuffer;

import java.util.Arrays;

/**
 * @author dutianze
 * @date 2022/9/14
 */
public class FrameBuffer implements Buffer {

  public static final int WIDTH = 10;
  public static final int HEIGHT = 8;

  private final Pixel[] pixels = new Pixel[WIDTH * HEIGHT];

  public FrameBuffer() {
    clearAll();
  }

  @Override
  public void clear(int x, int y) {
    pixels[getIndex(x, y)] = Pixel.WHITE;
  }

  @Override
  public void draw(int x, int y) {
    pixels[getIndex(x, y)] = Pixel.BLACK;
  }

  @Override
  public void clearAll() {
    Arrays.fill(pixels, Pixel.WHITE);
  }

  @Override
  public Pixel[] getPixels() {
    return pixels;
  }

  private int getIndex(int x, int y) {
    return x + WIDTH * y;
  }
}
