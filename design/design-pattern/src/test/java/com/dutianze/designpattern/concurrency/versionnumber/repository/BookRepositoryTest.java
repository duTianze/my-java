package com.dutianze.designpattern.concurrency.versionnumber.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.dutianze.designpattern.concurrency.versionnumber.entity.Book;
import com.dutianze.designpattern.concurrency.versionnumber.exception.BookDuplicateException;
import com.dutianze.designpattern.concurrency.versionnumber.exception.BookNotFoundException;
import com.dutianze.designpattern.concurrency.versionnumber.exception.VersionMismatchException;
import com.dutianze.designpattern.concurrency.versionnumber.repository.impl.BookRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/16
 */
class BookRepositoryTest {

  private final long bookId = 1;
  private final BookRepository bookRepository = new BookRepositoryImpl();

  @BeforeEach
  public void setUp() throws BookDuplicateException {
    Book book = new Book();
    book.setId(bookId);
    bookRepository.add(book);
  }

  @Test
  void defaultVersionRemainsZeroAfterAdd() throws BookNotFoundException {
    Book book = bookRepository.get(bookId);
    assertEquals(0, book.getVersion());
  }

  @Test
  void aliceAndBobHaveDifferentVersionsAfterAliceUpdate()
      throws BookNotFoundException, VersionMismatchException {
    final Book aliceBook = bookRepository.get(bookId);
    final Book bobBook = bookRepository.get(bookId);

    aliceBook.setTitle("Kama Sutra");
    bookRepository.update(aliceBook);

    assertEquals(1, aliceBook.getVersion());
    assertEquals(0, bobBook.getVersion());

    Book actualBook = bookRepository.get(bookId);

    assertEquals(aliceBook.getVersion(), actualBook.getVersion());
    assertEquals(aliceBook.getTitle(), actualBook.getTitle());
    assertNotEquals(aliceBook.getTitle(), bobBook.getTitle());
  }

  @Test
  void throwVersionMismatchExceptionOnStaleUpdate()
      throws BookNotFoundException, VersionMismatchException {
    final Book aliceBook = bookRepository.get(bookId);
    final Book bobBook = bookRepository.get(bookId);

    aliceBook.setTitle("Kama Sutra");
    bookRepository.update(aliceBook);

    bobBook.setAuthor("Vatsyayana Mallanaga");
    try {
      bookRepository.update(bobBook);
    } catch (VersionMismatchException e) {
      assertEquals(0, bobBook.getVersion());

      Book actualBook = bookRepository.get(bookId);

      assertEquals(1, actualBook.getVersion());
      assertEquals(aliceBook.getVersion(), actualBook.getVersion());

      assertEquals("", bobBook.getTitle());
      assertNotEquals(aliceBook.getAuthor(), bobBook.getAuthor());
    }
  }
}