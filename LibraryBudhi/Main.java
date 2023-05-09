package LibraryBudhi;

import java.util.Scanner;

public class Main extends Library {

    static Main main = new Main();
    static Scanner scan = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        library.initializationDatabase();

        String isContinue = "y";

        while (isContinue.equalsIgnoreCase("y")) {
          showMenu();
          int selectedMenu = chooseMenu();
    
          switch (selectedMenu) {
            case 1:
                main.showBooks();
                break;
            case 2:
                main.showMembers();
                break;
            case 3:
                main.addMember();
                break;
            case 4:
                main.addBook();
                break;
            case 5:
                main.borrowBook();
                break;
            case 6:
                main.returnBook();
                break;
            case 7:
                main.borrowedBooks();
                break; 
            default:
                System.out.println("Input salah.");
                break;
            }

            boolean validInput = false;

            while (!validInput) {
                System.out.printf("\nBack to Menu?%n[Y] [N]\n");
                isContinue = scan.next();
                try {

                    if (isContinue.equalsIgnoreCase("y")) {
                        validInput = true;
                    } else if (isContinue.equalsIgnoreCase("n")) {
                        System.exit(0);
                    } else {
                        throw new Exception();
                    }

                } catch (Exception e) {
                    System.out.println("Invalid Input.");
                }
            }
        }
    }

    public static void showMenu() {
        System.out.printf("================================\n");

        System.out.printf("|| %-1s || Show available books list\n", 1);
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
    

    /********** OVERRIDE METHOD ************/

    @Override
    public void showMembers() {
        library.showMembers();
    }

    @Override
    public void showBooks() {
        library.showBooks();
    }

    @Override
    public void addBook() {
        library.addBook();
    }

    @Override
    public void addMember() {
        library.addMember();
    }

    @Override
    public void borrowBook() {
        library.borrowBook();
    }

    @Override
    public void returnBook() {
        library.returnBook();
    }

    public void borrowedBooks() {
        
        System.out.println("1. Borrowed books by particular member");
        System.out.println("2. All borrowed books list");
    
        System.out.print("\nInput : ");
        int selectedMenu = scan.nextInt();
    
        switch (selectedMenu) {
            case 1:
                library.showBorrowedBooksByMember();
            break;

            case 2:
                library.showBorrowedBooksList();
            break;

            default:
                System.out.println("Wrong Input. Please re-input.");
                borrowedBooks();
            break;
        }

    }
}
