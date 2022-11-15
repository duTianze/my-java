package com.dutianze.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/15
 */
@Slf4j
public class FileCopyTest {

  private final String FILE_DIR_FROM = "src/test/resources/fileCopyFrom.txt";
  private final Path FILE_FROM_PATH = Paths.get(FILE_DIR_FROM);

  private final String DIR_TARGET = "src/test/resources/fileCopyTarget.txt";
  private final Path TARGET_PATH = Paths.get(DIR_TARGET);

  @BeforeEach
  public void cleanUpFiles() throws IOException {
    Files.deleteIfExists(FILE_FROM_PATH);
    Files.createFile(FILE_FROM_PATH);

    Files.deleteIfExists(TARGET_PATH);
  }

  @Test
  void copyFileCommonIO() {
    assertDoesNotThrow(() -> {
      File fromFile = FILE_FROM_PATH.toFile();
      File toFile = TARGET_PATH.toFile();

      FileUtils.copyFile(fromFile, toFile);
    });
  }

  @Test
  void copyFileNIO() {
    assertDoesNotThrow(() -> {
      // if toFile folder doesn't exist, Files.copy throws NoSuchFileException
      Path parent = TARGET_PATH.getParent();
      if (parent != null && Files.notExists(parent)) {
        Files.createDirectories(parent);
      }

      // default - if toFile exist, throws FileAlreadyExistsException
      Files.copy(FILE_FROM_PATH, TARGET_PATH);

      // if toFile exist, replace it.
      Files.copy(FILE_FROM_PATH, TARGET_PATH, StandardCopyOption.REPLACE_EXISTING);

      // multiple StandardCopyOption
      CopyOption[] options = {
          StandardCopyOption.REPLACE_EXISTING,
          StandardCopyOption.COPY_ATTRIBUTES,
          LinkOption.NOFOLLOW_LINKS
      };

      Files.copy(FILE_FROM_PATH, TARGET_PATH, options);
    });
  }

  @Test
  void copyFilePlainJava() {
    assertDoesNotThrow(() -> {
      try (InputStream inputStream = new FileInputStream(FILE_FROM_PATH.toFile());
          OutputStream outputStream = new FileOutputStream(TARGET_PATH.toFile())) {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
          outputStream.write(buffer, 0, length);
          outputStream.flush();
        }
      }
    });
  }
}
