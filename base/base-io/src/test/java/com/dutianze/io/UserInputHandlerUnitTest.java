package com.dutianze.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/11/21
 */
public class UserInputHandlerUnitTest {

  @Test
  public void givenDataInSystemInWhenCallingReadUserInputMethod_thenHaveUserInputData() {
    String[] inputLines = new String[]{
        "The first line.",
        "The second line.",
        "The last line.",
        "bye",
        "anything after 'bye' will be ignored"
    };
    String[] expectedLines = Arrays.copyOf(inputLines, inputLines.length - 2);
    List<String> expected = Arrays.stream(expectedLines).collect(Collectors.toList());
    InputStream stdin = System.in;
    try {
      System.setIn(new ByteArrayInputStream(String.join("\n", inputLines).getBytes()));
      List<String> actual = readUserInput();
      assertThat(actual).isEqualTo(expected);
    } finally {
      System.setIn(stdin);
    }
  }

  private static List<String> readUserInput() {
    List<String> userData = new ArrayList<>();
    System.out.println("Please enter your data below: (send 'bye' to exit) ");
    Scanner input = new Scanner(System.in);
    while (true) {
      String line = input.nextLine();
      if ("bye".equalsIgnoreCase(line)) {
        break;
      }
      userData.add(line);
    }
    return userData;
  }
}
