package August.javaProject;

import August.javaProject.Views.DonateBookView;
import August.javaProject.Views.Views;
import August.javaProject.businessLogic.BookEntryValidator;
import August.javaProject.businessLogic.BusinessLogic;
import August.javaProject.businessLogic.BusinessLogicImpl;
import August.javaProject.dataBase.DataBase;
import August.javaProject.dataBase.DataBaseImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by SynMobUsr on 8/2/2017.
 */
public class LibraryApplication {


    public static void main(String argss[]) {

        DataBase dataBase = new DataBaseImpl();
        BookEntryValidator validator = new BookEntryValidator(dataBase);
        BusinessLogic businessLogic=new BusinessLogicImpl()

        Map<Integer, Views> comands = new HashMap<Integer, Views>();
        comands.put(1, new DonateBookView());


        while (true) {
            printLibraryMenu();
            int userSelection = getUsersSelection();
            if (userSelection >= 2 && userSelection <= 5) {
                break;
            } else {

                Views view = comands.get(userSelection);
                view.execute();
            }
        }
    }

    static void printLibraryMenu() {
        System.out.println("Library menu");
        System.out.println("1. Search book by title");
        System.out.println("2. Search book by author");
        System.out.println("3. Search book by title and author");
        System.out.println("4. Donate book to library");
        System.out.println("5. Exit library");
    }

    static Integer getUsersSelection() {
        System.out.println("Select from 1 to 5 and press Enter");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }


}
