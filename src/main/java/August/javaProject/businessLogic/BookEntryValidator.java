package August.javaProject.businessLogic;

import August.javaProject.dataBase.DataBase;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;


/**
 * Created by SynMobUsr on 8/3/2017.
 */
public class BookEntryValidator {

    DataBase dataBase;


    public BookEntryValidator(DataBase dataBase) {
        this.dataBase = dataBase;


    }

    List<Error> validate(String title, String author, int pubYear) {
        List<Error> errorList = Lists.newArrayList();
        errorList.add(titleValidation(title).get());
        errorList.add(authorValidation(author).get());
    }


    Optional<Error> titleValidation(String title) {

        if (title.equals("") || title.equals(null)) {

            return Optional.of(new Error("Title", "Title field can not be empty"));

        }
        return Optional.empty();

    }


    Optional<Error> authorValidation(String author) {

        if (author.equals("") || author.equals(null)) {

            return Optional.of(new Error("Author", "Author field can not be empty"));
        }
        return Optional.empty();
    }


}