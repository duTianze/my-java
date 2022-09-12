package com.dutianze.designpattern.structural.composite.letter;

import com.dutianze.designpattern.structural.composite.LetterComposite;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/8/12
 */
public class Word extends LetterComposite {

  public Word(List<Letter> letters) {
    letters.forEach(this::add);
  }

  public Word(char... letters) {
    for (char letter : letters) {
      this.add(new Letter(letter));
    }
  }

  @Override
  protected void printThisBefore() {
    System.out.print(" ");
  }
}
