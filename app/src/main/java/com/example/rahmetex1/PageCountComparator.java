package com.example.rahmetex1;

import java.util.Comparator;

public class PageCountComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        if (book1.getPagesCount() == book2.getPagesCount()) {
            return 0;
        }
        else if (book1.getPagesCount() > book2.getPagesCount()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
