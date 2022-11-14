package com.dutianze.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/12
 */
@Slf4j
class FileCreateTest {

  private final String FILE_DIR = "src/test/resources/fileCreate.txt";
  private final String CONTENT = "create";

  @BeforeEach
  public void cleanUpFiles() {
    Path.of(FILE_DIR).toFile().delete();
  }

  @Test
  void createFileByFile() {
    // java 1.2
    assertDoesNotThrow(() -> {
      File file = new File(FILE_DIR);
      log.info(file.createNewFile() ? "File is created!" : "File already exists.");
      // Write to file
      try (FileWriter writer = new FileWriter(file)) {
        writer.write(CONTENT);
      }
    });
  }

  @Test
  void createFileByFiles() {
    // java 1.7
    assertDoesNotThrow(() -> {
      Path path = Paths.get(FILE_DIR);
      try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
        writer.write(CONTENT);
      }
    });
  }

  @Test
  void createFileByPrintWriter() {
    // java 10
    assertDoesNotThrow(() -> {
      try (PrintWriter writer = new PrintWriter(FILE_DIR, StandardCharsets.UTF_8)) {
        writer.println(CONTENT);
      }
    });
  }

  @Test
  void createFileByFiles2() {
    // java 11
    assertDoesNotThrow(() -> {
      Files.writeString(Paths.get(FILE_DIR), CONTENT);
    });
  }
}