package com.dutianze.designpattern.concurrency.versionnumber.repository.impl;

import com.dutianze.designpattern.concurrency.versionnumber.entity.Book;
import com.dutianze.designpattern.concurrency.versionnumber.exception.BookDuplicateException;
import com.dutianze.designpattern.concurrency.versionnumber.exception.BookNotFoundException;
import com.dutianze.designpattern.concurrency.versionnumber.exception.VersionMismatchException;
import com.dutianze.designpattern.concurrency.versionnumber.repository.BookRepository;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/15
 */
public class BookRepositoryImpl implements BookRepository {

  private final Map<Long, Book> collection = new HashMap<>();

  @Override
  public void add(Book book) throws BookDuplicateException {
    if (collection.containsKey(book.getId())) {
      throw new BookDuplicateException("Duplicated book with id: " + book.getId());
    }

    collection.put(book.getId(), new Book(book));
  }

  @Override
  public void update(Book book) throws BookNotFoundException, VersionMismatchException {
    if (!collection.containsKey(book.getId())) {
      throw new BookNotFoundException("Not found book with id: " + book.getId());
    }

    Book latestBook = collection.get(book.getId());
    if (book.getVersion() != latestBook.getVersion()) {
      throw new VersionMismatchException(
          "Tried to update stale version " + book.getVersion()
              + " while actual version is " + latestBook.getVersion()
      );
    }

    book.setVersion(book.getVersion() + 1);

    collection.put(book.getId(), new Book(book));
  }

  @Override
  public Book get(long bookId) throws BookNotFoundException {
    if (!collection.containsKey(bookId)) {
      throw new BookNotFoundException("Not found book with id: " + bookId);
    }

    return new Book(collection.get(bookId));
  }
}