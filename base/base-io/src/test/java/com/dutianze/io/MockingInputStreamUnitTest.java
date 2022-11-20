package com.dutianze.io;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/20
 */
public class MockingInputStreamUnitTest {

  @Test
  public void givenSimpleImplementationShouldProcessInputStream() throws IOException {
    int byteCount = processInputStream(new InputStream() {
      private final byte[] msg = "Hello World".getBytes();
      private int index = 0;

      @Override
      public int read() {
        if (index >= msg.length) {
          return -1;
        }
        return msg[index++];
      }
    });
    assertThat(byteCount).isEqualTo(11);
  }

  @Test
  public void givenByteArrayInputStreamShouldProcessInputStream() throws IOException {
    String msg = "Hello World";
    int bytesCount = processInputStream(new ByteArrayInputStream(msg.getBytes()));
    assertThat(bytesCount).isEqualTo(11);
  }

  @Test
  public void givenFileInputStream_shouldProcessInputStream() throws IOException {
    try (InputStream inputStream = getClass().getResourceAsStream("/hello.txt")) {
      int bytesCount = processInputStream(inputStream);
      assertThat(bytesCount).isEqualTo(11);
    }
  }

  @Test
  public void givenGeneratingInputStream_shouldProcessInputStream() throws IOException {
    InputStream inputStream = new GeneratingInputStream(1_000, "Hello World");
    int bytesCount = processInputStream(inputStream);
    assertThat(bytesCount).isEqualTo(1_000);
    inputStream.close();
  }


  int processInputStream(InputStream inputStream) throws IOException {
    int count = 0;
    while (inputStream.read() != -1) {
      count++;
    }
    return count;
  }

  static class GeneratingInputStream extends InputStream {

    private final int desiredSize;
    private int actualSize = 0;
    private final byte[] seed;

    public GeneratingInputStream(int desiredSize, String seed) {
      this.desiredSize = desiredSize;
      this.seed = seed.getBytes();
    }

    @Override
    public int read() {
      if (actualSize >= desiredSize) {
        return -1;
      }
      return seed[actualSize++ % seed.length];
    }
  }

}
