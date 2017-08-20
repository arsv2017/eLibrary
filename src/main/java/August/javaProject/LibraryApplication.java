package August.javaProject;

import August.javaProject.Views.DonateBookView;
import August.javaProject.Views.Views;
import August.javaProject.businessLogic.config.SpringAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class LibraryApplication {


    public static void main(String args[]) {



        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        Map<Integer, Views> comands = new HashMap<Integer, Views>();
        comands.put(1, applicationContext.getBean(DonateBookView.class));


        while (true) {
            printLibraryMenu();
            int userSelection = getUserSelection();
            if (userSelection == 5) {
                break;
            } else {

                Views view = comands.get(userSelection);
                view.execute();
            }
        }
    }

    static void printLibraryMenu() {
        System.out.println("eLibrary menu");
        System.out.println("1. Donate book to library");
        System.out.println("2. Search book by title");
        System.out.println("3. Search book by author");
        System.out.println("4. Search book by title and author");
        System.out.println("5. Exit library");

    }

    static Integer getUserSelection() {
        System.out.println("Select from 1 to 5 and press Enter");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }


}
