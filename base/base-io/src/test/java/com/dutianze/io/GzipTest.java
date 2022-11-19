package com.dutianze.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/19
 */
public class GzipTest {

  @Test
  void compressGzip() {
    assertDoesNotThrow(() -> {
      Path source = Paths.get("src/test/resources/google.png");
      Path target = Paths.get("src/test/resources/google.png.gz");

      try (GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(target.toFile()))) {
        Files.copy(source, gos);
      }
    });
  }

  @Test
  void decompressGzip() {
    assertDoesNotThrow(() -> {
      Path source = Paths.get("src/test/resources/google.png.gz");
      Path target = Paths.get("src/test/resources/google-decompress.png");

      try (GZIPInputStream gis = new GZIPInputStream(new FileInputStream(source.toFile()))) {
        Files.copy(gis, target);
      }
    });
  }
}
