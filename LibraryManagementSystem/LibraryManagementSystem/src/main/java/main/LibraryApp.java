package main;

import model.Book;
import model.User;
import service.Library;

public class LibraryApp {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(new Book(1, "Java Basics", "James Gosling"));
        lib.addBook(new Book(2, "Effective Java", "Joshua Bloch"));

        lib.registerUser(new User(101, "Hari Om"));
        lib.registerUser(new User(102, "Amit"));

        lib.listBooks();

        lib.issueBook(1, 101);
        lib.issueBook(2, 999);
        lib.issueBook(2, 102);
        lib.issueBook(1, 102);

        lib.returnBook(1);
        lib.returnBook(2);

        lib.listBooks();
    }
}
