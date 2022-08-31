package com.dutianze.designpattern.concurrency.versionnumber.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/15
 */
@Data
@NoArgsConstructor
public class Book {

    private long id;
    private String title = "";
    private String author = "";

    private long version = 0;

    public Book(Book book) {
        this.id = book.id;
        this.title = book.title;
        this.author = book.author;
        this.version = book.version;
    }
}
