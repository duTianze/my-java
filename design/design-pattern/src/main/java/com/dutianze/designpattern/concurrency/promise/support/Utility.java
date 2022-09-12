package com.dutianze.designpattern.concurrency.promise.support;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/31
 */
@Slf4j
public class Utility {

  public static Map<Character, Long> characterFrequency(String fileLocation) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation))) {
      return bufferedReader.lines()
          .flatMapToInt(String::chars)
          .mapToObj(x -> (char) x)
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return Collections.emptyMap();
  }

  public static Character lowestFrequencyChar(Map<Character, Long> charFrequency) {
    return charFrequency
        .entrySet()
        .stream()
        .min(Comparator.comparingLong(Map.Entry::getValue))
        .map(Map.Entry::getKey)
        .orElseThrow();
  }

  public static Integer countLines(String fileLocation) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation))) {
      return (int) bufferedReader.lines().count();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return 0;
  }

  public static String downloadFile(String urlString) throws IOException {
    log.info("Downloading contents from url: {}", urlString);
    URL url = new URL(urlString);
    File file = File.createTempFile("promise_pattern", null);
    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(url.openStream()));
        FileWriter writer = new FileWriter(file)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        writer.write(line);
        writer.write("\n");
      }
      log.info("File downloaded at: {}", file.getAbsolutePath());
      return file.getAbsolutePath();
    }
  }
}
