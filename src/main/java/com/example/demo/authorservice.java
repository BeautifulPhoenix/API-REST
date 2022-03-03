package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Authorservice {

    static List<Author> authors = new ArrayList<Author>();
    static {
        // int id, String name, String country, int dob, int qtyBooks, Boolean alive
        Author author1 = new Author(1, "Juan", "Barcelona", 1896, 2564, true);
        Author author2 = new Author(2, "Felipe", "Madrid", 1896, 2564, true);
        Author author3 = new Author(3, "Alberto", "Huelva", 1896, 2564, true);

        authors.add(author3);
        authors.add(author2);
        authors.add(author1);
    }

    // querry authors to array
    public List<Author> querryAuthorsFromArray() {

        return authors;
    }

    // add to Array
    public Author addAuthorToArray(Author author) {
        authors.add(author);
        return author;
    }

    // delete author from Array
    public String deleteAuthorFromArray(String index) {
        authors.remove(index);

        return "Author deleted by index";
    }

    // Search Authors by Tilte
    public int findAuthorByName(String name) {
        int index = -1;
        for (Author Authortemp : authors) {

            if (Authortemp.getname().equals(name)) {
                index = authors.indexOf(Authortemp);

            }

        }
        return index;
    }

    // Replace Author
    public Author replaceAuthor(int indexAuthor, Author author) {

        authors.set(indexAuthor, author);

        return author;

    }

    public Author getAuthorByIndex(int index) {
        Author author = authors.get(index);

        return author;
    }

    public Iterable<Author> queryauthor() {
        return null;
    }

}