package com.example.my_library.utilities;

import com.example.my_library.model.Book;

import java.util.ArrayList;

public class Utils {
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentBooks;
    private static ArrayList<Book> toRead;
    private static ArrayList<Book> finishedBooks;

    public Utils() {
        if(allBooks == null){
            allBooks = new ArrayList<>();
            initAllBooks();
        }

        if(currentBooks == null){
            currentBooks = new ArrayList<>();
            initAllBooks();
        }

        if (null == toRead){
            toRead = new ArrayList<>();

        }

        if (null == finishedBooks){
            finishedBooks = new ArrayList<>();
        }
    }

    private static void initAllBooks(){
        //TODO: initialize all array books here
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentBooks() {
        return currentBooks;
    }

    public static ArrayList<Book> getToRead() {
        return toRead;
    }

    public static ArrayList<Book> getFinishedBooks() {
        return finishedBooks;
    }

    public boolean addCurrReadingBooks(Book book){
        return currentBooks.add(book);
    }

    public boolean addToReadBooks(Book book){
        return toRead.add(book);
    }

    public boolean addFinishedBooks(Book book){
        return finishedBooks.add(book);
    }

    public boolean removeCurrReadingBooks(Book book){
        return currentBooks.remove(book);
    }

    public boolean removeToReadBooks(Book book){
        return toRead.remove(book);
    }

    public boolean removeFinishedBooks(Book book){
        return finishedBooks.remove(book);
    }
}
