package com.example.rahmetex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NetworkRepository implements IRepository {

    private List<Book> books;
    private Random random;

    public NetworkRepository() {
        books = new ArrayList<>();
        random = new Random();
        initBooks();
    }

    private void initBooks() {
        books.add(new Book("Порог", 370, 1445));
        books.add(new Book("Грехи отцов отпустят дети", 220, 1710));
        books.add(new Book("Убийство командора", 400, 2360));
        books.add(new Book("Зулейха открывает глаза", 450, 1445));
        books.add(new Book("Наполеонов обоз", 390, 2360));
        books.add(new Book("Махинация", 330, 1473));
        books.add(new Book("Тонкое искусство пофигизма", 180, 1769));
    }

    @Override
    public List<Book> getRandomBookList() {
        List<Book> randomBooks = new ArrayList<>();
        while (randomBooks.size() < 3) {
            int index = random.nextInt(books.size());
            boolean f = true;
            for (Book b : randomBooks) {
                if (books.get(index).compareTo(b) == 0) {
                    f = false;
                    break;
                }
            }
            if (f) {
                randomBooks.add(books.get(index));
            }
        }
        return randomBooks;
    }
}
