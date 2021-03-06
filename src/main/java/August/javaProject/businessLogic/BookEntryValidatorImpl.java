package August.javaProject.businessLogic;

import August.javaProject.businessLogic.api.Error;
import August.javaProject.dataBase.BookDao;
import August.javaProject.dataBase.DataBase;
import August.javaProject.domain.Book;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookEntryValidatorImpl implements BookEntryValidator {

  @Autowired  BookDao dao;




    @Override
    public List<Error> validate(String title, String author, int pubYear) {

        List<Error> errorList = Lists.newArrayList();

        if (titleValidation(title).isPresent()) {

            errorList.add(titleValidation(title).get());
        }

        if (authorValidation(author).isPresent()) {
            errorList.add(authorValidation(author).get());
        }

        if (pubYearValidation(pubYear).isPresent()) {
            errorList.add(pubYearValidation(pubYear).get());
        }
        if (alreadyExistValidation(new Book(title, author, pubYear)).isPresent()) {

            errorList.add(alreadyExistValidation(new Book(title, author, pubYear)).get());
        }
        return errorList;
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


    Optional<Error> pubYearValidation(int pubYear) {

        if (pubYear == 0) {

            return Optional.of(new Error("pubYear", "Publication Year field can not be empty"));
        }
        return Optional.empty();
    }

// THIS METHOD NEED REVISION SINCE CHECK DB ONLY BY TITLE
    Optional<Error> alreadyExistValidation(Book newBook) {

        if (dao.getBookByTitle(newBook.getTitle()).size() < 5) {

            return Optional.empty();
        }

        return Optional.of(new Error("", "Thank you, but this book is already present in library"));


    }


}