package com.example.rahmetex1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DBRepository implements IRepository{

    private DBHelper dbHelper;
    private List<Book> books;
    private Random random;

    public DBRepository(Context context) {
        dbHelper = new DBHelper(context);
        books = new ArrayList<>();
        random = new Random();
        initBooks();
    }

    private void initBooks() {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_BOOKS, null, null, null, null, null, null);
        if (!cursor.moveToFirst()) {
            ContentValues contentValues = new ContentValues();

            contentValues.put(DBHelper.KEY_NAME, "HeadFirst Java");
            contentValues.put(DBHelper.KEY_PAGESCOUNT, 657);
            contentValues.put(DBHelper.KEY_PRICE, 10000);
            database.insert(DBHelper.TABLE_BOOKS, null, contentValues);
            contentValues.clear();

            contentValues.put(DBHelper.KEY_NAME, "Pro JavaFX");
            contentValues.put(DBHelper.KEY_PAGESCOUNT, 330);
            contentValues.put(DBHelper.KEY_PRICE, 12000);
            database.insert(DBHelper.TABLE_BOOKS, null, contentValues);
            contentValues.clear();

            contentValues.put(DBHelper.KEY_NAME, "Modern C++");
            contentValues.put(DBHelper.KEY_PAGESCOUNT, 500);
            contentValues.put(DBHelper.KEY_PRICE, 15000);
            database.insert(DBHelper.TABLE_BOOKS, null, contentValues);
            contentValues.clear();

            contentValues.put(DBHelper.KEY_NAME, "HeadFirst Android");
            contentValues.put(DBHelper.KEY_PAGESCOUNT, 700);
            contentValues.put(DBHelper.KEY_PRICE, 11000);
            database.insert(DBHelper.TABLE_BOOKS, null, contentValues);
            contentValues.clear();

            contentValues.put(DBHelper.KEY_NAME, "Kotlin for Android Developers");
            contentValues.put(DBHelper.KEY_PAGESCOUNT, 240);
            contentValues.put(DBHelper.KEY_PRICE, 12600);
            database.insert(DBHelper.TABLE_BOOKS, null, contentValues);
            contentValues.clear();

            contentValues.put(DBHelper.KEY_NAME, "Effective C++");
            contentValues.put(DBHelper.KEY_PAGESCOUNT, 1200);
            contentValues.put(DBHelper.KEY_PRICE, 14700);
            database.insert(DBHelper.TABLE_BOOKS, null, contentValues);
            contentValues.clear();

            contentValues.put(DBHelper.KEY_NAME, "Robinzon Kruzo");
            contentValues.put(DBHelper.KEY_PAGESCOUNT, 340);
            contentValues.put(DBHelper.KEY_PRICE, 2000);
            database.insert(DBHelper.TABLE_BOOKS, null, contentValues);
            contentValues.clear();

            contentValues.put(DBHelper.KEY_NAME, "Arthur and invinsibiles");
            contentValues.put(DBHelper.KEY_PAGESCOUNT, 380);
            contentValues.put(DBHelper.KEY_PRICE, 3200);
            database.insert(DBHelper.TABLE_BOOKS, null, contentValues);
            contentValues.clear();

            contentValues.put(DBHelper.KEY_NAME, "Abay Zholy");
            contentValues.put(DBHelper.KEY_PAGESCOUNT, 10000);
            contentValues.put(DBHelper.KEY_PRICE, 100000);
            database.insert(DBHelper.TABLE_BOOKS, null, contentValues);
            contentValues.clear();
        }
    }

    @Override
    public List<Book> getRandomBookList() {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_BOOKS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            while (books.size() < 5) {
                int count = random.nextInt(cursor.getCount());
                for (int i = 0; i < count; ++i) {
                    cursor.moveToNext();
                }
                int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                int pagesCountIndex = cursor.getColumnIndex(DBHelper.KEY_PAGESCOUNT);
                int priceIndex = cursor.getColumnIndex(DBHelper.KEY_PRICE);
                Book book = new Book(cursor.getString(nameIndex), cursor.getInt(pagesCountIndex), cursor.getInt(priceIndex));
                boolean f = true;
                for (Book b : books) {
                    if (book.compareTo(b) == 0) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    books.add(book);
                }
                cursor.moveToFirst();
            }
            return books;
        }
        return null;
    }
}
