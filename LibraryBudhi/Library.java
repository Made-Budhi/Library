package LibraryBudhi;
import java.util.ArrayList;
import java.util.Scanner;

import LibraryBudhi.Management.Book;
import LibraryBudhi.Management.Member;

public class Library {

    Scanner scan = new Scanner(System.in);

    private ArrayList<Book> book = new ArrayList<>();
    private ArrayList<Member> member = new ArrayList<>();


    //*********** START MAIN FEATURES ***********//

    /**
     * Adding new member then storing it as
     * an object inside ArrayList member.
     */
    public void addMember() {
        System.out.printf("\nInput Member's ID : ");
        String inputId = scan.next();

        // An ID is valid when it's unique.
        boolean inputIdValid = true;

        for (int i = 0; i < this.member.size(); i++) {
            Member member = this.member.get(i);

            if (member.id.equals(inputId)) {
                inputIdValid = false;
                break;
            }

        }

        // Add the member if the ID is valid.
        if (inputIdValid) {

            Member member = new Member();

            System.out.printf("\nInput Member's Name : ");
            member.name = scan.next();
            member.id = inputId;
    
            this.member.add(member);
        } else {
            System.out.println("ID is not unique. Please re-input.");
            addMember();
        }

    }

    /**
     * Adding new book then storing it as
     * an object inside ArrayList book.
     */
    public void addBook() {
        System.out.printf("\nInput book's ID : ");
        String inputId = scan.next();

        // An ID is valid when it's unique.
        boolean inputIdValid = true;

        for (int i = 0; i < this.member.size(); i++) {
            Book book = this.book.get(i);

            if (book.id.equals(inputId)) {
                inputIdValid = false;
                break;
            }

        }

        // Add the book if the ID is valid.
        if (inputIdValid) {
            Book book = new Book();

            System.out.printf("\nInput book's Title : ");
            book.name = scan.nextLine();
            book.id = inputId;

            this.book.add(book);
        } else {
            System.out.println("ID is not unique. Please re-input.");
            addBook();
        }

    }

    /**
     * Borrowing mechanism by a member, it works by moving the book
     * data that is going to be borrowed from ArrayList book into
     * ArrayList borrowedBook (located in class Member).
     */
    public void borrowBook() {

        System.out.println("Input member ID : ");
        String inputId = scan.next();

        boolean inputIdInvalid = true;

        for (int i = 0; i < member.size(); i++) {
            Member member = this.member.get(i);

            if (member.id.equals(inputId)) {
                inputIdInvalid = false;

                System.out.printf("\nHi %s, what book would you like to borrow?\n\n", member.name);
                
                boolean bookIsInvalid = true;
                
                while (bookIsInvalid) {

                    showBooks();
                    System.out.printf("\nPlease choose the book by it's number\nInput : ");

                    try {

                        int inputBook = scan.nextInt();
                        Book book = this.book.get(inputBook-1);

                        System.out.printf("You are choosing \"%s\" to borrow. Processing...\n", book.name);
        
                        member.borrowedBooks.add(book);
                        this.book.remove(inputBook - 1);
        
                        System.out.printf("Proccess Succeed.\n");
                        bookIsInvalid = false;

                    } catch (Exception e) {

                        System.out.println("Invalid Input. please re-input.");
                        scan.nextLine();

                    }
                }
            }
        }

        if (inputIdInvalid) {
            System.out.println("ID not found. Re-input your ID?\n1. Yes, please\n2. No I'm good");
            
            int selectedMenu = scan.nextInt();

            switch (selectedMenu) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Wrong Input.");
            }
        }

    }

    /**
     * Returning book by reversing the process 
     * of the method borrowBook().
     */
    public void returnBook() {

        System.out.println("Input member ID : ");
        String inputId = scan.next();

        boolean inputIdInvalid = true;

        for (int i = 0; i < member.size(); i++) {
            Member member = this.member.get(i);

            if (member.id.equals(inputId)) {
                inputIdInvalid = false;

                if (member.borrowedBooks.isEmpty()) {
                    System.out.println("Seems like you haven't borrowed any books.");
                } else {

                    boolean bookIsInvalid = true;

                    System.out.printf("\nHi %s, here is the book that you borrowed\n\n", member.name);
                    
                    while (bookIsInvalid) {

                        for (int j=0; j < member.borrowedBooks.size(); j++) {
                            Book book = member.borrowedBooks.get(j);
                            System.out.printf("%s. %s\n", j+1, book.name);
                        }
    
                        System.out.printf("\nPlease choose the book you want to return by it's number\nInput : ");
        
                        try {

                            int inputBook = scan.nextInt();
                            Book book = member.borrowedBooks.get(inputBook-1);
            
                            System.out.printf("You are returning \"%s\". Processing...\n", book.name);
            
                            this.book.add(book);
                            member.borrowedBooks.remove(book);
            
                            System.out.printf("Proccess Succeed.\n");

                            bookIsInvalid = false;

                        } catch (Exception e) {

                            System.out.println("Input Invalid. Please re-input");
                            scan.nextLine();
                            
                        }
        
                    }
                }
            }
        }

        if (inputIdInvalid) {
            System.out.println("ID not found. Re-input your ID?\n1. Yes, please\n2. No I'm good");
            
            int selectedMenu = scan.nextInt();

            switch (selectedMenu) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Wrong Input.");
            }
        }
    }
    
    //*********** END OF MAIN FEATURES ***********//
    

    //*********** START SIDE FEATURES ***********//

    /**
     * Showing member list by looping through the ArrayList member.
     */
    public void showMembers() {
        
        int i = 0;
        System.out.println("========== MEMBERs LIST ==========");
        System.out.printf("|| %-1s || %-3s || %-10s\n", "No", "ID", "Member Name");

        for (Member member : this.member) {
            System.out.printf("|| %-2s || %-1s || %-10s\n", ++i, member.id, member.name);
        }

    }

    /**
     * Showing book list by looping through the ArrayList book.
     */
    public void showBooks() {
        
        int i = 0;
        System.out.println("========== BOOKs LIST ==========");
        System.out.printf("|| %-1s || %-3s || %-10s\n", "No", "ID", "Book Name");

        for (Book book : this.book) {
            System.out.printf("|| %-2s || %-3s || %-10s\n", ++i, book.id, book.name);
        }

    }

    /**
     * Showing books that are being borrowed by a particular member.
     * 
     * Work by looping through ArrayList borrowedBook 
     * that is owned by chosen member.
     */
    public void showBorrowedBooksByMember() {

        System.out.println("Input member ID : ");
        String inputId = scan.next();

        boolean inputIdInvalid = true;
         
        for (Member member : member) {

            if (member.id.equals(inputId)) {
                inputIdInvalid = false;

                if (member.borrowedBooks.isEmpty()) {
                    System.out.println("Seems like you haven't borrowed any books.");
                } else {
                    
                    System.out.printf("\nHi %s, here is the book that you borrowed\n\n", member.name);
                    
                    for (int j=0; j < member.borrowedBooks.size(); j++) {
                        Book book = member.borrowedBooks.get(j);
                        System.out.printf("%s. %s\n", j+1, book.name);
                    }
                }
            }
        }

        if (inputIdInvalid) {
            System.out.println("ID not found. Re-input your ID?\n1. Yes, please\n2. No I'm good");
            
            int selectedMenu = scan.nextInt();

            switch (selectedMenu) {
                case 1:
                    showBorrowedBooksByMember();
                break;

                case 2:
                break;
                
                default:
                    System.out.println("Wrong Input.");
                break;
            }
        }
    }

    /**
     * Showing books that are currently being borrowed.
     * 
     * Work by looping through ArrayList member then looping
     * one of the property owned by the object called
     * ArrayList borrowedBook.
     */
    public void showBorrowedBooksList() {

        int i = 0;

        System.out.println("Books that are being borrowed right now : \n");

        System.out.println("========== BORROWED BOOKs LIST ==========");
        System.out.printf("|| %-1s || %-3s || %-10s\n", "No", "ID", "Book Name");

        for (int j = 0; j < this.member.size(); j++) {

            Member member = this.member.get(j);

            for (Book book : member.borrowedBooks) {
                System.out.printf("|| %-2s || %-3s || %-10s\n", i+1, book.id, book.name);
            }

        }
    }
    
    //*********** END OF MAIN FEATURES ***********//

    /**
     * Ignore (Initialization Database)
     */
    public void initializationDatabase() {

        // Books Initialization
        Book book1 = new Book();
        book1.id = "001";
        book1.name = "Cara Menjadi Kaya";
        
        Book book2 = new Book();
        book2.id = "002";
        book2.name = "Mario Teguh Golden Ways";
    
        // Members Initialization
        Member member1 = new Member();
        member1.id = "001";
        member1.name = "Budhi";
        
        Member member2 = new Member();
        member2.id = "002";
        member2.name = "Mahatma";

        book.add(book1);
        book.add(book2);
        member.add(member1);
        member.add(member2);
    }
}