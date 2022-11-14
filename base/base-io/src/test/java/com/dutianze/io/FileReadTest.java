package com.dutianze.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/14
 */
@Slf4j
public class FileReadTest {

  private final Path FILE_PATH = Paths.get("src/test/resources/fileRead.txt");


  @Test
  void readFileJava8() {
    assertDoesNotThrow(() -> {
      // foreach
      System.out.println("foreach");
      try (Stream<String> lines = Files.lines(FILE_PATH)) {
        lines.forEach(log::info);
      }

      System.out.println();

      // parallel
      System.out.println("parallel");
      try (Stream<String> lines = Files.lines(FILE_PATH)) {
        lines.parallel().forEach(log::info);
      }

      // preserve order
      System.out.println("for parallel, preserve order");
      try (Stream<String> lines = Files.lines(FILE_PATH)) {
        lines.parallel().forEachOrdered(log::info);
      }
    });
  }
}
