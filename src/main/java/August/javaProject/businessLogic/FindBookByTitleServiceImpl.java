package August.javaProject.businessLogic;

import August.javaProject.businessLogic.api.Error;
import August.javaProject.businessLogic.api.Response;
import August.javaProject.dataBase.jdbc.BookDAOImpl;
import August.javaProject.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public class FindBookByTitleServiceImpl implements FindBookByTitleService {

    @Autowired BookDAOImpl dao;
    @Autowired BookEntryValidatorImpl validator;


    @Override
    @Transactional
    public Response findBookByTitle(String title) {

       List<Error> errorList = validator.validate(title, "Author", 1000);

        if (!errorList.isEmpty()) {
            return new Response(false, errorList);

        }

        dao.getBookByTitle(title);
        return new Response(true, null);
    }
}





