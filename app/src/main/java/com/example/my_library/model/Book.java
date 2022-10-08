package com.example.my_library.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String name,description, imageUrl;
    private List<String> authors;
    private int pages;
    private Long id;

    public Book(JSONObject jsonObject) throws JSONException {
        this.name = jsonObject.getString("title");
        this.authors = jsonArrayAuthors(jsonObject.getJSONArray("authors"));
        this.description = jsonObject.getString("shortDescription");
        this.imageUrl = jsonObject.getString("thumbnailUrl");
        this.id = jsonObject.getLong("isbn");
        this.pages = jsonObject.getInt("pageCount");
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthor() {
        return authors;
    }

    public void setAuthor(List<String> author) {
        this.authors = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    private static List<String> jsonArrayAuthors(JSONArray jsonArray) throws JSONException {
        ArrayList<String> authors = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            authors.add(jsonArray.getJSONArray(i).toString());
        }
        return authors;
    }

    public static List<Book> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            books.add(new Book(jsonArray.getJSONObject(i)));
        }

        return books;
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + authors + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", id=" + id +
                ", pages=" + pages +
                '}';
    }

}
