package com.example.rahmetex1;

import java.util.Comparator;

public class PriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        if (book1.getPrice() == book2.getPrice()) {
            return 0;
        }
        else if (book1.getPrice() > book2.getPrice()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
