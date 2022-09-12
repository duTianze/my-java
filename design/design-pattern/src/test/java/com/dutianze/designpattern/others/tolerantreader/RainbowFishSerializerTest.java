package com.dutianze.designpattern.others.tolerantreader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dutianze.designpattern.others.tolerantreader.model.RainbowFish;
import com.dutianze.designpattern.others.tolerantreader.model.RainbowFishV2;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * @author dutianze
 * @date 2022/8/21
 */
class RainbowFishSerializerTest {

  @TempDir
  static Path testFolder;

  @BeforeEach
  void beforeEach() {
    assertTrue(Files.isDirectory(testFolder));
  }

  private static final RainbowFish V1 = new RainbowFish("version1", 1, 2, 3);
  private static final RainbowFishV2 V2 = new RainbowFishV2("version2", 4, 5, 6, true, false, true);


  @Test
  void writeV1ReadV1() throws Exception {
    final Path outputPath = Files.createFile(testFolder.resolve("outputFile"));
    RainbowFishSerializer.writeV1(V1, outputPath.toString());

    final RainbowFish fish = RainbowFishSerializer.readV1(outputPath.toString());

    assertNotSame(V1, fish);
    assertEquals(V1.getName(), fish.getName());
    assertEquals(V1.getAge(), fish.getAge());
    assertEquals(V1.getLengthMeters(), fish.getLengthMeters());
    assertEquals(V1.getWeightTons(), fish.getWeightTons());
  }

  @Test
  void writeV2ReadV1() throws Exception {
    final Path outputPath = Files.createFile(testFolder.resolve("outputFile2"));
    RainbowFishSerializer.writeV2(V2, outputPath.toString());

    final RainbowFish fish = RainbowFishSerializer.readV1(outputPath.toString());

    assertNotSame(V2, fish);
    assertEquals(V2.getName(), fish.getName());
    assertEquals(V2.getAge(), fish.getAge());
    assertEquals(V2.getLengthMeters(), fish.getLengthMeters());
    assertEquals(V2.getWeightTons(), fish.getWeightTons());
  }
}