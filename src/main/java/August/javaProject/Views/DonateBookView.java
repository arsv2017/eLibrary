package August.javaProject.Views;

import August.javaProject.businessLogic.BusinessLogic;
import August.javaProject.businessLogic.BusinessLogicImpl;
import August.javaProject.businessLogic.api.Error;
import August.javaProject.businessLogic.api.Response;
import August.javaProject.domain.Book;

import java.util.Scanner;

/**
 * Created by SynMobUsr on 8/2/2017.
 */
public class DonateBookView implements Views {

BusinessLogic businessLogic;


public DonateBookView(BusinessLogic businessLogic){

    this.businessLogic=businessLogic;

}


    public void execute() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the name of the book you want to donate");
        String title=sc.nextLine();
        System.out.println("Enter the author of the book you want to donate");
        String author = sc.nextLine();
        System.out.println("Enter book's publication year");
        int pubYear = sc.nextInt();

///////////////////////////////BL//////////////////////////////////
      Response response= businessLogic.donateBook(title, author, pubYear);

////////////////////////////////BL////////////////////////////////////////


        if(!response.isSuccess()){
            for(Error error: response.getErrorList()){
                System.out.println(error.getField()+"    "+error.getErrorMessage());
            }

        } else {
            System.out.println("Thanks. Your book is added to eLibrary");
        }
    }
}
