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
    LetterComposite composedMessage = messageFromOrcs();
    String message = "Where there is a whip there is a way.";

    final String[] words = message.split(" ");
    assertNotNull(composedMessage);
    assertEquals(words.length, composedMessage.count());

    composedMessage.print();

    assertEquals(message, this.stdOutBuffer.toString().trim());
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