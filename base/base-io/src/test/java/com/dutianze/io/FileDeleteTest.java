package com.dutianze.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/14
 */
@Slf4j
public class FileDeleteTest {

  private final String FILE_DIR = "src/test/resources/fileDelete.txt";
  private final Path FILE_PATH = Paths.get(FILE_DIR);

  @BeforeEach
  public void setup() throws IOException {
    Files.deleteIfExists(FILE_PATH);
    Files.createFile(FILE_PATH);
  }

  @Test
  void deleteIfExistsJava7Nio() {
    assertDoesNotThrow(() -> {
      boolean result = Files.deleteIfExists(FILE_PATH);
      log.info(result ? "File is deleted!" : "Unable to delete the file.");
    });
  }

  @Test
  void deleteJava7Nio() {
    assertThrows(NoSuchFileException.class, () -> {
      Files.delete(FILE_PATH);
      Files.delete(FILE_PATH);
    });
  }

  @Test
  void deleteJavaClassic() {
    assertDoesNotThrow(() -> {
      File file = FILE_PATH.toFile();
      log.info(file.delete() ? file.getName() + " is deleted!" : "Unable to delete the file.");
    });
  }
}
