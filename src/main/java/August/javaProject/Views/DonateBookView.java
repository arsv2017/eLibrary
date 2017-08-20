package August.javaProject.Views;

import August.javaProject.businessLogic.DonateBookService;
import August.javaProject.businessLogic.DonateBookServiceImpl;
import August.javaProject.businessLogic.api.Error;
import August.javaProject.businessLogic.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;



@Component
public class DonateBookView implements Views {

@Autowired
DonateBookService donateBookService;


    public void execute() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the name of the book you want to donate");
        String title=sc.nextLine();
        System.out.println("Enter the author of the book you want to donate");
        String author = sc.nextLine();
        System.out.println("Enter book's publication year");
        int pubYear = sc.nextInt();

///////////////////////////////BL//////////////////////////////////
      Response response= donateBookService.donateBook(title, author, pubYear);

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
