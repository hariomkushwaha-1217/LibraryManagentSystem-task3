package service;

import model.Book;
import model.User;
import java.util.*;

public class Library {
    private List<Book> books;
    private Map<Integer, User> users;

    public Library() {
        books = new ArrayList<>();
        users = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void registerUser(User user) {
        users.put(user.getUserId(), user);
        System.out.println("User registered: " + user.getName());
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (!users.containsKey(userId)) {
            System.out.println("User not found!");
            return;
        }
        if (book.isIssued()) 
            System.out.println("Book already issued.");
        else 
            book.issue();
            System.out.println("Book issued to " + users.get(userId).getName());
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.isIssued()) {
            book.returned();
            System.out.println("Book returned: " + book.getTitle());
        } else
            System.out.println("Book is not issued or doesn't exist.");
    }

    public void listBooks() {
        System.out.println("Library Books:");
        for (Book b : books) {
            System.out.println(" - " + b);
        }
    }

    private Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) 
            		return b;
        }
        return null;
    }
}
