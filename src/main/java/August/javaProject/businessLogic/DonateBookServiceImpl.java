package August.javaProject.businessLogic;


import August.javaProject.businessLogic.api.Error;
import August.javaProject.businessLogic.api.Response;
import August.javaProject.dataBase.jdbc.BookDAOImpl;
import August.javaProject.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class DonateBookServiceImpl implements DonateBookService {

    @Autowired BookDAOImpl dao;
    @Autowired BookEntryValidatorImpl validator;

@Override
@Transactional
    public Response donateBook(String title, String author, int pubYear) {

        List<Error> errorList = validator.validate(title, author, pubYear);

        if (!errorList.isEmpty()) {
            return new Response(false, errorList);

        }

        dao.save(new Book(title, author, pubYear));
        return new Response(true, null);
    }
}