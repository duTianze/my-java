package com.dutianze.designpattern.game.doublebuffer;

import com.dutianze.designpattern.game.doublebuffer.buffer.Buffer;
import com.dutianze.designpattern.game.doublebuffer.buffer.FrameBuffer;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;

/**
 * <h2 id="credits">Credits</h2>
 * <ul>
 * <li><a href="http://gameprogrammingpatterns.com/double-buffer.html">Game Programming Patterns - Double Buffer</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/9/14
 */
@Slf4j
public class Scene {

  private final Buffer[] frameBuffers;

  private int current;

  private int next;

  public Scene() {
    frameBuffers = new FrameBuffer[2];
    frameBuffers[0] = new FrameBuffer();
    frameBuffers[1] = new FrameBuffer();
    current = 0;
    next = 1;
  }

  /**
   * Draw the next frame.
   *
   * @param coordinateList list of pixels of which the color should be black
   */
  public void draw(List<? extends Pair<Integer, Integer>> coordinateList) {
    log.info("Start drawing next frame");
    log.info("Current buffer: " + current + " Next buffer: " + next);
    frameBuffers[next].clearAll();
    coordinateList.forEach(coordinate -> {
      Integer x = coordinate.getKey();
      Integer y = coordinate.getValue();
      frameBuffers[next].draw(x, y);
    });
    log.info("Swap current and next buffer");
    swap();
    log.info("Finish swapping");
    log.info("Current buffer: " + current + " Next buffer: " + next);
  }

  public Buffer getBuffer() {
    log.info("Get current buffer: " + current);
    return frameBuffers[current];
  }

  private void swap() {
    current = current ^ next;
    next = current ^ next;
    current = current ^ next;
  }
}

