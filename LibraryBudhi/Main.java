package LibraryBudhi;
import LibraryBudhi.Management.*;

import java.util.Scanner;

public class Main extends Library {

    static Main main = new Main();
    static Scanner scan = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        initializationDatabase();

        String isContinue = "y";

        while (isContinue.equalsIgnoreCase("y")) {
          showMenu();
          int selectedMenu = chooseMenu();
    
          switch (selectedMenu) {
            case 1:
                main.showBooks();
                break;
            case 2:
                library.showMembers();
                break;
            case 3:
                library.addMember();
                break;
            case 4:
                library.addBook();
                break;
            case 5:
                library.borrowBook();
                break;
            case 6:
                library.returnBook();
                break;
            case 7:
                library.borrowedBooks();
                break; 
            default:
                System.out.println("Input salah.");
                break;
            }

            System.out.printf("\nKembali ke Menu?%n[Y] [N]\n");
            isContinue = scan.next();
        }

    }

    public static void showMenu() {
        System.out.printf("================================\n");

        System.out.printf("|| %-1s || Show books list\n", 1);
        System.out.printf("|| %-1s || Show members list\n", 2);
        System.out.printf("|| %-1s || Add member\n", 3);
        System.out.printf("|| %-1s || Add book\n", 4);
        System.out.printf("|| %-1s || Borrow book\n", 5);
        System.out.printf("|| %-1s || Return book\n", 6);
        System.out.printf("|| %-1s || Show borrowed book\n", 7);

        System.out.printf("================================\n");
    }

    public static int chooseMenu() {
        System.out.print("choose menu : ");
        int pilihan = scan.nextInt();
        return pilihan;
    }

    // Ignore
    public static void initializationDatabase() {
        Book book1 = new Book();
        book1.id = "1";
        book1.name = "Budhi";

        library.book.add(book1);
    }

    @Override // From class Library
    public void showMembers() {
        library.showMembers();
    }

    @Override // From class Library
    public void showBooks() {
        library.showBooks();
    }

    public void borrowBook() {
    }
    
    public void borrowedBooks() {
        
        System.out.println("1. Borrowed book(s) by particular member");
        System.out.println("2. All borrowed books list");
    
        System.out.print("\nInput : ");
        int selectedMenu = scan.nextInt();
    
        switch (selectedMenu) {
            case 1:
                borrowedBooksByMember();
                break;
            case 2:
                showBorrowedBooksList();
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }

    }
}
