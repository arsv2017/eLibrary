package August.javaProject.Views;

import August.javaProject.businessLogic.FindBookByTitleService;
import August.javaProject.businessLogic.api.Error;
import August.javaProject.businessLogic.api.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 * Created by SynMobUsr on 8/21/2017.
 */
public class FindBookByTitleView implements Views {

    @Autowired
    FindBookByTitleService findBookByTitleService;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the book you want to find");
        String title = sc.nextLine();


///////////////////////////////BL//////////////////////////////////
        Response response = findBookByTitleService.findBookByTitle(title);

////////////////////////////////BL////////////////////////////////////////


        if (!response.isSuccess()) {
            for (Error error : response.getErrorList()) {
                System.out.println(error.getField() + "    " + error.getErrorMessage());
            }

        } else {
            System.out.println("Thanks. Your book is added to eLibrary");
        }
    }
}


