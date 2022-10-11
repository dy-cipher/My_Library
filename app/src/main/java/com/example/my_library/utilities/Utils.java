package com.example.my_library.utilities;

import com.example.my_library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static List<Book> allBooks;
    private static List<Book> currentBooks;
    private static List<Book> toRead;
    private static List<Book> finishedBooks;

    public Utils() {
        if(allBooks == null){
            allBooks = new ArrayList<>();

        }

        if(currentBooks == null){
            currentBooks = new ArrayList<>();

        }

        if (null == toRead){
            toRead = new ArrayList<>();

        }

        if (null == finishedBooks){
            finishedBooks = new ArrayList<>();
        }
    }

    public void initAllBooks(List<Book> books){
        //TODO: initialize all array books here
        allBooks = new ArrayList<>();
        allBooks.addAll(books);

    }

    public static List<Book> getAllBooks() {
        return allBooks;
    }

    public static List<Book> getCurrentBooks() {
        return currentBooks;
    }

    public static List<Book> getToRead() {
        return toRead;
    }

    public static List<Book> getFinishedBooks() {
        return finishedBooks;
    }

    public static boolean addCurrReadingBooks(Book book){
        return currentBooks.add(book);
    }

    public static boolean addToReadBooks(Book book){
        return toRead.add(book);
    }

    public static boolean addFinishedBooks(Book book){
        return finishedBooks.add(book);
    }

    public static boolean removeCurrReadingBooks(Book book){
        return currentBooks.remove(book);
    }

    public static boolean removeToReadBooks(Book book){
        return toRead.remove(book);
    }

    public static boolean removeFinishedBooks(Book book){
        return finishedBooks.remove(book);
    }
}
