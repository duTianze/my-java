package com.dutianze.designpattern.concurrency.versionnumber.repository;

import com.dutianze.designpattern.concurrency.versionnumber.entity.Book;
import com.dutianze.designpattern.concurrency.versionnumber.exception.BookDuplicateException;
import com.dutianze.designpattern.concurrency.versionnumber.exception.BookNotFoundException;
import com.dutianze.designpattern.concurrency.versionnumber.exception.VersionMismatchException;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="https://vladmihalcea.com/jpa-entity-version-property-hibernate/">Hibernate</a></li>
 * <li><a href="https://www.elastic.co/guide/en/elasticsearch/reference/current/docs-index_.html#index-versioning">Elasticsearch</a></li>
 * <li><a href="https://lucene.apache.org/solr/guide/6_6/updating-parts-of-documents.html">Apache Solr</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/15
 */
public interface BookRepository {

  void add(Book book) throws BookDuplicateException;

  void update(Book book) throws BookNotFoundException, VersionMismatchException;

  Book get(long bookId) throws BookNotFoundException;
}
