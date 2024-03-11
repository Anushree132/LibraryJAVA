package models;

import java.util.ArrayList;

public class Avai_books {
    ArrayList<String> availableBooks;
    public Avai_books() {
        availableBooks = new ArrayList<>();
        availableBooks.add("The Great Gatsby");
        availableBooks.add("The Picture of Dorian Gray");
        availableBooks.add("Wuthering Heights");
        availableBooks.add("Great Expectations");
        availableBooks.add("The Kite Runner");
    }

    public void viewBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < 5 && i < availableBooks.size(); i++) {
            System.out.println((i + 1) + ". " + availableBooks.get(i));
        }
    }

}
