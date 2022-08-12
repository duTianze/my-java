package com.dutianze.designpattern.behavioral.composite.letter;

import com.dutianze.designpattern.behavioral.composite.LetterComposite;

import java.util.List;

/**
 * @author dutianze
 * @date 2022/8/12
 */
public class Sentence extends LetterComposite {

    public Sentence(List<Word> words) {
        words.forEach(this::add);
    }

    @Override
    protected void printThisAfter() {
        System.out.print(".\n");
    }
}
