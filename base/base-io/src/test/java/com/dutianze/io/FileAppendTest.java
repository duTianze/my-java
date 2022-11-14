package com.dutianze.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/13
 */
@Slf4j
public class FileAppendTest {

  private final String FILE_DIR = "src/test/resources/fileAppend.txt";
  private final String CONTENT = "append";

  @BeforeEach
  public void cleanUpFiles() {
    Path.of(FILE_DIR).toFile().delete();
  }

  @Test
  void appendFileByFiles() {
    // java 11
    assertDoesNotThrow(() -> {
      Files.writeString(Paths.get(FILE_DIR), CONTENT,
          StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    });
  }

  @Test
  void appendFileByFilesIterable() {
    // java 1.8
    assertDoesNotThrow(() -> {
      Files.write(Paths.get(FILE_DIR), List.of("append1", "append2"),
          StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    });
  }

  @Test
  void appendFileByFileWriter() {
    // java 1.1
    assertDoesNotThrow(() -> {
      try (FileWriter fw = new FileWriter(FILE_DIR, true);
          BufferedWriter bw = new BufferedWriter(fw)) {
        bw.write(CONTENT);
        bw.newLine();
      }
    });
  }

  @Test
  void appendFileByFileOutputStream() {
    // java 1.1
    assertDoesNotThrow(() -> {
      try (FileOutputStream fos = new FileOutputStream(FILE_DIR, true)) {
        fos.write(CONTENT.getBytes(StandardCharsets.UTF_8));
      }
    });
  }

  @Test
  void appendFileByFileUtils() {
    // apache
    assertDoesNotThrow(() -> {
      FileUtils.writeStringToFile(new File(FILE_DIR), CONTENT, StandardCharsets.UTF_8, true);
    });
  }
}
