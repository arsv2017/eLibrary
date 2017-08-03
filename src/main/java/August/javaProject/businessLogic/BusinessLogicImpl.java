package August.javaProject.businessLogic;

import August.javaProject.dataBase.DataBase;
import August.javaProject.dataBase.DataBaseImpl;
import August.javaProject.domain.Book;

/**
 * Created by SynMobUsr on 7/24/2017.
 */
public class BusinessLogicImpl implements BusinessLogic {

    DataBaseImpl dataBase;
    BookEntryValidator validator;


    public BusinessLogicImpl(DataBaseImpl dataBase, BookEntryValidator validator) {
        this.dataBase = dataBase;
        this.validator = validator;

    }


    public boolean donateBook(String title, String author, int pubYear) {

        validator.validateTitle(title);






    }
}