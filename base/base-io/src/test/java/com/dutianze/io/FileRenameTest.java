package com.dutianze.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/15
 */
public class FileRenameTest {

  private final String FROM = "src/test/resources/fileRenameFrom.txt";
  private final Path FROM_PATH = Paths.get(FROM);

  private final String TARGET = "src/test/resources/fileRenameTarget.txt";
  private final Path TARGET_PATH = Paths.get(TARGET);

  @BeforeEach
  public void cleanUpFiles() throws IOException {
    Files.deleteIfExists(FROM_PATH);
    Files.deleteIfExists(TARGET_PATH);

    Files.createFile(FROM_PATH);
  }

  @Test
  void renameFileNIO() {
    assertDoesNotThrow(() -> {
      // rename or move a file to other path
      // if target exists, throws FileAlreadyExistsException
      Files.move(FROM_PATH, TARGET_PATH);

      // if target exists, replace it.
      Files.createFile(FROM_PATH);
      Files.move(FROM_PATH, TARGET_PATH, StandardCopyOption.REPLACE_EXISTING);
    });
  }

  @Test
  void renameFileCommonIO() {
    assertDoesNotThrow(() -> {
      FileUtils.moveFile(FROM_PATH.toFile(), TARGET_PATH.toFile());
    });
  }
}
