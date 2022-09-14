package com.dutianze.designpattern.game.doublebuffer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.dutianze.designpattern.game.doublebuffer.buffer.Buffer;
import com.dutianze.designpattern.game.doublebuffer.buffer.FrameBuffer;
import com.dutianze.designpattern.game.doublebuffer.buffer.Pixel;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.MutablePair;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/9/15
 */
@Slf4j
class SceneTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      final Scene scene = new Scene();
      List<MutablePair<Integer, Integer>> drawPixels1 = List.of(
          new MutablePair<>(1, 1),
          new MutablePair<>(5, 6),
          new MutablePair<>(3, 2)
      );
      scene.draw(drawPixels1);
      Buffer buffer1 = scene.getBuffer();
      printBlackPixelCoordinate(buffer1);

      List<MutablePair<Integer, Integer>> drawPixels2 = List.of(
          new MutablePair<>(3, 7),
          new MutablePair<>(6, 1)
      );
      scene.draw(drawPixels2);
      Buffer buffer2 = scene.getBuffer();
      printBlackPixelCoordinate(buffer2);
    });
  }

  private static void printBlackPixelCoordinate(Buffer buffer) {
    StringBuilder stringBuilder = new StringBuilder("Black Pixels: ");
    Pixel[] pixels = buffer.getPixels();
    for (int i = 0; i < pixels.length; ++i) {
      if (pixels[i] == Pixel.BLACK) {
        int y = i / FrameBuffer.WIDTH;
        int x = i % FrameBuffer.WIDTH;
        stringBuilder.append(" (").append(x).append(", ").append(y).append(")");
      }
    }
    log.info(stringBuilder.toString());
  }
}