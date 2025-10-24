package Task4;

import java.io.*;
import java.util.Scanner;
public class NotesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt";

        while (true) {
            System.out.println("\n===== Notes App =====");
            System.out.println("1. Write a new note");
            System.out.println("2. Read all notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    writeNoteToFile(fileName, sc);
                    break;
                case 2:
                    readNotesFromFile(fileName);
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    private static void writeNoteToFile(String fileName, Scanner sc) {
        try {
            FileWriter writer = new FileWriter(fileName, true); // true = append mode
            System.out.print("Enter your note: ");
            String note = sc.nextLine();
            writer.write(note + "\n");
            writer.close();
            System.out.println(" Note saved successfully!");
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }
    }
    private static void readNotesFromFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println(" No notes found. Start writing some notes first!");
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("\n--- Your Notes ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }
}
