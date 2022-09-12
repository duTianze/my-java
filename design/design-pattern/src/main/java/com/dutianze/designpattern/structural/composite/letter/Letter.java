package com.dutianze.designpattern.structural.composite.letter;

import com.dutianze.designpattern.structural.composite.LetterComposite;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/12
 */
@RequiredArgsConstructor
public class Letter extends LetterComposite {

  private final char character;

  @Override
  protected void printThisBefore() {
    System.out.print(character);
  }
}
