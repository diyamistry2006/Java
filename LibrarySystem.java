import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    // Book class
    static class Book {
        String title;
        String author;
        boolean isIssued;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }

        public void issueBook() {
            if (!isIssued) {
                isIssued = true;
                System.out.println(title + " issued successfully.");
            } else {
                System.out.println(title + " is already issued.");
            }
        }

        public void returnBook() {
            if (isIssued) {
                isIssued = false;
                System.out.println(title + " returned successfully.");
            } else {
                System.out.println(title + " was not issued.");
            }
        }

        public void showBookInfo() {
            System.out.println("Title: " + title + ", Author: " + author + ", Available: " + !isIssued);
        }
    }

    // User class
    static class User {
        String name;
        int userId;

        public User(String name, int userId) {
            this.name = name;
            this.userId = userId;
        }

        public void showUserInfo() {
            System.out.println("User: " + name + " (ID: " + userId + ")");
        }
    }

    // Library class
    static class Library {
        ArrayList<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
            System.out.println("Book added: " + book.title);
        }

        public void showAllBooks() {
            for (Book b : books) {
                b.showBookInfo();
            }
        }

        public Book findBook(String title) {
            for (Book b : books) {
                if (b.title.equalsIgnoreCase(title)) {
                    return b;
                }
            }
            return null;
        }
    }

    // Main method
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Add some books
        library.addBook(new Book("Java Basics", "James"));
        library.addBook(new Book("OOP Concepts", "Tom"));

        // Create a user
        User user = new User("Diya", 1);
        user.showUserInfo();

        // Menu loop
        while (true) {
            System.out.println("\n1. Show Books\n2. Issue Book\n3. Return Book\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.showAllBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    Book bookToIssue = library.findBook(issueTitle);
                    if (bookToIssue != null) bookToIssue.issueBook();
                    else System.out.println("Book not found.");
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    Book bookToReturn = library.findBook(returnTitle);
                    if (bookToReturn != null) bookToReturn.returnBook();
                    else System.out.println("Book not found.");
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
