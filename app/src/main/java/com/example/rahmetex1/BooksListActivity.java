package com.example.rahmetex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BooksListActivity extends AppCompatActivity {

    private List<Book> books;
    private DBRepository dbRepository;
    private NetworkRepository networkRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        dbRepository = new DBRepository(this);
        networkRepository = new NetworkRepository();

        try {
            initBooks();
        } catch (NetworkException e) {
            Log.d("mLogs", e.toString());
        }

        initRecyclerView();
    }

    private void initBooks() throws NetworkException{
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            books = networkRepository.getRandomBookList();
            Collections.sort(books, new PriceComparator());
        }
        else {
            books = dbRepository.getRandomBookList();
            Collections.sort(books, new PageCountComparator());
            throw new NetworkException(1);
        }
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.booksRecyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(books);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
