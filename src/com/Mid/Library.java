package com.Mid;

class Book {
    String title;
    int totalCopies;
    int issuedCopies;

    Book(String title, int totalCopies) {
        this.title = title;
        this.totalCopies = totalCopies;
        this.issuedCopies = 0;
    }

    void issueBook() {
        if (issuedCopies < totalCopies) {
            issuedCopies++;
            System.out.println(title + " issued successfully.");
        } else {
            System.out.println("No copies available for " + title + ".");
        }
    }

    void returnBook() {
        if (issuedCopies > 0) {
            issuedCopies--;
            System.out.println(title + " returned successfully.");
        } else {
            System.out.println("No book to return for " + title + ".");
        }
    }

    void displayStatus() {
        System.out.println("Book: " + title);
        System.out.println("Available copies: " + (totalCopies - issuedCopies));
        System.out.println("Issued copies: " + issuedCopies);
    }
}

class Library {
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", 3);

        b1.displayStatus();
        b1.issueBook();
        b1.issueBook();
        b1.displayStatus();
        b1.returnBook();
        b1.displayStatus();
    }
}

