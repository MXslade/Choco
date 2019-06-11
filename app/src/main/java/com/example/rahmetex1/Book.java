package com.example.rahmetex1;

public class Book implements Comparable<Book>{

    private int pagesCount;
    private int price;
    private String name;

    Book(String name, int pagesCount, int price) {
        this.name = name;
        this.pagesCount = pagesCount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Book book) {
        if (pagesCount == book.pagesCount && price == book.getPrice() && name.equals(book.name)) {
            return 0;
        }
        else if (pagesCount > book.pagesCount) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
