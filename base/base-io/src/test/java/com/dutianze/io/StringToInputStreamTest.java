package com.dutianze.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/17
 */
public class StringToInputStreamTest {

  @Test
  void convertStringToInputStreamTest() {
    assertDoesNotThrow(() -> {
      String content = "test";
      InputStream is = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));

      int read;
      byte[] bytes = new byte[8192];
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      while ((read = is.read(bytes)) != -1) {
        out.write(bytes, 0, read);
      }
      assertThat(out.toString()).isEqualTo(content);
    });
  }
}
