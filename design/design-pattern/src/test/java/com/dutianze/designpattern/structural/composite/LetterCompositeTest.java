package com.dutianze.designpattern.structural.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.dutianze.designpattern.structural.composite.letter.Sentence;
import com.dutianze.designpattern.structural.composite.letter.Word;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/12
 */
class LetterCompositeTest {

  private ByteArrayOutputStream stdOutBuffer = new ByteArrayOutputStream();
  private final PrintStream realStdOut = System.out;

  @BeforeEach
  void setUp() {
    this.stdOutBuffer = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOutBuffer));
  }

  @AfterEach
  void tearDown() {
    System.setOut(realStdOut);
  }

  @Test
  void testMessageFromOrcs() {
    testMessage(messageFromOrcs(), "Where there is a whip there is a way.");
  }

  private void testMessage(final LetterComposite composedMessage, final String message) {
    // Test is the composed message has the correct number of words
    final String[] words = message.split(" ");
    assertNotNull(composedMessage);
    assertEquals(words.length, composedMessage.count());

    // Print the message to the mocked stdOut ...
    composedMessage.print();

    // ... and verify if the message matches with the expected one
    assertEquals(message, new String(this.stdOutBuffer.toByteArray()).trim());
  }

  LetterComposite messageFromOrcs() {
    List<Word> words = List.of(
        new Word('W', 'h', 'e', 'r', 'e'),
        new Word('t', 'h', 'e', 'r', 'e'),
        new Word('i', 's'),
        new Word('a'),
        new Word('w', 'h', 'i', 'p'),
        new Word('t', 'h', 'e', 'r', 'e'),
        new Word('i', 's'),
        new Word('a'),
        new Word('w', 'a', 'y')
    );
    return new Sentence(words);
  }
}