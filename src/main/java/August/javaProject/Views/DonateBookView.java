package August.javaProject.Views;

import August.javaProject.businessLogic.BusinessLogicImpl;
import August.javaProject.domain.Book;

import java.util.Scanner;

/**
 * Created by SynMobUsr on 8/2/2017.
 */
public class DonateBookView implements Views {

BusinessLogicImpl businessLogic = new BusinessLogicImpl();

    public void execute() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the name of the book you want to donate");
        String title=sc.nextLine();
        System.out.println("Enter the author of the book you want to donate");
        String author = sc.nextLine();
        System.out.println("Enter book's publication year");
        int pubYear = sc.nextInt();

///////////////////////////////BL//////////////////////////////////
       businessLogic.donateBook(title, author, pubYear);

////////////////////////////////BL////////////////////////////////////////


    }
}
