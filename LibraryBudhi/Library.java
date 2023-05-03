package LibraryBudhi;
import java.util.ArrayList;
import java.util.Scanner;

import LibraryBudhi.Management.Book;
import LibraryBudhi.Management.Member;
import LibraryBudhi.Management.BorrowedBook;

public class Library {

    Scanner scan = new Scanner(System.in);

    ArrayList<Book> book = new ArrayList<>();
    ArrayList<Member> member = new ArrayList<>();

    //*********** START MAIN FEATURES ***********//
    public void addMember() {
        Member member = new Member();
        System.out.printf("\nInput Member's ID : ");
        member.id = scan.next();

        System.out.printf("\nInput Member's Name : ");
        member.name = scan.next();

        this.member.add(member);
    }

    public void addBook() {
        Book book = new Book();
        System.out.printf("\nInput book's ID : ");
        book.id = scan.next();

        System.out.printf("\nInput book's Title : ");
        book.name = scan.next();

        this.book.add(book);
    }

    public void borrowBook() {

    }

    public void returnBook() {

    }
    //*********** END OF MAIN FEATURES ***********//
    

    //*********** START SIDE FEATURES ***********//
    public void showMembers() {
        
        int i = 0;
        System.out.println("========== MEMBERs LIST ==========");
        System.out.printf("|| %-1s || %-3s || %-10s", "No", "ID", "Member Name\n");

        for (Member showBook : this.member) {
            System.out.printf("|| %-2s || %-1s || %-10s\n", ++i, showBook.id, showBook.name);
        }

    }

    public void showBooks() {
        
        int i = 0;
        System.out.println("========== BOOKs LIST ==========");
        System.out.printf("|| %-1s || %-3s || %-10s", "No", "ID", "Book Name\n");

        for (Book showBook : this.book) {
            System.out.printf("|| %-2s || %-3s || %-10s\n", ++i, showBook.id, showBook.name);
        }

    }

    public void borrowedBooksByMember() {

    }

    public void showBorrowedBooksList() {
        
    }
    //*********** END OF MAIN FEATURES ***********//
}
