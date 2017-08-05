package August.javaProject.businessLogic;


import August.javaProject.businessLogic.api.Error;
import August.javaProject.businessLogic.api.Response;
import August.javaProject.dataBase.DataBaseImpl;
import August.javaProject.domain.Book;

import java.util.List;


public class BusinessLogicImpl implements BusinessLogic {

    DataBaseImpl dataBase;
    BookEntryValidator validator;


    public BusinessLogicImpl(DataBaseImpl dataBase, BookEntryValidator validator) {
        this.dataBase = dataBase;
        this.validator = validator;

    }


    public Response donateBook(String title, String author, int pubYear) {

        List<Error> errorList = validator.validate(title, author, pubYear);

        if (!errorList.isEmpty()) {
            return new Response(false, errorList);

        }

        dataBase.saveNewBookInLibrary(new Book(title, author, pubYear));
        return new Response(true, null);
    }
}