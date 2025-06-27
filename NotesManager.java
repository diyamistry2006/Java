import java.io.*;
import java.util.Scanner;

public class NotesManager {
    static final String FILE_NAME = "notes.txt";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.print("\n===== NOTES MANAGER =====\n");
            System.out.print("1. Write Note \n");
            System.out.print("2. View Notes \n");
            System.out.print("3. Clear All Notes \n");
            System.out.print("4. Exit \n");
            System.out.print("Enter your choice: \n ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> writeNote();
                case 2 -> viewNotes();
                case 3 -> clearNotes();
                case 4 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    static void writeNote() {
        System.out.print("Enter your note (type 'END' to finish):");
        StringBuilder noteBuilder = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("END")) {
            noteBuilder.append(line).append("\n");
        }

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(noteBuilder.toString());
            writer.write("-----\n"); // separator between notes
            System.out.print("Note saved successfully!");
        } catch (IOException e) {
            System.out.print("Error writing to file.");
        }
    }

    static void viewNotes() {
        System.out.print("\n--- All Notes ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean empty = true;
            while ((line = reader.readLine()) != null) {
                empty = false;
                System.out.print(line);
            }
            if (empty) {
                System.out.print("No notes found.");
            }
        } catch (IOException e) {
            System.out.print("Error reading file or file not found.");
        }
    }

    static void clearNotes() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(""); // overwrite with empty content
            System.out.println("All notes cleared.");
        } catch (IOException e) {
            System.out.println("Error clearing notes.");
        }
    }
}